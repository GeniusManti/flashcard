package unit.domain;

import flashcard.web.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertTrue;
import static testObjectFactories.TestUserFactory.createTestUser;

@RunWith(MockitoJUnitRunner.class)
public class UserTest {

    @Test
    public void whenICompareTwoUsersWithSameEmail_thenTheyAreEqual() {
        //given
        User testUser = createTestUser();
        User testUser1 = createTestUser();
        testUser1.setNick("differentNick");

        //when
        boolean hashCode = testUser.hashCode() == testUser1.hashCode();
        boolean equals = testUser.equals(testUser1);

        //then
        assertTrue(hashCode);
        assertTrue(equals);
    }
}
