package flashcard.web.services.registration;

import flashcard.application.domain.User;
import flashcard.application.domain.enums.Role;
import flashcard.application.exceptions.EmailSenderException.SendingGreetingEmailFailException;
import flashcard.application.exceptions.ObjectNotFoundException;
import flashcard.web.DTO.request.UserRequestDTO;
import flashcard.web.component.email.Email;
import flashcard.web.component.email.HtmlEmail;
import flashcard.web.component.email.builder.EmailBuilder;
import flashcard.web.component.email.sender.EmailSender;
import flashcard.web.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.MessagingException;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    private final UserRepository userRepository;

    private final EmailSender emailSender;

    private final EmailBuilder emailBuilder;

    @Autowired
    public RegistrationServiceImpl(UserRepository userRepository,
                                   EmailSender emailSender,
                                   EmailBuilder emailBuilder) {
        this.userRepository = userRepository;
        this.emailSender = emailSender;
        this.emailBuilder = emailBuilder;
    }

    @Transactional(rollbackFor = {MessagingException.class, ObjectNotFoundException.class})
    public void register(UserRequestDTO registrationReqDTO) {

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
    }

}
