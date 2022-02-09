package character;
import player.*;

public class Character {

    protected Player player;
	protected int nbOr;
	
	
	/**The constructor
	 * @param player The owner of this character
	 * @param nbOr The amount of gold owned by the character
	 */
	public Character(Player player, int nbOr) {
		
		this.player = player;
		this.nbOr = nbOr;
		
	}
	
	
	/**Getter method of <code>player</code> attribute
	 * @return The owner of this character
	 */
	public Player getPlayer() {
		return this.player;
	}
	
	/**Setter method of <code>player</code> attribute
	 * @param player The new owner of this character
	 */
	public void setPlayer(Player player) {
		this.player = player;
	}
	
	/**Getter method of <code>nbOr</code> attribute
	 * @return The amount of gold owned by the character
	 */
	public int getNbOr() {
		return this.nbOr;
	}
	
	/**Setter method of <code>nbOr</code> attribute
	 * @param nbOr The new amount of gold owned by the character
	 */
	public void setNbOr(int nbOr) {
		this.nbOr = nbOr;
	}
	
}
