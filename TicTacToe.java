import java.util.ArrayList;
import java.util.Random;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class TicTacToe {
    // ANSI escape codes for colored output
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String BLUE = "\u001B[34m";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nWelcome to Tic Tac Toe!");
        System.out.println("Player 1 is X and Player 2 is O.");
        System.out.println("Enter a number from 1 to 9 to place your mark on the board.");
        System.out.println("The board positions are as follows:");
        System.out.println("1 | 2 | 3");
        System.out.println("--+---+--");
        System.out.println("4 | 5 | 6");
        System.out.println("--+---+--");
        System.out.println("7 | 8 | 9");
        System.out.println("Choose Game Mode:");
        System.out.println("1. Two Player Game");
        System.out.println("2. Play with Bot");

        int gameMode = 0;
        // Input validation for game mode selection
        while (true) {
            try {
                gameMode = scanner.nextInt();

                if (gameMode == 1 || gameMode == 2) {
                    break;
                } else {
                    System.out.println("Please enter 1 or 2.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter 1 or 2.");
                scanner.next();
            }
        }

        char player = 'X';
        boolean gameOver = false;
        char playAgain = 'y';
        // Main game loop
        do {
            System.out.println("\nStarting a new game...");
            char[][] board = new char[3][3];

            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {
                    board[row][col] = ' ';
                }
            }

            gameOver = false;
            player = 'X';

            while (!gameOver) {

                printBoard(board);
                int position = -1;
                // Player input handling
                if (gameMode == 1 || player == 'X') {

                    while (true) {
                        System.out.println("Player " + player + " enter: ");

                        try {
                            position = scanner.nextInt();
                            if (position < 1 || position > 9) {
                                System.out.println("Please enter a number from 1-9.");
                                continue;
                            }

                            int row = getRowFromPosition(position);
                            int col = getColumnFromPosition(position);

                            if (board[row][col] != ' ') {
                                System.out.println("That position is already taken. Try again.");
                                continue;
                            }

                            board[row][col] = player;
                            break;

                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input! Please enter a valid number (1-9).");
                            scanner.next();

                        } catch (Exception e) {
                            System.out.println("Unexpected error: " + e.getMessage());
                            scanner.next();

                        }
                    }

                } else { // Bot's turn
                    System.out.println("Bot is making a move...");
                    position = getBotMove(board, 'O', 'X');
                    int row = getRowFromPosition(position);
                    int col = getColumnFromPosition(position);
                    board[row][col] = 'O';
                }

                // Check if the current player has won
                gameOver = haveWon(board, player);

                // If the game is over, announce the winner
                if (gameOver) {
                    System.out.println("Player " + player + " has won the game.");
                } else {
                    player = (player == 'X') ? 'O' : 'X';
                }

                // Check if the board is full and it's a draw
                if (isBoardFull(board)) {
                    System.out.println("It's a draw!");
                    break;
                }
            }

            printBoard(board);

            System.out.println("Play again? (y/n)");
            playAgain = scanner.next().toUpperCase().charAt(0);

        } while (playAgain == 'Y'); // Loop to play again

        scanner.close();
    }

    // Method to convert 1–9 board position into corresponding row index (0–2)
    public static int getRowFromPosition(int position) {
        int row = (position - 1) / 3;
        return row;
    }

    // Method to convert 1–9 board position into corresponding column index (0–2)
    public static int getColumnFromPosition(int position) {
        int col = (position - 1) % 3;
        return col;
    }

    // Method to print the Tic Tac Toe board with colored output
    public static void printBoard(char[][] board) {

        for (int row = 0; row < 3; row++) {

            for (int col = 0; col < 3; col++) {

                char cell = board[row][col];

                if (cell == 'X') { 
                    System.out.print(RED + cell + RESET);
                } else if (cell == 'O') {
                    System.out.print(BLUE + cell + RESET);
                } else {
                    System.out.print(cell);
                }

                if (col < 2) {
                    System.out.print(" | ");
                }
            }

            System.out.println();
            if (row < 2) {
                System.out.println("--+---+--");
            }
        }
    }

    // Method to check if a player has won the game
    public static boolean haveWon(char[][] board, char player) {

        // Check rows
        for (int row = 0; row < 3; row++) {
            if (board[row][0] == player && board[row][1] == player && board[row][2] == player) {
                return true;
            }
        }

        // Check columns
        for (int col = 0; col < 3; col++) {
            if (board[0][col] == player && board[1][col] == player && board[2][col] == player) {
                return true;
            }
        }

        // Check diagonals
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }

        // Check the other diagonal
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }

        return false;
    }

    // Method for the bot to determine its move
    // It checks for winning moves, blocking moves, and random available moves
    public static int getBotMove(char[][] board, char bot, char player) {

        // Check for winning move
        for (int pos = 1; pos <= 9; pos++) {

            int row = getRowFromPosition(pos);
            int col = getColumnFromPosition(pos);

            if (board[row][col] == ' ') {
                board[row][col] = bot;

                if (haveWon(board, bot)) {
                    board[row][col] = ' ';
                    return pos;
                }

                board[row][col] = ' ';
            }
        }

        // Check for blocking move
        // If the player is about to win, block them
        for (int pos = 1; pos <= 9; pos++) {
            int row = getRowFromPosition(pos);
            int col = getColumnFromPosition(pos);
            if (board[row][col] == ' ') {
                board[row][col] = player;
                if (haveWon(board, player)) {
                    board[row][col] = ' ';
                    return pos;
                }
                board[row][col] = ' ';
            }
        }

        // If no winning or blocking move, choose a random available move
        List<Integer> availableMoves = new ArrayList<>();
        for (int pos = 1; pos <= 9; pos++) {
            int row = getRowFromPosition(pos);
            int col = getColumnFromPosition(pos);
            if (board[row][col] == ' ') {
                availableMoves.add(pos);
            }
        }

        if (!availableMoves.isEmpty()) {
            Random rand = new Random();
            return availableMoves.get(rand.nextInt(availableMoves.size()));
        }

        return -1;
    }

    // Method to check if the board is full (no empty spaces)
    public static boolean isBoardFull(char[][] board) {

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (board[row][col] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}