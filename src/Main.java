import java.util.Scanner;

/**
 * The main class of this game that reads user input from STDIN and print output
 * to STDOUT
 * 
 * @author Nestor Qin
 */
public class Main {
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		Game game = new Game();
		intro();
		String command = console.nextLine();
		while (!command.equals("EXIT")) {
			while (command.length() == 0) {
				// Skip empty input
				command = console.nextLine();
			}
			String[] parts = command.split(" ");
			if (parts[0].equals("PUT")) {
				if (parts.length == 2) {
					try {
						game.put(Integer.parseInt(parts[1]));
					} catch (NumberFormatException e) {
						printCommands();
					}
				} else {
					printCommands();
				}
			} else if (parts[0].equals("GET")) {
				game.get();
			} else if (parts[0].equals("BOARD")) {
				game.board();
			} else {
				printCommands();
			}
			command = console.nextLine();
		}
		console.close();
	}
	
	/**
	 * prints the introduction of this game
	 */
	public static void intro() {
		System.out.println("This is the game 9dt, or 98point6 drop token.");
		System.out.println("In this game, 2 players drop tokens on a 4x4 grid. A player wins ");
		System.out.println("when they have 4 tokens next to each other either along a row,");
		System.out.println("in a column, or on a diagonal.");
		System.out.println();
		printCommands();
	}
	
	/**
	 * prints all available commands to STDOUT
	 */
	public static void printCommands() {
		System.out.println("Available Commands: PUT <column>, GET, BOARD, EXIT");
	}
}
