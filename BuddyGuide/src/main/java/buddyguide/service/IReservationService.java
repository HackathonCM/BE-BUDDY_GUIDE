package buddyguide.service;

import buddyguide.model.Reservation;

public interface IReservationService {

    Reservation getReservationByGuideId(long guideId);

    void addReservation(Reservation reservation);
}