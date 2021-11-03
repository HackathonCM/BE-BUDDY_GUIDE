package buddyguide.service.impl;

import buddyguide.model.Account;
import buddyguide.repository.IAccountRepository;
import buddyguide.service.IAccountService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@NoArgsConstructor
@Service("accountService")
public class AccountService implements IAccountService {

    @Autowired
    private IAccountRepository accountRepository;

    @Override
    public Account getAccountByUsernameAndPassword(String username, String password) {

        return accountRepository.findAccountByUsernameAndPassword(username, password);
    }
}
