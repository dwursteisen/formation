package com.github.dwursteisen.generics.model.humanite;

import com.github.dwursteisen.generics.model.Male;

/**
 * User: Wursteisen David
 * Date: 21/10/11
 * Time: 22:02
 */
public class Homme extends Humain implements Male {

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
}
