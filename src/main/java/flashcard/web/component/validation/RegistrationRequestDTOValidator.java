package flashcard.web.component.validation;

import flashcard.web.DTO.request.UserRequestDTO;
import flashcard.web.component.message.Messages;
import flashcard.web.repositories.UserRepository;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


@Component
public class RegistrationRequestDTOValidator implements Validator {

    private final UserRepository userRepository;

    private final Messages messages;

    public RegistrationRequestDTOValidator(UserRepository userRepository, Messages messages) {
        this.userRepository = userRepository;
        this.messages = messages;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return UserRequestDTO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserRequestDTO userRequestDTO = (UserRequestDTO) target;

        boolean nickAlreadyUsed = userRepository.readByNick(userRequestDTO.getNick()).orElse(null) != null;

        if (nickAlreadyUsed) {
            String errorCode = "validation.registration.nick.alreadyUsed";
            errors.rejectValue("nick", errorCode, messages.get(errorCode));
        }

        boolean emailAlreadyUsed = userRepository.readByNick(userRequestDTO.getEmail()).orElse(null) != null;

        if (emailAlreadyUsed) {
            String errorCode = "validation.registration.email.alreadyUsed";
            errors.rejectValue("email", errorCode, messages.get(errorCode));
        }
    }
}
