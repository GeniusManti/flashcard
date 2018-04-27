package flashcard.web.services.email;

import flashcard.web.component.email.HtmlEmail;
import flashcard.web.component.email.sender.EmailSender;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;

@Service
public class EmailSenderServiceImpl implements EmailSenderService {

    private final EmailSender emailSender;

    public EmailSenderServiceImpl(EmailSender emailSender) {
        this.emailSender = emailSender;
    }

    @Override
    public void sendEmail(String email) {

        HtmlEmail instance = new HtmlEmail("from@no-spam.com");
        instance.setHtmlContent("test Email");
        instance.setSubject("test title");
        instance.setRecipientNick("testRecipientNick");
        instance.setTo(email);

        try {
            emailSender.send(instance);
        } catch (MessagingException e) {
            e.printStackTrace();
        }


    }
}
