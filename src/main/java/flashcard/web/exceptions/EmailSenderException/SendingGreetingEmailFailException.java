package flashcard.web.exceptions.EmailSenderException;

public class SendingGreetingEmailFailException extends SendingEmailException {
    public SendingGreetingEmailFailException() {
        super("There are some problem with sending greeting message.");
    }
}
