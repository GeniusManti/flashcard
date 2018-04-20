package flashcard.web.services;

import flashcard.web.DTO.response.UserResponseDTO;
import org.springframework.http.ResponseEntity;

public interface UserService {
    UserResponseDTO readUser(long id);
    UserResponseDTO deleteUser(long id);
    UserResponseDTO readUserByNick(String nick);
}