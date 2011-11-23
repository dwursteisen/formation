package com.github.dwursteisen.injection;

import com.github.dwursteisen.injection.module.OperationModule;
import com.github.dwursteisen.injection.operator.Operator;
import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * User: Wursteisen David
 * Date: 23/11/11
 * Time: 23:41
 */
public class Main {

    public static void main(final String...args) {
        Injector injector = Guice.createInjector(new OperationModule());
        Operator operator = injector.getInstance(Operator.class);
        operator.perform();
    }
}
