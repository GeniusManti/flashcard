package flashcard.web.component.email.sender;

import flashcard.web.component.email.HtmlEmail;

import javax.mail.MessagingException;

public interface EmailSender {
    void send(HtmlEmail email) throws MessagingException;
}
