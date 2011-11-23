package com.github.dwursteisen.injection.operator;

/**
 * User: Wursteisen David
 * Date: 23/11/11
 * Time: 23:27
 */
public class MultiplyOperator extends AbstractOperator{
    public void perform() {
        int value = left.generate() * right.generate();
        display.display(value);
    }
}
