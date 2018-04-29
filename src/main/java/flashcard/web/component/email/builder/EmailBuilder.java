package flashcard.web.component.email.builder;

import flashcard.web.component.email.Email;

public interface EmailBuilder {

    EmailBuilder buildGreetingEmail(String activationToken);

    Email to(String recipientAddress);

}
