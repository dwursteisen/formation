package com.github.dwursteisen.threads;

import com.github.dwursteisen.threads.verificators.KillProgramByUser;
import com.github.dwursteisen.threads.verificators.WebserviceVerificator;
import com.github.dwursteisen.threads.webservice.IWebservice;
import com.github.dwursteisen.threads.webservice.Quotes;
import com.github.dwursteisen.threads.webservice.Twitter;
import com.google.common.eventbus.EventBus;

import java.util.Arrays;

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

        final Thread checkQuotesService = new ProducteurMessage(quotes, broker);
        final Thread checkTwitterService = new ProducteurMessage(twitter, broker);

        final Thread affichageMessage = new ConsomateurMessage();

        broker.register(affichageMessage);

        affichageMessage.start();
        checkQuotesService.start();
        checkTwitterService.start();
        
        (new KillProgramByUser()).start();
        
        Thread webserviceVerificator = new WebserviceVerificator(Arrays.asList(quotes, twitter));
        Runtime.getRuntime().addShutdownHook(webserviceVerificator);

    }


}
