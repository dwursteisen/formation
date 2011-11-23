package com.github.dwursteisen.injection.operator;

import com.github.dwursteisen.injection.display.Display;
import com.github.dwursteisen.injection.generator.Generator;

/**
 * User: Wursteisen David
 * Date: 23/11/11
 * Time: 23:19
 */
public interface Operator {

    void perform();

    void setLeftGenerator(Generator left);

    void setRightGenerator(Generator right);

    void setDisplay(Display display);
}
