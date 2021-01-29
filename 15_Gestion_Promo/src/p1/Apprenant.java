package p1;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;

public class Apprenant implements MethodeApprenant {
    protected String               nom;
    protected String               prenom;
    protected LocalDate            dateInscription;
    protected String               contact1;
    protected String               contact2;
    protected Promotion            promo;
    protected ArrayList<LocalDate> journeeAbsence;
    protected Duration             sommeRetard;
    protected int                  nbAbsences;

    // Constructeur
    public Apprenant( String nom, String prenom, LocalDate dateInscription, String contact1, String contact2,
            Promotion promo ) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateInscription = dateInscription;
        this.contact1 = contact1;
        this.contact2 = contact2;
        this.promo = promo;
        journeeAbsence = new ArrayList<LocalDate>();
        sommeRetard = Duration.ofMinutes( 0 );
        nbAbsences = 0;
    }

    // Méthode qui permet d'ajouter une durée de retard à un apprenant
    public void addRetard( Duration d ) {
        sommeRetard = sommeRetard.plus( d );
    }

    // Méthode qui permet d'ajouter une date d'absence à un apprenant
    public void addAbsence( LocalDate d ) {
        journeeAbsence.add( d );
        nbAbsences++;
    }

    /*
     * Méthode qui permet d'afficher tout les détails d'un apprenant
     */
    public void afficherApprenant() {
        System.out.println( getClass().getSimpleName() + " : " + nom + " " + prenom + ", contact : " + contact1
                + " ou " + contact2 + ", date d'inscription : " + dateInscription + ", Promotion : "
                + promo.nom );
    }

    // Retourne true si l'apprenant a plus de 30 minutes de retard
    public boolean bcpRetard() {
        if ( sommeRetard.toMinutes() > Duration.ofMinutes( 30 ).toMinutes() ) {
            return true;
        } else
            return false;

    }

    // On affiche le retard d' un apprenant, avec une alerte en plus si il as
    // plus de 30 minutes de retard
    public void verifierRetard() {
        if ( bcpRetard() ) {
            System.out.println( "ALERTE " + nom + " A TROP DE RETARDS (+ de 30 minutes)" );
        }
        System.out.println( "Somme des retards de " + nom + " : " + sommeRetard.toMinutes() + " minutes" );
    }

    // Retourne true si l'apprenant a plus de 10% de temps d'absence
    public boolean tresAbsent() {
        if ( nbAbsences > ( promo.duree.toDays() / 10 ) ) {
            return true;
        } else
            return false;
    }

    // On affiche les absences d' un apprenant, avec une alerte en plus si il as
    // plus de 10% de temps d'absence
    public void verifierAbsence() {
        if ( tresAbsent() ) {
            System.out.println( "ALERTE " + nom + " A TROP D' ABSENCES (+ de 10% du temps de formation)" );
        }

        System.out.println(
                "Nombre de jours d'absence : " + nbAbsences + "\nJours d'absence : " + journeeAbsence );

    }

    // On vérifie parmi tout les apprenants qui as plus de 30 minutes de retard
    // ou plus de 10% d'absence
    public static void leverAlerte() {
        for ( Apprenant app : Promotion.listeComplete ) {
            if ( app.tresAbsent() || app.bcpRetard() ) {
                System.out.println( app );
            }
        }
    }

    @Override
    public String toString() {
        return "\nApprenant [nom=" + nom + ", prenom=" + prenom + ", dateInscription=" + dateInscription + ", contact1="
                + contact1 + ", contact2=" + contact2 + ", promo=" + promo + ", journeeAbsence=" + journeeAbsence
                + ", sommeRetard=" + sommeRetard + ", nbAbsences=" + nbAbsences + "]";
    }

    public static void main( String[] args ) {
        // Génération de mes promotions et de mes apprenants :

        Promotion java = new Promotion( "java", Duration.ofDays( 90 ), Duration.ofDays( 0 ) );
        Promotion php = new Promotion( "php", Duration.ofDays( 5 ), Duration.ofDays( 0 ) );
        Alternant seb = new Alternant( "adecco", 1000, "Massei", "Sebastien", LocalDate.of( 2020, 10, 21 ),
                "0635172441", "masseiseb@gmail.com", java );
        Alternant alex = new Alternant( "manpower", 1200, "Roussel", "Alexandre", LocalDate.of( 2020, 10, 19 ),
                "0615849678", "alex@gmail.com", java );
        Stagiaire albert = new Stagiaire( "pension", 300, "Francklin", "Albert", LocalDate.of( 2020, 12, 9 ),
                "0615854678", "albert@gmail.com", php );
        Stagiaire bruno = new Stagiaire( "AH", 500, "Lemaire", "bruno", LocalDate.of( 2020, 12, 11 ),
                "0618541135", "bruno@gmail.com", java );
        Stagiaire matthieu = new Stagiaire( "GBH", 150, "Bartolo", "Matthieu", LocalDate.of( 2020, 12, 10 ),
                "0687324952", "mat@gmail.com", php );
        java.liste.add( seb );
        java.liste.add( alex );
        java.liste.add( bruno );
        php.liste.add( albert );
        php.liste.add( matthieu );
        for ( Apprenant app : java.liste ) {
            Promotion.listeComplete.add( app );
        }
        for ( Apprenant app : php.liste ) {
            Promotion.listeComplete.add( app );
        }
        /*
         * Test des fonctionnalitées :
         */
        seb.addRetard( Duration.ofMinutes( 31 ) );
        albert.addAbsence( LocalDate.of( 2021, 1, 5 ) );
        albert.addAbsence( LocalDate.of( 2021, 1, 8 ) );

        seb.afficherApprenant();
        seb.verifierRetard();
        albert.verifierAbsence();
        java.getApprenants();
        leverAlerte();
        java.setDureeEffectuee( Duration.ofHours( 240 ) );
        Duration tempsRestant = java.duree.minus( java.getDureeEffectuee() );
        System.out.println( "Dans cette exemple il reste " + tempsRestant.toDays() + " jours" );

    }
}
