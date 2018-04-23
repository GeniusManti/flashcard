package flashcard.web.DTO.response;

import flashcard.application.domain.enums.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
public class UserResponseDTO {

    private long id;
    private String nick;
    private String email;
    private String phoneNumber;
    private String password;

}
