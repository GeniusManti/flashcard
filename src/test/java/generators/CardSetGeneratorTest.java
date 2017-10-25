package generators;

import flashcard.application.domain.FlashCard;
import flashcard.application.generators.CardGenerator;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created by Kacper Kuźniarski on 09.10.2017.
 */
public class CardSetGeneratorTest {

    private static List<Object[]> validData;
    private static List<Object[]> inValidData;
    private static List<FlashCard> flashCards;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @BeforeClass
    public static void beforeClass() {
        validData = Arrays.asList(new Object[][]{
                {"amount;wielkość", ";", "amount", "wielkość"},
                {"digit;cyfra", ";", "digit", "cyfra"},
                {"dividend;dzielna", ";", "dividend", "dzielna"}});

        inValidData = Arrays.asList(new Object[][]{
                {"amount;wielkość", "/", null},
                {"digitcyfra", ";", null},
                {"", ";", null}});

        flashCards = new ArrayList<>();
    }

    @Test
    public void validDataTest() {
        validData.forEach(s -> flashCards.add(new CardGenerator().generateFlashCard(s[0].toString(), s[1].toString())));

        for (int i = 0; i < validData.size(); i++) {
            assertEquals(validData.get(i)[2], flashCards.get(i).getText());
            assertEquals(validData.get(i)[3], flashCards.get(i).getTranslation());
        }
    }
    
}