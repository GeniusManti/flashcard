package com.kuzniarski.domain;

import java.util.List;

/**
 * Created by Kacper Kuźniarski on 08.10.2017.
 */
public class CardSet {

    private List<FlashCard> flashCardSet;

    public CardSet() {}

    public CardSet(List<FlashCard> set) {
        this.flashCardSet = set;
    }

    public List<FlashCard> getFlashCardSet() {
        return flashCardSet;
    }

    public void setFlashCardSet(List<FlashCard> flashCardSet) {
        this.flashCardSet = flashCardSet;
    }

    public void addObject(FlashCard flashCard) {
        flashCardSet.add(flashCard);
    }

    public void removeObject(FlashCard flashCard) {
        flashCardSet.remove(flashCard);
    }
}
