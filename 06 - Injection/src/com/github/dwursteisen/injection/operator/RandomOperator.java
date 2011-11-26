package com.github.dwursteisen.injection.operator;

import com.github.dwursteisen.injection.display.Display;
import com.github.dwursteisen.injection.generator.Generator;
import com.google.inject.Inject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * User: Wursteisen David
 * Date: 26/11/11
 * Time: 12:53
 */
public class RandomOperator extends AbstractOperator {

    private final List<Operator> operatorList = new ArrayList<Operator>();
    private final Random seed = new Random();
    @Inject
    public RandomOperator(PlusOperator plus, MinusOperator minus, MultiplyOperator multi) {
        operatorList.addAll(Arrays.asList(plus, minus, multi));
    }

    @Override
    public void setLeftGenerator(@Left Generator left) {
        for (Operator operator : operatorList) {
            operator.setLeftGenerator(left);
        }
    }

    @Override
    public void setRightGenerator(@Right Generator right) {
        for (Operator operator : operatorList) {
            operator.setRightGenerator(right);
        }
    }

    @Override
    public void setDisplay(Display display) {
        for (Operator operator : operatorList) {
            operator.setDisplay(display);
        }
    }

    public void perform() {
        final int indexMax = operatorList.size() - 1;
        int randomIndex = seed.nextInt(indexMax);
        final Operator randomOperator = operatorList.get(randomIndex);
        randomOperator.perform();
    }
}
