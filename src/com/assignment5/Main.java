package com.assignment5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static int lives;

    static char inputLetter() {
        Scanner sc= new Scanner(System.in);
        String letter = sc.nextLine();
        return letter.charAt(0);
    }

    static boolean hangman(String word) {
        char[] hiddenWord = word.toCharArray();
        char letter = '\0';

        for (int i = 0; i < word.length(); i++)
            hiddenWord[i] = '_';

        while (!word.equals(new String(hiddenWord))) {
            System.out.println(hiddenWord);
            System.out.println("Choose a letter :");
            letter = inputLetter();
            boolean guess = false;
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == letter) {
                    hiddenWord[i] = letter;
                    guess = true;
                }
            }
            if (!guess)
                lives--;
            if (lives == 0)
                return false;
            System.out.println("You have " + (lives - 1) + " live(s) left");
        }
        return true;
    }

    static String chooseRandomWord() throws FileNotFoundException {
        int random = (int) (Math.random() * (100 - 1 + 1) + 1);
        Scanner sc = new Scanner(new File("./src/com/assignment5/RandomWordList.txt"));
        String nextLine = null;

        for (int  i = 0; i <= random || !sc.hasNextLine(); i++) {
            nextLine = sc.nextLine();
        }
        sc.close();
        return nextLine;
    }

    public static void main(String[] args) throws FileNotFoundException {
        lives = 9;

        String word = chooseRandomWord();

        if (hangman(word)) {
            System.out.println("Congratulation you found the word !");
            System.out.println("The word was :");
            System.out.println(word);
        } else {
            System.out.println("You did not find the word...");
            System.out.println("  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    " /|\\  |\n" +
                    " / \\  |\n" +
                    "      |\n" +
                    "========");
            System.out.println("The word was :");
            System.out.println(word);
        }
    }
}
