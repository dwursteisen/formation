package com.github.dwursteisen.threads.webservice;

import java.util.Random;

/**
 * User: Wursteisen David
 * Date: 22/10/11
 * Time: 22:48
 */
public class Twitter implements IWebservice {


    private static String[] tweets = {
            "*A un braquage de banque* Voleur : \"Le fric!\" Banquier : \"C'est chic!\"",
            "Sur Quotes, on est généralement gavés de répondre aux discussions alors que sur Twitter c'est un plaisir de répondre aux mentions.",
            "Heureusement que Carla a accouché d'une fille , ça lui évitera la confusion quand on lui demandera \" Comment va le petit ? \" .",
            "\"David Guetta sacré meilleur DJ au monde\". Du coup je viens d'attribuer le Nobel de mathématique à mon steak haché.",
            "Bienvenue dans notre société. Vous serez jugés sur ce que vous portez, vos goûts musicaux, et sur votre physique. Profitez de votre séjour.",
            "Si toi aussi tu as déjà pensé à l'idée que quelqu'un t'espionne à travers ta webcam.",
            "Le CSA exige qu'une socialiste accouche dans la semaine.",
            "J'aime bien utiliser \"etc...\" en contrôle. Genre \"Je sais tellement de choses que je peux pas tout écrire...\" Alors que je sais rien.",
            "Je découvre les gens qui \"follow back\". Ça m'fait penser à ceux qui demandaient des \"com\" sur Skyblog. Ça me donne envie de quitter Twitter.",
            "BlackBerry offre à chacun de ses clients 100 $ d'applications gratuites. Franchement, offrez-leur plutôt un truc utile. Genre un smartphone."
    };

    private Random seed = new Random();
    private volatile boolean isRunning = false;

    @Override
    public void demarrage() {
        System.out.println("Démarrage du service TWITTER");
        isRunning = true;
    }

    @Override
    public String interrogation() {
        if (!isVivant()) {
            demarrage();
        }
        return nomService() + " - " + tweets[seed.nextInt(tweets.length)];
    }

    @Override
    public void arret() {
        System.out.println("Stop du service TWITTER");
        isRunning = false;
    }

    @Override
    public boolean isVivant() {
        return isRunning;
    }

    @Override
    public String nomService() {
        return "TWITTER";
    }
}
