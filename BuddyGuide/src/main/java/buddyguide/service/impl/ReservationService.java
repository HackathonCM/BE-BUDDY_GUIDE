package buddyguide.service.impl;

import buddyguide.model.Reservation;
import buddyguide.repository.IReservationRepository;
import buddyguide.service.IReservationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service("reservationService")
public class ReservationService implements IReservationService {

    @Autowired
    private IReservationRepository reservationRepository;

    @Override
    public Reservation getReservationByGuideId(long guideId) {
        return reservationRepository.getReservationByGuide(guideId);
    }

    @Override
    public void addReservation(Reservation reservation) {
        reservationRepository.save(reservation);
        reservation.getGuide().setAvailable(false);
    }

    @Override
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }
}