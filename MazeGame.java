import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MazeGame extends JFrame implements KeyListener {
    private static final int MAZE_SIZE = 10; // Adjust maze size as needed
    private char[][] maze;
    private int playerX, playerY; // Player position

    public MazeGame() {
        setTitle("Maze Game");
        setSize(600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        addKeyListener(this);

        maze = generateMaze();
        playerX = 1; // Start position
        playerY = 1;
    }

    private char[][] generateMaze() {
        // Implement maze generation algorithm (e.g., Randomized Prim's, Recursive Backtracking)
        // Return a randomly generated maze represented as a 2D char array
        // 'X' for walls, ' ' for empty spaces, 'S' for start, 'E' for end
        // Example:
        char[][] maze = new char[MAZE_SIZE][MAZE_SIZE];
        // Generate maze content
        return maze;
    }

    private void displayMaze(Graphics g) {
        int cellSize = 50; // Adjust cell size as needed
        for (int i = 0; i < MAZE_SIZE; i++) {
            for (int j = 0; j < MAZE_SIZE; j++) {
                int x = j * cellSize;
                int y = i * cellSize;
                if (maze[i][j] == 'X') {
                    g.setColor(Color.BLACK);
                    g.fillRect(x, y, cellSize, cellSize);
                } else if (maze[i][j] == 'S') {
                    g.setColor(Color.GREEN);
                    g.fillRect(x, y, cellSize, cellSize);
                } else if (maze[i][j] == 'E') {
                    g.setColor(Color.RED);
                    g.fillRect(x, y, cellSize, cellSize);
                }
                // Add more conditions for displaying other elements of the maze
            }
        }
    }

    private void movePlayer(int dx, int dy) {
        // Check if the move is valid and update player position accordingly
        int newX = playerX + dx;
        int newY = playerY + dy;
        if (newX >= 0 && newX < MAZE_SIZE && newY >= 0 && newY < MAZE_SIZE && maze[newY][newX] != 'X') {
            playerX = newX;
            playerY = newY;
        }
        repaint(); // Redraw the maze after player movement
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        displayMaze(g);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) {
            movePlayer(-1, 0);
        } else if (key == KeyEvent.VK_RIGHT) {
            movePlayer(1, 0);
        } else if (key == KeyEvent.VK_UP) {
            movePlayer(0, -1);
        } else if (key == KeyEvent.VK_DOWN) {
            movePlayer(0, 1);
        }
        // Add more key handling if needed
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MazeGame game = new MazeGame();
            game.setVisible(true);
        });
    }
    }
             
