package com.github.dwursteisen.threads;

import com.github.dwursteisen.threads.webservice.IWebservice;
import com.github.dwursteisen.threads.webservice.Quotes;
import com.github.dwursteisen.threads.webservice.Twitter;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * User: Wursteisen David
 * Date: 22/10/11
 * Time: 21:11
 */
public class MonProgramme {

    public static void main(final String... args) throws InterruptedException {

        final IWebservice quotes = new Quotes();
        final IWebservice twitter = new Twitter();


        final EventBus broker = new EventBus();

        final Thread checkQuotesService = new InterrogationWebservice(quotes, broker);
        final Thread checkTwitterService = new InterrogationWebservice(twitter, broker);

        final Thread affichageMessage = new Thread("affichageMessage") {

            private final Queue<String> messages = new LinkedBlockingQueue<String>(5);

            @Override
            public void run() {
                boolean running = true;
                while (running) {
                    String message = messages.poll();
                    if (message == null) {
                        continue;
                    }

                    System.out.println("MESSAGE => " + message);
                    try {
                        sleep(3000);
                    } catch (InterruptedException e) {
                        running = false;
                    }
                }
                System.out.println("....CONNEXION ARRETE....");
            }


            @Subscribe
            public void receptionMessage(String nouveauMessage) {
                messages.offer(nouveauMessage);
            }
        };

        broker.register(affichageMessage);

        affichageMessage.start();
        checkQuotesService.start();
        checkTwitterService.start();

        Thread webserviceVerificator = new WebserviceVerificator(Arrays.asList(quotes, twitter));
        Runtime.getRuntime().addShutdownHook(webserviceVerificator);

    }


    private static class WebserviceVerificator extends Thread {

        private List<String> threadImportant = Arrays.asList(
                "Monitor Ctrl-Break",
                "DestroyJavaVM",
                "verificator" // ça, c'est moi !
        );

        final private Collection<IWebservice> webservices;

        public WebserviceVerificator() {
            this(new ArrayList<IWebservice>());
        }

        public WebserviceVerificator(final List<? extends IWebservice> webservices) {
            super("verificator");
            this.webservices = new ArrayList<IWebservice>(webservices);
        }


        private void interruptionDesThreads() {
            System.out.println("Interruption de tous les threads...");
            ThreadGroup rootGroup = Thread.currentThread().getThreadGroup();

            System.out.println("groupname : " + rootGroup.getName());

            Thread[] threads = new Thread[rootGroup.activeCount()];
            while (rootGroup.enumerate(threads, true) == threads.length) {
                threads = new Thread[threads.length * 2];
            }

            for (Thread thread : threads) {
                if (thread == null || threadImportant.contains(thread.getName())) {
                    continue;
                }

                System.out.println("Interruption du thread " + thread.getName());
                thread.interrupt();
            }
        }

        public void run() {
            interruptionDesThreads();
            verificationDesServices();
            System.out.println("Fin de l'application...");
        }

        private void verificationDesServices() {
            for (IWebservice webservice : webservices) {
                if (webservice.isVivant()) {
                    System.err.println("Hey ! Tu as oublié de faire un stop sur le service " + webservice.nomService());
                }
            }
        }
    }

    private static class InterrogationWebservice extends Thread {

        private final IWebservice webservice;
        private final EventBus broker;

        public InterrogationWebservice(final IWebservice webservice, EventBus broker) {
            super("Interrogation du service " + webservice.nomService());
            this.webservice = webservice;
            this.broker = broker;
        }

        @Override
        public void run() {
            webservice.demarrage();
            boolean running = true;
            while (running) {
                try {
                    this.broker.post(webservice.interrogation());
                    sleep(10);
                } catch (InterruptedException e) {
                    webservice.arret();
                    running = false;
                }
            }
        }
    }
}
