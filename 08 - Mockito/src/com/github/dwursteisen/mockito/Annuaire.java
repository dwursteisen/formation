package com.github.dwursteisen.mockito;

import java.util.*;

/**
 * User: Wursteisen David
 * Date: 06/12/11
 * Time: 21:43
 */
public class Annuaire {

    private AdresseDao dao;

    public Annuaire(AdresseDao adresseDao) {
        this.dao = adresseDao;
    }
    public void enregistressePersonne(String nom, String adresse) {
        Adresse objAdresse = fabriqueAdresse(nom, adresse);
        dao.ajouteAdresse(objAdresse);
    }
    
    public Collection<String> recupereToutesLesAdressesSansDoublon() {
        Set<String> result = new HashSet<String>();
        List<Adresse> adresses = dao.toutesLesAdresses();
        for(Adresse adresse : adresses) {
            result.add(adresse.getAdresse());
        }
        return result;
    }
    
    Adresse fabriqueAdresse(String nom, String adresse) {
        return new Adresse(nom, adresse);
    }
}
