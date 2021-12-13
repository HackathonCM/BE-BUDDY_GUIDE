package buddyguide.service.impl;

import buddyguide.model.*;
import buddyguide.service.IAccountService;
import buddyguide.service.IBuddyGuideService;
import buddyguide.service.IGuideService;
import buddyguide.service.IUserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

@AllArgsConstructor
@NoArgsConstructor
@Component
@CrossOrigin("http://localhost:3000")
public class BuddyGuideService implements IBuddyGuideService {

    @Autowired
    private IUserService userService;

    @Autowired
    private IGuideService guideService;

    @Autowired
    private IAccountService accountService;

    @Override
    public BaseEntity<Long> login(String username, String password) throws Exception {
        Account account = accountService.getAccountByUsernameAndPassword(username, password);
        if (account == null) {
            throw new Exception("This account does not exist!");
        } else {
            AccountType accountType = account.getAccountType();
            if (accountType == AccountType.GUIDE) {
                Guide guide = guideService.getGuideByID(account.getAccountOwnerID());
                return guide;
            } else {
                User user = userService.getUserByID(account.getAccountOwnerID());
                return user;
            }
        }
    }
}
