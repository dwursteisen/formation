package com.github.dwursteisen.injection.display;

/**
 * User: Wursteisen David
 * Date: 23/11/11
 * Time: 23:32
 */
public class BigDisplay implements Display {
    public void display(int value) {
        System.out.println("+-------------+");
        System.out.println("|             |");
        System.out.println("|             |");
        System.out.println("|     "+value+"      |");
        System.out.println("|             |");
        System.out.println("|             |");
        System.out.println("+-------------+");

    }
}
