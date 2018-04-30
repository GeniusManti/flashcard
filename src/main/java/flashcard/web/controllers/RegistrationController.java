package flashcard.web.controllers;

import flashcard.web.DTO.request.UserRequestDTO;
import flashcard.web.component.message.Messages;
import flashcard.web.component.validation.RegistrationRequestDTOValidator;
import flashcard.web.services.registration.RegistrationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/api/registration")
public class RegistrationController {

    private final RegistrationService registrationService;
    private final RegistrationRequestDTOValidator registrationRequestDTOValidator;
    private final Messages messages;

    public RegistrationController(RegistrationService registrationService, RegistrationRequestDTOValidator registrationRequestDTOValidator, Messages messages) {
        this.registrationService = registrationService;
        this.registrationRequestDTOValidator = registrationRequestDTOValidator;
        this.messages = messages;
    }

    @InitBinder("registrationReqDTO")
    public void initValidators(WebDataBinder binder){
        binder.addValidators(registrationRequestDTOValidator);
    }

    @PostMapping
    public ResponseEntity registration(@RequestBody @Valid @NotNull UserRequestDTO registrationReqDTO) {
        registrationService.register(registrationReqDTO);
        return ResponseEntity.ok(messages.get("registration.success"));
    }

}
