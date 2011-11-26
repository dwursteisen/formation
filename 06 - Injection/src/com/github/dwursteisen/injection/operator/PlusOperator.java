package com.github.dwursteisen.injection.operator;

/**
 * User: Wursteisen David
 * Date: 23/11/11
 * Time: 23:21
 */
public class PlusOperator extends AbstractOperator {


    public void perform() {
        int leftValue = left.generate();
        int rightValue = right.generate();
        int result = leftValue + rightValue;
        display.display(leftValue, rightValue, result, "+");
    }


}
