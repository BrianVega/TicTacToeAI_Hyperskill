# Tic-Tac-Toe Game

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
