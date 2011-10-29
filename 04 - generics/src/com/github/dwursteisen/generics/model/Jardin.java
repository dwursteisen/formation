package com.github.dwursteisen.generics.model;

import java.util.ArrayList;
import java.util.Collection;

/**
 * User: Wursteisen David
 * Date: 21/10/11
 * Time: 22:04
 */
public class Jardin {

    private Collection joueurs = new ArrayList();

    public void ajouteDansLeJardin(Object nouvelArrivant) {
        joueurs.add(nouvelArrivant);
    }

    public void faireJouerToutLeMonde() {
        for (Object joueur : joueurs) {
            System.out.println(((EtreVivant)joueur).jouer());
        }
    }

}
