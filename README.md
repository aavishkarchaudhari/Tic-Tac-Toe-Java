# 🎮 Java Tic Tac Toe Game

Welcome to **Tic Tac Toe**, a console-based Java game where you can either play locally with a friend or challenge a basic bot. This game is built using core Java concepts like arrays, loops, input handling, and basic logic.

---

## 🧠 Features

* 🧍‍♂️ **Two-Player Mode** – Play locally with another player  
* 🤖 **Single-Player Mode (vs Bot)** – Challenge a basic opponent  
* 🎨 **Colored Output** – Red for `X`, Blue for `O` using ANSI escape codes  
* 🔒 **Input Validation** – Ensures valid input and prevents moves in occupied cells  
* 🔁 **Replay Option** – Play as many rounds as you like 

---

## 🕹️ How to Play

### 1️⃣ Compile the Code

Make sure you have Java installed. Then open your terminal or command prompt and run:

```bash
javac TicTacToe.java
```

### 2️⃣ Run the Game

```bash
java TicTacToe
```

### 3️⃣ Follow the Prompts

* Choose your game mode:
  * `1` for Two-Player  
  * `2` for playing with Bot  
* Enter positions (1-9) to place your mark:

  ```
  1 | 2 | 3
  --+---+--
  4 | 5 | 6
  --+---+--
  7 | 8 | 9
  ```

* `X` always starts first.  
* The game ends when:
  * A player wins  
  * The board is full (draw)  
* After each round, you’ll be asked if you want to play again.

---

## 🤖 Bot Intelligence

The bot uses a basic strategy:

1. Checks if it can win in the next move.  
2. Blocks the player if they are about to win.  
3. Picks a random available cell if neither condition is met.

---

## 📸 Sample Output

```
Welcome to Tic Tac Toe!
Player 1 is X and Player 2 is O.
Enter a number from 1 to 9 to place your mark...

X | O | 
--+---+--
  | X | 
--+---+--
O |   | X

Player X has won the game!
Play again? (y/n)
```

---

## 👨‍💻 Author

**Aavishkar Chaudhari**  
Aspiring Software Engineer | Passionate about Java and Problem Solving  
🔗 [GitHub](https://github.com/aavishkarchaudhari)
