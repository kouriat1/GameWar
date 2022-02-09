package action.army;

import action.Action;
import player.Player;
import player.PlayerArmy;

public class Pass implements Action {
	
	private PlayerArmy player;
	
	/* The constructor of an Pass instance
	 * @param player The player who do this action
	 */
	public Pass(PlayerArmy player) {
		this.player = player;
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
	

	/* 
	 * An action method to pass, it display a message in the terminal 
	 */
	public void doAction() {
		System.out.println( this.player.getName() + " choose to pass ..." );
	}

}
