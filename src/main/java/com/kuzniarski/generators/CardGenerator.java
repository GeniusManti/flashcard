package com.kuzniarski.generators;

import com.kuzniarski.domain.FlashCard;
import com.kuzniarski.exceptions.NoRegexException;

/**
 * Created by Kacper Kuźniarski on 08.10.2017.
 */
public class CardGenerator {

    public static FlashCard getFlashCard(String text, String regex) {
        try {
            CardGenerator.isRegex(text, regex);
        } catch (NoRegexException e) {
            e.printStackTrace();
        }
        String[] tab = text.split(regex);
        return new FlashCard(tab[0], tab[1]);
    }

    public static void isRegex(String flashCard, String regex) throws NoRegexException {
        int regexAmount = flashCard.length() - flashCard.replaceAll(regex, "").length();
        if (regexAmount != 0) {
            throw new NoRegexException();
        }
    }


}
