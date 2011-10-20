package com.github.dwursteisen.gestion.erreurs;

import com.github.dwursteisen.mon.programme.BandePassante;
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
        // TODO: supprimer le try/catch/finally
        try {

            List<String> stations = radio.listeDesStations();
            String stationCourante = radio.nomStationCourante();
            radio.ecouteStation(bandePassante);
            radio.stationSuivante();
        } catch (ProblemeTechnique problemeTechnique) {
            logger.warning("* Oups * ! Problème technique lors de l'écoute de la radio");
        } finally {
            bandePassante.fermeture();
        }

    }
}
