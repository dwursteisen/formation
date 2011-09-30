package my.test.implementation;

import my.test.MonAnnuaire;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;

import static junit.framework.Assert.*;
import static org.junit.Assert.assertTrue;


public class MonImprementationDeBaseTest {

    private MonAnnuaire annuaire;

    @Before
    public void setUp() {
        annuaire = new MonImprementationDeBase();
    }


    @Test
    public void testTaille() throws Exception {
        assertEquals(0, annuaire.taille());
        annuaire.ajoutPersonne("nom", "prenom", "0231445422");
        assertEquals(1, annuaire.taille());
        annuaire.suppressionPersonne("nom", "prenom");
        assertEquals(0, annuaire.taille());
    }

    @Test
    public void testAjoutPersonne() throws Exception {
        annuaire.ajoutPersonne("nom", "prenom", "0231445422");
        assertEquals(1, annuaire.taille());
        annuaire.ajoutPersonne("nom", "prenom", "0231445422");
        assertEquals(1, annuaire.taille());
    }

    @Test
    public void testSuppressionPersonne() throws Exception {
        assertFalse(annuaire.suppressionPersonne("nom", "prenom"));
        annuaire.ajoutPersonne("nom", "prenom", "0231445422");
        assertTrue(annuaire.suppressionPersonne("nom", "prenom"));
    }

    @Test
    public void testTelephone() throws Exception {
        assertNull(annuaire.telephone("nom", "prenom"));
        annuaire.ajoutPersonne("nom", "prenom", "0231445422");
        assertEquals("0231445422", annuaire.telephone("nom", "prenom"));
    }

    @Test
    public void testTousLesNumeros() throws Exception {
        annuaire.ajoutPersonne("nom1", "prenom1", "0231445422");
        annuaire.ajoutPersonne("nom2", "prenom2", "0231445422");
        annuaire.ajoutPersonne("nom3", "prenom3", "0211111111");
        annuaire.ajoutPersonne("nom4", "prenom4", "0222222222");

        Collection<String> numeros = annuaire.tousLesNuméros();

        assertEquals(3, numeros.size());
    }


    @Test
    public void testNomAssociéAuTéléphone() {
        annuaire.ajoutPersonne("nom1", "prenom1", "0231445422");

        assertEquals("nom1", annuaire.nomAssociéAuTéléphone("0231445422"));
    }

    @Test
    public void testPrenomAssociéAuTéléphone() {
        annuaire.ajoutPersonne("nom1", "prenom1", "0231445422");

        assertEquals("prenom1", annuaire.prenomAssociéAuTéléphone("0231445422"));
    }


}
