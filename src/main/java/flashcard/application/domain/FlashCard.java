package flashcard.application.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Kacper Kuźniarski on 23.06.2017.
 */
@Setter
@Getter
public class FlashCard {

    private String text;
    private String translation;

    public FlashCard(String text, String translation) {
        this.text = text;
        this.translation = translation;
    }

    public FlashCard getFlashCard() {
        return this;
    }
}
