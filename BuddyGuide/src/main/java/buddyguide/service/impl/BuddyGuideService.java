package buddyguide.service.impl;

import buddyguide.model.*;
import buddyguide.service.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@Component
public class BuddyGuideService implements IBuddyGuideService {

    @Autowired
    private IUserService userService;

    @Autowired
    private IGuideService guideService;

    @Autowired
    private IAccountService accountService;

    @Autowired
    private IReservationService reservationService;

    @Override
    public void login(String username, String password) throws Exception {
        Account account = accountService.getAccountByUsernameAndPassword(username, password);
        if (account == null) {
            throw new Exception("This account does not exist!");
        } else {
            AccountType accountType = account.getAccountType();
            if (accountType == AccountType.GUIDE) {
                Guide guide = guideService.getGuideByID(account.getAccountOwnerID());
                System.out.println(guide);
            } else {
                User user = userService.getUserByID(account.getAccountOwnerID());
                System.out.println(user);
            }
        }
    }

    @Override
    public void makeReservation(Guide guide, User user) {
        reservationService.addReservation(new Reservation(guide, user));
    }
}
