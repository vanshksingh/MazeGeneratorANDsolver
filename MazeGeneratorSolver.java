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
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                maze[i][j] = WALL;
            }
        }

        divide(1, 1, rows - 2, cols - 2);
    }

    private void divide(int startX, int startY, int width, int height) {
        if (width < 2 || height < 2) {
            return;
        }

        int wallX = startX + randomEven(width);
        int wallY = startY + randomEven(height);

        for (int i = startX; i < startX + width; i++) {
            maze[wallY][i] = PATH;
        }
        for (int i = startY; i < startY + height; i++) {
            maze[i][wallX] = PATH;
        }

        int passageX = startX + randomEven(width - 1);
        int passageY = startY + randomEven(height - 1);

        maze[passageY][passageX] = PATH;

        divide(startX, startY, wallX - startX, wallY - startY);
        divide(wallX + 1, startY, startX + width - wallX - 1, wallY - startY);
        divide(startX, wallY + 1, wallX - startX, startY + height - wallY - 1);
        divide(wallX + 1, wallY + 1, startX + width - wallX - 1, startY + height - wallY - 1);
    }

    private int randomEven(int max) {
        return 2 * (int) (Math.random() * (max / 2 + 1));
    }

    public void solveMaze() {
        // Implement your maze-solving algorithm here
        // You can use depth-first search or other search algorithms
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

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Menu:");
            System.out.println("1. Generate Maze");
            System.out.println("2. Solve Maze");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    mazeGenerator.generateMaze();
                    mazeGenerator.printMaze();
                    break;
                case 2:
                    mazeGenerator.solveMaze();
                    mazeGenerator.printMaze();
                    break;
                case 3:
                    System.out.println("Exiting program.");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
                    break;
            }
        }
        scanner.close();
    }
}
