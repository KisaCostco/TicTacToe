# Design report for TicTacToe

[Download report as PDF](https://gitprint.com/KisaCostco/TicTacToe/blob/master/docs/DesignReport.md)

This is an assignment in the software development course SC-T-303-HUGB at Reykjavík University.

## Project
The project involves implemeting the game TicTacToe with automated tests. We used Agile methods and test driven development. Git was used for version control, specifically feature branches and pull requests.
 
## Game
TicTacToe is a simple two player game in which the first player is assigned the mark X and the second is assigned O. The game is played on a board consisting of a 3x3 grid. The players take turn and the game's goal is to line up three marks, whether it is horizontal, vertical or diagonal. If neither of the players scores three marks in a row the game ends as a draw.

##  Design
We chose to implement the game in a simple version where there are two playing against each other. The initial design was a console application and when it was complete, we moved on to a web application. In the web application the board is 9 squares and above it there are nine buttons corresponding to each square on the board. The player picks where he wants his mark to go. Then the board prints out the state of the game.

![UI](https://github.com/KisaCostco/TicTacToe/blob/master/ui.png)

## Coding standards
* Code must be commented
* Class names are in Pascal casing and function names are in Camel casing.
* Kernighan and Ritchie brace style


## Classes

Our code is object-oriented and follows recommended design principles. 

### Class diagram
Here is the updated class diagram, which changed a bit from the initial design, but conserved the initial class structure for the most part. Below we describe each class and their relations briefly.

![ClassDiagram](https://github.com/KisaCostco/TicTacToe/blob/master/classdiagram.jpg)

### Board.java
This is the class which handles the business logic of the game board. It can be seen as the bottom layer, and the UI has no direct access to it. It sets up the board as a double array in a fixed size and updates the cells. It also checks if the board is full and whether a user has won.

### Game.java
The Game class handles the logic concerning the game in session. It keeps track of the game state using the enum State, and changes between players. The most important method of Game is setCell(row, col), which uses the methods from Board to set the cell given the input. It also sends through data from the Board class to the UI.

### UI.java
Initially, this contained the UI for the console application, but was transformed into a Spark backend which also uses JavaScript/HTML/CSS. The game is live on [https://kfc-tictactoe.herokuapp.com/](https://kfc-tictactoe.herokuapp.com/).



