package my.test.implementation;

import my.test.MonAnnuaire;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class MonImplementationDeBase implements MonAnnuaire {

    private Map<Personne, String> dictionnaire = new HashMap<Personne, String>();

    public void ajoutPersonne(String nom, String prenom, String telephone) {
        dictionnaire.put(new Personne(nom, prenom), telephone);
    }

    public int taille() {
        return dictionnaire.size();
    }

    public boolean suppressionPersonne(String nom, String prenom) {
        return dictionnaire.remove(new Personne(nom, prenom)) != null;
    }

    public String telephone(String nom, String prenom) {
        return dictionnaire.get(new Personne(nom, prenom));
    }

    public Collection<String> tousLesNuméros() {
        return new HashSet<String>(dictionnaire.values());
    }

    public String nomAssociéAuTéléphone(String téléphone) {
        return trouvePersonne(téléphone).nom;
    }

    public String prenomAssociéAuTéléphone(String téléphone) {
        return trouvePersonne(téléphone).prenom;
    }

    private Personne trouvePersonne(final String téléphone) {
        for (Map.Entry<Personne, String> entry : dictionnaire.entrySet()) {
            if (téléphone.equals(entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }

    private class Personne {
        final private String nom;
        final private String prenom;

        private Personne(String nom, String prenom) {
            this.nom = nom;
            this.prenom = prenom;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Personne personne = (Personne) o;

            if (nom != null ? !nom.equals(personne.nom) : personne.nom != null) return false;
            if (prenom != null ? !prenom.equals(personne.prenom) : personne.prenom != null) return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = nom != null ? nom.hashCode() : 0;
            result = 31 * result + (prenom != null ? prenom.hashCode() : 0);
            return result;
        }
    }
}
