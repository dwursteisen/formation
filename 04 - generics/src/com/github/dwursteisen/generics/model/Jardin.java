package com.github.dwursteisen.generics.model;

import java.util.ArrayList;
import java.util.Collection;

/**
 * User: Wursteisen David
 * Date: 21/10/11
 * Time: 22:04
 */
public class Jardin<GENRE extends EtreVivant> {

    private Collection<GENRE> joueurs = new ArrayList<GENRE>();

    public void ajouteDansLeJardin(GENRE nouvelArrivant) {
        joueurs.add(nouvelArrivant);
    }

    public void faireJouerToutLeMonde() {
        for (GENRE joueur : joueurs) {
            System.out.println(joueur.jouer());
        }
    }

}
