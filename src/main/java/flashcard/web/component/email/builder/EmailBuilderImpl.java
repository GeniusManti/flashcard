package flashcard.web.component.email.builder;

import flashcard.web.component.email.Email;
import flashcard.web.component.email.HtmlEmail;
import flashcard.web.component.message.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.thymeleaf.spring4.SpringTemplateEngine;

@Component
public class EmailBuilderImpl implements EmailBuilder {

    private final SpringTemplateEngine templateEngine;

    private final Messages messages;

    private Email instance;

    @Autowired
    public EmailBuilderImpl(SpringTemplateEngine templateEngine, Messages messages) {
        this.templateEngine = templateEngine;
        this.messages = messages;
    }

    @Override
    public EmailBuilder buildGreetingEmail(String userNick) {
        HtmlEmail instance = new HtmlEmail("flashcardService@gmail.com");
        instance.setSubject("Welcome in flashcard");

        instance.setHtmlContent("Hello " + userNick + ", we enjoy, that you are with us.");

        this.instance = instance;

        return this;
    }


    @Override
    public Email to(String recipientAddress){
        instance.setTo(recipientAddress);

        return instance;
    }

}
