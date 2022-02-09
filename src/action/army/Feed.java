package action.army;

import action.Action;
import board.Board;
import player.*;
import board.tile.*;
import character.CharacterArmy;

public class Feed implements Action {
	
	private PlayerArmy player;
	private Board board;
	
	/* The constructor of an Feed instance
	 * @param player The player who do this action
	 * @param board The board
	 */
	public Feed(PlayerArmy player, Board board) {
		this.player = player;
		this.board = board;
	}

	
	/**Getter method of <code>player</code> attribute
	 * @return The player
	 */
	public PlayerArmy getPlayer() {
		return this.player;
	}

	/**Setter method of <code>player</code> attribute
	 * @param player The new player
	 */
	public void setPlayer(Player player) {
		this.player = (PlayerArmy) player;
	}
	
	/**Getter method of <code>board</code> attribute
	 * @return The board
	 */
	public Board getBoard() {
		return this.board;
	}

	/**Setter method of <code>board</code> attribute
	 * @param board The new board
	 */
	public void setBoard(Board board) {
		this.board = board;
	}
	

	/* 
	 * An action method to feed allies army, it display in the terminal the amount of feeded army and how many army/land the player lost
	 */
	public void doAction() {

		Tile[][] gameBoard = this.board.getGameBoard();
		int foodUnitsAmountToSubstract = 0; // Food units amount to subtract
		CharacterArmy charArmy = null; // Temporary variable to cast a Character to a CharacterArmy
		
		int feededArmyCounter = 0;
		int lostArmyCounter = 0;
		
		for (int line = 0; line < gameBoard.length; line++) { // Evaluating line by line (y)
			for (int column = 0; column < gameBoard.length; column++) { // Evaluating column by column for each line (x)
								
				if ( !(gameBoard[line][column] instanceof OceanTile) && gameBoard[line][column].fill() && (this.player == gameBoard[line][column].getPresentCharacter().getPlayer()) ) { // If the tile is a filled land with allied characters
					
					charArmy = (CharacterArmy) gameBoard[line][column].getPresentCharacter();
					
					if (gameBoard[line][column] instanceof DesertTile) { // If it's a DesertTile
						foodUnitsAmountToSubstract = charArmy.getNbCharacter() * 2;
					}
					
					else { // If it's a other type of land
						foodUnitsAmountToSubstract = charArmy.getNbCharacter();
					}
					
					
					if ( 0 <= ( this.player.getNbFood() - foodUnitsAmountToSubstract ) ) { // If the player have enough food to feed his army
						this.player.setNbFood(this.player.getNbFood() - foodUnitsAmountToSubstract);
						feededArmyCounter++;
					}
					
					else { // If the player can't feed his army
						gameBoard[line][column].setPresentCharacter(null); // Delete the army
						lostArmyCounter++;
					}
				}
				
			}
		}
		
		this.board.setGameBoard(gameBoard);
		this.player.setNbrGold( this.player.getNbrGold() + lostArmyCounter ); // Add the total amount of gold won thanks to delete army
		System.out.println( this.player.getName() + " fed " + feededArmyCounter + " army and lost " + lostArmyCounter );
		
	}

}
