package com.github.dwursteisen.gestion.erreurs;

import com.github.dwursteisen.mon.programme.BandePassante;
import com.github.dwursteisen.mon.programme.ProblemeTechnique;
import com.github.dwursteisen.mon.programme.Radio;
import com.github.dwursteisen.mon.programme.implementation.RadioLocale;
import com.github.dwursteisen.mon.programme.implementation.RadioMondiale;
import com.github.dwursteisen.mon.programme.implementation.RadioNationale;
import org.apache.log4j.Logger;

import java.util.List;

public class EcouteRadio {

    private static final Logger logger = Logger.getLogger(EcouteRadio.class);

    public static void main(final String[] args) {


        logger.info("Création des radios");
        final Radio radioLocale = new RadioLocale();
        final Radio radioNationale = new RadioNationale();
        final Radio radioMondiale = new RadioMondiale();

        logger.info("Réservation de la bande passante");
        final BandePassante bandePassante = new BandePassante();

        logger.info("Utilisation de la radio locale");
        utilisationRadio(bandePassante, radioLocale);

        logger.info("Utilisation de la radio locale (encore)");
        utilisationRadio(bandePassante, radioLocale);

        logger.info("Utilisation de la radio nationale");
        utilisationRadio(bandePassante, radioNationale);

        logger.info("Utilisation de la radio mondiale");
        utilisationRadio(bandePassante, radioMondiale);

    }

    private static void utilisationRadio(BandePassante bandePassante, Radio radio) {
        bandePassante.ouverture();
        if(logger.isDebugEnabled()) {
            List<String> stations = radio.listeDesStations();
            logger.debug("Liste des stations de la radio courante : "+stations);
        }

        String stationCourante = radio.nomStationCourante();

        logger.debug("Ecoute de la station :"+stationCourante);

        // gérer le try/catch ici !
        radio.ecouteStation(bandePassante);
		
        radio.stationSuivante();
        
    }
}
