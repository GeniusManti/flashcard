package flashcard.web.services.user;

import flashcard.web.DTO.request.UserRequestDTO;
import flashcard.web.DTO.response.UserResponseDTO;

public interface UserService {

    UserResponseDTO registerUser(UserRequestDTO userRequestDTO);
    UserResponseDTO readUserById(long id);
    UserResponseDTO readUserByNick(String nick);
    void deleteUser(long id);
    void deleteAllUser();
}
