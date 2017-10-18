package com.kuzniarski.generators;

import com.kuzniarski.domain.FlashCard;
import com.kuzniarski.exceptions.NoRegexException;

/**
 * Created by Kacper Kuźniarski on 08.10.2017.
 */
public class CardGenerator {
        private String[] tab = null;

    public FlashCard generateFlashCard(String text, String regex) {
        try {
            NoRegexException.isRegex(text, regex);
            tab = text.split(regex);
        } catch (NoRegexException e) {
            e.printStackTrace();
        }
        return (isTableEqualsNull()) ? returnFlashCard() : null;
    }

    private FlashCard returnFlashCard() {
        return new FlashCard(tab[0], tab[1]);
    }

    private boolean isTableEqualsNull() {
        return tab != null;
    }

}
