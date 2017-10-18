package generators;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by Kacper Kuźniarski on 18.10.2017.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({CardSetGeneratorTest.class, InValidDataCardGeneratorTest.class, ValidDataCardGeneratorTest.class})
public class AllGeneratorsTests {
}
