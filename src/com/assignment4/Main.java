package com.assignment4;

public class Main {

    public static int[] code = new int[4];

    static boolean checkCode(int[] testCode) {
        for (int i = 0; i < 4; i++)
            if (code[i] != testCode[i])
                return false;
        return true;
    }

    static void bruteForce(int nb) {
        int[] testCode = new int[]{0, 0, 0, 0};
        int nbCopy = nb;

        for (int i = 3; nb > 0; nb /= 10, i--)
            testCode[i] = nb % 10;

        for (int i = 0; i < 4; i++)// print test code
            System.out.print(testCode[i]);
        System.out.println("");

        if (checkCode(testCode))
            System.out.println("Code found :");
        else
            bruteForce(nbCopy + 1);
    }

    public static void main(String[] args) { // brute force attack on random 4 digits code

        for (int i = 0; i < 4; i++) // generate random 4 digits code
            code[i] = (int) (Math.random() * (9 - 1 + 1) + 1); // random number generator between 0 and 10

        bruteForce(0);

        for (int i = 0; i < 4; i++)
            System.out.print(code[i]);
    }
}
