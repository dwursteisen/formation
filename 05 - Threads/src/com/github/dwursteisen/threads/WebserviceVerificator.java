package com.github.dwursteisen.threads;

import com.github.dwursteisen.threads.webservice.IWebservice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * User: Wursteisen David
 * Date: 23/10/11
 * Time: 12:15
 */
class WebserviceVerificator extends Thread {

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
