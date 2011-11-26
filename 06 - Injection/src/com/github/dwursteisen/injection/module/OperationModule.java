package com.github.dwursteisen.injection.module;

import com.github.dwursteisen.injection.display.Display;
import com.github.dwursteisen.injection.display.SystemOutDisplay;
import com.github.dwursteisen.injection.generator.ByOrderGenerator;
import com.github.dwursteisen.injection.generator.Generator;
import com.github.dwursteisen.injection.generator.RandomGenerator;
import com.github.dwursteisen.injection.operator.*;
import com.google.inject.Binder;
import com.google.inject.Module;

/**
 * User: Wursteisen David
 * Date: 23/11/11
 * Time: 23:34
 */
public class OperationModule implements Module {
    public void configure(Binder binder) {
        binder.bind(Display.class).to(SystemOutDisplay.class);

        binder.bind(Generator.class).annotatedWith(Left.class).to(ByOrderGenerator.class);
        binder.bind(Generator.class).annotatedWith(Right.class).to(RandomGenerator.class);

        binder.bind(Operator.class).to(PlusOperator.class);
    }
}
