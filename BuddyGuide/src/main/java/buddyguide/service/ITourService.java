package buddyguide.service;

import buddyguide.model.Tour;
import buddyguide.model.TourCategory;

import java.util.List;

public interface ITourService {

    List<Tour> getToursByCategory(TourCategory tourCategory);
}
