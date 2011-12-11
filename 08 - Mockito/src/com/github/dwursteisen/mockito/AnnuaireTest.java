package com.github.dwursteisen.mockito;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

/**
 * User: Wursteisen David
 * Date: 06/12/11
 * Time: 21:46
 */
@RunWith(MockitoJUnitRunner.class)
public class AnnuaireTest {

    private Annuaire annuaire;

    @Before
    public void setUp() {
        
    }

    /**
     * Test de la méthode enregistrePersonne
     * Pour cela, il est nécessaire de vérifier que la méthode
     * ajouteAdresse a bien été appelé sur l'interface AdresseDao
     * @throws Exception
     */
    @Test
    public void testEnregistrePersonne() throws Exception {

    }

    
    /**
     * Vérifier que la méthode recupereToutesLesAdressesSansDoublon 
     * retourne la liste des adresses, en supprimant les doublons.
     * 
     * Pour cela, la méthode toutesLesAdresses de l'interface AdresseDao
     * devra retourner une liste d'adresse avec des doublons.
     */
    @Test
    public void testRecupereLesAdressesSansDoublon() {

    }

    /**
     * Vérifie que la méthode possedeDejaUneAdresse retourne false
     * quand il n'y a pas d'adresse associé au nom.
     * 
     * Il faudra simuler recupereUneAdresse qui n'est pas encore 
     * implémenté en utilisant un Spy
     */
    @Test
    public void testNePossedePasAdresse() {
        
    }

    @Test
    public void testPossedeAdresse() {
        
    }
}
