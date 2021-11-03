package buddyguide.repository;

import buddyguide.model.Guide;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGuideRepository extends JpaRepository<Guide, Long> {
}
