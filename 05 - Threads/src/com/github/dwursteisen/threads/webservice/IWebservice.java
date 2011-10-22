package com.github.dwursteisen.threads.webservice;

/**
 * User: Wursteisen David
 * Date: 22/10/11
 * Time: 22:46
 */
public interface IWebservice {

    void demarrage();

    String interrogation();

    void arret();

    boolean isVivant();

    String nomService();
}
