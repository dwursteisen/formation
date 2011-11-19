package com.github.dwursteisen.generics;

import com.github.dwursteisen.generics.annotation.MaitreDuTemps;
import com.github.dwursteisen.generics.model.humanite.Femme;
import com.github.dwursteisen.generics.model.humanite.Homme;

/**
 * User: Wursteisen David
 * Date: 23/10/11
 * Time: 15:05
 */
public class TroisiemeProgramme {

    public static void main(String... args) {
        MaitreDuTemps maitreDuTemps = new MaitreDuTemps();


        final Homme adam = new Homme("adam");
        final Femme eve = new Femme("eve");

        // maitreDuTemps va chercher les annotations qu'il sait lire dans
        // les objets adam & eve
        maitreDuTemps.analyse(adam, eve);
        maitreDuTemps.demarrage();

    }
}
