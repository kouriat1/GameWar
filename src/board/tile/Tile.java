package board.tile;
import character.Character;


public class Tile {

	protected Character presentCharacter;
	protected int maxCharacter;
	protected int[] pos;
	
	
	/**The constructor
	 * @param x The x-axis coordinate
	 * @param y The y-axis coordinate
	 * @param maxCharacter The maximum size of characters can be on the tile
	 */
	public Tile(int x, int y, int maxCharacter) {
		this.maxCharacter = maxCharacter;
		this.pos = new int[]{x,y};
	}
	
	/**The constructor
	 * @param x The x-axis coordinate
	 * @param y The y-axis coordinate
	 */
	protected Tile(int x, int y) {
		this.pos = new int[]{x,y};
	}
	
	
	/**Getter method of <code>presentCharacter</code> attribute
	 * @return The character on the tile or null
	 */
	public Character getPresentCharacter() {
		return this.presentCharacter;
	}
	
	/**Setter method of <code>presentCharacter</code> attribute
	 * @param presentCharacter The character to set on the tile
	 */
	public void setPresentCharacter(Character presentCharacter) {
		this.presentCharacter = presentCharacter;
	}
	
	/**Getter method of <code>maxCharacter</code> attribute
	 * @return The maximum size of characters on the tile or null
	 */
	public int getMaxCharacter() {
		return this.maxCharacter;
	}
	
	/**Setter method of <code>maxCharacter</code> attribute
	 * @param maxCharacter The maximum size of characters can be on the tile
	 */
	public void setMaxCharacter(int maxCharacter) {
		this.maxCharacter = maxCharacter;
	}

	/**Getter method of <code>pos</code> attribute
	 * @return The coordinates of the tile
	 */
	public int[] getPos() {
		return this.pos;
	}

	/**Setter method of <code>pos</code> attribute
	 * @param pos The coordinates of the tile
	 */
	public void setPos(int[] pos) {
		this.pos = pos;
	}
	
	/**A predicate evaluating if the tile is filled
	 * @return <code>true</code>(Filled) / <code>false</code>(Empty)
	 */
	public boolean fill() {
		return (this.presentCharacter != null) || (this.maxCharacter == 0);
	}
}
