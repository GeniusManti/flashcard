package unit.mappers;

import flashcard.application.domain.User;
import flashcard.web.DTO.response.UserResponseDTO;
import flashcard.web.mappers.UserMapperImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import testObjectFactories.TestUserFactory;

@RunWith(MockitoJUnitRunner.class)
public class UserMapperTest {

    private UserMapperImpl userMapper;

    @Before
    public void setUp() {
        userMapper = new UserMapperImpl();
    }

    @Test
    public void whenIMapUserToResponseDTO_IGetUserResponseDTO() {

        //given
        User testUser = TestUserFactory.createTestUser();

        //when
        UserResponseDTO userResponseDTO = userMapper.mapToResponseDTO(testUser);

        //then
        Assert.assertEquals(testUser.getNick(), userResponseDTO.getNick());
        Assert.assertEquals(testUser.getPassword(), userResponseDTO.getPassword());
        Assert.assertEquals(testUser.getEmail(), userResponseDTO.getEmail());
        Assert.assertEquals(testUser.getPhoneNumber(), userResponseDTO.getPhoneNumber());
        Assert.assertEquals(testUser.getRole().toString(), userResponseDTO.getRole());
        Assert.assertEquals(testUser.getNick(), userResponseDTO.getNick());
    }
}

