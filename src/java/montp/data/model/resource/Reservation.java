package montp.data.model.resource;

import montp.data.model.GenericEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "RESERVATION")
public class Reservation extends GenericEntity {

    @ManyToOne()
    private Person personne;

    @ManyToOne()
    private Resource ressource;

    private Date dateDebut;

    private Date dateFin;

    private Integer nbpartageable;

    public Reservation(Person personne, Resource ressource, Date dateDebut, Date dateFin, Integer nbpartageable) {
        this.personne = personne;
        this.ressource = ressource;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.nbpartageable = nbpartageable;
    }

    public Reservation() {

    }

    public Person getPersonne() {
        return personne;
    }

    public void setPersonne(Person personne) {
        this.personne = personne;
    }

    public Resource getRessource() {
        return ressource;
    }

    public void setRessource(Resource ressource) {
        this.ressource = ressource;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Integer getPartageable() {
        return nbpartageable;
    }

    public void setPartageable(Integer nbpartageable) {
        this.nbpartageable = nbpartageable;
    }
}
