# Tic-Tac-Toe Game

## Table of Contents

1. [Description](#description)
2. [Project Structure](#project-structure)
   - [Package `org.example`](#package-orgexample)
   - [Package `org.example.Models.Enums`](#package-orgexamplemodelsenums)
   - [Package `org.example.Models.Players`](#package-orgexamplemodelsplayers)
   - [Package `org.example.Models.Difficulties`](#package-orgexamplemodelsdifficulties)
   - [Package `org.example.Interfaces`](#package-orgexampleinterfaces)
3. [Heuristics for Difficulty Levels](#heuristics-for-difficulty-levels)
   - [Easy Difficulty](#easy-difficulty)
   - [Medium Difficulty](#medium-difficulty)
   - [Hard Difficulty](#hard-difficulty)
4. [Usage](#usage)
   - [Starting the Game](#starting-the-game)
   - [Example Input for start command](#example-input-for-start-command)
   - [Example Input for User-Set difficulty](#example-input-for-user-set-difficulty)
   - [Exiting the Game](#exiting-the-game)
5. [Requirements](#requirements)
6. [Maven Wrapper implementation](#maven-wrapper-implementation)
   - [What is Maven Wrapper?](#what-is-maven-wrapper)
   - [Why to use it?](#why-to-use-it)
   - [Maven Wrapper in the project](#maven-wrapper-in-the-project)
7. [Static Code Analysis](#static-code-analysis)
   - [What is Static Code Analysis?](#what-is-the-static-code-analysis)
   - [Why to use it?](#why-to-use-it-1)
   - [PMD in the project](#pmd-in-the-project)
   - [CheckStyle in the project](#checkstyle-in-the-project)
   - [SpotBugs in the project](#spotbugs-in-the-project)
8. [Java Code Coverage](#static-code-analysis)

  
## Description

This project implements a Tic-Tac-Toe game with different difficulty levels and options to play against the computer or another user. The game is designed to run in the console and provides an interactive gaming experience.

## Project Structure

The project is organized into the following packages and classes:

### Package `org.example`

- **Main:** Main class that handles user input and game flow.
- **Utils:** Provides utility methods to convert strings to `Difficulties` and `Players` enums.
- **PlayingStatus:** Class representing the current game state.
- **Game:** Class that handles the game logic.
- **Board:** Class representing the game board.

### Package `org.example.Models.Enums`

- **Difficulties:** Enumeration of difficulty levels (`EASY`, `MEDIUM`, `HARD`, `INPUT`).
- **Players:** Enumeration of player types (`COMPUTER`, `USER`).

### Package `org.example.Models.Players`

- **PlayersFactory:** Factory to create instances of players (`User`, `Computer`).
- **User:** Class representing a human player.
- **Computer:** Class representing an AI-controlled player.

### Package `org.example.Models.Difficulties`

- **DifficultyFactory:** Factory to create instances of difficulty (`Easy`, `Medium`, `Hard`, `Input`).
- **Easy:** Implementation of easy difficulty.
- **Medium:** Implementation of medium difficulty.
- **Hard:** Implementation of hard difficulty.
- **Input:** Implementation of difficulty where the user inputs the moves.

### Package `org.example.Interfaces`

- **Player:** Abstract class that defines player behavior.
- **Difficulty:** Interface that defines the behavior of different difficulty levels.

## Heuristics for Difficulty Levels

### Easy Difficulty
- **Heuristic**: Random Move
- **Description**: The computer makes a move by randomly selecting an empty cell on the board. There is no strategic evaluation or consideration of the game state.

### Medium Difficulty
- **Heuristic**: Basic Line Analysis
- **Description**: The computer evaluates the board to make a move based on the following priorities:
  1. **Win**: If there are two of the computer's symbols in a line (row, column, or diagonal) and one empty cell, complete the line to win.
  2. **Block**: If the opponent has two symbols in a line and one empty cell, block the opponent by placing a symbol in the empty cell.
  3. **Random Move**: If neither of the above conditions is met, make a random move in an empty cell.

### Hard Difficulty
- **Heuristic**: Minimax Algorithm with Alpha-Beta Pruning
- **Description**: The computer uses the Minimax algorithm to evaluate the best possible move by simulating all possible future moves and their outcomes. The algorithm aims to maximize the computer's chances of winning while minimizing the opponent's chances. Alpha-beta pruning is used to optimize the evaluation by eliminating branches in the search tree that do not need to be explored. If the board is empty, the computer makes a random move. If the board is not empty, the computer uses the Minimax algorithm to choose the optimal move.

## Usage

### Starting the Game

1. Run the `Main` class.
2. Follow the instructions in the console to start a new game or exit the game.
3. To start a game, enter the command `start <difficulty1> <difficulty2>`, where `<difficulty1>` and `<difficulty2>` can be `easy`, `medium`, `hard`, or `user`.
4. The game will display the board and alternate turns between players until there is a winner or a draw.

### Example Input for start command

  ```bash
    start easy medium  
  ```

This command starts a game between a player with easy difficulty and a player with medium difficulty.

### Example Input for User-Set difficulty

  ```bash
    1 1  
  ```
#### This command represents how the user can play its turn, the format is the following: 
  ```bash
    <NumberOfRow> <NumberOfColumn>  
  ```

### Exiting the Game

Enter the command `exit` to exit the game.

## Requirements

- Java 8 or higher
- IDE or text editor of your choice

## Maven Wrapper implementation
### What is Maven Wrapper?
Maven Wrapper is an excellent choice for projects that need a specific version of maven or for users that don't want to install Maven at all. 
Maven Wrapper basically downloads the correct Maven version if it is not found.
### Why to use it?
- Consistency: Ensures that all the developers use the same Maven Version.
- Ease of use: No need to install Maven on every developer's machine.
- Portability: Makes it easier to set up de CI/CD pipelines as the exact Maven version is specified of the application.
### Maven Wrapper in the project
Maven Wrapper has been just integrated into the project. Changes can be visualized since the following commit: [_**`409260e`**_](https://github.com/BrianVega/TicTacToeAI_Hyperskill/commit/4daf8deefbbd052d17115b6675955f9f73fdd369)

## Static Code Analysis
### What is the Static Code Analysis?
Is a method of computer program debugging that is done by examining the code without executing the program.
Basically the process provides an understanding of the code structure so that can help to ensure that the code adheres to industry standards.
Among all the static code analysis available nowadays we can find:
- **PMD**: It helps to find common programming flaws like unused variables, empty catch blocks, unnecessary object creation and so forth.  
- **CheckStyle**: It helps to identify whether if Java source code is compliant with specified coding rules. 
- **SpotBugs**: It looks for instances of "bug patterns". It means, code instances that are likely ro be errors.
### Why to use it?
Static Code Analysis helps to identify problems at an early development stage.
### PMD In the project
The following commit contains all the plugins and configurations that were added in order to comply with the PMD using requisites. [_**`61de1b7`**_](https://github.com/BrianVega/TicTacToeAI_Hyperskill/commit/61de1b79873d70986f92b917b727aabf575e1edf)

#### Results before refactor
![img.png](assets/PMDBefore.png)
#### Results after refactor
Commit: [_**`f9f703e`**_](https://github.com/BrianVega/TicTacToeAI_Hyperskill/commit/f9f703e289443add276c28f3cb495d7bee808229)
![img.png](assets/PMDAfter.png)

### CheckStyle in the project
The following commit contains all the plugins and configurations that were added in order to comply with the CheckStyle using requisites. [_**`9c6e9ed`**_](https://github.com/BrianVega/TicTacToeAI_Hyperskill/commit/9c6e9ed825fba17e423fe0a38eea6277c0403b0f)

#### Results before refactor
![img.png](assets/checkStyleBefore.png)

#### Results after refactor
Commit: [_**`1b16da2`**_](https://github.com/BrianVega/TicTacToeAI_Hyperskill/commit/1b16da2677a8fcd82758f7b6e233d6a5cf90d003)
![img.png](assets/checkStyleAfter.png)

### SpotBugs in the project
The following commit contains all the plugins and configurations that were added in order to comply with the SpotBugs(including Find Security Bugs) using requisites. [_**`644b840`**_](https://github.com/BrianVega/TicTacToeAI_Hyperskill/commit/644b8407089402da5c43e96ea1ca9046bcc9fefc)

#### Results before refactor
![img.png](assets/SpotBugsBefore.png)

#### Results after refactor
Commit: [_**`100d9a7`**_](https://github.com/BrianVega/TicTacToeAI_Hyperskill/commit/100d9a7317b32f66613cc7ed5cf6de5f1fa0814a)
![img.png](assets/SpotBugsAfter.png)

### Java Code Coverage
In order to guarantee the code quality, 64 tests were added, covering 100% of the code. Such results can be visualized in the following report generated via the JaCoCo plugin.
![img.png](assets/jacocoReport.png)
