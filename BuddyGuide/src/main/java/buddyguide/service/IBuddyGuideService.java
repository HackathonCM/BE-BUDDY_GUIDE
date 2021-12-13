package buddyguide.service;

import buddyguide.model.Guide;
import buddyguide.model.User;

public interface IBuddyGuideService {

    void login(String username, String password) throws Exception;

    void makeReservation(Guide guide, User user);
}
