package character;
import player.*;

public class CharacterArmy extends Character {
	
	private int nbCharacter;
	
	
	/**The constructor
	 * @param player The owner of this character
	 * @param nbOr The amount of gold owned by the character
	 * @param nbCharacter The number of characters
	 */
	public CharacterArmy(Player player, int nbOr, int nbCharacter) {
		super(player, nbOr);
		this.nbCharacter = nbCharacter;
	}
	
	
	/**Setter method of <code>nbCharacter</code> attribute
	 * @return The number of characters
	 */
	public int getNbCharacter() {
		return this.nbCharacter;
	}
	
	/**Setter method of <code>nbCharacter</code> attribute
	 * @param nbPerson The new number of characters
	 */
	public void setNbCharacter(int nbPerson) {
		this.nbCharacter = nbPerson;
	}
}
