package flashcard.web.services;

import flashcard.web.DTO.request.CreateUserRequestDTO;
import flashcard.web.DTO.response.UserResponseDTO;
import org.springframework.http.ResponseEntity;

public interface UserService {
    UserResponseDTO createUser(CreateUserRequestDTO userRequestDTO);
    UserResponseDTO readUserById(long id);
    void deleteUser(long id);
    void deleteAllUser();
    UserResponseDTO readUserByNick(String nick);
}
