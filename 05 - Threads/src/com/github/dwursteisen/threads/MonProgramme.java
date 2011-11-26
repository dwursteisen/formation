package com.github.dwursteisen.threads;

import com.github.dwursteisen.threads.thread.SimpleThread;
import com.github.dwursteisen.threads.verificators.KillProgramByUser;
import com.github.dwursteisen.threads.verificators.ThreadVerificator;

/**
 * User: Wursteisen David
 * Date: 22/10/11
 * Time: 21:11
 */
public class MonProgramme {

    public static void main(final String... args) throws InterruptedException {

    	// Modifier la class SimpleThread
        SimpleThread thread = new SimpleThread();
        thread.start();


        // pas touche !
        KillProgramByUser killProgramByUser = new KillProgramByUser();
        killProgramByUser.start();

        Thread webserviceVerificator = new ThreadVerificator(thread);
        Runtime.getRuntime().addShutdownHook(webserviceVerificator);

    }


}
