package com.github.dwursteisen.threads;

import java.util.ArrayList;
import java.util.Collection;

/**
 * User: Wursteisen David
 * Date: 22/10/11
 * Time: 21:11
 */
public class MonProgramme {

    public static void main(final String... args) throws InterruptedException {
        Runtime.getRuntime().addShutdownHook(new Thread(new ShutdownHock()));
        Thread mainThread = new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        sleep(100);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        };
        mainThread.start();
    }


    private static class ShutdownHock implements Runnable {

        private Collection<Thread> threads;

        public ShutdownHock() {
            this(new ArrayList<Thread>());
        }

        public ShutdownHock(final Collection<Thread> threads) {
            this.threads = new ArrayList<Thread>(threads);
        }

        public void run() {
            System.out.println("Les threads vont être stoppés...");
            for (Thread thread : threads) {
                thread.interrupt();
            }
            System.out.println("Fin de l'application...");
        }
    }
}
