package my.test;

import java.util.Collection;

public interface MonAnnuaire {
    void ajoutPersonne(final String nom, final String prénom, final String téléphone);
    int taille();
    boolean suppressionPersonne(final String nom, final String prénom);
    String telephone(final String nom, final String prénom);
    Collection<String> tousLesNuméros();

    String nomAssociéAuTéléphone(String téléphone);
    String prenomAssociéAuTéléphone(final String téléphone);
}
