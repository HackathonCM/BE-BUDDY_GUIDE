package buddyguide.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GuideDto extends BaseDto {

    private String firstName;
    private String lastName;
    private String telephone;
    private String email;
    private boolean available;

}
