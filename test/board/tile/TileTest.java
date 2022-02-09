package board.tile;

import static org.junit.Assert.*;
import org.junit.Test;

import player.Player;
import character.Character;

public class TileTest {
	
	private Player playerTest1 = new Player("Player 1", 10);
	private Player playerTest2 = new Player("Player 2", 5);
	
	/**
	 * Test method for the fill method of Tile class and subclasses
	 */
	@Test
	public void fillTest() {
		Tile tileTest1 = new Tile(0, 0, 5);
		Tile tileTest2 = new Tile(5, 5, 3);
		Tile tileTest3 = new Tile(5, 5, 0);
		
		assertFalse( tileTest1.fill() );
		assertFalse( tileTest2.fill() );
		
		Character characterTest1 = new Character(playerTest1, 0);
		Character characterTest2 = new Character(playerTest2, 0);
		
		tileTest1.setPresentCharacter(characterTest1);
		tileTest2.setPresentCharacter(characterTest2);
		
		assertTrue( tileTest1.fill() );
		assertTrue( tileTest2.fill() );
		assertTrue( tileTest3.fill() );
	}

}
