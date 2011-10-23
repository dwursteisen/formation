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
public class Animal implements EtreVivant {


    @Override
    public String jouer() {
        return "Waff !";
    }
}
