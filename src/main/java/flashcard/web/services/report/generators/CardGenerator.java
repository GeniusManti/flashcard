package flashcard.web.services.report.generators;

import flashcard.web.domain.FlashCard;
import flashcard.web.exceptions.NoRegexException;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Kacper Kuźniarski on 08.10.2017.
 */
public class CardGenerator {

    private static String[] tab = null;

    public static List<FlashCard> generateFlashCardSet(List<String> textList, String regex) {
        return textList.stream().
                map(s -> generateFlashCard(s, regex))
                .collect(Collectors.toList());
    }

    public static FlashCard generateFlashCard(String text, String regex) {

        try {
            NoRegexException.isRegex(text, regex);
            tab = text.split(regex);
        } catch (NoRegexException e) {
            e.printStackTrace();
        }
        return (isTableEqualsNull()) ? returnFlashCard() : null;
    }

    private static FlashCard returnFlashCard() {
        return new FlashCard(tab[0], tab[1]);
    }

    private static boolean isTableEqualsNull() {
        return tab != null;
    }

}
