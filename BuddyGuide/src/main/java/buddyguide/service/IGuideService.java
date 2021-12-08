package buddyguide.service;

import buddyguide.model.Guide;
import buddyguide.model.TourCategory;

import java.util.List;

public interface IGuideService {

    Guide getGuideByID(Long Id);

    List<Guide> getAllGuides();

    List<Guide> getGuidesForGivenCategory(TourCategory category);
}
