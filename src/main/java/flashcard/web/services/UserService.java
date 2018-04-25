package flashcard.web.services;

import flashcard.web.DTO.request.UserRequestDTO;
import flashcard.web.DTO.response.UserResponseDTO;

public interface UserService {
    UserResponseDTO createUser(UserRequestDTO userRequestDTO);
    UserResponseDTO readUserById(long id);
    void deleteUser(long id);
    void deleteAllUser();
    UserResponseDTO readUserByNick(String nick);
}
