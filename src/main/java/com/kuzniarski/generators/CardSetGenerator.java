package com.kuzniarski.generators;

import com.kuzniarski.domain.FlashCard;
import com.kuzniarski.exceptions.NoRegexException;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Kacper Kuźniarski on 08.10.2017.
 */
public class CardSetGenerator {

    public List<FlashCard> generateFlashCard(List<String> textList, String regex) {
        return textList.stream().
                map(s -> new CardGenerator().generateFlashCard(s, regex))
                .collect(Collectors.toList());
    }

}
