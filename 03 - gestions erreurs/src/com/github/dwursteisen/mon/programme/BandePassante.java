package com.github.dwursteisen.mon.programme;

import com.github.dwursteisen.mon.programme.implementation.RadioLocale;
import com.github.dwursteisen.mon.programme.implementation.RadioMondiale;
import com.github.dwursteisen.mon.programme.implementation.RadioNationale;

/**
 * User: Wursteisen David
 * Date: 21/10/11
 * Time: 00:00
 */
public class BandePassante {

    private boolean ouverture = false;

    public void ouverture() {

        if (ouverture) {
            throw new BandePassanteToujoursOuverte("Veuillez fermer la bande passante courante, "
                    + "avant de pouvoir la réutiliser !");
        }
        ouverture = true;

    }

    public void utilisation(RadioLocale radio) throws ProblemeTechnique {
        throw new ProblemeTechnique("Arg ! Poblème technique !");
    }

    public void utilisation(RadioMondiale radio) {
        throw new OutOfMemoryError("Oups, la JVM n'a plus de mémoire !");
    }

    public void utilisation(RadioNationale radio) {
        // TODO: faire quelque chose (comme corriger le code) !
    	String maVariable = radio.nomStationCourante();
    	if(!maVariable.isEmpty()) {
    		maVariable = "";
    	}
    }

    public void fermeture() {
        ouverture = false;
    }

    public boolean isOuverture() {
        return ouverture;
    }
}
