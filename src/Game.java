import java.util.LinkedList;
import java.util.Queue;

/**
 * This class is the main Game class, store the state of this game
 * and provides the command methods
 * 
 * @author Nestor Qin
 */
public class Game {
	// The dimension of the board, use constant to change it easily if needed
	public static final int DIMENSION = 4;
	private int[][] board;
	private int[] colSizes;
	private int[] rowSizes;
	private int totalSize;
	private Queue<Integer> history;
	private boolean playerOneTurn;
	private boolean isFinished;
	
	/**
	 * initial the game
	 */
	public Game() {
		this.board = new int[DIMENSION][DIMENSION];
		this.colSizes = new int[DIMENSION];
		this.rowSizes = new int[DIMENSION];
		this.history = new LinkedList<>();
		this.playerOneTurn = true;
		this.isFinished = false;
	}
	
	/*
	 * Print the board
	 */
	public void board() {
		for (int i = DIMENSION - 1; i >= 0; i--) {
			System.out.print("|");
			for (int j = 0; j < DIMENSION; j++) {
				System.out.print(" " + board[i][j]);
			}
			System.out.println();
		}
		System.out.print("+");
		for (int i = 0; i < 2 * DIMENSION; i++) {
			System.out.print("-");
		}
		System.out.println();
		System.out.print(" ");
		for (int i = 0; i < DIMENSION; i++) {
			System.out.print(" " + (i + 1));
		}
		System.out.println();
	}
	
	/*
	 * list the columns that have been successfully put to
	 */
	public void get() {
		for (int col : history) {
			System.out.println(col);
		}
	}
	
	/**
	 * drop a token into the specified column if allowed
	 * @param col the column to drop the token
	 */
	public void put(int col) {
		if (isFinished || col > DIMENSION || colSizes[col - 1] == DIMENSION) {
			System.out.println("ERROR");
			return;
		}
		board[colSizes[col - 1]][col - 1] = playerOneTurn ? 1 : 2;
		rowSizes[colSizes[col - 1]]++;
		colSizes[col - 1]++;
		totalSize++;
		history.add(col);
		System.out.println(checkIfFinish(col));
		playerOneTurn = !playerOneTurn;
	}
	
	/*
	 * Check if the game is finished
	 */
	private String checkIfFinish(int col) {
		int currentPlayer = playerOneTurn ? 1 : 2;
		int row = colSizes[col - 1];
		// check column
		if (colSizes[col - 1] == DIMENSION) {
			int i = 0;
			while (i < DIMENSION && board[i][col - 1] == currentPlayer) {
				i++;
			}
			if (i == DIMENSION) {
				isFinished = true;
				return "WIN";
			}
		}
		// check row
		if (rowSizes[colSizes[col - 1] - 1] == DIMENSION) {
			int i = 0;
			while (i < DIMENSION && board[row - 1][i] == currentPlayer) {
				i++;
			}
			if (i == DIMENSION) {
				isFinished = true;
				return "WIN";
			}
		}
		// check diagonal
		if (row == DIMENSION && col == DIMENSION) {
			// check left-bottom to right-top diagonal
			int i = 0;
			while (i < DIMENSION && board[i][i] == currentPlayer) {
				i++;
			}
			if (i == DIMENSION) {
				isFinished = true;
				return "WIN";
			}
		} else if (row == DIMENSION && col == 1) {
			// check right-bottom to left-top diagonal
			int i = 0;
			while (i < DIMENSION && board[i][DIMENSION - 1 - i] == currentPlayer) {
				i++;
			}
			if (i == DIMENSION) {
				isFinished = true;
				return "WIN";
			}
		}
		// check draw
		if (totalSize == DIMENSION * DIMENSION) {
			// the board is full
			isFinished = true;
			return "DRAW";
		}
		return "OK";
	}
}
