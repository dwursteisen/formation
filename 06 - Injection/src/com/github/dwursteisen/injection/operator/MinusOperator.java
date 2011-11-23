package com.github.dwursteisen.injection.operator;

import com.github.dwursteisen.injection.display.Display;
import com.github.dwursteisen.injection.generator.Generator;

/**
 * User: Wursteisen David
 * Date: 23/11/11
 * Time: 23:25
 */
public class MinusOperator extends AbstractOperator{
    public void perform() {
        int result = left.generate() - right.generate();
        display.display(result);
    }

}
