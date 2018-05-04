package unit.exceptions;

import flashcard.web.exceptions.NoRegexException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.fail;

/**
 * Created by Kacper Kuźniarski on 09.10.2017.
 */
@RunWith(Parameterized.class)
public class NoRegexExceptionTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private String withRegex;
    private String withoutRegex;

    public NoRegexExceptionTest(String positive, String negative) {
        this.withRegex = positive;
        this.withoutRegex = negative;
    }


    @Parameterized.Parameters
    public static List<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"amount;wielkość", "amountwielkość"},
                {"digit;cyfra", "amount;wielkość;"},
                {"dividend;dzielna", ";;amount;wielkość"}
        });

    }

    @Test
    public void exceptionPositiveTest() throws NoRegexException {

        thrown.expect(NoRegexException.class);
        thrown.expectMessage("regex not found or too many regex");

        NoRegexException.isRegex(withoutRegex, ";");
    }

    @Test
    public void exceptionNegativeTest() {
        try {
            NoRegexException.isRegex(withRegex, ";");
        } catch (NoRegexException e) {
            fail();
        }
    }
}