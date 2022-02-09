package action.worker;

import action.Action;
import board.Board;
import board.tile.*;
import player.*;

public class Pass implements Action {
	
	private PlayerWorker player;
	private Board board;
	
	/* The constructor of an Pass instance
	 * @param player The player who do this action
	 * @param board The board
	 */
	public Pass(PlayerWorker player, Board board) {
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
	 * An action method to pass, it displays in the terminal a message to warn that the player passes his turn and the money he win
	 */
	public void doAction() {
		Tile[][] gameBoard = this.board.getGameBoard();

		int goldCounter = 0;
		
		for (Tile[] line : gameBoard) { // Evaluating line by line
			for (Tile frame : line) { // Evaluating frame by frame for each line
				if (!(frame instanceof OceanTile) && frame.fill()) { // If the tile is a land filled
					if (this.player.equals(frame.getPresentCharacter().getPlayer())) { // If the tile is filled with an ally worker
						if ((frame instanceof ForestTile) || (frame instanceof PlainTile)) {
							goldCounter++;
						}

						else if (frame instanceof DesertTile) {
							goldCounter += 2;
						}
					}
				}
			}
		}
		
		this.player.setNbrGold( this.player.getNbrGold() + goldCounter );
		System.out.println(this.player.getName() + " pass his turn and gets " + goldCounter + " golds");
	}

}
