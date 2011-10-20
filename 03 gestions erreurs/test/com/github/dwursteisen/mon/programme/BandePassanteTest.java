package com.github.dwursteisen.mon.programme;

import org.junit.Before;
import org.junit.Test;

/**
 * User: Wursteisen David
 * Date: 21/10/11
 * Time: 00:01
 */
public class BandePassanteTest {


    private BandePassante bandePassante;

    @Before
    public void setUp() {
        bandePassante = new BandePassante();
    }
    @Test(expected = BandePassanteToujoursOuverte.class)
    public void bandePassanteNonFerme() {

        bandePassante.ouverture();
        bandePassante.ouverture();

    }
}
