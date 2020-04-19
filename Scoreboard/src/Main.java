/**
 * Class for testing score board
 * @author Miro Vähä-Ruona
 * @version 18 April 2020
 */
public class Main {
	public static void main(String[] args) {
		ScoreBoard sb = new ScoreBoard();
		sb.addPlayer("Tim", 2);
		sb.addPlayer("MegaHacker", 0);
		sb.addPlayer("Topi", 6);
		sb.addPlayer("Meh", 99999);
		sb.addPlayer("Lockhart", -60);
		sb.addPlayer("Tim", 3);
		sb.addPlayer("asdf", 1);
		sb.addPlayer("fdsa", 0);
		
		System.out.println(sb);
		sb.sortAscending();
		System.out.println(sb);
		sb.sortDescending();
		System.out.println(sb);
	}
}
