package is.ru.hugb;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;

import org.junit.Test;

public class TestGame {

	Game g;

    @Before
    public void set() {
        g = new Game();
    }

    @Test
	public void testChangePlayer(){
    	assertEquals('O', g.changePlayer('X'));
    }
	
	@Test
	public void testSetCell(){
		assertEquals(false, g.setCell(3, 3));
		assertEquals(false, g.setCell(-0, 4));
		assertEquals(true, g.setCell(0, 2));

	}
}