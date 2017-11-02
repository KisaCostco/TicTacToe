package is.ru.hugb;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;

import org.junit.Test;

public class TestBoard {

        Board b;

        @Before
        public void setUp() {
          b = new Board();
        }

        @Test
        public void testCheckLegalMove(){
        	 assertEquals(false, b.checkLegalMove(3,3));
           assertEquals(false, b.checkLegalMove(-2, 1));
           assertEquals(true, b.checkLegalMove(0,0));
        }

        @Test
        public void testIsNotFull(){
          assertEquals(false, b.isFull());
        }

        @Test
        public void testIsFull(){
            b.updateCell('X', 1, 0);
            b.updateCell('O', 0, 0);
            b.updateCell('X', 0, 1);
            b.updateCell('O', 2, 0);
            b.updateCell('X', 2, 1);
            b.updateCell('O', 1, 1);
            b.updateCell('X', 0, 2);
            b.updateCell('O', 1, 2);
            b.updateCell('X', 2, 2);
          assertEquals(true, b.isFull());
        }

        @Test
        public void testWinRow(){
          b.updateCell('X', 0, 0);
          b.updateCell('X', 1, 0);
          b.updateCell('X', 2, 0);
          assertEquals(true, b.checkWin());
        }

        @Test
        public void testWinCol(){
          b.updateCell('X', 1, 0);
          b.updateCell('X', 1, 1);
          b.updateCell('X', 1, 2);
          assertEquals(true, b.checkWin());
        }

        @Test
        public void testWinDiag(){
          b.updateCell('O', 0, 0);
          b.updateCell('O', 1, 1);
          b.updateCell('O', 2, 2);
          assertEquals(true, b.checkWin());
        }

    		@Test
    		public void testNotWinRow(){
    		  assertEquals(false, b.checkWin());
              b.updateCell('X', 0, 0);
              b.updateCell('X', 1, 0);
    		  assertEquals(false, b.checkWin());
    		}

    		@Test
    		public void testNotWinCol(){
    		  assertEquals(false, b.checkWin());
              b.updateCell('X', 1, 0);
              b.updateCell('X', 1, 1);
    		  assertEquals(false, b.checkWin());
    		}

    		@Test
    		public void testNotWinDiag(){
    		  assertEquals(false, b.checkWin());
              b.updateCell('X', 0, 0);
              b.updateCell('X', 1, 1);
    		  assertEquals(false, b.checkWin());
    		}
}
