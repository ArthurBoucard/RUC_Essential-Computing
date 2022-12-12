package com.miniProject;

import java.util.Scanner;

public class Main {
    public static final int ROWS = 6;
    public static final int COLUMNS = 9;

    public static void main(String[] args) {
        // Create board
        char[][] gameBoard = new char[ROWS][COLUMNS];
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                gameBoard[i][j] = ' ';
            }
        }
        // Fill outer columns with random pieces
        fillOuterColumns(gameBoard);

        Scanner scanner = new Scanner(System.in);

        // Player 1 starts
        char currentPlayer = 'X';
        while (true) {
            System.out.println("Current game board: ");
            printGameBoard(gameBoard);

            // Verification that the input is valid
            int column = 0;
            while (column == 0) {
                System.out.println("Player " + currentPlayer + ", enter the column number (1-9) where you want to place your piece: ");
                if (!scanner.hasNextInt()) {
                    System.out.println("Please select a number fom 1-9");
                    scanner = new Scanner(System.in);
                    continue;
                }
                column = scanner.nextInt();
                if (column < 1 || column > 9) {
                    System.out.println("Please select a number fom 1-9");
                    column = 0;
                }
            }

            // Place the piece
            if (placePiece(gameBoard, column - 1, currentPlayer)) {
                // Check for a win
                if (checkForWin(gameBoard, currentPlayer)) {
                    printGameBoard(gameBoard);
                    System.out.println("Player " + currentPlayer + " wins!");
                    break;
                }

                // Switch players
                if (currentPlayer == 'X') {
                    currentPlayer = 'O';
                } else {
                    currentPlayer = 'X';
                }
            }
        }
    }

    public static void fillOuterColumns(char[][] gameBoard) {
        // Choose the player randomly and places its piece
        int random;
        for (int i = 0, j = 0; i < ROWS; i++) {
            random = (int) (Math.random() * (2 - 1 + 1) + 1);
            if (random == 1) {
                placePiece(gameBoard, j, 'X');
            } else {
                placePiece(gameBoard, j, 'O');
            }
            // Check to switch from first column to last column
            if (i == ROWS - 1 && j == 0) {
                i = -1;
                j = COLUMNS - 1;
            }
        }
    }

    public static boolean placePiece(char[][] gameBoard, int column, char piece) {
        // Check if the selected column is full
        if (gameBoard[0][column] != ' ') {
            System.out.println("Column " + (column + 1) + " is full. Please select a different column.");
            return false;
        }

        // Place the piece in the first empty row in the selected column
        for (int i = ROWS - 1; i >= 0; i--) {
            if (gameBoard[i][column] == ' ') {
                gameBoard[i][column] = piece;
                break;
            }
        }
        return true;
    }

    public static boolean checkForWin(char[][] gameBoard, char piece) {
        // Check for horizontal wins
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS - 4; j++) {
                if (gameBoard[i][j] != ' ' &&
                        gameBoard[i][j] == gameBoard[i][j + 1] &&
                        gameBoard[i][j] == gameBoard[i][j + 2] &&
                        gameBoard[i][j] == gameBoard[i][j + 3] &&
                        gameBoard[i][j] == gameBoard[i][j + 4]) {
                    gameBoard[i][j] = '#';
                    gameBoard[i][j + 1] = '#';
                    gameBoard[i][j + 2] = '#';
                    gameBoard[i][j + 3] = '#';
                    gameBoard[i][j + 4] = '#';
                    return true;
                }
            }
        }

        // Check for vertical wins
        for (int i = 0; i < ROWS - 4; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                if (gameBoard[i][j] != ' ' &&
                        gameBoard[i][j] == gameBoard[i + 1][j] &&
                        gameBoard[i][j] == gameBoard[i + 2][j] &&
                        gameBoard[i][j] == gameBoard[i + 3][j] &&
                        gameBoard[i][j] == gameBoard[i + 4][j]) {
                    gameBoard[i][j] = '#';
                    gameBoard[i + 1][j] = '#';
                    gameBoard[i + 2][j] = '#';
                    gameBoard[i + 3][j] = '#';
                    gameBoard[i + 4][j] = '#';
                    return true;
                }
            }
        }

        // Check for diagonal wins (top-left to bottom-right)
        for (int i = 0; i < ROWS - 4; i++) {
            for (int j = 0; j < COLUMNS - 4; j++) {
                if (gameBoard[i][j] != ' ' &&
                        gameBoard[i][j] == gameBoard[i + 1][j + 1] &&
                        gameBoard[i][j] == gameBoard[i + 2][j + 2] &&
                        gameBoard[i][j] == gameBoard[i + 3][j + 3] &&
                        gameBoard[i][j] == gameBoard[i + 4][j + 4]) {
                    gameBoard[i][j] = '#';
                    gameBoard[i + 1][j + 1] = '#';
                    gameBoard[i + 2][j + 2] = '#';
                    gameBoard[i + 3][j + 3] = '#';
                    gameBoard[i + 4][j + 4] = '#';
                    return true;
                }
            }
        }

        // Check for diagonal wins (top-right to bottom-left)
        for (int i = 4; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS - 4; j++) {
                if (gameBoard[i][j] != ' ' &&
                        gameBoard[i][j] == gameBoard[i - 1][j + 1] &&
                        gameBoard[i][j] == gameBoard[i - 2][j + 2] &&
                        gameBoard[i][j] == gameBoard[i - 3][j + 3] &&
                        gameBoard[i][j] == gameBoard[i - 4][j + 4]) {
                    gameBoard[i][j] = '#';
                    gameBoard[i - 1][j + 1] = '#';
                    gameBoard[i - 2][j + 2] = '#';
                    gameBoard[i - 3][j + 3] = '#';
                    gameBoard[i - 4][j + 4] = '#';
                    return true;
                }
            }
        }

        // If no winning alignment
        return false;
    }

    public static void printGameBoard(char[][] gameBoard) {
        // Print the board with added aesthetics and the pieces
        for (int j = 0; j < COLUMNS; j++) {
            System.out.print("+---");
        }
        System.out.println("+");
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                System.out.print("| " + gameBoard[i][j] + " ");
            }
            System.out.println("|");
            for (int j = 0; j < COLUMNS; j++) {
                System.out.print("+---");
            }
            System.out.println("+");
        }
    }
}
