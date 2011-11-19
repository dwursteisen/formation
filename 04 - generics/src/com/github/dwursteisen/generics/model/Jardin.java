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
public class Jardin {

    private Collection joueurs = new ArrayList();

    public void ajouteDansLeJardin(Object nouvelArrivant) {
        joueurs.add(nouvelArrivant);
    }

    public void faireJouerToutLeMonde() {
        for (Object joueur : joueurs) {
            EtreVivant obj = (EtreVivant) joueur;
            System.out.println(obj.jouer());
        }
    }

}
