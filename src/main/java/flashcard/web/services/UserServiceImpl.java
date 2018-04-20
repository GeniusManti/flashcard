package flashcard.web.services;

import flashcard.web.DTO.UserResponseDTO;
import org.apache.catalina.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public UserResponseDTO readUser(long id) {
        return null;
    }

    @Override
    public UserResponseDTO deleteUser(long id) {
        return null;
    }

    @Override
    public UserResponseDTO readUserByNick(String nick) {
        return null;
    }
}
