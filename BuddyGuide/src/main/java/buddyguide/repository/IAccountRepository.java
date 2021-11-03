package buddyguide.repository;

import buddyguide.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAccountRepository extends JpaRepository<Account, Long> {

    Account findAccountByUsernameAndPassword(String username, String password);
}
