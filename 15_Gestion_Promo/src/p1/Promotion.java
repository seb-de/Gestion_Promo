package p1;

import java.time.Duration;
import java.util.ArrayList;

public class Promotion {
    protected static ArrayList<Apprenant> listeComplete = new ArrayList<Apprenant>();
    protected ArrayList<Apprenant>        liste;
    protected String                      nom;
    protected Duration                    duree;
    protected Duration                    dureeEffectuee;

    // Constructeur de Promotion
    public Promotion( String nom, Duration duree, Duration dureeEffectuee ) {
        liste = new ArrayList<Apprenant>();
        this.nom = nom;
        this.duree = duree;
        this.dureeEffectuee = dureeEffectuee;
    }

    // Méthode qui liste les détails d'une promo, incluant ses apprenants
    public void getApprenants() {
        System.out.println( "Promotion : " + nom + ", durée de formation: " + duree.toDays()
                + " jours, durée déjà effectuée : " + dureeEffectuee.toDays() + " jours, liste des apprenants :" );
        System.out.println( liste );
    }

    // getter et setter de dureeEffectuee
    public Duration getDureeEffectuee() {
        return dureeEffectuee;
    }

    public void setDureeEffectuee( Duration dureeEffectuee ) {
        this.dureeEffectuee = dureeEffectuee;
    }

}
