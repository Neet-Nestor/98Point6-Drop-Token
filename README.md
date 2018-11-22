# 98Point6-Drop-Token
A Command line interface game of 98Point6 Drop Token implemented by Java.

## Compile and Run
To Compile, use terminal to enter `src` folder, then type `javac Main.java`
Or enter `bin` folder and run `java Main` directly

##Game Rule
Drop Token takes place on a 4x4 grid. A token is dropped along a column (labeled 1-4) and said token goes to the lowest unoccupied row of the board. A player wins when they have 4 tokens next to each other either along a row, in a column, or on a diagonal. If the board is filled, and nobody has won then the game is a draw. Each player takes a turn, starting with player 1, until the game reaches either win or draw. If a player tries to put a token in a column that is already full, that results in an error state, and the player must play again until the play a valid move.

##Interface
- `PUT` \<column\> (OK | ERROR | WIN | DRAW)
- `GET` List of columns that have been successfully put to
- `BOARD` a 4x4 matrix that shows the board state
```
| 0 0 0 0
| 0 0 0 0
| 2 2 0 0
| 1 1 1 2
+--------
  1 2 3 4
```
- `EXIT` ends the program

