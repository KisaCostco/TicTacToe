# Administration manual

TicTacToe is a simple web-based version of the game Tic Tac Toe. It is developed in Java, built using Gradle and uses Travis Continuous integration and the Heroku staging environment. The process to run the system is mostly automatic, so here are some basic instructions to get you up and running.

### What you need

1. Install Java, [JDK 1.8](https://docs.oracle.com/javase/8/docs/technotes/guides/install/install_overview.html).
2. Start by forking the project's repository on GitHub, at [https://github.com/KisaCostco/TicTacToe](https://github.com/KisaCostco/TicTacToe). 
3. Go to [https://travis-ci.org/](https://travis-ci.org/) and click **Sign in with GitHub**. This is the continuous integration platform that integrates all new changes and allows you to check the build status of the project.
4. Give Travis access to the repository by synching your account.
5. Go to Heroku.com, set up an account and set up the [Heroku Toolbelt](https://devcenter.heroku.com/articles/heroku-cli). Follow the tutorials on Heroku, especially [Getting started with Gradle on Heroku](https://devcenter.heroku.com/articles/getting-started-with-gradle-on-heroku#introduction)

### Installing and running
1. Start by cloning the repository to your computer in your shell with the command:
> git clone https://github.com/KisaCostco/TicTacToe.git

2. Create a deployable package with this command line:
> gradle installDist

3. Finally run the application with this command:
> gradle run

After that you can click [here](localhost:4567) and play the game.

### Deploy and maintain
1. Go to [Travis](https://travis-ci.org/) and sign up with your GitHub account.
2. Use Heroku toolbelt to create an app by runni > heroku create.
3. Put the line into your README.md file  > [![Build Status](your travis url for the repo here.png)](your travis url for the repo here) 
4. Set up the Heroku key for Travis by using the command > travis encrypt $(heroku auth:token) --add deploy.api_key .
5. Finally change the .travis.yml file so that it corresponds with your own app.

### The web page
The game is live on the web on [https://kfc-tictactoe.herokuapp.com/](https://kfc-tictactoe.herokuapp.com/). Any changes are deployed automatically to the Heroku server and are available within moments.

[Download manual as PDF](https://gitprint.com/KisaCostco/TicTacToe/blob/master/docs/AdministrationManual.md)

