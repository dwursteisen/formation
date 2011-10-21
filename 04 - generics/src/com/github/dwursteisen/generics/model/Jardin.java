package com.github.dwursteisen.generics.model;

/**
 * User: Wursteisen David
 * Date: 21/10/11
 * Time: 22:04
 */
public class Jardin<MALE extends EtreVivant & Male, FEMELLE extends EtreVivant & Femelle> {

    private final MALE male;
    private final FEMELLE femelle;


    public Jardin(MALE male, FEMELLE femelle) {
        this.male = male;
        this.femelle = femelle;
    }


    public <GENRE extends EtreVivant> GENRE nouvelleGeneration(Class<GENRE> genre) {
        return (GENRE) male.reproduction(femelle);
    }


}
