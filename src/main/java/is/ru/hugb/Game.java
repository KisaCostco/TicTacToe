package is.ru.hugb;

// the different game states
public class Game {
	public enum State {
	  PLAYING, DRAW, WIN
	}
	private Board board;            // the game board
  private State currentState; 		// the current state of the game (of enum State)
  private char currentPlayer; 		// the player

	private final char PLAYER_O = 'O';
	private final char PLAYER_X = 'X';

	public Game() {
		currentPlayer = PLAYER_X;			// x starts
		currentState = State.PLAYING;	// playing state is set
		board = new Board();					// board of the game initialized
	}

	public State getState() {
		return currentState;
	}

	public void resetState() {
		currentState = State.PLAYING;
		currentPlayer = PLAYER_X;
	}

	public char getPlayer() {
		return currentPlayer;
	}

	// sets the given user input to the correct cell
	public Boolean setCell(int row, int col) {
		// continues if the move is legal
		if(board.checkLegalMove(row, col) && !board.checkWin()) {
			board.updateCell(currentPlayer, row, col);
			// need to check if we have a win or a draw
			if(board.checkWin()) {
				currentState = State.WIN;
				return true;
			}
			else if (board.isFull()) {
				currentState = State.DRAW;
				return true;
			}
			// finally we change players
			currentPlayer = changePlayer(currentPlayer);
			return true;
		}
		return false;
	}

	// changes between X and O
	public char changePlayer(char player){
		if (player == PLAYER_O) {
			return PLAYER_X;
		}
		else {
			return PLAYER_O;
		}
	}
	//sends the board from Board.java to maintain code abstraction
	public char[][] getBoard() {
		return board.getBoard();
	}
}
