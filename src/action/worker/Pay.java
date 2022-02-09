package action.worker;

import action.Action;
import board.Board;
import board.tile.DesertTile;
import board.tile.MountainTile;
import board.tile.OceanTile;
import board.tile.Tile;
import character.CharacterWorker;
import player.Player;
import player.PlayerWorker;

public class Pay implements Action {
	
	private PlayerWorker player;
	private Board board;
	
	/* The constructor of an Pay instance
	 * @param player The player who do this action
	 * @param board The board
	 */
	public Pay(PlayerWorker player, Board board) {
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
	 * An action method to Pay workers, it displays in the terminal the total of paid workers and how many fired
	 */
	public void doAction() {
		Tile[][] gameBoard = this.board.getGameBoard();
		int gameBoardSize = gameBoard.length;
		
		Tile evaluatedTile = null;
		CharacterWorker evaluatedCharacter = null;
		
		int paidWorkerCounter = 0;
		int firedWorkerCounter = 0;
		int goldAmountToPay = 0; // gold to pay
		
		for (int line = 0; line < gameBoardSize; line++) { // Evaluating line by line (y)
			for (int column = 0; column < gameBoardSize; column++) { // Evaluating column by column for each line (x)
				evaluatedTile = gameBoard[line][column];
				evaluatedCharacter = (CharacterWorker) evaluatedTile.getPresentCharacter();
				
				if (!(evaluatedTile instanceof OceanTile) && evaluatedTile.fill() && this.player.equals(evaluatedCharacter.getPlayer())) { // If the tile is a land filled with an ally worker
					if (evaluatedTile instanceof MountainTile) { // The tile is a Mountain
						goldAmountToPay = 5;
					}
					
					else if (evaluatedTile instanceof DesertTile) { // The tile is a Desert
						goldAmountToPay = 3;
					}
					
					else { // The tile is a Plain or a Forest
						goldAmountToPay = 1;
					}
					
					
					if (goldAmountToPay <= this.player.getNbrGold()) { // If the player can pay his worker
						this.player.setNbrGold( this.player.getNbrGold() - goldAmountToPay );
						evaluatedCharacter.setNbOr( evaluatedCharacter.getNbOr() + goldAmountToPay );
						
						paidWorkerCounter++;
					}
					
					else { // If the player haven't enough gold
						evaluatedTile.setPresentCharacter(null); // Fired the worker
						
						firedWorkerCounter++;
					}
				}
			}
		}
		
		System.out.println(this.player.getName() + " paid " + paidWorkerCounter + " workers and " + firedWorkerCounter + " were fired");
		this.board.setGameBoard(gameBoard);
	}

}
