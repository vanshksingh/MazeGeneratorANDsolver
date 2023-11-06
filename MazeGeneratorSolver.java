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

    public void solveMaze() {
        boolean[][] visited = new boolean[rows][cols];
        Stack<Point> stack = new Stack<>();
        Point start = new Point(1, 1);
        Point end = new Point(cols - 2, rows - 2);

        stack.push(start);

        while (!stack.isEmpty()) {
            Point current = stack.peek();
            int x = current.x;
            int y = current.y;
            visited[y][x] = true;

            if (current.equals(end)) {
                return; // Maze solved
            }

            int[] dx = {1, 0, -1, 0};
            int[] dy = {0, 1, 0, -1};

            boolean found = false;

            for (int i = 0; i < 4; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];

                if (nextX >= 0 && nextX < cols && nextY >= 0 && nextY < rows && !visited[nextY][nextX] && maze[nextY][nextX] == PATH) {
                    stack.push(new Point(nextX, nextY));
                    found = true;
                    break;
                }
            }

            if (!found) {
                stack.pop(); // Backtrack
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
        Scanner scanner = new Scanner(System.in);
        MazeGeneratorSolver mazeGenerator = new MazeGeneratorSolver(21, 21);

        while (true) {
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
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
                    break;
            }
        }
    }
}

class Point {
    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Point point = (Point) obj;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
