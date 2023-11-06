import java.util.*;

public class MazeGeneratorSolver {
    private static final int WALL = 1;
    private static final int PATH = 0;

    private int[][] maze;
    private int rows;
    private int cols;

    public MazeGeneratorSolver(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.maze = new int[rows][cols];
    }

    public void generateMaze() {
        // Initialize the maze with walls
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                maze[i][j] = WALL;
            }
        }

        Random random = new Random();
        int startX = random.nextInt(cols);
        int startY = random.nextInt(rows);

        generateMazeRecursive(startX, startY);
    }

    private void generateMazeRecursive(int x, int y) {
        maze[y][x] = PATH;

        int[] directions = { 1, 2, 3, 4 };
        Collections.shuffle(Arrays.asList(directions));

        for (int direction : directions) {
            int nextX = x;
            int nextY = y;

            switch (direction) {
                case 1: // Up
                    nextY -= 2;
                    break;
                case 2: // Down
                    nextY += 2;
                    break;
                case 3: // Left
                    nextX -= 2;
                    break;
                case 4: // Right
                    nextX += 2;
                    break;
            }

            if (nextX > 0 && nextX < cols - 1 && nextY > 0 && nextY < rows - 1 && maze[nextY][nextX] == WALL) {
                maze[nextY][nextX] = PATH;
                maze[y + (nextY - y) / 2][x + (nextX - x) / 2] = PATH;
                generateMazeRecursive(nextX, nextY);
            }
        }
    }

    public void printMaze() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (maze[i][j] == WALL) {
                    System.out.print("█");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        MazeGeneratorSolver mazeGenerator = new MazeGeneratorSolver(21, 21);
        mazeGenerator.generateMaze();
        mazeGenerator.printMaze();
    }
}
