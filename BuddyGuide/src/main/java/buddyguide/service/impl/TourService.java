package buddyguide.service.impl;

import buddyguide.model.Tour;
import buddyguide.model.TourCategory;
import buddyguide.repository.ITourRepository;
import buddyguide.service.ITourService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Service("tourService")
public class TourService implements ITourService {

    @Autowired
    private ITourRepository tourRepository;

    @Override
    public List<Tour> getToursByCategory(TourCategory tourCategory) {
        return tourRepository.getTourByTourCategory(tourCategory);
    }
}
