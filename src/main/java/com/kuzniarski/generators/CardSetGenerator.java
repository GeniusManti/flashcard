package com.kuzniarski.generators;

import com.kuzniarski.domain.CardSet;
import com.kuzniarski.domain.FlashCard;

import java.util.List;

/**
 * Created by Kacper Kuźniarski on 08.10.2017.
 */
public class CardSetGenerator {

    public static CardSet getCardSet(List<String> textList) {
        CardSet cardSet = new CardSet();
        textList.forEach(s -> cardSet.addObject(CardGenerator.getFlashCard(s, ";")));
        return cardSet;
    }

}
