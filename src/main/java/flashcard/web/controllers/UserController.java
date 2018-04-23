package flashcard.web.controllers;

import flashcard.web.DTO.response.UserResponseDTO;
import flashcard.web.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
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
}
