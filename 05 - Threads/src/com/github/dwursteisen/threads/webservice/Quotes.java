package com.github.dwursteisen.threads.webservice;

import java.util.Random;

/**
 * User: Wursteisen David
 * Date: 22/10/11
 * Time: 22:59
 */
public class Quotes implements IWebservice {

    private static String[] quotes = {
            "A joke is a very serious thing. ",
            "A politician needs the ability to foretell what is going to happen tomorrow, next week, next month, and next year. And to have the ability afterwards to explain why it didn't happen.",
            "All the great things are simple, and many can be expressed in a single word: freedom, justice, honor, duty, mercy, hope. ",
            "Battles are won by slaughter and maneuver. The greater the general, the more he contributes in maneuver, the less he demands in slaughter.",
            "Continuous effort - not strength or intelligence - is the key to unlocking our potential. ",
            "I never worry about action, but only inaction.",
            "If the human race wishes to have a prolonged and indefinite period of material prosperity, they have only got to behave in a peaceful and helpful way toward one another. ",
            "India is a geographical term. It is no more a united nation than the Equator.",
            "Let our advance worrying become advance thinking and planning.",
            "Men occasionally stumble over the truth, but most of them pick themselves up and hurry off as if nothing had happened. "

    };

    private Random seed = new Random();
    private volatile boolean isRunning = false;

    @Override
    public void demarrage() {
        System.out.println("Démarrage du service QUOTES");
        isRunning = true;
    }

    @Override
    public String interrogation() {
        if (!isVivant()) {
            throw new RuntimeException("le service " + nomService() + " n'est pas démarré !");
        }
        return nomService() + " - " + quotes[seed.nextInt(quotes.length)];
    }

    @Override
    public void arret() {
        System.out.println("Arrêt du service QUOTES");
        isRunning = false;
    }

    @Override
    public boolean isVivant() {
        return isRunning;
    }

    @Override
    public String nomService() {
        return "QUOTES";
    }
}
