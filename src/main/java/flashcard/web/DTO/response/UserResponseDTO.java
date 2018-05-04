package flashcard.web.DTO.response;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UserResponseDTO {

    private long id;
    private String nick;
    private String email;
    private String phoneNumber;
    private String password;
    private String role;

}
