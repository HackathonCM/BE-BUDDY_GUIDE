package buddyguide.converter;

import buddyguide.model.User;
import buddyguide.model.dto.UserDto;
import org.springframework.stereotype.Component;

@Component("userConverter")
public class UserConverter implements IConverter<User, UserDto> {

    @Override
    public UserDto convertModelToDto(User user) {
        var userDto = new UserDto();

        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setTelephone(user.getTelephone());
        userDto.setEmail(user.getEmail());
        userDto.setType(userDto.getType());

        return userDto;
    }
}
