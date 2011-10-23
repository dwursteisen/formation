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

        /*
         * Il ne doit être possible que des animaux dans ce jardin !
         */
        Jardin petitJardin = new Jardin();
        petitJardin.ajouteDansLeJardin(new Animal());
        petitJardin.faireJouerToutLeMonde();

        /*
         * Il ne doit être possible de mettre que des humains dans ce jardin ! 
         */
        Jardin grandJardin = new Jardin();
        grandJardin.ajouteDansLeJardin(adam);
        grandJardin.ajouteDansLeJardin(eve);
        grandJardin.faireJouerToutLeMonde();

        /*
         * Il ne doit être possible de mettre que des hommes dans ce jardin ! 
         */
        Jardin jardin = new Jardin();
        jardin.ajouteDansLeJardin(adam);
        jardin.faireJouerToutLeMonde();


    }
}
