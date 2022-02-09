package player;


public class Player {

	protected String name;	
	protected int nbrGold;
	protected int score;
	protected int nbTileOwned;
	
	
	/**The constructor
	 * @param name The name of the player
	 * @param nbrGold The amount of gold owned by the player
	 */
	public Player(String name, int nbrGold) {
		this.name = name;
		this.nbrGold = nbrGold;
		this.score = 0;
	}
	
	
	/**Getter method of <code>name</code> attribute
	 * @return The name of the player
	 */
	public String getName() {
		return this.name;
	}
	
	/**Setter method of <code>name</code> attribute
	 * @param name The new name of the player
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**Getter method of <code>nbrGold</code> attribute
	 * @return The amount of gold owned by the player
	 */
	public int getNbrGold() {
		return this.nbrGold;
	}
	
	/**Setter method of <code>nbrGold</code> attribute
	 * @param nbrGold The new amount of gold owned by the player
	 */
	public void setNbrGold(int nbrGold) {
		this.nbrGold = nbrGold;
	}
	
	/**Getter method of <code>score</code> attribute
	 * @return The score of the player
	 */
	public int getScore() {
		return this.score;
	}
	
	/**Getter method of <code>score</code> attribute
	 * @param score The new score of the player
	 */
	public void setScore(int score) {
		this.score = score;
	}
	
	/**Getter method of <code>nbTileOwned</code> attribute
	 * @return The amount of owned tile by the player
	 */
	public int getNbTileOwned() {
		return this.nbTileOwned;
	}
	
	/**Getter method of <code>nbTileOwned</code> attribute
	 * @param nbTileOwned The amount of owned tile by the player
	 */
	public void setNbTileOwned(int nbTileOwned) {
		this.nbTileOwned = nbTileOwned;
	}
	
	
	/**A predicate testing the equivalence of two objects
	 * @param o An object
	 * @return <code>true</code>(They are equals) / <code>false</code>(They aren't equals)
	 */
	public boolean equals(Object o) {
		if ((o instanceof Player) && (o != null)) {
			Player other = (Player) o;
			return (this == other);
		}
		else {
			return false;
		}
	}
}
