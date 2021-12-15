package buddyguide.service;

import buddyguide.model.BaseEntity;

public interface IBuddyGuideService {

    BaseEntity<Long> login(String username, String password) throws Exception;

    void makeReservation(long guideId, long userId);
}
