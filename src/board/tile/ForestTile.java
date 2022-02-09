package board.tile;


public class ForestTile extends Tile {

	/**The constructor
	 * @param x The x-axis coordinate
	 * @param y The y-axis coordinate
	 * @param maxCharacter The maximum size of characters can be on the tile
	 */
	public ForestTile(int x, int y, int maxCharacter) {
		super(x, y, maxCharacter);
	}

	/**The constructor
	 * @param x The x-axis coordinate
	 * @param y The y-axis coordinate
	 */
	public ForestTile(int x, int y) {
		super(x, y);
		this.maxCharacter = 5;
	}

}
