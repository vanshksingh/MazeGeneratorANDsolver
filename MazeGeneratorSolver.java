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

        int currentX = startX;
        int currentY = startY;

        int visitedCells = 1;
        int totalCells = rows * cols;

        while (visitedCells < totalCells) {
            List<Integer> directions = Arrays.asList(1, 2, 3, 4);
            Collections.shuffle(directions);

            for (int direction : directions) {
                int nextX = currentX;
                int nextY = currentY;

                switch (direction) {
                    case 1: // Up
                        nextY = currentY - 1;
                        break;
                    case 2: // Down
                        nextY = currentY + 1;
                        break;
                    case 3: // Left
                        nextX = currentX - 1;
                        break;
                    case 4: // Right
                        nextX = currentX + 1;
                        break;
                }

                if (nextX > 0 && nextX < cols - 1 && nextY > 0 && nextY < rows - 1 && maze[nextY][nextX] == WALL) {
                    maze[nextY][nextX] = PATH;
                    maze[currentY][currentX] = PATH;
                    visitedCells++;
                }

                currentX = nextX;
                currentY = nextY;
            }
        }
    }

    public void solveMaze() {
        // Implement your maze-solving algorithm here
        // You can use the depth-first search or other search algorithms
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
