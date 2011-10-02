package my.test.implementation;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import my.test.MonAnnuaire;

public class DavidWImpl implements MonAnnuaire {

	private Map<String, String> internal = new HashMap<String, String>();
	
	@Override
	public void ajoutPersonne(String nom, String prénom, String téléphone) {
		internal.put(téléphone, nom + File.pathSeparator + prénom);
	}

	@Override
	public int taille() {
		return internal.size();
	}

	@Override
	public boolean suppressionPersonne(String nom, String prénom) {
		String téléphone = telephone(nom, prénom);
		return internal.remove(téléphone) != null;
	}

	@Override
	public String telephone(String nom, String prénom) {
		String value = nom + File.pathSeparator + prénom;
		for(Entry<String, String> entry : internal.entrySet()) {
			if(entry.getValue().equals(value)) {
				return entry.getKey();
			}
		}
		return null;
	}

	@Override
	public Collection<String> tousLesNuméros() {
		return new ArrayList<String>(internal.keySet());
	}

	@Override
	public String nomAssociéAuTéléphone(String téléphone) {
		return internal.get(téléphone).split(File.pathSeparator)[0];
	}

	@Override
	public String prenomAssociéAuTéléphone(String téléphone) {
		return internal.get(téléphone).split(File.pathSeparator)[1];
	}

	@Override
	public String nomImplementation() {
		return "DavidWImpl";
	}

}
