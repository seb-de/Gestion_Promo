package p1;

import java.time.LocalDate;

public class Alternant extends Apprenant {
    protected String nomEntreprise;
    protected double salaire;

    // Constructeur
    public Alternant( String nomEntreprise, double salaire, String nom, String prenom, LocalDate dateInscription,
            String contact1, String contact2,
            Promotion promo ) {
        super( nom, prenom, dateInscription, contact1, contact2, promo );
        this.nomEntreprise = nomEntreprise;
        this.salaire = salaire;

    }

    public void afficherApprenant() {
        System.out.println( getClass().getSimpleName() + " : " + nom + " " + prenom + ", contact : " + contact1
                + " ou " + contact2 + ", date d'inscription : " + dateInscription + ", Promotion : "
                + promo.nom +
                ", Nom de l'entreprise : " + nomEntreprise + ", Salaire : "
                + salaire + "€" );
    }

    @Override
    public String toString() {
        return "\nAlternant [nom entreprise : " + nomEntreprise + ", salaire : " + salaire + "€, nom : " + nom
                + ", prénom : "
                + prenom + ", date inscription : " + dateInscription + ", contact1 : " + contact1 + ", contact2 : "
                + contact2
                + ", promo : " + promo.nom + ", liste absence : " + journeeAbsence + ", retards : "
                + sommeRetard.toMinutes()
                + " minutes, absences : " + nbAbsences + " jours ]";
    }

}
