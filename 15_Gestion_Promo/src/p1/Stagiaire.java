package p1;

import java.time.LocalDate;

public class Stagiaire extends Apprenant {
    protected String typeAllocation;
    protected double montantAllocation;

    // Constructeur
    public Stagiaire( String typeAllocation, double montantAllocation, String nom, String prenom,
            LocalDate dateInscription,
            String contact1, String contact2,
            Promotion promo ) {
        super( nom, prenom, dateInscription, contact1, contact2, promo );
        this.typeAllocation = typeAllocation;
        this.montantAllocation = montantAllocation;
    }

    public void afficherApprenant() {
        System.out.println( getClass().getSimpleName() + " : " + nom + " " + prenom + ", contact : " + contact1
                + " ou " + contact2 + ", date d'inscription : " + dateInscription + ", Promotion : "
                + promo.nom + ", Type d'Allocation : " + typeAllocation + ", montant : "
                + montantAllocation + "€" );
    }

    @Override
    public String toString() {
        return "\nStagiaire [type allocation : " + typeAllocation + ", montant allocation : " + montantAllocation
                + "€, nom : "
                + nom + ", prénom : " + prenom + ", date inscription : " + dateInscription + ", contact1 : " + contact1
                + ", contact2 : " + contact2 + ", promotion : " + promo.nom + ", liste absence : " + journeeAbsence
                + ", retards : " + sommeRetard.toMinutes() + " minutes, absences : " + nbAbsences + " jours ]";
    }

}
