package com.github.dwursteisen.mon.programme;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: david
 * Date: 03/10/11
 * Time: 22:46
 * To change this template use File | Settings | File Templates.
 */
public interface Radio {
    List<String> listeDesStations();

    void ecouteStation(BandePassante bandePassante) throws ProblemeTechnique;
    String nomStationCourante();
    void stationSuivante();


}
