package buddyguide.service.impl;

import buddyguide.model.User;
import buddyguide.repository.IUserRepository;
import buddyguide.service.IUserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@NoArgsConstructor
@Service("userService")
public class UserService implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public User getUserByID(long id) {
        return userRepository.getById(id);
    }
}
