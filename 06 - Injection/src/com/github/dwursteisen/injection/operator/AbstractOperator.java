package com.github.dwursteisen.injection.operator;

import com.github.dwursteisen.injection.display.Display;
import com.github.dwursteisen.injection.generator.Generator;
import com.google.inject.Inject;

/**
 * User: Wursteisen David
 * Date: 23/11/11
 * Time: 23:26
 */
public abstract class AbstractOperator implements Operator {
    protected Generator left;
    protected Generator right;
    protected Display display;

    @Inject
    public void setLeftGenerator(@Left Generator left) {
        this.left = left;
    }

    @Inject
    public void setRightGenerator(@Right Generator right) {
        this.right = right;
    }

    @Inject
    public void setDisplay(Display display) {
        this.display = display;
    }
}
