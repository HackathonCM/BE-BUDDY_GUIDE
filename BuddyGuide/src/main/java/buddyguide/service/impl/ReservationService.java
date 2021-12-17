package buddyguide.service.impl;

import buddyguide.model.Reservation;
import buddyguide.repository.IGuideRepository;
import buddyguide.repository.IReservationRepository;
import buddyguide.service.IReservationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service("reservationService")
public class ReservationService implements IReservationService {

    @Autowired
    private IReservationRepository reservationRepository;

    @Autowired
    private IGuideRepository guideRepository;

    @Override
    public Reservation getReservationByGuideId(long guideId) {
        return reservationRepository.getReservationByGuide(guideId);
    }

    @Override
    public void addReservation(Reservation reservation) {
        reservation.getGuide().setAvailable(false);
        reservationRepository.save(reservation);
    }
}