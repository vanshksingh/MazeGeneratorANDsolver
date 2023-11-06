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

        recursiveDivision(1, 1, cols - 2, rows - 2);
    }

    private void recursiveDivision(int x, int y, int width, int height) {
        if (width < 2 || height < 2) {
            return;
        }

        int wallX = x + 2 + (int) (Math.random() * (width - 2) / 2) * 2;
        int wallY = y + 2 + (int) (Math.random() * (height - 2) / 2) * 2;

        for (int i = y; i <= y + height; i++) {
            maze[i][wallX] = WALL;
        }

        for (int j = x; j <= x + width; j++) {
            maze[wallY][j] = WALL;
        }

        int gapX = x + 2 + (int) (Math.random() * (width - 2) / 2) * 2;
        int gapY = y + 2 + (int) (Math.random() * (height - 2) / 2) * 2;

        maze[gapY][gapX] = PATH;

        recursiveDivision(x, y, wallX - x - 1, wallY - y - 1);
        recursiveDivision(wallX + 1, y, x + width - wallX - 1, wallY - y - 1);
        recursiveDivision(x, wallY + 1, wallX - x - 1, y + height - wallY - 1);
        recursiveDivision(wallX + 1, wallY + 1, x + width - wallX - 1, y + height - wallY - 1);
    }

    public void solveMaze() {
        
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
