package action.worker;

import action.Action;
import board.Board;
import board.tile.*;
import player.*;
import character.*;

public class Collect implements Action {
	
	private PlayerWorker player;
	private Board board;
	
	/* The constructor of an Collect instance
	 * @param player The player who do this action
	 * @param board The board
	 */
	public Collect(PlayerWorker player, Board board) {
		this.player = player;
		this.board = board;
	}
	
	
	/**Getter method of <code>player</code> attribute
	 * @return The player
	 */
	public PlayerWorker getPlayer() {
		return this.player;
	}

	/**Setter method of <code>player</code> attribute
	 * @param player The new player
	 */
	public void setPlayer(Player player) {
		this.player = (PlayerWorker) player;
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
	 * An action method to collect resources, it display in the terminal the amounts of collected resources
	 */
	public void doAction() {
		Tile[][] gameBoard = this.board.getGameBoard();
		int gameBoardSize = gameBoard.length;
		
		Tile evaluatedTile = null;
		CharacterWorker evaluatedCharacter = null;
		
		int rockCounter = 0;
		int sandCounter = 0;
		int woodCounter = 0;
		int wheatCounter = 0;
		
		for (int line = 0; line < gameBoardSize; line++) { // Evaluating line by line (y)
			for (int column = 0; column < gameBoardSize; column++) { // Evaluating column by column for each line (x)
				evaluatedTile = gameBoard[line][column];
				
				if (!(evaluatedTile instanceof OceanTile) && evaluatedTile.fill()) { // If the tile is a land filled
					evaluatedCharacter = (CharacterWorker) evaluatedTile.getPresentCharacter();
					
					if (this.player.equals(evaluatedCharacter.getPlayer())) { // If the tile is filled with an ally army
						if (evaluatedTile instanceof MountainTile) { // The tile is a Mountain
							rockCounter++;
						}
						else if (evaluatedTile instanceof DesertTile) { // The tile is a Desert
							sandCounter++;
						}
						else if (evaluatedTile instanceof ForestTile) { // The tile is a Forest
							woodCounter++;
						}
						else { // The tile is a Plain
							wheatCounter++;
						}

						evaluatedCharacter.setResourceAmount( evaluatedCharacter.getResourceAmount() + 1 );
					}
				}
			}
		}
		
		System.out.println(this.player.getName() + " collected : " + rockCounter + " rocks, " + sandCounter + " sands, " + woodCounter + " woods and " + wheatCounter + " wheat.");
		this.board.setGameBoard(gameBoard);
	}

}
