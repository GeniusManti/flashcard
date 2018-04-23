package flashcard.web.repositories;

import flashcard.application.domain.User;
import flashcard.web.DTO.response.UserResponseDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> readById(long id);
    Optional<User> readByNick(String nick);

}
