package buddyguide.service;

import buddyguide.model.Reservation;

import java.util.List;

public interface IReservationService {

    Reservation getReservationByGuideId(long guideId);

    void addReservation(Reservation reservation);

    List<Reservation> getAllReservations();
}
