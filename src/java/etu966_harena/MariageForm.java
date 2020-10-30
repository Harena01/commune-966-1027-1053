package etu966_harena;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class MariageForm {
    private static String champ_nom = "nom";
    private static String champ_prenom = "prenom";
    private static String champ_Sexe = "sexe";
    private Map<String, String> erreur = new HashMap<String, String>();
    private static String resultat;

    public static String getChamp_nom() {
        return champ_nom;
    }

    public Map<String, String> getErreur() {
        return erreur;
    }

    private void setErreur( String champ, String message ) {
        erreur.put( champ, message );
    }

    public static String getResultat() {
        return resultat;
    }

    public static void setResultat(String resultat) {
        MariageForm.resultat = resultat;
    }


    public static String getChamp_Sexe() {
        return champ_Sexe;
    }

    public static void setChamp_Sexe(String champ_Sexe) {
        MariageForm.champ_Sexe = champ_Sexe;
    }

    public static String getChamp_prenom() {
        return champ_prenom;
    }

    public static void setChamp_prenom(String champ_prenom) {
        MariageForm.champ_prenom = champ_prenom;
    }

    public static void setChamp_nom(String champ_nom) {
        MariageForm.champ_nom = champ_nom;
    }

    private void validationNom( String nom ) throws Exception {
        if ( nom != null && nom.length() < 3 ) {
            throw new Exception( "Le nom doit contenir au moins 3 caractères." );
        }
    }

    private void validationPrenom( String prenom ) throws Exception {
        if ( prenom != null && prenom.length() < 3 ) {
            throw new Exception( "Le prenom doit contenir au moins 3 caractères." );
        }
    }
    
    private static String getValeurChamp( HttpServletRequest request, String nomChamp ) {
        String valeur = request.getParameter( nomChamp );
        if ( valeur == null || valeur.trim().length() == 0 ) {
            return null;
        } else {
            return valeur.trim();
        }
    }

    public Mariage inscrireMariage(HttpServletRequest request) {
        String nom = getValeurChamp(request, champ_nom);
        String prenom = getValeurChamp(request, champ_prenom);
        String sexe = getValeurChamp(request, champ_Sexe);


        Mariage utilisateur = new Mariage();
        utilisateur.setSexe(sexe);

        try {
            validationNom(nom);
        } catch (Exception e) {
            setErreur(champ_nom, e.getMessage());
        }
        utilisateur.setNom(nom);

        try {
            validationPrenom(prenom);
        } catch (Exception e) {
            setErreur(champ_prenom, e.getMessage());
        }
        utilisateur.setPrenom(nom);

        if (erreur.isEmpty()) {
        setResultat("Succès de l'inscription.");
        } else {
            setResultat("Échec de l'inscription.");
        }   
    
        return utilisateur;
    }
}
