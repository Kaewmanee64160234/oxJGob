/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.xojgob;

import java.util.Scanner;

/**
 *
 * @author USER
 */
public class XoJGob {
     public String[][] list = {{"-", "-", "-"}, {"-", "-", "-"}, {"-", "-", "-"}};
    public String start;
    public String turn;
    public boolean confirm;
    public int row;
    public int column;
    public boolean isEnd = false;

    Scanner sc = new Scanner(System.in);
 public void showTable() {
        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list[i].length; j++) {
                System.out.print(" " + list[i][j] + " ");
            }

            System.out.println();
        }

    }
 public void checkStart() {
        System.out.println("Welcome to XO Game");
        System.out.print("Start XO Games? (Y/N) : ");
        start = sc.nextLine().toLowerCase();
        while (!start.equals("y") && !start.equals("n")) {
            System.out.print("Start XO Games? (Y/N) : ");
            start = sc.nextLine().toLowerCase();
        }
        if (start.equals("n")) {
            confirm = false;
        } else {
            confirm = true;
        }
    }
  public void changeTurn() {
        if (turn.equals("x")) {
            turn = "o";
        } else {
            turn = "x";
        }
    }
  
  
    public void reset() {
        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list.length; j++) {
                list[i][j] = "-";
            }
        }
    }


    public boolean checkDraw() {
        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list.length; j++) {
                if (list[i][j].toLowerCase().equals("-")) {
                    return false;
                }

            }

        }
        return true;
    }
      public boolean checkNawnond() {
        for (int j = 0; j < list[row - 1].length; j++) {
            if (!list[row - 1][j].toLowerCase().equals(turn)) {
                return false;
            }
        }

        return true;
    }
       public boolean checkTayang() {
        if (row - 1 == column - 1) {
            for (int i = 0; i < list.length; i++) {
                if (!list[i][i].toLowerCase().equals(turn)) {
                    return false;
                }

            }
            return true;
        }
        if ((row + column) - 2 == list.length - 1) {
            for (int i = 0; i < list.length; i++) {
                if (!list[i][list.length - 1 - i].toLowerCase().equals(turn)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

   public boolean checkNawTang() {
        for (int i = 0; i < list[row - 1].length; i++) {
            if (!list[i][column - 1].toLowerCase().equals(turn)) {
                return false;
            }
        }
        return true;
    }
    public void showTurn() {
        System.out.println("--------------------------------");
        System.out.println("Turn >>> " + turn.toUpperCase());
    }
     public boolean continute() {
        System.out.print("You want to play again (Y/N) : ");
        String str = sc.next();
        while (!str.toLowerCase().equals("n") && !str.toLowerCase().equals("y")) {
            System.out.print("You want to play again (Y/N) : ");
            str = sc.next().toLowerCase();
        }
        if (str.equals("n")) {
            isEnd = true;
            System.out.println("GoodBye!!");
            return false;
        }

        return true;
    }
     public void checkWin() {
        if (checkNawnond() || checkNawTang() || checkTayang()) {

            System.out.println("+--------------------+");
            System.out.println("|    !!! " + turn.toUpperCase() + " Win !!!   |");
            System.out.println("+--------------------+");
            showTable();
            if (continute()) {
                reset();
            } else {
                isEnd = true;

            }
        }
        //check 3 style
        if (isEnd == false) {
            if (checkDraw()) {
                isEnd = true;
                System.out.println("+--------------------+");
                System.out.println("|    !!! Draw !!!    |");
                System.out.println("+--------------------+");
                showTable();
                if (continute()) {
                    reset();
                } else {
                    isEnd = true;

                }
            }
        }

    }
      public void process() {
        showTurn();
        showTable();
        inputRowandColumn();

    }
       public void inputRowandColumn() {
        System.out.print("Input row :");
        row = sc.nextInt();
        System.out.print("Input column :");
        column = sc.nextInt();
        if (((row > 0 && row < 4) && (column > 0 && column < 4))) {
            if (list[row - 1][column - 1].equals("-")) {
                list[row - 1][column - 1] = turn.toUpperCase();

            } else {

                while ((!(row > 0 && row < 4) && !(column > 0 && column < 4)) && (!list[row - 1][column - 1].equals("-"))) {

                    System.out.println("that row and Column is already exits.");
                    System.out.print("Input row :");
                    row = sc.nextInt();
                    System.out.print("Input column :");
                    column = sc.nextInt();
                }
                return;

            }

            checkWin();
            changeTurn();
        } else {
            return;
        }

    }
    public static void main(String[] args) {
    
        XoJGob xo = new XoJGob();
         xo.turn = "x";

        xo.checkStart();
        if (xo.confirm == false) {
            System.out.println("Goodbye!!");
            xo.isEnd = true;
        }
        while (!xo.isEnd) {
            xo.process();
        }

    }
}
