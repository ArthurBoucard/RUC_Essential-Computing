package com.assignment1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.print("What is your name? ");
        String name= sc.nextLine();
        System.out.print("Nice to meet you, " + name + "!");
    }
}
