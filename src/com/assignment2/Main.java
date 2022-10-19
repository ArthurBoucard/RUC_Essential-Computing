package com.assignment2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please type in your age => ");
        int age = Integer.parseInt(sc.nextLine());

        if (age <= 14) {
            System.out.println("You are a child.");
            System.out.println("You are not legally allowed to drink beer.");
            System.out.println("You have to wait " + (16 - age) + " more years!");
        } else if (age <= 24) {
            System.out.println("You are a youth.");
            if (age >= 16) {
                System.out.println("You are legally allowed to drink beer.");
            } else {
                System.out.println("You are not legally allowed to drink beer.");
                System.out.println("You have to wait " + (16 - age) + " more years!");
            }
        } else if (age <= 64) {
            System.out.println("You are an adult.");
            System.out.println("You are legally allowed to drink beer.");
        } else {
            System.out.println("You are a senior.");
            System.out.println("You are legally allowed to drink beer.");
        }
    }
}
