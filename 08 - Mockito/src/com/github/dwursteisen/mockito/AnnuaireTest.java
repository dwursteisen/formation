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

import static org.junit.Assert.assertEquals;

/**
 * User: Wursteisen David
 * Date: 06/12/11
 * Time: 21:46
 */
@RunWith(MockitoJUnitRunner.class)
public class AnnuaireTest {

    @Mock
    private AdresseDao dao;

    private Annuaire annuaire;

    @Before
    public void setUp() {
        annuaire = new Annuaire(dao);
    }

    @Test
    public void testEnregistressePersonne() throws Exception {

        annuaire.enregistressePersonne("nom", "mon adresse");

        Mockito.verify(dao).ajouteAdresse(new Adresse("nom", "mon adresse"));
    }

    @Test
    public void testRecupereLesAdressesSansDoublon() {
        Adresse adr1 = new Adresse("aaa", "adr");
        Adresse adr2 = new Adresse("aaa", "adr");
        Adresse adr3 = new Adresse("aaa", "adr");
        List<Adresse> adresses = Arrays.asList(adr1, adr2, adr3);

        Mockito.doReturn(adresses).when(dao).toutesLesAdresses();

        Collection<String> result = annuaire.recupereToutesLesAdressesSansDoublon();
        assertEquals(1, result.size());

    }
}
