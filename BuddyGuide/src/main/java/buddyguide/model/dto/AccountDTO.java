package buddyguide.model.dto;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class AccountDTO {
    @NonNull
    private String username;

    @NonNull
    private String password;
}
