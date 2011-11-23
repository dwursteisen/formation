package com.github.dwursteisen.injection.generator;

import java.util.Random;

/**
 * User: Wursteisen David
 * Date: 23/11/11
 * Time: 23:28
 */
public class RandomGenerator implements Generator{

    private final Random random = new Random();

    public int generate() {
        return random.nextInt(30);
    }
}
