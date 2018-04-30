package flashcard.web.services.user;

import flashcard.application.domain.User;
import flashcard.application.domain.enums.Role;
import flashcard.application.exceptions.EmailSenderException.SendingGreetingEmailFailException;
import flashcard.application.exceptions.ObjectNotFoundException;
import flashcard.web.DTO.request.UserRequestDTO;
import flashcard.web.DTO.response.UserResponseDTO;
import flashcard.web.component.email.Email;
import flashcard.web.component.email.HtmlEmail;
import flashcard.web.component.email.builder.EmailBuilder;
import flashcard.web.component.email.sender.EmailSender;
import flashcard.web.mappers.UserMapper;
import flashcard.web.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.MessagingException;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    private final EmailSender emailSender;
    private final EmailBuilder emailBuilder;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper, EmailSender emailSender, EmailBuilder emailBuilder) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.emailSender = emailSender;
        this.emailBuilder = emailBuilder;
    }

    @Override
    @Transactional(rollbackFor = {MessagingException.class, ObjectNotFoundException.class})
    public UserResponseDTO registerUser(UserRequestDTO registrationReqDTO) {
        User user = User.builder()
                .nick(registrationReqDTO.getNick())
                .email(registrationReqDTO.getEmail())
                .phoneNumber(registrationReqDTO.getPhoneNumber())
                .password(registrationReqDTO.getPassword())
                .role(Role.USER)
                .build();

        userRepository.save(user);

        Email greetingEmail = emailBuilder.buildGreetingEmail(user.getNick()).to(user.getEmail());

        try {
            emailSender.send((HtmlEmail) greetingEmail);
        } catch (MessagingException e) {
            e.printStackTrace();
            throw new SendingGreetingEmailFailException();
        }

        return userMapper.mapToResponseDTO(user);
    }

    @Override
    public UserResponseDTO readUserById(long id) {
        User foundUser = userRepository.readById(id)
                .orElseThrow(() -> new ObjectNotFoundException(User.class, id));

        return userMapper.mapToResponseDTO(foundUser);
    }

    @Override
    public UserResponseDTO readUserByNick(String nick) {
        User foundUser = userRepository.readByNick(nick)
                .orElseThrow(() -> new ObjectNotFoundException(User.class, "nick", nick));

        return userMapper.mapToResponseDTO(foundUser);
    }

    @Override
    public void deleteUser(long id) {
        userRepository.delete(id);
    }

    @Override
    public void deleteAllUser() {
        userRepository.deleteAll();
    }
}
