package com.github.dwursteisen.threads;

import com.github.dwursteisen.threads.webservice.IWebservice;
import com.google.common.eventbus.EventBus;

/**
 * User: Wursteisen David
 * Date: 23/10/11
 * Time: 12:16
 */
class ProducteurMessage extends Thread {

    private final IWebservice webservice;
    private final EventBus broker;

    public ProducteurMessage(final IWebservice webservice, EventBus broker) {
        super("Producteur de message à partir du service " + webservice.nomService());
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
                sleep(5);
            } catch (InterruptedException e) {
                webservice.arret();
                running = false;
            }
        }
    }
}
