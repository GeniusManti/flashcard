package unit.generators;

import flashcard.web.domain.FlashCard;
import flashcard.web.services.report.generators.CardGenerator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertNull;

/**
 * Created by Kacper Kuźniarski on 18.10.2017.
 */
@RunWith(Parameterized.class)
public class InValidDataCardGeneratorTest {

    private String text;
    private String regex;

    private static FlashCard flashCard;

    public InValidDataCardGeneratorTest(String text, String regex) {
        this.text = text;
        this.regex = regex;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"amount;wielkość", "/"},
                {"digitcyfra", ";"},
                {"", ";"}});
    }

    @Before
    public void setUp() throws Exception {
        flashCard = CardGenerator.generateFlashCard(text, regex);
    }

    @Test
    public void inValidDataTest() throws Exception {
        
        assertNull(flashCard);
    }
}
