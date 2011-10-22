package com.github.dwursteisen.threads;

import com.github.dwursteisen.threads.webservice.IWebservice;
import com.github.dwursteisen.threads.webservice.Quotes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * User: Wursteisen David
 * Date: 22/10/11
 * Time: 21:11
 */
public class MonProgramme {

    public static void main(final String... args) throws InterruptedException {

        final Quotes quotes = new Quotes();

        final Thread checkQuotesService = new Thread() {

            @Override
            public void run() {
                quotes.demarrage();
                boolean running = true;
                while (running) {
                    try {
                        System.out.println(quotes.interrogation());
                        sleep(100);
                    } catch (InterruptedException e) {
                        quotes.arret();
                        running = false;
                    }
                }
            }
        };

        Thread interruptor = new Thread() {
            @Override
            public void run() {
                checkQuotesService.interrupt();
            }
        };

        checkQuotesService.start();

        Runtime.getRuntime().addShutdownHook(interruptor);
        Runtime.getRuntime().addShutdownHook(new Thread(new ShutdownHock(Arrays.asList(quotes))));

    }


    private static class ShutdownHock implements Runnable {

        private Collection<IWebservice> threads;

        public ShutdownHock() {
            this(new ArrayList<IWebservice>());
        }

        public ShutdownHock(final List<? extends IWebservice> threads) {
            this.threads = new ArrayList<IWebservice>(threads);
        }

        public void run() {
            for (IWebservice thread : threads) {
                if (thread.isVivant()) {
                    System.err.println("Hey ! Tu as oublié de faire un stop sur le service " + thread.nomService());
                }
            }
            System.out.println("Fin de l'application...");
        }
    }
}
