
import java.util.Scanner;

public class TicTacToe {

	public static void main(String[] args) {
		String player = "1";
		char checkp = 'O';
		char[][] board = { { '#', '#', '#' }, { '#', '#', '#' }, { '#', '#', '#' } };
		while (true) {
			for (int j = 2; j > -1; j--) {
				for (int i = 0; i < board[j].length; i++) {
					char current = board[j][i];
					System.out.print(current + " ");
				}
				System.out.println();
			}

			// Check if someone won
			for (int i = 2; i > -1; i--) {
				// Columns
				int X = 0;
				int Y = 0;
				for (int k = 2; k > -1; k--) {
					for (int j = 2; j > -1; j--) {
						if (board[Y][X] == checkp) {
							Y = Y + 1;
						}
						if (Y > 2) {
							System.out.print("Player " + player + " wins!");
							System.exit(j);
						}
					}
					X = X + 1;
				}

				// Rows
				X = 0;
				Y = 0;
				for (int k = 2; k > -1; k--) {
					for (int j = 2; j > -1; j--) {
						if (board[X][Y] == checkp) {
							Y = Y + 1;
						}
						if (Y > 2) {
							System.out.print("Player " + player + " wins!");
							System.exit(j);
						}
					}
					X = X + 1;
				}

				// Diagonal (bottom left corner to top right corner)
				X = 0;
				Y = 0;
				for (int k = 2; k > -1; k--) {
					for (int j = 2; j > -1; j--) {
						if (board[Y][X] == 'O') {
							Y = Y + 1;
							X = X + 1;
						}
						if (Y > 2) {
							System.out.print("Player " + player + " wins!");
							System.exit(j);
						}
					}
				}

				// Diagonal (top left corner to bottom right corner)
				X = 2;
				Y = 2;
				for (int k = 2; k > -1; k--) {
					for (int j = 2; j > -1; j--) {
						if (board[Y][X] == 'O') {
							Y = Y - 1;
							X = X - 1;
						}
						if (Y < 0) {
							System.out.print("Player " + player + " wins!");
							System.exit(j);
						}
					}
				}
				checkp = 'X';
			}
			// End of check

			System.out.println("Where would P" + player + " like to go? Type coordinates. (Bottom left corner is 1,1)");
			Scanner scan = new Scanner(System.in);
			int inputX = scan.nextInt() - 1;
			int inputY = scan.nextInt() - 1;
			try {
				if (board[inputY][inputX] == '#') {
					if (player.equals("1")) {
						board[inputY][inputX] = 'O';

					} else {
						board[inputY][inputX] = 'X';
					}
					if (player.equals("1")) {
						player = "2";
					} else {
						player = "1";
					}
				} else {
					System.out.println("That space isn't free!");
				}
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("That's not on the board you dummy, try that again.");
			}

		}
	}

}
