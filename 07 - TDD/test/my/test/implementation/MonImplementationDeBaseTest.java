package my.test.implementation;

import my.test.MonAnnuaire;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;

import static junit.framework.Assert.*;
import static org.junit.Assert.assertTrue;


public class MonImplementationDeBaseTest {

    private MonAnnuaire annuaire;

    @Before
    public void setUp() {
        annuaire = new MonImplementationDeBase();
    }

    @Test
    public void testAjoutPersonne() throws Exception {
        annuaire.ajoutPersonne("nom", "prenom", "0231445422");
        assertEquals(1, annuaire.taille());
        annuaire.ajoutPersonne("nom", "prenom", "0231445422");
        assertEquals(1, annuaire.taille());
    }


}
