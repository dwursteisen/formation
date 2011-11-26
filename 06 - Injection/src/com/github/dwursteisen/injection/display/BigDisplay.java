package com.github.dwursteisen.injection.display;

/**
 * User: Wursteisen David
 * Date: 23/11/11
 * Time: 23:32
 */
public class BigDisplay implements Display {
    public void display(int leftValue, int rightValue, int result, String operationSymbol) {
        System.out.format("+-------------+------------+------------+---------+\n");
        System.out.format("|             |            |            |         |\n");
        System.out.format("|             |            |            |         |\n");
        System.out.format("|   %7d   | %7s    |  %6d    |  =%4d  |\n", leftValue, operationSymbol, rightValue, result);
        System.out.format("|             |            |            |         |\n");
        System.out.format("|             |            |            |         |\n");
        System.out.format("+-------------+------------+------------+---------+\n");

    }
}
