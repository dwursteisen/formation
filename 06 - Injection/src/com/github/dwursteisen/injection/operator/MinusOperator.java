package com.github.dwursteisen.injection.operator;

/**
 * User: Wursteisen David
 * Date: 23/11/11
 * Time: 23:25
 */
public class MinusOperator extends AbstractOperator{
    public void perform() {
        int leftValue = left.generate();
        int rightValue = right.generate();
        int result = leftValue - rightValue;
        display.display(leftValue, rightValue, result, "-");
    }

}
