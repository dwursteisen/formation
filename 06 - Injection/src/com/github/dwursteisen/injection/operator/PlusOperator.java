package com.github.dwursteisen.injection.operator;

import com.github.dwursteisen.injection.display.Display;
import com.github.dwursteisen.injection.generator.Generator;
import com.google.inject.Inject;

/**
 * User: Wursteisen David
 * Date: 23/11/11
 * Time: 23:21
 */
public class PlusOperator extends AbstractOperator {


    public void perform() {
        int result = left.generate() + right.generate();
        display.display(result);
    }


}
