package my.test.implementation;

import my.test.MonAnnuaire;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class MonImplementationDeBase implements MonAnnuaire {



	@Override
	public String nomImplementation() {
		return "MonImplementationDeBase";
	}

    @Override
    public void ajoutPersonne(String nom, String prénom, String téléphone) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int taille() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean suppressionPersonne(String nom, String prénom) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String telephone(String nom, String prénom) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Collection<String> tousLesNuméros() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String nomAssociéAuTéléphone(String téléphone) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String prenomAssociéAuTéléphone(String téléphone) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
