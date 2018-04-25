package flashcard.web.mappers;

import flashcard.application.domain.User;
import flashcard.application.domain.enums.Role;
import flashcard.web.DTO.request.UserRequestDTO;
import flashcard.web.DTO.response.UserResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User mapFromRequestDTO(UserRequestDTO userRequestDTO) {
        return User.builder()
                .nick(userRequestDTO.getNick())
                .email(userRequestDTO.getEmail())
                .password(userRequestDTO.getPassword())
                .phoneNumber(userRequestDTO.getPhoneNumber())
                .role(Role.USER)
                .banned(false)
                .build();
    }

    @Override
    public UserResponseDTO mapToResponseDTO(User createdUser) {
        return UserResponseDTO.builder()
                .id(createdUser.getId())
                .nick(createdUser.getNick())
                .email(createdUser.getEmail())
                .password(createdUser.getPassword())
                .phoneNumber(createdUser.getPhoneNumber())
                .role(createdUser.getRole().toString())
                .build();
    }
}
