package buddyguide.repository;

import buddyguide.model.Guide;
import buddyguide.model.Reservation;
import buddyguide.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IReservationRepository extends JpaRepository<Reservation, Long> {

    @Query("SELECT r FROM reservation r WHERE r.guide.id = :guide_id")
    Reservation getReservationByGuide(@Param("guide_id") long guideId);

    Reservation getReservationByGuideAndUser(Guide guide, User user);
}