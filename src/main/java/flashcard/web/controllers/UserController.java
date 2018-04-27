package flashcard.web.controllers;

import flashcard.web.DTO.request.UserRequestDTO;
import flashcard.web.DTO.response.UserResponseDTO;
import flashcard.web.services.user.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody @Valid UserRequestDTO userRequestDTO) {
        return new ResponseEntity<>(userService.createUser(userRequestDTO), HttpStatus.OK);
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
