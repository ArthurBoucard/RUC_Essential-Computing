package com.assignment3;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = (int)(Math.random()*(100 - 1 + 1) + 1); // random number generator between 1 and 100
        int guess = 0;

        System.out.println("I have chosen a number between 1 and 100. Try to guess it!");
        while (true) {
            System.out.print("What is your guess? => ");
            guess = Integer.parseInt(sc.nextLine());
            if (guess == number)
                break;
            if (guess < number)
                System.out.println("The number is higher!");
            else
                System.out.println("The number is lower!");
        }
        System.out.println("Correct!");
    }
}
