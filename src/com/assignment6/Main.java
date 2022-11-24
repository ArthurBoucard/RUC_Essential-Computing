package com.assignment6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    static int table[][] = new int[10][10];

    static void findNeighbours() {
        // horizontally
        int horizontal = 0;
        for (int i = 0; i < 10; i++) {
            int temp = table[i][0];
            int maxCount = 0;
            for (int j = 0; j < 10; j++) {
                if (table[i][j] == temp) {
                    maxCount++;
                } else {
                    if (maxCount > horizontal)
                        horizontal = maxCount;
                    maxCount = 1;
                }
                temp = table[i][j];
            }
        }
        System.out.println("Horizontal max : " + horizontal);

        // vertically
        int vertical = 0;
        for (int i = 0, j = 0; i < 10 && j < 10; i = 0, j++) {
            int temp = table[i][j];
            int maxCount = 0;
            for (; i < 10; i++) {
                if (table[i][j] == temp) {
                    maxCount++;
                } else {
                    if (maxCount > vertical)
                        vertical = maxCount;
                    maxCount = 1;
                }
                temp = table[i][j];
            }
        }
        System.out.println("Vertical max : " + vertical);

        // diagonally
        int diagonal = 0;
        for (int i = 0, j = 0; i < 10; i++, j = 0) {
            int temp = table[i][j];
            int maxCount = 0;
            for (; i < 10 && j < 10; i++, j++) {
                if (table[i][j] == temp) {
                    maxCount++;
                } else {
                    if (maxCount > diagonal)
                        diagonal = maxCount;
                    maxCount = 1;
                }
                temp = table[i][j];
            }
        }
        System.out.println("Diagonal max : " + diagonal);
    }

    static void printTable() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (table[i][j] == -1)
                    System.out.print("x ");
                else if (table[i][j] == 0)
                    System.out.print("o ");
                else
                    System.out.print("u ");
            }
            System.out.println("");
        }
    }

    static void fillTable() {
        for (int i = 0; i < 10; i++)
            for (int j = 0; j < 10; j++)
                table[i][j] = (int) (Math.random() * (3 - 1 + 1) + 1) - 2;
    }

    public static void main(String[] args) {
        fillTable();

        printTable();

        findNeighbours();
    }
}
