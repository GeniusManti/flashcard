package flashcard.web.domain;

import flashcard.web.domain.enums.Role;
import lombok.*;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = "USERS")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "USERS_ID")
    private long id;

    @Column(unique = true)
    @NotBlank
    private String nick;

    @Column(unique = true)
    @NotBlank
    private String email;

    private String phoneNumber;

    @Size(min = 6, max = 16)
    private String password;

    private boolean banned;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {

        return Objects.hash(email);
    }
}


