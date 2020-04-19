import java.io.Serializable;

/**
 * Class for player
 * @author Miro Vähä-Ruona
 * @version 18 April 2020
 */
public class Player implements Serializable, Comparable<Player>{
	private String 	name;
	private int 	points;
	
	/**
	 * Constructor for a player with just a name. Basic score is zero (0)
	 * @param name Players name
	 */
	public Player(String name) {
		this.name = name;
	}
	
	/**
	 * Constructor for a player with name and points
	 * @param name Players name
	 * @param points Players points
	 */
	public Player(String name, int points) {
		this.name = name;
		this.points = points;
	}
	
	/**
	 * @return Players name
	 */
	public String getPlayerName() {
		return name;
	}
	
	/**
	 * @return Players points
	 */
	public int getPlayerPoints() {
		return points;
	}
	
	/**
	 * Method for setting players points
	 * @param points Amount of points to be set for a player
	 */
	public void setPlayerPoints(int points) {
		this.points = points;

	}
	
	/**
	 * Method for comparing players points
	 */
	@Override
	public int compareTo(Player player) {
		return ((Integer)(player.getPlayerPoints())).compareTo(getPlayerPoints());
	}
	
	public String toString() {
		return name + " " + points;
	}
	
}
