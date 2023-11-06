# MazeGeneratorANDsolver


# Maze Solver

## Overview

**Maze Solver** is a Java application that generates and solves mazes using a graphical user interface. This program employs a maze generation algorithm and a maze-solving algorithm to create visually appealing mazes and find a path from the maze's start to its end. This README provides a thorough understanding of the code, its logic, the chosen algorithm, implemented techniques, and explanations of why alternative algorithms were not used.

**Author: vanshksingh**

## Table of Contents

- [Getting Started](#getting-started)
- [Features](#features)
- [How to Use](#how-to-use)
- [Code Logic](#code-logic)
- [Maze Generation Algorithm](#maze-generation-algorithm)
- [Maze Solving Algorithm](#maze-solving-algorithm)
- [Customization](#customization)
- [Contributing](#contributing)
- [License](#license)

## Getting Started

To run the Maze Solver locally, Java must be installed on your system. Follow these steps:

1. Clone or download the repository to your computer.

2. Open your terminal or command prompt and navigate to the project directory.

3. Compile and run the Maze.java file:

   ```bash
   javac Maze.java
   java Maze
   ```

4. A graphical window will appear, allowing you to start and stop maze generation and solving.

## Features

**Maze Solver** offers the following features:

- Generates random mazes with customizable parameters.
- Solves the generated maze using a recursive algorithm.
- Provides control over maze generation and solving speed.
- Offers a colorful and visually appealing graphical interface.

## How to Use

1. Run the application by executing the `Maze` class. The graphical interface will open.

2. Click the "Run Maze" button to start generating and solving the maze. You can adjust the speed of maze generation and solving by modifying the `sleepTime` and `speedSleep` variables in the code.

3. The maze generation process is visualized as walls being removed to create paths.

4. The solving process is also visualized as the algorithm finds the path from the start (top-left) to the end (bottom-right) of the maze.

5. You can stop the process at any time by closing the application.

## Code Logic

The code is organized as a Java Swing application. It creates a maze grid and offers a graphical representation of the maze generation and solving processes.

- The `Maze` class extends `JPanel` and implements `Runnable`.
- The code uses a 2D array to represent the maze grid, with each cell having a specific type (e.g., wall, path, empty).
- Maze colors are defined to enhance the visual representation.
- The maze generation and solving processes are run in a separate thread.

## Maze Generation Algorithm

The maze generation process utilizes a randomized Prim's algorithm, a variation of the Prim's algorithm. The key steps of this algorithm include:

1. Initialize a grid with walls.
2. Create a list of "walls" that can be removed to create paths.
3. Randomly select a wall from the list and remove it.
4. Connect the adjacent cells, creating a passage.
5. Repeat steps 3 and 4 until the maze is fully connected.

The randomized Prim's algorithm is chosen for its ability to produce intricate mazes with a high level of connectivity and visual appeal.

## Maze Solving Algorithm

The maze solving process employs a recursive algorithm that seeks to find a path from the maze's start to its end. The key steps include:

1. Start at the entrance (usually the top-left corner).
2. Explore adjacent cells in a specific order (up, left, down, right).
3. Mark visited cells and backtrack if no path is found.
4. Repeat this process until the exit (usually the bottom-right corner) is reached or all options are exhausted.

The chosen recursive algorithm is a simple and intuitive approach for solving mazes, making it suitable for visualization and learning purposes.

## Customization

The code can be customized in various ways:

- Adjust the `rows` and `columns` variables to change the maze size.
- Modify the colors of the maze by editing the `generateMazeColors` method.
- Change the sleep times to control the speed of maze generation and solving.
- Customize the appearance and layout of the graphical interface.

## Contributing

Contributions to this project are welcome. If you have ideas for improvements or bug fixes, please follow these steps:

1. Fork the repository.
2. Create a new branch for your feature or bug fix.
3. Make your changes and test them thoroughly.
4. Submit a pull request with a clear description of your changes.

## License

This Maze Solver is licensed under the [MIT License](LICENSE). Feel free to use and modify the code for your projects.

---

Enjoy exploring mazes and experimenting with this Maze Solver application! If you have any questions or issues, please don't hesitate to open an issue or reach out to the project's author, "vanshksingh"
