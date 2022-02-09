package action.worker;

import action.Action;
import board.Board;
import board.tile.*;
import character.*;
import player.*;
import java.util.Random;

public class Deploy implements Action {
	
	private PlayerWorker player;
	private Board board;
	
	/* The constructor of an Deploy instance
	 * @param player The player who do this action
	 * @param board The board
	 */
	public Deploy(PlayerWorker player, Board board) {
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
	 * An action method to deploy a worker, it display in the terminal the pos where the worker was deployed
	 */
	public void doAction() { // Only on a random AI game
		Tile[][] gameBoard = this.board.getGameBoard();
		int gameBoardSize = gameBoard.length;
		
		Random random = new Random();
		
		/*----------------------------------Tile select----------------------------------*/
		
		int randomLine = random.nextInt(gameBoardSize); // (y)
		int randomColumn = random.nextInt(gameBoardSize); // (x)
		
		while (gameBoard[randomLine][randomColumn].fill()) { // While the random tile is filled --> search random a new empty land tile
			randomLine = random.nextInt(gameBoardSize); // (y)
			randomColumn = random.nextInt(gameBoardSize); // (x)
		}
		
		/*----------------------------------Setting up the worker----------------------------------*/
		
		CharacterWorker deployedWorker = new CharacterWorker(this.player);
		gameBoard[randomLine][randomColumn].setPresentCharacter( deployedWorker ); // Set up the worker on the tile
		
		System.out.println(this.player.getName() + " deploys a worker on the tile (" + randomColumn + "," + randomLine + ") !");
		
		this.board.setGameBoard(gameBoard);
	}
}
