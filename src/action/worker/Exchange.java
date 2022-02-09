package action.worker;

import action.Action;
import board.Board;
import board.tile.*;
import character.*;
import player.*;

public class Exchange implements Action {
	
	private PlayerWorker player;
	private Board board;
	
	/* The constructor of an Exchange instance
	 * @param player The player who do this action
	 * @param board The board
	 */
	public Exchange(PlayerWorker player, Board board) {
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
	 * An action method to exchange resources to gold, it displays in the terminal the total gold earned
	 */
	public void doAction() {
		Tile[][] gameBoard = this.board.getGameBoard();
		int gameBoardSize = gameBoard.length;
		
		Tile evaluatedTile = null;
		CharacterWorker evaluatedCharacter = null;

		int goldCounter = 0;
		
		for (int line = 0; line < gameBoardSize; line++) { // Evaluating line by line (y)
			for (int column = 0; column < gameBoardSize; column++) { // Evaluating column by column for each line (x)
				evaluatedTile = gameBoard[line][column];
				
				if (!(evaluatedTile instanceof OceanTile) && evaluatedTile.fill()) { // If the tile is a land filled
					evaluatedCharacter = (CharacterWorker) evaluatedTile.getPresentCharacter();
					if (this.player.equals(evaluatedCharacter.getPlayer())) { // If the tile is filled with an ally worker
					
						if (evaluatedTile instanceof MountainTile) { // The tile is a Mountain
							goldCounter += evaluatedCharacter.getResourceAmount() * 8;
						}
						else if (evaluatedTile instanceof DesertTile) { // The tile is a Desert
							goldCounter += evaluatedCharacter.getResourceAmount() * 5;
						}
						else { // The tile is a Plain or a Forest
							goldCounter += evaluatedCharacter.getResourceAmount() * 2;
						}

						evaluatedCharacter.setResourceAmount(0);
					}
				}
			}
		}
		
		this.player.setNbrGold( this.player.getNbrGold() + goldCounter );
		System.out.println(this.player.getName() + " exchanges resources and earn " + goldCounter + " golds");
		this.board.setGameBoard(gameBoard);
	}

}
