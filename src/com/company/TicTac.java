package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TicTac {

    public static char[][] field =
            {       { '+', '+', '+' },
                    { '+', '+', '+' },
                    { '+', '+', '+' } };

    public static void CompMove() {
        int x = (int) (Math.random() * 3), y = (int) (Math.random() * 3);
        while (field[x][y] == '0' || field[x][y] == 'X') {
            x = (int) (Math.random() * 3);
            y = (int) (Math.random() * 3);
        }
        field[x][y] = '0';
    }

    public static void HumanMove() throws IOException {
        int x = -1, y = -1;
        System.out.println("Enter y (1..3):");
        BufferedReader br = new BufferedReader(new InputStreamReader(
                System.in));
        x = Integer.parseInt(br.readLine())-1;
        System.out.println("Enter x (1..3):");
        y = Integer.parseInt(br.readLine())-1;
        while (field[x][y] == '0' || field[x][y] == 'X' || x < 0 || x > 2
                || y < 0 || y > 2) {
            System.out.println("Enter y:");
            x = Integer.parseInt(br.readLine())-1;
            System.out.println("Enter x:");
            y = Integer.parseInt(br.readLine())-1;
        }
        field[x][y] = 'X';
    }

    public static void PrintField() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(field[i][j]);
            }
            System.out.println();
        }
    }

    public static char CheckGame() {
        char winner = ' ';
        // Проверка по горизонтали
        for (int i = 0; i < 3; i++) {
            if (field[i][0] == field[i][1] && field[i][1] == field[i][2]
                    && field[i][0] != '+') {
                winner = field[i][0];
                break;
            }
        }


        if (winner == ' ') {
            for (int i = 0; i < 3; i++) {
                if (field[0][i] == field[1][i] && field[1][i] == field[2][i]
                        && field[0][i] != '+') {
                    winner = field[0][i];
                    break;
                }
            }
        }


        if (winner == ' ') {
            if (field[0][0] == field[1][1] && field[1][1] == field[2][2]
                    && field[0][0] != '+') {
                winner = field[0][0];
            }
        }

        if (winner == ' ') {
            if (field[0][2] == field[1][1] && field[1][1] == field[2][0]
                    && field[0][2] != '+') {
                winner = field[0][0];
            }
        }
        return winner;
    }

    public static boolean CanMove() {
        boolean p = false;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (field[i][j] == '+') {
                    p = true;
                    break;
                }
            }
            if (p = true) {
                break;
            }
        }
        return p;
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Game Started!!!");
        PrintField();
        while (CheckGame() == ' ' && CanMove()) {
            HumanMove();
            CompMove();
            PrintField();
        }
        if (CheckGame() == 'X') {
            System.out.println("YOU WIN!");
        }
        if (CheckGame() == '0') {
            System.out.println("YOU LOSE!");
        }
        if (CheckGame() == ' ' && !CanMove()) {
            System.out.println("STANDOFF!");
        }
    }

}