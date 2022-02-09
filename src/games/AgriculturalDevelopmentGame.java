package games;

import board.Board;
import board.tile.*;
import player.PlayerWorker;
import action.Action;
import action.worker.*;
import java.util.Random;

public class AgriculturalDevelopmentGame {

	private PlayerWorker[] playersArray;
	private int nbTurn;
	private Board board;
	
	
	/**The constructor
	 * @param playersNames An array filled with players names
	 * @param boardSize The size of the game board
	 * @param nbTurn The number of playable turn
	 */
	protected AgriculturalDevelopmentGame(String[] playersNames, int boardSize, int nbTurn) {
		this.playersArray = new PlayerWorker[playersNames.length];
		for (int i = 0; i < playersNames.length; i++) {
			this.playersArray[i] = new PlayerWorker( playersNames[i] , 15);
		}
		
		this.board = new Board( boardSize );
		this.nbTurn = nbTurn;
	}

	
	/**Getter method of <code>playersArray</code> attribute
	 * @return The array compound of players
	 */
	public PlayerWorker[] getPlayersArray() {
		return this.playersArray;
	}

	/**Setter method of <code>playersArray</code> attribute
	 * @param playersArray The array compound of players
	 */
	public void setPlayersArray(PlayerWorker[] playersArray) {
		this.playersArray = playersArray;
	}

	/**Getter method of <code>nbTurn</code> attribute
	 * @return The number of playable turn
	 */
	public int getNbTurn() {
		return this.nbTurn;
	}

	/**Setter method of <code>nbTurn</code> attribute
	 * @param nbTurn The number of playable turn
	 */
	public void setNbTurn(int nbTurn) {
		this.nbTurn = nbTurn;
	}

	/**Getter method of <code>board</code> attribute
	 * @return The game board
	 */
	public Board getBoard() {
		return this.board;
	}

	/**Getter method of <code>board</code> attribute
	 * @param board The game board
	 */
	public void setBoard(Board board) {
		this.board = board;
	}
	
	
	/*
	 * Start a game
	 */
	public static void main(String[] args) {
		if (args.length < 2) {
			System.out.println("The game cannot start : Not enough players !");
			return;
		}
		
		AgriculturalDevelopmentGame game = new AgriculturalDevelopmentGame(args, 10, 6);
		
		System.out.println("The game is starting ...\n");
		game.gamingPhase();
		System.out.println("The game is end !\n");
		
		game.scoringPhase();
	}
	
	
	/*
	 * A method to simulate a gaming phase
	 */
	public void gamingPhase() {
		int nbPlayers = this.getPlayersArray().length;
		int nbTurnTotal = this.getNbTurn() * nbPlayers;
		PlayerWorker actualPlayer;
		
		Random random = new Random();
		int randomValue; // Use to choose an action between Deploy and Pass
		
		Action[] firstPart = new Action[]{ new Deploy(null, this.getBoard()), new Exchange(null, this.getBoard()), new Pass(null, this.getBoard()) }; // Deploy or Exchange or Pass
		Action secondPart = new Collect(null, this.getBoard()); // Collect
		Action thirdPart = new Pay(null, this.getBoard()); // Pay
		
		
		for (int i = 0; i < nbTurnTotal ; i++) {
			
			actualPlayer = this.getPlayersArray()[i % nbPlayers];
			randomValue = random.nextInt(3);
			
			System.out.println(actualPlayer.getName() + " is playing !");
			
			firstPart[randomValue].setPlayer(actualPlayer);
			firstPart[randomValue].doAction();
			
			if (this.getBoard().boardFill()) { // If the board is filled, stop the game and warn players
				System.out.println("The board is filled !");
				break;
			}
			
			secondPart.setPlayer(actualPlayer);
			secondPart.doAction();
			
			thirdPart.setPlayer(actualPlayer);
			thirdPart.doAction();
			
			System.out.println("End of " + actualPlayer.getName() + " turn !\n");
		}
	}
	
	/* 
	 * A method to simulate a scoring phase and displaying the winner
	 */
	public void scoringPhase() {
		int nbPlayers = this.getPlayersArray().length;
		PlayerWorker actualPlayer;
		
		for (Tile[] line : this.getBoard().getGameBoard()) { // Evaluating line by line
			for (Tile frame : line) { // Evaluating frame by frame for each line
				
				if ( !(frame instanceof OceanTile) && frame.fill() ) { // If the tile is a filled land
					actualPlayer = (PlayerWorker) frame.getPresentCharacter().getPlayer();
					
					actualPlayer.setScore( actualPlayer.getScore() + frame.getPresentCharacter().getNbOr() ); // Add the gold amount owned by the character to the player previous score
					actualPlayer.setNbTileOwned( actualPlayer.getNbTileOwned() + 1 );
				}
			}
		}
		
		PlayerWorker winnerPlayer = this.getPlayersArray()[0]; // Initialization
		
		for (int i2 = 0; i2 < nbPlayers; i2++) { // Display players score, and the winner
			actualPlayer = this.getPlayersArray()[i2];
			
			System.out.println(actualPlayer.getName() + " : " + actualPlayer.getScore() + " points !");
			
			if (winnerPlayer.getScore() < actualPlayer.getScore()) { // If the evaluated player has more than the previous 'winner'
				winnerPlayer = actualPlayer;
			}
		}
		
		System.out.println("\nThe winner is : " + winnerPlayer.getName() + "\n");
	}
}
