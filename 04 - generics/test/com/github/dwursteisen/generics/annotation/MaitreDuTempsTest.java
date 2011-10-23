package com.github.dwursteisen.generics.annotation;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;

/**
 * User: Wursteisen David
 * Date: 23/10/11
 * Time: 14:20
 */
public class MaitreDuTempsTest {

    private MaitreDuTemps analyseur;
    private Object testObject;

    @Before
    public void setUp() {
        analyseur = new MaitreDuTemps();
        testObject = new Object() {

            @Timer(frequence = 1000)
            public void apelleMoi() {

            }

            @Timer(frequence = 2000)
            public void appelleMoiEncore() {

            }
        };

    }

    @Test
    public void changeMethode() throws NoSuchMethodException {
        final List<String> message = new ArrayList<String>();

    }

    @Test
    public void trouveMethods() {
        MaitreDuTemps.MethodInformation[] methods = analyseur.trouveMethods(testObject);
        assertEquals(2, methods.length);
    }

    @Test
    public void creationTimer() {
        MaitreDuTemps.MethodInformation[] methods = analyseur.trouveMethods(testObject);
        TimerTask timer = analyseur.creationTimer(methods[0].getMethod(), methods[0].getParent());
        assertNotNull(timer);

    }
}
