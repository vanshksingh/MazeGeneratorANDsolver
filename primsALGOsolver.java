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

    maze[startY][startX] = PATH;

    List<Point> walls = new ArrayList<>();
    walls.add(new Point(startX + 1, startY));
    walls.add(new Point(startX - 1, startY));
    walls.add(new Point(startX, startY + 1));
    walls.add(new Point(startX, startY - 1));

    while (!walls.isEmpty()) {
        int randomIndex = random.nextInt(walls.size());
        Point current = walls.get(randomIndex);
        int x = current.x;
        int y = current.y;
        walls.remove(randomIndex);

        if (x < 1 || x >= cols - 1 || y < 1 || y >= rows - 1 || maze[y][x] == PATH) {
            continue;
        }

        maze[y][x] = PATH;

        List<Point> neighbors = new ArrayList<>();
        neighbors.add(new Point(x + 1, y));
        neighbors.add(new Point(x - 1, y));
        neighbors.add(new Point(x, y + 1));
        neighbors.add(new Point(x, y - 1));

        for (Point neighbor : neighbors) {
            int nx = neighbor.x;
            int ny = neighbor.y;
            if (nx >= 1 && nx < cols - 1 && ny >= 1 && ny < rows - 1 && maze[ny][nx] == WALL) {
                walls.add(new Point(nx, ny));
            }
        }
    }
}
