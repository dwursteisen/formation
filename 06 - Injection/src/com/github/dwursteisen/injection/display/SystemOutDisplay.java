package com.github.dwursteisen.injection.display;

/**
 * User: Wursteisen David
 * Date: 23/11/11
 * Time: 23:31
 */
public class SystemOutDisplay implements Display{
    public void display(int value) {
        System.out.println(value);
    }
}
