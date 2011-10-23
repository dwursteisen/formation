package com.github.dwursteisen.generics.model.humanite;

/**
 * User: Wursteisen David
 * Date: 21/10/11
 * Time: 22:02
 */
public class Homme extends Humain {

    public Homme() {
        this(null);
    }

    public Homme(final String nom) {
        super(nom);
    }

    @Override
    public String getGenre() {
        return "Homme";
    }

    @Override
    public String jouer() {
        return "Radio, biere, foot !";
    }
}
