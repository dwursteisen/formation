package my.test;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.List;

public class MonProgramme {

    public static void main(final String[] args) {
        MonAnnuaire annuaire = constructionAnnuaire();

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


    public static MonAnnuaire constructionAnnuaire() {
    	List<MonAnnuaire> annuaires = new ArrayList<MonAnnuaire>();
        try {
            Class[] classes = getClasses("my.test.implementation");
            for (Class c : classes) {

                if(MonAnnuaire.class.isAssignableFrom(c)) {
                    annuaires.add( (MonAnnuaire) c.newInstance());
                }
            }
            
            int taille = annuaires.size();
            long indexAlleatoire = Math.round(Math.random() * (taille -1));
            return annuaires.get((int)indexAlleatoire);
        } catch (Exception ex) {
            System.err.println("Erreur dans la recupération des classes");
            ex.printStackTrace();
        }
        return null;
    }

      /**
     * Scans all classes accessible from the context class loader which belong to the given package and subpackages.
     *
     * @param packageName The base package
     * @return The classes
     * @throws ClassNotFoundException
     * @throws IOException
     */
    private static Class[] getClasses(String packageName)
            throws ClassNotFoundException, IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        assert classLoader != null;
        String path = packageName.replace('.', '/');
        Enumeration<URL> resources = classLoader.getResources(path);
        List<File> dirs = new ArrayList<File>();
        while (resources.hasMoreElements()) {
            URL resource = resources.nextElement();
            try {
                dirs.add(new File(resource.toURI()));
            } catch (URISyntaxException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }
        ArrayList<Class> classes = new ArrayList<Class>();
        for (File directory : dirs) {
            classes.addAll(findClasses(directory, packageName));
        }
        return classes.toArray(new Class[classes.size()]);
    }

    /**
     * Recursive method used to find all classes in a given directory and subdirs.
     *
     * @param directory   The base directory
     * @param packageName The package name for classes found inside the base directory
     * @return The classes
     * @throws ClassNotFoundException
     */
    private static List<Class> findClasses(File directory, String packageName) throws ClassNotFoundException {
        List<Class> classes = new ArrayList<Class>();
        if (!directory.exists()) {
            return classes;
        }
        File[] files = directory.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                assert !file.getName().contains(".");
                classes.addAll(findClasses(file, packageName + "." + file.getName()));
            } else if (file.getName().endsWith(".class")) {
                classes.add(Class.forName(packageName + '.' + file.getName().substring(0, file.getName().length() - 6)));
            }
        }
        return classes;
    }
}
