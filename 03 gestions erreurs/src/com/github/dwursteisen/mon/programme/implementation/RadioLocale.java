package com.github.dwursteisen.mon.programme.implementation;

import com.github.dwursteisen.mon.programme.ProblemeTechnique;
import com.github.dwursteisen.mon.programme.Radio;

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

    public List<String> listeDesStations() {
        return Arrays.asList("Radio Proche", "Radio Pas Trop Loin", "Radio Plus Loin");
    }

    public void ecouteStation() throws ProblemeTechnique {
        throw new ProblemeTechnique("Oups ! Impossible de trouver la station radio locale");
    }

    public String nomStationCourante() {
        return listeDesStations().get(currentIndex);
    }

    public void stationSuivante() {
        currentIndex = (currentIndex + 1) % listeDesStations().size();
    }
}
