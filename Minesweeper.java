import java.util.Scanner;

public class Minesweeper {
    private static final int ROWS = 8;
    private static final int COLS = 8;
    private static final int MINES = 10;

    private char[][] board;
    private char[][] mineField;

    public Minesweeper() {
        board = new char[ROWS][COLS];
        mineField = new char[ROWS][COLS];
    }

    public void initialize() {
        // Initialize the board with hidden cells
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                board[i][j] = '-';
            }
        }

        // Randomly place mines
        for (int i = 0; i < MINES; i++) {
            int row, col;
            do {
                row = (int) (Math.random() * ROWS);
                col = (int) (Math.random() * COLS);
            } while (mineField[row][col] == '*');
            mineField[row][col] = '*';
        }
    }

    public void printBoard() {
        System.out.println("  0 1 2 3 4 5 6 7");
        for (int i = 0; i < ROWS; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < COLS; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void play(int row, int col) {
        if (mineField[row][col] == '*') {
            System.out.println("Game Over! You hit a mine.");
            revealMines();
            printBoard();
        } else {
            int count = countAdjacentMines(row, col);
            board[row][col] = (char) (count + '0');
            printBoard();
        }
    }

    private int countAdjacentMines(int row, int col) {
        int count = 0;
        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {
                if (i >= 0 && i < ROWS && j >= 0 && j < COLS && mineField[i][j] == '*') {
                    count++;
                }
            }
        }
        return count;
    }

    private void revealMines() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (mineField[i][j] == '*') {
                    board[i][j] = '*';
                }
            }
        }
    }

    public static void main(String[] args) {
        Minesweeper game = new Minesweeper();
        game.initialize();
        game.printBoard();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter row and column (separated by space): ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if (row < 0 || row >= ROWS || col < 0 || col >= COLS) {
                System.out.println("Invalid input. Please enter valid row and column.");
                continue;
            }

            game.play(row, col);
            if (game.board[row][col] != '-') {
                System.out.println("Congratulations! You won!");
                break;
            }
        }
        scanner.close();
    }
}
