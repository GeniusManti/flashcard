package flashcard.web.controllers;

import flashcard.web.DTO.request.UserRequestDTO;
import flashcard.web.DTO.response.UserResponseDTO;
import flashcard.web.component.message.Messages;
import flashcard.web.component.validation.RegistrationRequestDTOValidator;
import flashcard.web.services.user.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("api/users")
public class UserController {

    private final UserService userService;
    private final RegistrationRequestDTOValidator registrationRequestDTOValidator;
    private final Messages messages;

    public UserController(UserService userService, RegistrationRequestDTOValidator registrationRequestDTOValidator, Messages messages) {
        this.userService = userService;
        this.registrationRequestDTOValidator = registrationRequestDTOValidator;
        this.messages = messages;
    }

    @InitBinder("registrationReqDTO")
    public void initValidators(WebDataBinder binder){
        binder.addValidators(registrationRequestDTOValidator);
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> registerUser(@RequestBody @Valid @NotNull UserRequestDTO registrationReqDTO) {
        return new ResponseEntity<>(userService.registerUser(registrationReqDTO), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> readUserById(@PathVariable long id) {
        return new ResponseEntity<>(userService.readUserById(id), HttpStatus.OK);
    }

    @GetMapping("/nick/{nick}")
    public ResponseEntity<UserResponseDTO> readUserByNick(@PathVariable String nick) {
        return new ResponseEntity<>(userService.readUserByNick(nick), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable long userId) {
        userService.deleteUser(userId);
    }

    @DeleteMapping
    public void deleteAllUsers() {
        userService.deleteAllUser();
    }


}
