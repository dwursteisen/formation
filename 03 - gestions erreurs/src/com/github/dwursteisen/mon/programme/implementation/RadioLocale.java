package com.github.dwursteisen.mon.programme.implementation;

import com.github.dwursteisen.mon.programme.BandePassante;
import com.github.dwursteisen.mon.programme.ProblemeTechnique;
import com.github.dwursteisen.mon.programme.Radio;
import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: david
 * Date: 03/10/11
 * Time: 22:49
 * To change this template use File | Settings | File Templates.
 */
public class RadioLocale implements Radio {

    private int currentIndex = 0;

    private static final Logger logger = Logger.getLogger(RadioLocale.class);

    public List<String> listeDesStations() {
        logger.debug("Recherche des différentes stations de la radio locale...");
        return Arrays.asList("Radio Proche", "Radio Pas Trop Loin", "Radio Plus Loin");
    }

    public void ecouteStation(BandePassante bandePassante) throws ProblemeTechnique {
        if(!bandePassante.isOuverture()) {
            throw new ProblemeTechnique("Bande passante non ouverte !");
        }
        logger.info("Ecoute de la station courante sur la radio locale");
        bandePassante.utilisation(this);
    }

    public String nomStationCourante() {
        return listeDesStations().get(currentIndex);
    }

    public void stationSuivante() {
        logger.info("Recherche de la station suivante sur la radio locale");
        currentIndex = (currentIndex + 1) % listeDesStations().size();
    }

	public void annulationEcoute() {
		// rollback de la dernière écoute
		logger.info("Annulation de la dernière écoute");
	}
}
