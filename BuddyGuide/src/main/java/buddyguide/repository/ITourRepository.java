package buddyguide.repository;

import buddyguide.model.Tour;
import buddyguide.model.TourCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ITourRepository extends JpaRepository<Tour, Long> {

    List<Tour> getTourByTourCategory(TourCategory tourCategory);
}
