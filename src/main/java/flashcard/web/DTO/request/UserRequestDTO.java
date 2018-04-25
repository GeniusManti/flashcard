package flashcard.web.DTO.request;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
public class UserRequestDTO {

    @NotBlank
    @Pattern(regexp = "^[A-ZĄĆĘŁŃÓŚŹŻa-zzżźćńółęąś0-9]{3,30}$", message = "validation.registration.nick.pattern")
    private String nick;

    @NotBlank
    @Pattern(regexp = "(^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.+[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@+(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$)",
            message = "validation.registration.email.pattern")
    private String email;

    @NotNull
    @Pattern(regexp = "^$|^[0-9]{9,11}$", message = "validation.registration.phoneNumber.pattern")
    private String phoneNumber;

    @NotBlank
    @Size(min = 6, max = 16, message = "validation.registration.password.pattern")
    private String password;

    @Builder
    public UserRequestDTO(String nick, String email, String phoneNumber, String password) {
        this.nick = nick;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }
}
