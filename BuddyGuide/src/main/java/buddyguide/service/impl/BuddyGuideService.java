package buddyguide.service.impl;

import buddyguide.model.Account;
import buddyguide.model.AccountType;
import buddyguide.model.Guide;
import buddyguide.model.User;
import buddyguide.service.IAccountService;
import buddyguide.service.IBuddyGuideService;
import buddyguide.service.IGuideService;
import buddyguide.service.IUserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

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

    @Override
    public void login(String username, String password) throws Exception {
        Account account = accountService.getAccountByUsernameAndPassword(username, password);
        if (account == null) {
            System.out.println("Inexistent");
            throw new Exception("This account does not exist!");
        }
        else{
            AccountType accountType = account.getAccountType();
            if (accountType == AccountType.GUIDE){
                Guide guide = guideService.getGuideByID(account.getAccountOwnerID());
                System.out.println(guide);
            }
            else{
                User user = userService.getUserByID(account.getAccountOwnerID());
                System.out.println(user);
            }
        }
    }
}
