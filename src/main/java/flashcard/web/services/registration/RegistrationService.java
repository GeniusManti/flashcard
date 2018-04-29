package flashcard.web.services.registration;

import flashcard.web.DTO.request.UserRequestDTO;

public interface RegistrationService {
    void register(UserRequestDTO userRequestDTO);
}
