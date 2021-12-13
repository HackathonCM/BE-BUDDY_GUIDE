package buddyguide.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto extends BaseDto {

    private String firstName;

    private String lastName;

    private String telephone;

    private String email;
}
