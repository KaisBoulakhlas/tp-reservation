package montp.data.dao;

import montp.data.model.resource.Reservation;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class ReservationDAO extends GenericDAO<Reservation>  {
    public ReservationDAO() {
        super(Reservation.class);
    }

    @SuppressWarnings("unchecked")
    public List<Reservation> getReservations() {
        return em.createQuery("SELECT r FROM Reservation r")
                .getResultList();
    }
}
