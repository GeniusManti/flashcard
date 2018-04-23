package flashcard.web.mappers;

import flashcard.application.domain.User;
import flashcard.web.DTO.request.CreateUserRequestDTO;
import flashcard.web.DTO.response.UserResponseDTO;

public interface UserMapper {

    User mapFromRequestDTO(CreateUserRequestDTO userRequestDTO);

    UserResponseDTO mapToResponseDTO(User createdUser);

}
