package generators;

import com.kuzniarski.domain.FlashCard;
import com.kuzniarski.generators.CardGenerator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Kacper Kuźniarski on 09.10.2017.
 */
@RunWith(Parameterized.class)
public class CardSetGeneratorTest {

    private String text;
    private String regex;
    private FlashCard expected;

    public CardSetGeneratorTest(String text, String regex, FlashCard expected) {
        this.text = text;
        this.regex = regex;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"amount;wielkość", ";", new FlashCard("amount", "wielkość")},
                {"digit;cyfra", ";", new FlashCard("digit", "cyfra")},
                {"dividend;dzielna", ";", new FlashCard("dividend", "dzielna")}
        });
    }

    @Test
    public void FlashCardGeneratorTest() {

        FlashCard card = CardGenerator.getFlashCard(text, regex);

        assertEquals(card.getText(), expected.getText());
        assertEquals(card.getTranslation(), expected.getTranslation());
    }
}