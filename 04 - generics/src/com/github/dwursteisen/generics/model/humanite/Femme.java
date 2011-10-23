package com.github.dwursteisen.generics.model.humanite;

import com.github.dwursteisen.generics.annotation.Timer;
import com.github.dwursteisen.generics.model.Femelle;

/**
 * User: Wursteisen David
 * Date: 21/10/11
 * Time: 22:02
 */
public class Femme extends Humain implements Femelle {


    public Femme() {
        this(null);
    }

    public Femme(String nom) {
        super(nom);
    }

    @Override
    public String getGenre() {
        return "Femme";
    }


    @Timer(frequence = 5000)
    public void pouvoirAuxFemmes() {
        System.out.println("Pouvoir aux femmes !");
    }
}
