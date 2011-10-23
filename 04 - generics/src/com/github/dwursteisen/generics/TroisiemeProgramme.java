package com.github.dwursteisen.generics;

import com.github.dwursteisen.generics.annotation.MaitreDuTemps;
import com.github.dwursteisen.generics.model.humanite.Femme;
import com.github.dwursteisen.generics.model.humanite.Homme;

import java.util.Timer;
import java.util.TimerTask;

/**
 * User: Wursteisen David
 * Date: 23/10/11
 * Time: 15:05
 */
public class TroisiemeProgramme {

    public static void main(String ... args) {
        MaitreDuTemps maitreDuTemps = new MaitreDuTemps();


        final Homme adam = new Homme("adam");
        final Femme eve = new Femme("eve");

        maitreDuTemps.analyse(adam, eve);
        maitreDuTemps.demarrage();

        Timer timer = new Timer();
        TimerTask reproduction = new TimerTask() {
            @Override
            public void run() {
                adam.reproduction(eve);
            }
        };
        timer.schedule(reproduction, 0, 200);


    }
}
