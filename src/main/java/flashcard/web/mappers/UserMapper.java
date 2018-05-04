package flashcard.web.mappers;

import flashcard.web.domain.User;
import flashcard.web.DTO.request.UserRequestDTO;
import flashcard.web.DTO.response.UserResponseDTO;

public interface UserMapper {

    User mapFromRequestDTO(UserRequestDTO userRequestDTO);

    UserResponseDTO mapToResponseDTO(User createdUser);

}
