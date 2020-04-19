import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Class for the score board
 * @author Miro Vähä-Ruona
 * @version 18 April 2020
 */
public class ScoreBoard {
	private ArrayList<Player> Players;
	private static final String PLAYER_FILE = "players.dat";
	ObjectOutputStream outputStream = null;
    ObjectInputStream inputStream = null;
    
    /**
     * Constructor for the score board
     */
    public ScoreBoard() {
    	Players = new ArrayList<Player>();
    }
    
    /**
	 * Method for adding a new player with just a name
	 * @param name Players name
	 */
	public void addPlayer(String name) {
		loadPlayerFile();
		Players.add(new Player(name));
		updatePlayerFile();
	}
	
	/**
	 * Method for adding new player with a name and points
	 * @param name Players name
	 * @param points Players points
	 */
	public void addPlayer(String name, int points) {
		loadPlayerFile();
		Players.add(new Player(name, points));
		updatePlayerFile();
	}
	
    /**
     * Method for getting the players
     * @return
     */
    public ArrayList<Player> getPlayers(){
    	loadPlayerFile();
    	return Players;
    }

    /**
     * Sorts the players to a descending order by their scores
     */
	public void sortDescending() {
		Collections.sort(Players);
		
	}
	
	/**
	 * Sorts the players to an ascending order by their scores
	 */
	public void sortAscending() {
		Collections.sort(Players, Collections.reverseOrder());
	}
	
	/**
	 * Method for turning scoreboard to string
	 */
	public String toString() {
		return Players.toString();
	}

	/**
	 * Loads the players from a file
	 */
	private void loadPlayerFile() {
		try {
			inputStream = new ObjectInputStream(new FileInputStream(PLAYER_FILE));
			Players = (ArrayList<Player>) inputStream.readObject();
		} catch (FileNotFoundException e) {
            System.out.println("File Not Found Error: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO Error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Class Not Found Error: " + e.getMessage());
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.flush();
                    outputStream.close();
                }
            } catch (IOException e) {
                System.out.println("IO Error: " + e.getMessage());
            }
        }	
		
	}
	
	/**
	 * Writes to the file containing player data
	 */
	private void updatePlayerFile() {
		try {
            outputStream = new ObjectOutputStream(new FileOutputStream(PLAYER_FILE));
            outputStream.writeObject(Players);
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found Error: " + e.getMessage() + ", the program will now try to make a new file");
        } catch (IOException e) {
            System.out.println("IO Error: " + e.getMessage());
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.flush();
                    outputStream.close();
                }
            } catch (IOException e) {
                System.out.println("IO Error: " + e.getMessage());
            }
        }
		
	}
	
}
