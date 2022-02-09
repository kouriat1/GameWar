package games;

import board.Board;
import board.tile.*;
import player.PlayerArmy;
import action.Action;
import action.army.*;
import java.util.Random;

public class WarGame {

	private PlayerArmy[] playersArray;
	private int nbTurn;
	private Board board;
	
	
	/**The constructor
	 * @param playersNames An array filled with players names
	 * @param boardSize The size of the game board
	 * @param nbTurn The number of playable turn
	 */
	protected WarGame(String[] playersNames, int boardSize, int nbTurn) {
		this.playersArray = new PlayerArmy[playersNames.length];
		for (int i = 0; i < playersNames.length; i++) {
			this.playersArray[i] = new PlayerArmy( playersNames[i], 0, 10, 35 );
		}
		
		this.board = new Board( boardSize );
		this.nbTurn = nbTurn;
	}

	
	/**Getter method of <code>playersArray</code> attribute
	 * @return The array compound of players
	 */
	public PlayerArmy[] getPlayersArray() {
		return this.playersArray;
	}

	/**Setter method of <code>playersArray</code> attribute
	 * @param playersArray The array compound of players
	 */
	public void setPlayersArray(PlayerArmy[] playersArray) {
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
			System.out.println("The game cannot start : Not enough players !\n");
			return;
		}
		
		WarGame game = new WarGame(args, 10, 10);
		
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
		PlayerArmy actualPlayer;
		
		Random random = new Random();
		int randomValue; // Use to choose an action between Deploy and Pass
		
		Action[] firstPart = new Action[]{ new Deploy(null, this.getBoard()), new Pass(null) }; // Deploy or Pass
		Action secondPart = new Collect(null, this.getBoard()); // Collect
		Action thirdPart = new Feed(null, this.getBoard()); // Feed
		
		
		for (int i = 0; i < nbTurnTotal ; i++) {
			
			actualPlayer = this.getPlayersArray()[i % nbPlayers];
			randomValue = random.nextInt(2);
			
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
		PlayerArmy actualPlayer;
		int addedScore;
		
		for (Tile[] line : this.getBoard().getGameBoard()) { // Evaluating line by line
			for (Tile frame : line) { // Evaluating frame by frame for each line
				
				if ( !(frame instanceof OceanTile) && frame.fill() ) { // If the tile is a filled land
					actualPlayer = (PlayerArmy) frame.getPresentCharacter().getPlayer();
					
					if (frame instanceof PlainTile) { // If it's a plain tile
						addedScore = 1 + frame.getPresentCharacter().getNbOr();
					}
					
					else if (frame instanceof ForestTile) { // If it's a forest tile
						addedScore = 2 + frame.getPresentCharacter().getNbOr();
					}
					
					else { // Else (Mountain / Desert)
						addedScore = 4 + frame.getPresentCharacter().getNbOr();
					}
					
					actualPlayer.setScore( actualPlayer.getScore() + addedScore ); // Add the gold amount owned by the character and the tile value to the player previous score
					actualPlayer.setNbTileOwned( actualPlayer.getNbTileOwned() + 1 );
				}
				
			}
		}
		
		
		PlayerArmy winnerPlayer = this.getPlayersArray()[0]; // Initialization
		
		for (int i2 = 0; i2 < nbPlayers; i2++) { // For each players, add them score with them golds and eval if them have more than 10 territory
			actualPlayer = this.getPlayersArray()[i2];
			
			actualPlayer.setScore( actualPlayer.getScore() + actualPlayer.getNbrGold() + (10 <= actualPlayer.getNbTileOwned() ? 5 : 0) );
			
			System.out.println(actualPlayer.getName() + " : " + actualPlayer.getScore() + " points !");
			
			if (winnerPlayer.getScore() < actualPlayer.getScore()) { // If the evaluated player has more than the previous 'winner'
				winnerPlayer = actualPlayer;
			}
		}
		
		System.out.println("\nThe winner is : " + winnerPlayer.getName() + "\n");
	}
	
}
