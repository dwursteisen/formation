package com.github.dwursteisen.mockito;

import java.util.List;

/**
 * User: Wursteisen David
 * Date: 06/12/11
 * Time: 21:41
 */
public interface AdresseDao {
    
    List<Adresse> toutesLesAdresses();
    Adresse derniereAdresse();
    void ajouteAdresse(Adresse adresse);
}
