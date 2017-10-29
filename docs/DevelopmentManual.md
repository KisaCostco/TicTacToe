# Development manual for the game TicTacToe by Kisa fór í Costco
The game was developed using Github, Java V 1.8, Gradle, Spark Framework, Travis, Heroku and Selenium.
To run the application you will need to have [Java](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) and [Gradle](https://gradle.org/install/) installed on the computer that is being used to run it. The repository is open on GitHub, and can be found and cloned [here](https://github.com/KisaCostco/TicTacToe).

## [GitHub](https://github.com/)
GitHub is an important site that hosts code so that people can in an easy and efficient way share code and work together. 
To start working on the application you will need to clone the repository on your shell 
> git clone https://github.com/KisaCostco/TicTacToe.git

## [Gradle](https://gradle.org/)
Gradle is a tool that automates the system so building, testing and running the application becomes easy.
The commands that are used are:

To build:
> gradle build

Run tests:
> gradle test 

To run the application:
> gradle run

## [Travis](https://travis-ci.org/)
Travis is a service that performs continuous integration. When a pull request is made to the GitHub repository Travis tests the code automatically to insure that the code works. If you want to get more information select the Travis heading to go to their site.

## [Heroku](https://www.heroku.com/)
Heroku is service that is used as a web application deployment model. To get more information press the Heroku heading.

## [Selenium](http://www.seleniumhq.org/)
Selenium performs tests to the web application by mimicking what the user should do. To run the Selenium test use the command:
> gradle selenium

## Deploying the game
To play the game click [here](https://kfc-tictactoe.herokuapp.com/), or you can play the game locally when the application has been built and run [here](localhost:4567).
[Download manual as PDF](https://gitprint.com/KisaCostco/TicTacToe/blob/master/docs/DevelopmentManual.md)
