package buddyguide.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GuideDto extends BaseDto {

    private String firstName;
    private String lastName;
    private String telephone;
    private String email;
    private String type;
    private List<String> categories;
    private boolean available;
    private String price;
}
