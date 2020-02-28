package com.company;

import java.util.Random;
import java.util.Scanner;

public class Guess_the_number {

    public static void main(String[] args) {
        int r = new Random().nextInt(100);
        int v;
        while(r != (v = input("Enter a number from 0 to 100: "))){
            System.out.println( (v < r) ? " > " : " < ");
        }
        System.out.println("You win! Game over.");
    }

    public static int input(String text){
        System.out.print(text);
        Scanner sc = new Scanner(System.in);
        while(!sc.hasNextInt()){
            sc.next();
            System.out.print(text);
        }
        return sc.nextInt();
    }
}