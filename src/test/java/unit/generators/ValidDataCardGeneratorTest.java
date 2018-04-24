package unit.generators;

import flashcard.application.domain.FlashCard;
import flashcard.application.generators.CardGenerator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Created by Kacper Kuźniarski on 18.10.2017.
 */
@RunWith(Parameterized.class)
public class ValidDataCardGeneratorTest {

    private String text;
    private String regex;
    private String expectedText;
    private String expectedTranslation;

    private static FlashCard flashCard;

    public ValidDataCardGeneratorTest(String text, String regex, String expectedText, String expectedTranslation) {
        this.text = text;
        this.regex = regex;
        this.expectedText = expectedText;
        this.expectedTranslation = expectedTranslation;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"amount;wielkość", ";", "amount", "wielkość"},
                {"digit;cyfra", ";", "digit", "cyfra"},
                {"dividend;dzielna", ";", "dividend", "dzielna"}});
    }

    @Before
    public void setUp() throws Exception {
        flashCard = new CardGenerator().generateFlashCard(text, regex);
    }

    @Test
    public void validDataTest() throws Exception {

        assertEquals(expectedText, flashCard.getText());
        assertEquals(expectedTranslation, flashCard.getTranslation());
    }
}
