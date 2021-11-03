package buddyguide.service.impl;

import buddyguide.model.Guide;
import buddyguide.repository.IGuideRepository;
import buddyguide.service.IGuideService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@NoArgsConstructor
@Service("guideService")
public class GuideService implements IGuideService {

    @Autowired
    private IGuideRepository guideRepository;

    @Override
    public Guide getGuideByID(Long Id) {
        return guideRepository.getById(Id);
    }
}
