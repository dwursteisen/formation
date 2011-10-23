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

        // TODO: mettre des Object partout
        Jardin<Animal> petitJardin = new Jardin<Animal>();
        petitJardin.ajouteDansLeJardin(new Animal());
        petitJardin.faireJouerToutLeMonde();

        Jardin<Humain> grandJardin = new Jardin<Humain>();
        grandJardin.ajouteDansLeJardin(adam);
        grandJardin.ajouteDansLeJardin(eve);
        grandJardin.faireJouerToutLeMonde();

        Jardin<Homme> jardin = new Jardin<Homme>();
        jardin.ajouteDansLeJardin(adam);
        jardin.faireJouerToutLeMonde();


    }
}
