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
    public static void main(String[] args) {
        System.out.println("Hello World!");
        XoJGob xo = new XoJGob();

    }
}
