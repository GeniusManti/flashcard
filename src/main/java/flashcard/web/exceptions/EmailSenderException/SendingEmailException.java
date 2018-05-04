package flashcard.web.exceptions.EmailSenderException;

public class SendingEmailException extends RuntimeException {
    public SendingEmailException(String message) {
        super(message);
    }
}
