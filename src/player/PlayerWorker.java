package player;


public class PlayerWorker extends Player {
	
	/**The constructor
	 * @param name The name of the player
	 * @param nbrGold The amount of gold owned by the player
	 */
	public PlayerWorker(String name, int nbrGold) {
		super(name, nbrGold);
	}
	
	
	/**A predicate testing the equivalence of two objects
	 * @param o An object
	 * @return <code>true</code>(They are equals) / <code>false</code>(They aren't equals)
	 */
	public boolean equals(Object o) {
		if ((o instanceof PlayerWorker) && (o != null)) {
			PlayerWorker other = (PlayerWorker) o;
			return (this == other);
		}
		else {
			return false;
		}
	}
}
