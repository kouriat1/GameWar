package character;
import player.*;

public class CharacterWorker extends Character {
	
	private int resourceAmount;
	
	/**The constructor
	 * @param player The owner of this character
	 */
	public CharacterWorker(Player player) {
		super(player, 0);
		this.resourceAmount = 0;
	}
	
	
	/**Setter method of <code>resourceAmount</code> attribute
	 * @return The amount of resource owned by the character
	 */
	public int getResourceAmount() {
		return this.resourceAmount;
	}
	
	/**Setter method of <code>resourceAmount</code> attribute
	 * @param resourceAmount The new amount of resource owned by the character
	 */
	public void setResourceAmount(int resourceAmount) {
		this.resourceAmount = resourceAmount;
	}
}
