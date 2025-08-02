# 🎮 Java Tic Tac Toe Game

Welcome to **Tic Tac Toe**, a console-based Java game where you can either play locally with a friend or challenge a basic AI bot. This game is built using core Java concepts like arrays, loops, input handling, and basic AI logic.

---

## 🧠 Features

* 🧍‍♂️ **Two-Player Mode** – Play locally with another player  
* 🤖 **Single-Player Mode (vs Bot)** – Challenge a basic AI opponent  
* 🎨 **Colored Output** – Red for `X`, Blue for `O` using ANSI escape codes  
* 🔒 **Input Validation** – Ensures valid input and prevents moves in occupied cells  
* 🔁 **Replay Option** – Play as many rounds as you like  
* 🧼 **Modular Codebase** – Clear and well-structured logic  

---

## 🧪 Technologies Used

* **Java SE (Standard Edition)**  
* **Scanner Class** – For user input  
* **2D Arrays** – For representing the board  
* **ANSI Color Codes** – To display colored `X` and `O` in the console  

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

## 📂 Project Structure

```
TicTacToe.java  // Main game logic and entry point
```

---

## 📸 Sample Output

```
Welcome to Tic Tac Toe!
Player 1 is X and Player 2 is O.
Enter a number from 1 to 9 to place your mark...

X | O | 3
--+---+--
4 | X | 6
--+---+--
O | 8 | X

Player X has won the game!
Play again? (y/n)
```

---

## ✅ To-Do / Improvements (Optional)

* 🧠 Improve bot with Minimax algorithm for unbeatable AI  
* 💻 Create a GUI version using JavaFX or Swing  
* 🌐 Build an online multiplayer version  

---

## 📜 License

This project is open-source and free to use for educational or personal use.
---

## 👨‍💻 Author

**Aavishkar Chaudhari**  
Aspiring Software Engineer | Passionate about Java and Problem Solving  
🔗 [GitHub](https://github.com/Aavishkar7777)
