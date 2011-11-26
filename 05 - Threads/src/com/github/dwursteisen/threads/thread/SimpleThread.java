package com.github.dwursteisen.threads.thread;

import com.github.dwursteisen.threads.webservice.IWebservice;
import com.github.dwursteisen.threads.webservice.Twitter;

/**
 * User: Wursteisen David
 * Date: 20/11/11
 * Time: 00:01
 */
public class SimpleThread extends Thread {

    private volatile boolean isRunning = false;


    private final IWebservice webservice = new Twitter();

    public SimpleThread() {
        super("Simple Thread !");
    }

    @Override
    public void run() {

    	// faire un appel toutes les 1000ms !
    	String reponse = webservice.interrogation();
    	System.out.println(reponse);
    }
}
