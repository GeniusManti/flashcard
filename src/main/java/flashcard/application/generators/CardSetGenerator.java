package flashcard.application.generators;

import flashcard.application.domain.FlashCard;

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
