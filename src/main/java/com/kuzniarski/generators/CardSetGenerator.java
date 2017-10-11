package com.kuzniarski.generators;

import com.kuzniarski.domain.FlashCard;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Kacper Kuźniarski on 08.10.2017.
 */
public class CardSetGenerator {

    public static List<String[]> getCardSet(List<String> textList) {
        return textList.stream().
                map(s -> CardGenerator.getFlashCard(s, ";"))
                .collect(Collectors.toList());
    }

}
