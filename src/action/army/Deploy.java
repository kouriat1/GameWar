package action.army;

import action.Action;
import board.Board;
import board.tile.*;
import character.*;
import player.*;
import java.util.Random;

public class Deploy implements Action {
	
	private PlayerArmy player;
	private Board board;
	
	/* The constructor of an Deploy instance
	 * @param player The player who do this action
	 * @param board The board
	 */
	public Deploy(PlayerArmy player, Board board) {
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
	 * An action method to deploy an army, it display in the terminal the pos where the army was deployed and the consequence of the deployment
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
		
		/*----------------------------------Select and set army size----------------------------------*/
		
		int maxCharacterOnThisTile = gameBoard[randomLine][randomColumn].getMaxCharacter(); // Max size of the army on this tile
		int randomArmyDeployedSize = 1 + random.nextInt( (maxCharacterOnThisTile <= this.player.getNbWarrior()) ? maxCharacterOnThisTile : this.player.getNbWarrior() ); // Choose a random number between 1 and the minimum between the maximum size of the army deployable on this tile and the number of soldiers remaining
		
		CharacterArmy deployedArmy = new CharacterArmy(this.player, 0, randomArmyDeployedSize);
		gameBoard[randomLine][randomColumn].setPresentCharacter( deployedArmy ); // Set up the army on the tile
		
		System.out.println(this.player.getName() + " deploys an army of " + randomArmyDeployedSize + " soldiers on the tile (" + randomColumn + "," + randomLine + ") !");
		
		/*----------------------------------Calculation of army modifications----------------------------------*/
		
		if ((randomColumn == 0) && (randomLine == 0)) { // Top left corner
			gameBoard = this.rightTreatment(gameBoard, randomColumn, randomLine, randomArmyDeployedSize, deployedArmy);
			
			gameBoard = this.bottomTreatment(gameBoard, randomColumn, randomLine, randomArmyDeployedSize, deployedArmy);
		}
		
		
		else if ((randomColumn == (gameBoardSize - 1)) && (randomLine == 0)) { // Top right corner
			gameBoard = this.leftTreatment(gameBoard, randomColumn, randomLine, randomArmyDeployedSize, deployedArmy);
			
			gameBoard = this.bottomTreatment(gameBoard, randomColumn, randomLine, randomArmyDeployedSize, deployedArmy);
		}
		
		
		else if ((randomColumn == 0) && (randomLine == (gameBoardSize - 1))) { // Bottom left corner
			gameBoard = this.rightTreatment(gameBoard, randomColumn, randomLine, randomArmyDeployedSize, deployedArmy);
			
			gameBoard = this.topTreatment(gameBoard, randomColumn, randomLine, randomArmyDeployedSize, deployedArmy);
		}
		
		
		else if ((randomColumn == (gameBoardSize - 1)) && (randomLine == (gameBoardSize - 1))) { // Bottom right corner
			gameBoard = this.leftTreatment(gameBoard, randomColumn, randomLine, randomArmyDeployedSize, deployedArmy);
			
			gameBoard = this.topTreatment(gameBoard, randomColumn, randomLine, randomArmyDeployedSize, deployedArmy);
		}
		
		
		else if (randomLine == 0) { // Border top except top left and right corner
			gameBoard = this.rightTreatment(gameBoard, randomColumn, randomLine, randomArmyDeployedSize, deployedArmy);
			
			gameBoard = this.leftTreatment(gameBoard, randomColumn, randomLine, randomArmyDeployedSize, deployedArmy);
			
			gameBoard = this.bottomTreatment(gameBoard, randomColumn, randomLine, randomArmyDeployedSize, deployedArmy);
		}
		
		
		else if (randomColumn == 0) { // Border left except top and bottom left corner
			gameBoard = this.rightTreatment(gameBoard, randomColumn, randomLine, randomArmyDeployedSize, deployedArmy);
			
			gameBoard = this.topTreatment(gameBoard, randomColumn, randomLine, randomArmyDeployedSize, deployedArmy);
			
			gameBoard = this.bottomTreatment(gameBoard, randomColumn, randomLine, randomArmyDeployedSize, deployedArmy);
		}
		
		
		else if (randomLine == (gameBoardSize - 1)) { // Border bottom except bottom left and right corner
			gameBoard = this.rightTreatment(gameBoard, randomColumn, randomLine, randomArmyDeployedSize, deployedArmy);
			
			gameBoard = this.leftTreatment(gameBoard, randomColumn, randomLine, randomArmyDeployedSize, deployedArmy);
			
			gameBoard = this.topTreatment(gameBoard, randomColumn, randomLine, randomArmyDeployedSize, deployedArmy);
		}
		
		
		else if (randomColumn == (gameBoardSize - 1)) { // Border right except top and bottom right corner
			gameBoard = this.leftTreatment(gameBoard, randomColumn, randomLine, randomArmyDeployedSize, deployedArmy);
			
			gameBoard = this.topTreatment(gameBoard, randomColumn, randomLine, randomArmyDeployedSize, deployedArmy);
			
			gameBoard = this.bottomTreatment(gameBoard, randomColumn, randomLine, randomArmyDeployedSize, deployedArmy);
		}
		
		
		else { // Except borders
			gameBoard = this.leftTreatment(gameBoard, randomColumn, randomLine, randomArmyDeployedSize, deployedArmy);
			
			gameBoard = this.rightTreatment(gameBoard, randomColumn, randomLine, randomArmyDeployedSize, deployedArmy);
			
			gameBoard = this.topTreatment(gameBoard, randomColumn, randomLine, randomArmyDeployedSize, deployedArmy);
			
			gameBoard = this.bottomTreatment(gameBoard, randomColumn, randomLine, randomArmyDeployedSize, deployedArmy);
		}
		
		this.board.setGameBoard(gameBoard);
	}
	
	
	/* Treatment for the right tile when the player deploy an army
	 * @param gameBoard A board obtained
	 * @param randomColumn The column where the player deploy his army
	 * @param randomLine The line where the player deploy his army
	 * @param randomArmyDeployedSize The size of the deployed army
	 * @param deployedArmy The deployed army
	 * @return A modified board
	 */
	public Tile[][] rightTreatment(Tile[][] gameBoard, int randomColumn, int randomLine, int randomArmyDeployedSize, CharacterArmy deployedArmy) {
		if (!(gameBoard[randomLine][randomColumn + 1] instanceof OceanTile) && gameBoard[randomLine][randomColumn + 1].fill()) { // Right tile is a filled land
			
			CharacterArmy evaluatedArmy = (CharacterArmy) gameBoard[randomLine][randomColumn + 1].getPresentCharacter(); // The character to evaluate
			int evaluatedArmySizeAccordingToTile = (gameBoard[randomLine][randomColumn + 1] instanceof MountainTile) ? evaluatedArmy.getNbCharacter() + 2 : evaluatedArmy.getNbCharacter(); // The size of evaluated character (only use for enemy)
			
			if ( (this.player == evaluatedArmy.getPlayer()) && (evaluatedArmy.getNbCharacter() < randomArmyDeployedSize) ) { // The right tile is filled with an ally army and the army ally size is lower than the deployed army
				System.out.println("The ally army on the right tile is lower than the deployed army :");
				
				if ((evaluatedArmy.getNbCharacter() + 1) <= gameBoard[randomLine][randomColumn + 1].getMaxCharacter()) { // The size of ally army is lower than the max capacity of the tile
					evaluatedArmy.setNbCharacter(evaluatedArmy.getNbCharacter() + 1);
					System.out.println("\tThe ally army grow up, they are now " + evaluatedArmy.getNbCharacter());
				}
				
				deployedArmy.setNbOr( deployedArmy.getNbOr() + 1 );
				System.out.println("\tThe deployed army obtains 1 gold");
			}
			
			else if ( (this.player != evaluatedArmy.getPlayer()) && (evaluatedArmySizeAccordingToTile < randomArmyDeployedSize) ) { // The right tile is filled with an enemy army and the size of enemy army is lower than the deployed army
				System.out.println("The enemy army on the right tile is lower than the deployed army :");
				evaluatedArmy.setNbCharacter( evaluatedArmy.getNbCharacter() / 2 );
				
				if (evaluatedArmy.getNbCharacter() < 1) { // The size of enemy army is lower than 1, The player capture the territory
					evaluatedArmy = new CharacterArmy(this.player, evaluatedArmy.getNbOr(), 1);
					deployedArmy.setNbOr( deployedArmy.getNbOr() + 2 );
					System.out.println("\tThe enemy army is converted, " + this.player.getName() + " gets the territory !\n\tThe deployed army obtains 2 gold");
				}
			}
			
			gameBoard[randomLine][randomColumn + 1].setPresentCharacter(evaluatedArmy);
		}
		
		return gameBoard;
	}
	
	/* Treatment for the bottom tile when the player deploy an army
	 * @param gameBoard A board obtained
	 * @param randomColumn The column where the player deploy his army
	 * @param randomLine The line where the player deploy his army
	 * @param randomArmyDeployedSize The size of the deployed army
	 * @param deployedArmy The deployed army
	 * @return A modified board
	 */
	public Tile[][] bottomTreatment(Tile[][] gameBoard, int randomColumn, int randomLine, int randomArmyDeployedSize, CharacterArmy deployedArmy) {
		if (!(gameBoard[randomLine + 1][randomColumn] instanceof OceanTile) && gameBoard[randomLine + 1][randomColumn].fill()) { // Bottom tile is a filled land
			
			CharacterArmy evaluatedArmy = (CharacterArmy) gameBoard[randomLine + 1][randomColumn].getPresentCharacter(); // The character to evaluate
			int evaluatedArmySizeAccordingToTile = (gameBoard[randomLine + 1][randomColumn] instanceof MountainTile) ? evaluatedArmy.getNbCharacter() + 2 : evaluatedArmy.getNbCharacter(); // The size of evaluated character (only use for enemy)

			if ( (this.player == evaluatedArmy.getPlayer()) && (evaluatedArmy.getNbCharacter() < randomArmyDeployedSize) ) { // The bottom tile is filled with an ally army and the army ally size is lower than the deployed army
				System.out.println("The ally army on the bottom tile is lower than the deployed army :");

				if ((evaluatedArmy.getNbCharacter() + 1) <= gameBoard[randomLine + 1][randomColumn].getMaxCharacter()) { // The size of ally army is lower than the max capacity of the tile
					evaluatedArmy.setNbCharacter(evaluatedArmy.getNbCharacter() + 1);
					System.out.println("\tThe ally army grow up, they are now " + evaluatedArmy.getNbCharacter());
				}

				deployedArmy.setNbOr( deployedArmy.getNbOr() + 1 );
				System.out.println("\tThe deployed army obtains 1 gold");
			}

			else if ( (this.player != evaluatedArmy.getPlayer()) && (evaluatedArmySizeAccordingToTile < randomArmyDeployedSize) ) { // The bottom tile is filled with an enemy army and the size of enemy army is lower than the deployed army
				System.out.println("The enemy army on the bottom tile is lower than the deployed army :");
				evaluatedArmy.setNbCharacter( evaluatedArmy.getNbCharacter() / 2 );

				if (evaluatedArmy.getNbCharacter() < 1) { // The size of enemy army is lower than 1, The player capture the territory
					evaluatedArmy = new CharacterArmy(this.player, evaluatedArmy.getNbOr(), 1);
					deployedArmy.setNbOr( deployedArmy.getNbOr() + 2 );
					System.out.println("\tThe enemy army is converted, " + this.player.getName() + " gets the territory !\n\tThe deployed army obtains 2 gold");
				}
			}

			gameBoard[randomLine + 1][randomColumn].setPresentCharacter(evaluatedArmy);
		}
		
		return gameBoard;
	}
	
	/* Treatment for the left tile when the player deploy an army
	 * @param gameBoard A board obtained
	 * @param randomColumn The column where the player deploy his army
	 * @param randomLine The line where the player deploy his army
	 * @param randomArmyDeployedSize The size of the deployed army
	 * @param deployedArmy The deployed army
	 * @return A modified board
	 */
	public Tile[][] leftTreatment(Tile[][] gameBoard, int randomColumn, int randomLine, int randomArmyDeployedSize, CharacterArmy deployedArmy) {
		if (!(gameBoard[randomLine][randomColumn - 1] instanceof OceanTile) && gameBoard[randomLine][randomColumn - 1].fill()) { // Left tile is a filled land
			
			CharacterArmy evaluatedArmy = (CharacterArmy) gameBoard[randomLine][randomColumn - 1].getPresentCharacter(); // The character to evaluate
			int evaluatedArmySizeAccordingToTile = (gameBoard[randomLine][randomColumn - 1] instanceof MountainTile) ? evaluatedArmy.getNbCharacter() + 2 : evaluatedArmy.getNbCharacter(); // The size of evaluated character (only use for enemy)
			
			if ( (this.player == evaluatedArmy.getPlayer()) && (evaluatedArmy.getNbCharacter() < randomArmyDeployedSize) ) { // The left tile is filled with an ally army and the army ally size is lower than the deployed army
				System.out.println("The ally army on the left tile is lower than the deployed army :");
				
				if ((evaluatedArmy.getNbCharacter() + 1) <= gameBoard[randomLine][randomColumn - 1].getMaxCharacter()) { // The size of ally army is lower than the max capacity of the tile
					evaluatedArmy.setNbCharacter(evaluatedArmy.getNbCharacter() + 1);
					System.out.println("\tThe ally army grow up, they are now " + evaluatedArmy.getNbCharacter());
				}
				
				deployedArmy.setNbOr( deployedArmy.getNbOr() + 1 );
				System.out.println("\tThe deployed army obtains 1 gold");
			}
			
			else if ( (this.player != evaluatedArmy.getPlayer()) && (evaluatedArmySizeAccordingToTile < randomArmyDeployedSize) ) { // The left tile is filled with an enemy army and the size of enemy army is lower than the deployed army
				System.out.println("The enemy army on the left tile is lower than the deployed army :");
				evaluatedArmy.setNbCharacter( evaluatedArmy.getNbCharacter() / 2 );
				
				if (evaluatedArmy.getNbCharacter() < 1) { // The size of enemy army is lower than 1, The player capture the territory
					evaluatedArmy = new CharacterArmy(this.player, evaluatedArmy.getNbOr(), 1);
					deployedArmy.setNbOr( deployedArmy.getNbOr() + 2 );
					System.out.println("\tThe enemy army is converted, " + this.player.getName() + " gets the territory !\n\tThe deployed army obtains 2 gold");
				}
			}
			
			gameBoard[randomLine][randomColumn - 1].setPresentCharacter(evaluatedArmy);
		}
		
		return gameBoard;
	}
	
	/* Treatment for the top tile when the player deploy an army
	 * @param gameBoard A board obtained
	 * @param randomColumn The column where the player deploy his army
	 * @param randomLine The line where the player deploy his army
	 * @param randomArmyDeployedSize The size of the deployed army
	 * @param deployedArmy The deployed army
	 * @return A modified board
	 */
	public Tile[][] topTreatment(Tile[][] gameBoard, int randomColumn, int randomLine, int randomArmyDeployedSize, CharacterArmy deployedArmy) {
		if (!(gameBoard[randomLine - 1][randomColumn] instanceof OceanTile) && gameBoard[randomLine - 1][randomColumn].fill()) { // Top tile is a filled land

			CharacterArmy evaluatedArmy = (CharacterArmy) gameBoard[randomLine - 1][randomColumn].getPresentCharacter(); // The character to evaluate
			int evaluatedArmySizeAccordingToTile = (gameBoard[randomLine - 1][randomColumn] instanceof MountainTile) ? evaluatedArmy.getNbCharacter() + 2 : evaluatedArmy.getNbCharacter(); // The size of evaluated character (only use for enemy)
			
			if ( (this.player == evaluatedArmy.getPlayer()) && (evaluatedArmy.getNbCharacter() < randomArmyDeployedSize) ) { // The top tile is filled with an ally army and the army ally size is lower than the deployed army
				System.out.println("The ally army on the top tile is lower than the deployed army :");
				
				if ((evaluatedArmy.getNbCharacter() + 1) <= gameBoard[randomLine - 1][randomColumn].getMaxCharacter()) { // The size of ally army is lower than the max capacity of the tile
					evaluatedArmy.setNbCharacter(evaluatedArmy.getNbCharacter() + 1);
					System.out.println("\tThe ally army grow up, they are now " + evaluatedArmy.getNbCharacter());
				}
				
				deployedArmy.setNbOr( deployedArmy.getNbOr() + 1 );
				System.out.println("\tThe deployed army obtains 1 gold");
			}
			
			else if ( (this.player != evaluatedArmy.getPlayer()) && (evaluatedArmySizeAccordingToTile < randomArmyDeployedSize) ) { // The top tile is filled with an enemy army and the size of enemy army is lower than the deployed army
				System.out.println("The enemy army on the top tile is lower than the deployed army :");
				evaluatedArmy.setNbCharacter( evaluatedArmy.getNbCharacter() / 2 );
				
				if (evaluatedArmy.getNbCharacter() < 1) { // The size of enemy army is lower than 1, The player capture the territory
					evaluatedArmy = new CharacterArmy(this.player, evaluatedArmy.getNbOr(), 1);
					deployedArmy.setNbOr( deployedArmy.getNbOr() + 2 );
					System.out.println("\tThe enemy army is converted, " + this.player.getName() + " gets the territory !\n\tThe deployed army obtains 2 gold");
				}
			}
			
			gameBoard[randomLine - 1][randomColumn].setPresentCharacter(evaluatedArmy);
		}
		
		return gameBoard;
	}
}
