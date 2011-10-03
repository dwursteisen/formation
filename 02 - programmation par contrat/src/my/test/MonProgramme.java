package my.test;

import java.util.Collection;

public class MonProgramme {

    public static void main(final String[] args) {

        // Remplacez FrabriqueAnnuaire.constructionAnnuaire(); par
        // new VotreNomImpl();
        MonAnnuaire annuaire = FabriqueAnnuaire.constructionAnnuaire();

        System.out.println("==== IMPLEMENTATION "+annuaire.nomImplementation() + " ======");
        
        System.out.println("Ajout de John Doe dans l'annuaire");
        annuaire.ajoutPersonne("Doe", "John", "01 04 03 05 03");

        System.out.println("Ajout de Bob Levinsky dans l'annuaire");
        annuaire.ajoutPersonne("Levinsky", "Bob", "01 22 33 44 55");

        System.out.println("Il y a " + annuaire.taille() + " nom dans l'annuaire");

        System.out.println("Ajout de Richard Zord dans l'annuaire");
        annuaire.ajoutPersonne("Zord", "Roberd", "01 22 44 66 77");

        Collection<String> téléphones = annuaire.tousLesNuméros();

        System.out.println("+--------------------+--------------------+--------------------+");
        for(String téléphone : téléphones) {
            String nom = annuaire.nomAssociéAuTéléphone(téléphone);
            String prénom = annuaire.prenomAssociéAuTéléphone(téléphone);
            System.out.format("+ %18s + %18s + %18s +%n", téléphone, nom, prénom);
        }
        System.out.println("+--------------------+--------------------+--------------------+");

        System.out.println("Numéro de téléphone de John Doe : "+annuaire.telephone("Doe", "John"));

        System.out.println("Suppression de John Doe");
        annuaire.suppressionPersonne("Doe", "John");

        System.out.println("Numéro de téléphone de John Doe : "+annuaire.telephone("Doe", "John"));




    }


}
