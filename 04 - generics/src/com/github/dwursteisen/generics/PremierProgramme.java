package com.github.dwursteisen.generics;

import com.github.dwursteisen.generics.model.humanite.Femme;
import com.github.dwursteisen.generics.model.humanite.Homme;
import com.github.dwursteisen.generics.model.humanite.Humain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * User: Wursteisen David
 * Date: 21/10/11
 * Time: 23:04
 */
public class PremierProgramme {

    public static void main(final String...args) {
    	/*
    	 * Tout le code suivant est écrit en Java 1.4
    	 * 
    	 * Il doit être modifié pour utiliser les generics
    	 */
    	
        List list = new ArrayList();
        list.add("un");
        list.add("deux");
        list.add("trois");


        List hommesCelebres = new ArrayList();
        hommesCelebres.add(new Homme("Einstein"));
        hommesCelebres.add(new Homme("Sun Tzu"));
        hommesCelebres.add(new Homme("Patrick Bruel"));

        List personnesCelebres = new ArrayList();
        personnesCelebres.add(new Homme("Mickael Jackson"));
        personnesCelebres.add(new Femme("Marilyn Monroe"));


        Humain qui = personneAuPif(personnesCelebres);
        System.out.println("Qui ? "+qui.getNom());
        Humain quiDonc = personneAuPif(hommesCelebres);
        System.out.println("Qui Donc ? "+quiDonc.getNom());
    }

    private static Humain personneAuPif(final List desGens) {
        int indexAleatoire = Math.abs(new Random().nextInt()) % desGens.size();
        return (Humain) desGens.get(indexAleatoire);
    }
}
