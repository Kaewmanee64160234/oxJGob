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
    public static void main(String[] args) {
        System.out.println("Hello World!");
        XoJGob xo = new XoJGob();
        xo.showTable();
    }
}
