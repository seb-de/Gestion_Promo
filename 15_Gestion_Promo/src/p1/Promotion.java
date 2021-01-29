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

    // M�thode qui liste les d�tails d'une promo, incluant ses apprenants
    public void getApprenants() {
        System.out.println( "Promotion : " + nom + ", dur�e de formation: " + duree.toDays()
                + " jours, dur�e d�j� effectu�e : " + dureeEffectuee.toDays() + " jours, liste des apprenants :" );
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
