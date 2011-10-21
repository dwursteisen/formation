package com.github.dwursteisen.generics;

import com.github.dwursteisen.generics.model.EtreVivant;
import com.github.dwursteisen.generics.model.Jardin;
import com.github.dwursteisen.generics.model.animaux.Animal;
import com.github.dwursteisen.generics.model.humanite.Femme;
import com.github.dwursteisen.generics.model.humanite.Homme;
import com.github.dwursteisen.generics.model.humanite.Humain;

/**
 * User: Wursteisen David
 * Date: 21/10/11
 * Time: 22:00
 */
public class SecondProgramme {

    public static void main(final String[] arguments) {


        Homme adam = new Homme();
        Femme eve = new Femme();

        Jardin<Homme, Femme> heaven = new Jardin<Homme, Femme>(adam, eve);
        Humain enfant = heaven.nouvelleGeneration(Humain.class);

        Animal animal = heaven.nouvelleGeneration(Animal.class);

    }
}
