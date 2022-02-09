package board;
import board.tile.*;
import java.util.Random;

public class Board {

	private Tile[][] gameBoard;

	/**The constructor of a Board instance
	 * @param boardSize The size of the board
	 */
	public Board(int boardSize) {
		
		this.gameBoard = new Tile[boardSize][boardSize];
		
		int nbLandTileAvailable = Math.floorDiv(boardSize * boardSize, 3); //Nombre de tuile maximale disponible pour les terres (limite pour les 66% d'eau)
		
		Random random = new Random();
		int randomNumber = 4; // Initialization for no errors
		
		for (int line = 0; line < boardSize; line++) {
			for (int column = 0; column < boardSize; column++) {
				
				/*----------------------------------Choice of tile----------------------------------*/
				
				if (column == 0) {  // Border Left
					randomNumber = (nbLandTileAvailable <= 0) ? 4 : random.nextInt(5); // No land left (Mandatory OceanTile) : There is still land (5 possibilities)
				}
				
				
				else if (column == 1) {  // Only one tile to the left border
					if (this.gameBoard[line][column - 1] instanceof OceanTile) { // Left tile is an OceanTile
						randomNumber = (nbLandTileAvailable <= 0) ? 4 : random.nextInt(5); // No land left (Mandatory OceanTile) : There is still land (5 possibilities)
					}
		
					else { // Left tile is a land tile
						randomNumber = random.nextInt(4); // 4 possibilities
					}
				}
				
				
				else if ((column == boardSize - 1) && (1 <= line)) { // Border Right
					if (line == 1) {
						if ( (!(this.gameBoard[line - 1][column] instanceof OceanTile) && (this.gameBoard[line - 1][column - 1] instanceof OceanTile)) || // Either the top tile is land surrounded by ocean
								(!(this.gameBoard[line][column - 1] instanceof OceanTile) && (this.gameBoard[line][column - 2] instanceof OceanTile)) ) { // Either the left tile is land surrounded by ocean
							randomNumber = random.nextInt(4); // 4 possibilities
						}
						
						else {
							randomNumber = ((nbLandTileAvailable <= 0) || (line == boardSize - 1)) ? 4 : random.nextInt(5); // No land left or last case (Mandatory OceanTile) : There is still land (5 possibilities)
						}
					}
					
					else {
						if  ( (!(this.gameBoard[line - 1][column] instanceof OceanTile) && (this.gameBoard[line - 1][column - 1] instanceof OceanTile) && (this.gameBoard[line - 2][column] instanceof OceanTile)) || // Either the top tile is land surrounded by ocean
								(!(this.gameBoard[line][column - 1] instanceof OceanTile) && (this.gameBoard[line][column - 2] instanceof OceanTile)) ) { // Either the left tile is land surrounded by ocean
							randomNumber = random.nextInt(4); // 4 possibilities
						}
						
						else {
							randomNumber = ((nbLandTileAvailable <= 0) || (line == boardSize - 1)) ? 4 : random.nextInt(5); // No land left or last case (Mandatory OceanTile) : There is still land (5 possibilities)
						}
					}
				}
				
				
				else { // Two tiles or more to the left border and one tile to the right border
					if (this.gameBoard[line][column - 1] instanceof OceanTile) { // Left tile is an OceanTile
						randomNumber = (nbLandTileAvailable <= 0) ? 4 : random.nextInt(5); // No land left (Mandatory OceanTile) : There is still land (5 possibilities)
					}
					
					else { // Left tile is a land tile
						if (this.gameBoard[line][column - 2] instanceof OceanTile) { // The left tile is surrounded (left) by ocean
							randomNumber = random.nextInt(4); // 4 possibilities
						}
						
						else { // The left tile is surrounded (left) by one land or more
							randomNumber = (nbLandTileAvailable <= 0) ? 4 : random.nextInt(5); // No land left (Mandatory OceanTile) : There is still land (5 possibilities)
						}
					}	
				}
				
				
				/*----------------------------------Tile generation----------------------------------*/
				
				
				switch( randomNumber ) {
					case 0:
						this.gameBoard[line][column] = new MountainTile(column, line);
						nbLandTileAvailable--;
						break;
					case 1:
						this.gameBoard[line][column] = new PlainTile(column, line);
						nbLandTileAvailable--;
						break;
					case 2:
						this.gameBoard[line][column] = new ForestTile(column, line);
						nbLandTileAvailable--;
						break;
					case 3:
						this.gameBoard[line][column] = new DesertTile(column, line);
						nbLandTileAvailable--;
						break;
					case 4:
						this.gameBoard[line][column] = new OceanTile(column, line);
						break;
					default:
						break;
				}
				
			}
		}	
	}

	
	/**Getter method of <code>gameBoard</code> attribute
	 * @return The board
	 */
	public Tile[][] getGameBoard() {
		return this.gameBoard;
	}

	/**Setter method of <code>gameBoard</code> attribute
	 * @param gameBoard A board
	 */
	public void setGameBoard(Tile[][] gameBoard) {
		this.gameBoard = gameBoard;
	}
	
	
	/**A predicate evaluating if the each tile of the board is filled
	 * @return <code>true</code>(Filled) / <code>false</code>(Empty)
	 */
	public boolean boardFill() {
		for (Tile[] line : this.gameBoard) {
			for (Tile frame : line) {
				if (!frame.fill()) {
					return false;
				}
			}
		}
		return true;
	}
	
	
}
