package is.ru.hugb;

public class Board {
        private  char[][] board;
        private final int row = 3;
        private final int col = 3;

        private final char EMPTY = ' ';

        public Board() {
          board = new char[row][col];

          for (int i = 0; i < row; i++) {
              for (int j = 0; j < col; j++) {
                  board[i][j] = EMPTY;
              }
          }
        }

        public char[][] getBoard() {
          return board;
        }

        // checks for input that is out of bounds or empty

       public Boolean checkLegalMove(int row, int col) {
          if((row > 2 || row < 0) || (col > 2 || col < 0))
            return false;
          else if(board[row][col] != EMPTY) {
            return false;
          }

          return true;

        }

        // X or O written to the correct cell
        public void updateCell(char player, int row, int col) {
          board[row][col] = player;
        }

        // calls three private functions that check each case
       public Boolean checkWin(){
          if(checkWinRow() || checkWinCol() || checkWinDiag()) {
            return true;
          }
          else {
            return false;
          }
       }

       // Game uses this to determine if there is a draw
        public Boolean isFull(){
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    // if some cell is empty the board is not full
                    if (board[i][j] == EMPTY) {
                        return false;
                    }
                }
            }
            return true;
        }

        private Boolean checkWinRow(){
          if(board[0][0] == board[1][0] && board[1][0] == board[2][0] && (board[0][0] == 'X' || board[0][0] == 'O')) {
            return true;
          }
          else if (board[0][1] == board[1][1] && board[1][1] == board[2][1] && (board[0][1] == 'X' || board[0][1] == 'O')) {
            return true;
          }
          else if (board[0][2] == board[1][2] && board[1][2] == board[2][2] && (board[0][2] == 'X' || board[0][2] == 'O')) {
            return true;
          }
          else return false;
        }

        private Boolean checkWinCol(){
          if (board[0][0] == board[0][1] && board[0][1] == board[0][2] && (board[0][0] == 'X' || board[0][0] == 'O')) {
            return true;
          }
          else if (board[1][0] == board[1][1] && board[1][1] == board[1][2] && (board[1][0] == 'X' || board[1][0] == 'O')) {
              return true;
          } else if (board[2][0] == board[2][1] && board[2][1] == board[2][2] && (board[2][0] == 'X' || board[2][0] == 'O')) {
              return true;
         }
         else return false;
       }

       private Boolean checkWinDiag(){
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && (board[0][0] == 'X' || board[0][0] == 'O')) {
            return true;
          } else if (board[2][0] == board[1][1] && board[1][1] == board[0][2] && (board[2][0] == 'X' || board[2][0] == 'O')) {
              return true;
          }
          else return false;
     }
}
