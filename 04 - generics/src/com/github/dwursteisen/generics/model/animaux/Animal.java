package com.github.dwursteisen.generics.model.animaux;

import com.github.dwursteisen.generics.model.EtreVivant;
import com.github.dwursteisen.generics.model.humanite.Femme;
import com.github.dwursteisen.generics.model.humanite.Homme;

import java.util.Random;

/**
 * User: Wursteisen David
 * Date: 21/10/11
 * Time: 22:07
 */
public abstract class Animal implements EtreVivant<Animal> {

    public Animal reproduction(EtreVivant<? extends Animal> etreVivant) {
        int aleatoire = new Random().nextInt();
        boolean isImpaire = (aleatoire & 0x01) == 0;

        if(isImpaire) {
            return new Chien();
        } else {
            return new Chienne();
        }

    }
}
