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
 * Time: 22:52
 * To change this template use File | Settings | File Templates.
 */
public class RadioNationale implements Radio {
    public List<String> listeDesStations() {
        return Arrays.asList("Radio Normandie", "Radio Bretagne", "Radio Ile de France");
    }

    public void ecouteStation(BandePassante bandePassante) throws ProblemeTechnique {
        if(!bandePassante.isOuverture()) {
            throw new ProblemeTechnique("Bande passante non ouverte !");
        }
        bandePassante.utilisation(this);
    }

    public String nomStationCourante() {
       return "";
    }

    public void stationSuivante() {

    }
}
