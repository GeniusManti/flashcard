package flashcard.web.controllers;

import flashcard.web.DTO.response.UserResponseDTO;
import flashcard.web.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> readUserById(@PathVariable("id") long id) {
        return new ResponseEntity<>(userService.readUser(id), HttpStatus.OK);
    }

    @GetMapping("/{nick}")
    public ResponseEntity<UserResponseDTO> readUserByNick(@PathVariable("nick") String nick) {
        return new ResponseEntity<>(userService.readUserByNick(nick), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserResponseDTO> deleteUser(@PathVariable("id") long id) {
        return new ResponseEntity<>(userService.deleteUser(id), HttpStatus.OK);
    }
}
