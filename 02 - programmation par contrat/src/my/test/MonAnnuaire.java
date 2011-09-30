package my.test;

import java.util.Collection;

public interface MonAnnuaire {
	
	/**
	 * La méthode ajout une personne dans l'annuaire.
	 * Si on ajoute cette personne dans l'annuaire, alors on doit être capable de pouvoir :
	 * - récupérer son téléphone via la méthode telephone @see {@link #telephone(String, String)}
	 * - récupérer son nom via la méthode nomAssociéAuTéléphone @see {@link #nomAssociéAuTéléphone(String)}
	 * - récuperer son prénom via la méthode prenomAssociéAuTéléphone @see {@link #prenomAssociéAuTéléphone(String)}
	 * 
	 * @param nom : nom de la personne à ajouter
	 * @param prénom : prénom de la personne à ajouter
	 * @param téléphone : numéro de téléphone du contact. (exemple : 01 23 43 23)
	 */
    void ajoutPersonne(final String nom, final String prénom, final String téléphone);
    
    /**
     * Retourne la taille de l'annuaire. Exemple : si j'ajoute 3 personnes, la taille doit être de 3
     * @return taille de l'annuaire
     */
    int taille();
    
    /**
     * Suppression de la personne dans l'annuaire. 
     * 
     * @param nom : nom de la personne à supprimer
     * @param prénom : prénom de la personne à supprimer
     * @return true si la suppression s'est correctement déroulé. false autrement 
     */
    boolean suppressionPersonne(final String nom, final String prénom);
    
    /**
     * Permet de récuperer le numéro de la personne voulu. La méthode se doit de retourner
     * null si aucun contact n'a été trouvé.
     * 
     * @param nom : nom de la personne à retrouver
     * @param prénom : prénom de la personne à retrouver
     * @return : numéro de téléphone du contact. null si le contact n'est pas trouvé dans l'annuaire
     */
    String telephone(final String nom, final String prénom);
    
    /**
     * Retourne la liste de tous les numéros présent dans l'annuaire
     * @return : l'ensemble des numéros de téléphone présent dans l'annuaire
     */
    Collection<String> tousLesNuméros();

    /**
     * récupère le nom d'un contact à partir de son numéro de téléphone
     * @param téléphone : téléphone du contact à retrouver
     * @return : nom du contact
     */
    String nomAssociéAuTéléphone(String téléphone);
    
    /**
     * récupère le prénom d'un contact à partir de son numéro de téléphone
     * @param téléphone : téléphone du contact à retrouver
     * @return : prénom du contact
     */
    String prenomAssociéAuTéléphone(final String téléphone);
}
