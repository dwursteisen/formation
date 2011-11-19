package com.github.dwursteisen.threads;

import com.google.common.eventbus.Subscribe;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * User: Wursteisen David
 * Date: 23/10/11
 * Time: 12:17
 */
class ConsomateurMessage extends Thread {

    private final int MAX_MESSAGE = 5;
    private final Queue<String> messages = new LinkedBlockingQueue<String>(MAX_MESSAGE);

    public ConsomateurMessage() {
        super("Consomateur message");
    }

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
}
