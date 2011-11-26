package com.github.dwursteisen.injection.module;

import com.github.dwursteisen.injection.display.Display;
import com.github.dwursteisen.injection.display.SystemOutDisplay;
import com.github.dwursteisen.injection.generator.ByOrderGenerator;
import com.github.dwursteisen.injection.generator.Generator;
import com.github.dwursteisen.injection.generator.RandomGenerator;
import com.github.dwursteisen.injection.operator.Left;
import com.github.dwursteisen.injection.operator.Operator;
import com.github.dwursteisen.injection.operator.PlusOperator;
import com.github.dwursteisen.injection.operator.Right;
import com.google.inject.Binder;
import com.google.inject.Module;

/**
 * User: Wursteisen David
 * Date: 23/11/11
 * Time: 23:34
 */
public class OperationModule implements Module {
    public void configure(Binder binder) {

        /**
         * Différents types d'affichage sont disponibles.
         * Vous pouvez essayer avec le SystemOutDisplay, le BigDisplay,
         */
        binder.bind(Display.class).to(SystemOutDisplay.class);

        /**
         * Vous pouvez aussi modifier les générateurs de valeurs pour les opérandes.
         *
         * Vous pouvez aussi écrire un nouveau générateur de nombre en créant
         * une nouvelle class qui hérite de l'interface Generator
         */
        binder.bind(Generator.class).annotatedWith(Left.class).to(ByOrderGenerator.class);
        binder.bind(Generator.class).annotatedWith(Right.class).to(RandomGenerator.class);

        /**
         * Modificer l'opérateur utilisé dans le programme et observait les différents
         * comportements, sans que le code ne soit modifié, à part cette class !
         * (qui pourrait être un fichier xml, comme dans Spring)
         */
        binder.bind(Operator.class).to(PlusOperator.class);
    }
}
