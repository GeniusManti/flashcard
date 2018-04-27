package flashcard.web.component.email;

import lombok.Data;

@Data
public abstract class Email {
    private String from;
    private String to;
    private String recipientNick;
    private String subject;

    public Email(String from) {
        this.from = from;
    }
}
