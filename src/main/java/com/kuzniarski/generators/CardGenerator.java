package com.kuzniarski.generators;

import com.kuzniarski.domain.FlashCard;
import com.kuzniarski.exceptions.NoRegexException;

/**
 * Created by Kacper Kuźniarski on 08.10.2017.
 */
public class CardGenerator {

    public static String[] getFlashCard(String text, String regex) {
        String[] tab = null;
        try {
            NoRegexException.isRegex(text, regex);
            tab = text.split(regex);
        } catch (NoRegexException e) {
            e.printStackTrace();
        }
        return (tab != null) ? new String[]{tab[0], tab[1]} : null;
    }



}
