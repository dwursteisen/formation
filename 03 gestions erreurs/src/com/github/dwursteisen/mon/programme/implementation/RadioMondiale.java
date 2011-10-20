package com.github.dwursteisen.mon.programme.implementation;

import com.github.dwursteisen.mon.programme.BandePassante;
import com.github.dwursteisen.mon.programme.ProblemeTechnique;
import com.github.dwursteisen.mon.programme.Radio;

import java.util.Arrays;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: david
 * Date: 03/10/11
 * Time: 22:54
 * To change this template use File | Settings | File Templates.
 */
public class RadioMondiale implements Radio {
    public List<String> listeDesStations() {
        return Arrays.asList("Radio France", "Radio Allemagne", "Radio Russie");
    }

    public void ecouteStation(BandePassante bandePassante) throws ProblemeTechnique {
        if(!bandePassante.isOuverture()) {
            throw new ProblemeTechnique("Bande passante non ouverte !");
        }
        bandePassante.utilisation(this);
    }

    public String nomStationCourante() {
        return "Radio d'un pays...";
    }

    public void stationSuivante() {

    }
}
