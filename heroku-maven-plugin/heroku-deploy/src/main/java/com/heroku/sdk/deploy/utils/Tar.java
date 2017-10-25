package com.heroku.sdk.deploy.utils;

import org.apache.commons.compress.archivers.*;
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveOutputStream;
import org.apache.commons.compress.archivers.tar.TarConstants;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.io.FileUtils;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.FileSystems;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;


public class Tar {
  public static File create(String filename, String directory, File workingDir, File outputDir) throws IOException, ArchiveException, InterruptedException {
    return new Pack(workingDir, directory).apply(filename, outputDir);
  }

  public static void extract(File tarFile, File outputDir) throws IOException, InterruptedException, ArchiveException {
    new Unpack(tarFile, outputDir).apply();
  }

  public static class Pack {
    private File workingDir;
    private String directory;

    public Pack(File workingDir, String directory) {
      this.workingDir = workingDir;
      this.directory = directory;
    }

    private List<File> recursiveListFiles(File f) {
      List<File> allFiles = new ArrayList<File>();

      for (File subFile : f.listFiles()) {
        if (subFile.isDirectory()) {
          allFiles.addAll(recursiveListFiles(subFile));
        }
        allFiles.add(subFile);
      }
      return allFiles;
    }

    private void addFilesToTar(ArchiveOutputStream tarBall, File dir) throws IOException {
      for (File file : recursiveListFiles(dir)) {
        if (!file.isDirectory()) {
          Path path = FileSystems.getDefault().getPath(file.getAbsolutePath());
          String pathInTar = relativize(file);
          if (Files.isSymbolicLink(path)) {
            TarArchiveEntry tarFile = new TarArchiveEntry(pathInTar, TarConstants.LF_SYMLINK);
            String symbolicLink = Files.readSymbolicLink(path).toString();
            tarFile.setLinkName(symbolicLink);
            tarBall.putArchiveEntry(tarFile);
            tarBall.closeArchiveEntry();
          } else {
            TarArchiveEntry tarFile = new TarArchiveEntry(file, pathInTar);
            tarFile.setSize(file.length());
            if (Files.isExecutable(path)) {
              tarFile.setMode(493);
            }
            tarBall.putArchiveEntry(tarFile);
            IOUtils.copy(new FileInputStream(file), tarBall);
            tarBall.closeArchiveEntry();
          }
        }
      }
    }

    private void compress(File sourceFile, File targetFile) throws IOException {
      try (FileOutputStream fos = new FileOutputStream(targetFile);
           GZIPOutputStream gzs = new GZIPOutputStream(fos);
           FileInputStream fis = new FileInputStream(sourceFile)) {
        IOUtils.copy(fis, gzs);
      }
    }

    private File apply(String archiveFilename, File outputDir) throws ArchiveException, IOException {
      File archive = new File(outputDir, (archiveFilename + ".tar"));
      FileOutputStream tarOutput = new FileOutputStream(archive);

      TarArchiveOutputStream tarBall = (TarArchiveOutputStream)new ArchiveStreamFactory().createArchiveOutputStream(ArchiveStreamFactory.TAR, tarOutput);
      tarBall.setLongFileMode(TarArchiveOutputStream.LONGFILE_GNU);
      try {
        addFilesToTar(tarBall, new File(workingDir, directory));
      } finally {
        tarBall.close();
      }

      File outputFile = new File(outputDir, (archiveFilename));
      compress(archive, outputFile);
      FileUtils.deleteQuietly(archive);
      return outputFile;
    }

    private String relativize(File path) {
      String relativePath = new File(this.workingDir, this.directory).toURI().relativize(path.toURI()).getPath();

      // don't use File.separator because it will be wrong on Windows
      return this.directory + "/" + relativePath;
    }
  }

  public static class Unpack {

    private File tarFile;
    private File outputDir;

    public Unpack(File tarFile, File outputDir) {
      this.tarFile = tarFile;
      this.outputDir = outputDir;
    }

    private ArchiveInputStream extract(InputStream input) throws ArchiveException {
      return new ArchiveStreamFactory().createArchiveInputStream(input);
    }

    public void apply() throws IOException, ArchiveException {
      try (FileInputStream fis = new FileInputStream(tarFile);
           GZIPInputStream gzs = new GZIPInputStream(fis)) {
        ArchiveInputStream archiveInputStream = extract(new BufferedInputStream(gzs));

        ArchiveEntry entry = archiveInputStream.getNextEntry();
        while (entry != null) {
          if (entry.isDirectory()) {
            FileUtils.forceMkdir(new File(outputDir, entry.getName()));
          } else {
            File destPath = new File(outputDir, entry.getName());

            IOUtils.copy(archiveInputStream, new FileOutputStream(destPath));

            if (((TarArchiveEntry) entry).getMode() == 493) {
              destPath.setExecutable(true);
            }
          }
          entry = archiveInputStream.getNextEntry();
        }
      }
    }
  }
}
