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

## Usage

### Starting the Game

1. Run the `Main` class.
2. Follow the instructions in the console to start a new game or exit the game.
3. To start a game, enter the command `start <difficulty1> <difficulty2>`, where `<difficulty1>` and `<difficulty2>` can be `easy`, `medium`, `hard`, or `user`.
4. The game will display the board and alternate turns between players until there is a winner or a draw.

### Example Input

  ```bash
    start easy medium  
  ```

This command starts a game between a player with easy difficulty and a player with medium difficulty.

### Exiting the Game

Enter the command `exit` to exit the game.

## Requirements

- Java 8 or higher
- IDE or text editor of your choice
