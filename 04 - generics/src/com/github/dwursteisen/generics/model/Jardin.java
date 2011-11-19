package com.github.dwursteisen.generics.model;

import java.util.ArrayList;
import java.util.Collection;

/**
 * User: Wursteisen David
 * Date: 21/10/11
 * Time: 22:04
 */

/**
 * Pour rendre généric cette class, il faut :
 * 1) utiliser la syntax généric sur la class Jardin avec le bon joker. Il est important
 * de savoir que la méthode 'jouer' n'est fourni uniquement que par l'interface EtreVivant
 * <p/>
 * 2) utiliser la syntaxe généric sur la collection joueurs
 * <p/>
 * 3) la collection étant généric, il est possible de modifier le for et le cast de la méthode faireJouerToutLeMonde
 * <p/>
 * 4) la dernière modification portera sur la méthode ajouteDansLeJardin, au niveau du paramètre de la méthode
 */
public class Jardin<GENRE extends EtreVivant> {

    private Collection<GENRE> joueurs = new ArrayList<GENRE>();

    public void ajouteDansLeJardin(GENRE nouvelArrivant) {
        joueurs.add(nouvelArrivant);
    }

    public void faireJouerToutLeMonde() {
        for (GENRE joueur : joueurs) {
            System.out.println(joueur.jouer());
        }
    }

}
