package com.github.dwursteisen.injection.display;

import com.github.dwursteisen.injection.generator.Generator;

/**
 * User: Wursteisen David
 * Date: 23/11/11
 * Time: 23:30
 */
public class BridgeDisplay implements Display, Generator{
    private int current;

    public void display(int value) {
        current = value;
    }

    public int generate() {
        return current;
    }
}
