package com.github.dwursteisen.injection.generator;

/**
 * User: Wursteisen David
 * Date: 23/11/11
 * Time: 23:29
 */
public class ByOrderGenerator implements Generator{

    private int current = 0;
    public int generate() {
        current = (current + 1) % 30;
        return current;
    }
}
