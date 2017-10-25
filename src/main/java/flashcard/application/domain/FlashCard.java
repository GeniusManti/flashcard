package flashcard.application.domain;

/**
 * Created by Kacper Kuźniarski on 23.06.2017.
 */
public class FlashCard {

    private String text;
    private String translation;

    public FlashCard(String text, String translation) {
        this.text = text;
        this.translation = translation;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public String getText() {
        return text;
    }

    public String getTranslation() {
        return translation;
    }

    public FlashCard getFlashCard() {
        return this;
    }
}
