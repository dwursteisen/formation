package com.github.dwursteisen.mockito;

/**
 * User: Wursteisen David
 * Date: 06/12/11
 * Time: 21:42
 */
public class Adresse {
    
    private final String adresse;
    private final String personne;
    
    public Adresse(String personne, String adr) {
        this.adresse = adr;
        this.personne = personne;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getPersonne() {
        return personne;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Adresse adresse1 = (Adresse) o;

        if (adresse != null ? !adresse.equals(adresse1.adresse) : adresse1.adresse != null) return false;
        if (personne != null ? !personne.equals(adresse1.personne) : adresse1.personne != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = adresse != null ? adresse.hashCode() : 0;
        result = 31 * result + (personne != null ? personne.hashCode() : 0);
        return result;
    }
}
