package com.github.dwursteisen.gestion.erreurs;

import com.github.dwursteisen.mon.programme.ProblemeTechnique;
import com.github.dwursteisen.mon.programme.Radio;
import com.github.dwursteisen.mon.programme.implementation.RadioLocale;
import com.github.dwursteisen.mon.programme.implementation.RadioMondiale;
import com.github.dwursteisen.mon.programme.implementation.RadioNationale;

import java.util.List;
import java.util.logging.Logger;

/**
 * Created by IntelliJ IDEA.
 * User: david
 * Date: 03/10/11
 * Time: 22:56
 * To change this template use File | Settings | File Templates.
 */
public class EcouteRadio {

    private static final Logger logger = Logger.getLogger("MonLogger");

    public static void main(final String[] args) {


        logger.info("Création des radios");
        Radio radioLocale = new RadioLocale();
        Radio radioNationale = new RadioNationale();
        Radio radioMondiale = new RadioMondiale();


        try {
            logger.info("Utilisation de la radio locale");
            List<String> stations = radioLocale.listeDesStations();
            String stationCourante = radioLocale.nomStationCourante();
            radioLocale.ecouteStation();
            radioLocale.stationSuivante();
        } catch (ProblemeTechnique problemeTechnique) {

        }

        // TODO pareil pour les autres Radios
        logger.info("Utilisation de la radio nationale");


        logger.info("Utilisation de la radio mondiale");


    }
}
