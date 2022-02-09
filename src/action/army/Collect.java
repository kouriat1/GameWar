package action.army;

import action.Action;
import player.*;
import board.Board;
import board.tile.*;


public class Collect implements Action {
	
	private PlayerArmy player;
	private Board board;
	
	/* The constructor of an Collect instance
	 * @param player The player who do this action
	 * @param board The board
	 */
	public Collect(PlayerArmy player, Board board) {
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
	 * An action method to collect resources from ally lands, it display in the terminal the amount of food units obtained and the new total amount possessed by the player
	 */
	public void doAction() {
		
		Tile[][] gameBoard = this.board.getGameBoard();
		int resourcesCounter = 0;
		
		for (Tile[] line : gameBoard) { // Evaluating line by line
			for (Tile frame : line) { // Evaluating frame by frame for each line
				
				if ( !(frame instanceof OceanTile) && frame.fill() && (this.player == frame.getPresentCharacter().getPlayer()) ) { // If the tile is a filled land with allied characters
					if (frame instanceof ForestTile) { // If it's a forest tile
						resourcesCounter += 1;
					}
					
					else if (frame instanceof PlainTile) { // If it's a plain tile
						resourcesCounter += 5;
					}
				}
				
			}
		}
		
		this.player.setNbFood(this.player.getNbFood() + resourcesCounter); // Add the total amount of food units collected
		System.out.println(this.player.getName() + " gets " + resourcesCounter + " food units !\nHis new stock is " + this.player.getNbFood() + " food units !");
		
	}

}
