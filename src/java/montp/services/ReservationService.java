package montp.services;

import montp.data.dao.ReservationDAO;
import montp.data.dao.ResourceDAO;
import montp.data.model.resource.Person;
import montp.data.model.resource.Reservation;
import montp.data.model.resource.Resource;
import montp.data.model.resource.ResourceType;
import montp.web.UserSession;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@ApplicationScoped
public class ReservationService extends GenericService<Reservation, ReservationDAO>{

    public List<Reservation> getReservations() {
        return dao.getReservations();
    }

    @Transactional
    public void insert(Reservation reservation) {
        reservation.setDateDebut(reservation.getDateDebut());
        reservation.setDateFin(reservation.getDateFin());
        reservation.setPersonne(reservation.getPersonne());
        reservation.setPartageable(reservation.getPartageable());
        reservation.setRessource(reservation.getRessource());
        super.insert(reservation);
    }

    public void delete(Reservation reservation) {
        dao.delete(reservation);
    }

}
