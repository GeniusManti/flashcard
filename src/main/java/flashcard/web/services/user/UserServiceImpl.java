package flashcard.web.services.user;

import flashcard.application.domain.User;
import flashcard.application.exceptions.ObjectNotFoundException;
import flashcard.web.DTO.request.UserRequestDTO;
import flashcard.web.DTO.response.UserResponseDTO;
import flashcard.web.mappers.UserMapper;
import flashcard.web.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserResponseDTO createUser(UserRequestDTO userRequestDTO) {
        User userToSave = userMapper.mapFromRequestDTO(userRequestDTO);

        User createdUser = userRepository.save(userToSave);

        return userMapper.mapToResponseDTO(createdUser);
    }

    @Override
    public UserResponseDTO readUserById(long id) {
        User foundUser = userRepository.readById(id)
                .orElseThrow(() -> new ObjectNotFoundException(User.class, id));

        return userMapper.mapToResponseDTO(foundUser);
    }

    @Override
    public UserResponseDTO readUserByNick(String nick) {
        User foundUser = userRepository.readByNick(nick)
                .orElseThrow(() -> new ObjectNotFoundException(User.class, "nick", nick));

        return userMapper.mapToResponseDTO(foundUser);
    }

    @Override
    public void deleteUser(long id) {
        userRepository.delete(id);
    }

    @Override
    public void deleteAllUser() {
        userRepository.deleteAll();
    }
}
