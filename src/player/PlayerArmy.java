package player;

public class PlayerArmy extends Player {
	
	private int nbFood; 
	private int nbWarrior;
	
	
	/**The constructor
	 * @param name The name of the player
	 * @param nbrGold The amount of gold owned by the player
	 * @param nbFood The amount of food owned by the player
	 * @param nbWarrior The amount of warrior owned by the player
	 */
	public PlayerArmy(String name, int nbrGold, int nbFood, int nbWarrior) {
		super(name, nbrGold);
		this.nbWarrior = nbWarrior;
		this.nbFood = nbFood;
	}
	
	
	/**Getter method of <code>nbFood</code> attribute
	 * @return The amount of food owned by the player
	 */
	public int getNbFood(){
		return this.nbFood;
	}
	
	/**Getter method of <code>nbWarrior</code> attribute
	 * @return The amount of warrior owned by the player
	 */
	public int getNbWarrior(){
		return this.nbWarrior;
	}

	/**Setter method of <code>nbWarrior</code> attribute
	 * @param nbWarrior The new amount of warrior owned by the player
	 */
	public void setNbWarrior(int nbWarrior){
		this.nbWarrior = nbWarrior;
	}

	/**Setter method of <code>nbFood</code> attribute
	 * @param nbFood The new amount of food owned by the player
	 */
	public void setNbFood(int nbFood){
		this.nbFood = nbFood;
	}
	
	
	/**A predicate testing the equivalence of two objects
	 * @param o An object
	 * @return <code>true</code>(They are equals) / <code>false</code>(They aren't equals)
	 */
	public boolean equals(Object o) {
		if ((o instanceof PlayerArmy) && (o != null)) {
			PlayerArmy other = (PlayerArmy) o;
			return (this == other);
		}
		else {
			return false;
		}
	}
}
