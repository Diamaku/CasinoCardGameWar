# Casino War Card Game

A terminal-based Java program that simulates the official casino card game War, where a player competes against the computer using a standard 52-card deck.

# How It's Made

**Tech used**: Java

This project was created to practice object-oriented programming, class design, and game logic. It recreates the official rules of casino War in a console-based format where the user plays against a computer opponent.

# Features

- Player vs computer gameplay

- Standard 52-card deck

- Deck shuffling using randomization

- User presses ENTER to play each round

- Automatic card comparison to determine round winner

- War (tie) handling

- Displays played cards and round outcomes

- Game ends when one player runs out of cards

# How to Run
## Requirements

- Java installed (JDK)

## Compile
- javac CasinoWar.java
## Run
- java CasinoWar

# How to Play

- Run the program in the terminal.

- Press ENTER to play a card each round.

- The program displays the player's card and the computer's card.

- The higher card wins the round automatically.

- If both cards are the same rank, **WAR** begins:

  - Press ENTER to place a face-down card.

  - Press ENTER again to play a face-up card.

  - The program checks the winner again.

  - War repeats until someone wins.

- The game ends when one player runs out of cards.

# Project Structure

Card.java – defines suit, rank, and value of a card

Deck.java – creates the deck and includes the shuffling method

Player.java – manages player cards

CasinoWar.java – main gameplay logic and program entry point

# What I Learned

This project helped me learn how to create object-oriented design in Java. I understood the relationship between classes and how to use arrays and include randomization in my code. I learned how to implement a gameplay loop and handling user input to start each round of a loop.

# Future Improvements

- GUI using Swing

- Betting system

- Multiplayer support

# Author

Mario Castelo
