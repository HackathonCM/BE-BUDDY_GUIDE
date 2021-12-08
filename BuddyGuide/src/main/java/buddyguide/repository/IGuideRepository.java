package buddyguide.repository;

import buddyguide.model.Guide;
import buddyguide.model.TourCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IGuideRepository extends JpaRepository<Guide, Long> {
    List<Guide> findAllByCategoriesContaining(TourCategory tourCategory);
}
