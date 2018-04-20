package flashcard.application.domain;

import flashcard.application.domain.enums.Role;
import lombok.*;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class User {

    private long id;
    private String nick;
    private String email;
    private String phoneNumber;
    private String password;
    private boolean banned;
    private Role role;
}
