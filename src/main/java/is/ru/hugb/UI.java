package is.ru.hugb;

import java.util.Scanner;
import java.net.URLDecoder;

import static spark.Spark.*;

public class UI {
  // Print board for game in html
  public static String printBoard(Game game) {
    String out = "<h2>";
    out += "<table align='center' style='border: 3px solid black; background-color: rgb(216, 216, 216);'>";
    for (int i = 0; i < 3; i++) {
      out += "<tr>";
        for (int j = 0; j < 3; j++) {
          out += "<td style='border: 3px solid black' width='100' height='100'>" + "&nbsp;" + game.getBoard()[i][j] + " &nbsp;" + "</td>";
        }
        out += "</tr>";
        out += "&nbsp;";
      }
    out += "</table>";
    return out ;
  }
  
  // Clear board and reset state and player for new game
	public static void clearBoard(Game game) {
		for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        game.getBoard()[i][j] = ' ';
      }
    }
		game.resetState();
	}
  
  // Game is played here
  public static void main(String[] args) {
    // In order for this to work on Heroku, we need to allow Heroku to set the port number
      staticFileLocation("/public");
      port(getHerokuPort());

       Game game = new Game();
       UI ui = new UI();

      post("/add", (req, res) -> {

           String input = req.queryParams("input");
           String numbers[] = input.split(",");

			     int iInput1 = Integer.parseInt(numbers[0]);
		       int iInput2 = Integer.parseInt(numbers[1]);

			game.setCell(iInput1, iInput2);

            if(game.getState() == Game.State.PLAYING){
        return ui.printBoard(game) + "<h3>" + "Player " + game.getPlayer() + ", it's your turn";
			}
			else if(game.getState() == Game.State.WIN) {

				return ui.printBoard(game) + "<h3>" + game.getPlayer() + " has won!! :)";
			}
			else {
				return ui.printBoard(game) + "<h3>It's a draw!";
			}
    });

		delete("/reset", (req, res) -> {
			ui.clearBoard(game);
			return ui.printBoard(game) + "<h3>" + "Player " + game.getPlayer() + ", it's your turn";
		});

    get("/", (req, res) -> {
      ui.clearBoard(game);
      return ui.printBoard(game) + "<h3>" + "Player " + game.getPlayer() + ", it's your turn";
    });
  }
    static int getHerokuPort() {
      ProcessBuilder psb = new ProcessBuilder();
      if (psb.environment().get("PORT") != null) {
        return Integer.parseInt(psb.environment().get("PORT"));
      }
      return 4567;
    }
}
