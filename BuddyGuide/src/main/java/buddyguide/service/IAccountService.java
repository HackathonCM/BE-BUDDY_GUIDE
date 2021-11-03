package buddyguide.service;

import buddyguide.model.Account;

public interface IAccountService {

    Account getAccountByUsernameAndPassword(String username, String password);
}
