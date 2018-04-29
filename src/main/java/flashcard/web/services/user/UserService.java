package flashcard.web.services.user;

import flashcard.web.DTO.response.UserResponseDTO;

public interface UserService {
    UserResponseDTO readUserById(long id);
    void deleteUser(long id);
    void deleteAllUser();
    UserResponseDTO readUserByNick(String nick);
}
