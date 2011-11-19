package com.github.dwursteisen.threads.verificators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * User: Wursteisen David
 * Date: 23/10/11
 * Time: 12:15
 */
public class ThreadVerificator extends Thread {

    private List<String> threadImportant = Arrays.asList(
            "Monitor Ctrl-Break",
            "DestroyJavaVM",
            "verificator" // ça, c'est moi !
    );

    final private ArrayList<Thread> threads;

    public ThreadVerificator() {
        this(new ArrayList<Thread>());
    }

    public ThreadVerificator(final Thread... threads) {
        this(Arrays.asList(threads));
    }

    public ThreadVerificator(final List<? extends Thread> webservices) {
        super("verificator");
        this.threads = new ArrayList<Thread>(webservices);
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
        for (Thread t : threads) {
            if (t.isAlive()) {
                System.err.println("Hey ! Tu as oublié de faire un stop sur le service " + t.getName());
            }
        }
    }
}
