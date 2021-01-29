package p1;

import java.time.Duration;
import java.time.LocalDate;

public interface MethodeApprenant {
    public void afficherApprenant();

    public void addRetard( Duration d );

    public void addAbsence( LocalDate l );

    public boolean bcpRetard();

    public boolean tresAbsent();

    public void verifierRetard();

    public void verifierAbsence();

}
