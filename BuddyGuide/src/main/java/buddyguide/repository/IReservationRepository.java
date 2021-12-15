package buddyguide.repository;

import buddyguide.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IReservationRepository extends JpaRepository<Reservation, Long> {

    Reservation getReservationByGuide(long guide_id);
}