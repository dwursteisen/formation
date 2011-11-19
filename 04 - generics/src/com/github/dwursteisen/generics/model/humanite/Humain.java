package com.github.dwursteisen.generics.model.humanite;

import com.github.dwursteisen.generics.model.EtreVivant;

import java.util.Random;

/**
 * User: Wursteisen David
 * Date: 21/10/11
 * Time: 22:01
 */
public abstract class Humain implements EtreVivant {

    private static int population = 0;

    protected final String nom;

    public Humain(final String nom) {
        this.nom = nom;
    }

    public abstract String getGenre();

    public Humain reproduction(Humain autre) {
        int aleatoire = new Random().nextInt();
        boolean isImpaire = (aleatoire & 0x01) == 0;

        population++;

        if (isImpaire) {
            return new Femme();
        } else {
            return new Homme();
        }
    }

    public String getNom() {
        return nom;
    }

}
