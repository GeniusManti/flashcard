package flashcard.application.domain;

import flashcard.application.domain.enums.Role;
import lombok.*;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "Users")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder


public class User {

    @Id
    @GeneratedValue
    @Column(name = "USERS_ID")
    private long id;

    @Column(unique = true)
    private String nick;

    @Column(unique = true)
    @NotBlank
    private String email;

    private String phoneNumber;

    @Size(min = 60, max = 60)
    private String password;
    private boolean banned;

    @Enumerated(EnumType.STRING)
    private Role role;
}


