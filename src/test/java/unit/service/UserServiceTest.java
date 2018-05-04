package unit.service;

import flashcard.web.domain.User;
import flashcard.web.mappers.UserMapper;
import flashcard.web.repositories.UserRepository;
import flashcard.web.services.user.UserService;
import flashcard.web.services.user.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Optional;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static testObjectFactories.TestUserFactory.createTestUser;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;
    @Mock
    private UserMapper userMapper;

    private UserService userService;

    @Before
    public void setUp() {
        userService = new UserServiceImpl(userRepository, userMapper);
    }
    
//    @Test
//    public void whenICreatePerson_thenThisPersonIsSavedAndMapped() {
//        //given
//        UserRequestDTO userRequestDTO = createTestUserRequestDTO();
//        User testUser = createTestUser();
//
//        when(userMapper.mapFromRequestDTO(userRequestDTO)).thenReturn(testUser);
//
//        User savedUser = createTestUser();
//        savedUser.setId(1L);
//
//        when(userRepository.save(testUser)).thenReturn(savedUser);
//
//        //when
//        userService.createUser(userRequestDTO);
//
//        //then
//        verify(userMapper, times(1)).mapFromRequestDTO(userRequestDTO);
//        verify(userRepository, times(1)).save(testUser);
//        verify(userMapper, times(1)).mapToResponseDTO(savedUser);
//    }


    @Test
    public void whenIReadUserById_thenThisUserIsReadAndMapped() {

        //given
        User testUser = createTestUser();
        testUser.setId(1L);

        Mockito.when(userRepository.readById(1L)).thenReturn(Optional.of(testUser));

        //when
        userService.readUserById(1L);

        //then
        Mockito.verify(userRepository, Mockito.times(1)).readById(1L);
        Mockito.verify(userMapper, Mockito.times(1)).mapToResponseDTO(testUser);

    }

    @Test
    public void whenIReadUserByNick_thenThisUserIsReadAndMapped() {

        //given
        User testUser = createTestUser();

        String testUserNick = "janek";
        testUser.setNick(testUserNick);

        Mockito.when(userRepository.readByNick(testUserNick)).thenReturn(Optional.of(testUser));

        //when
        userService.readUserByNick(testUserNick);

        //then
        Mockito.verify(userRepository, Mockito.times(1)).readByNick(testUserNick);
        Mockito.verify(userMapper, Mockito.times(1)).mapToResponseDTO(testUser);

    }

    @Test
    public void whenIDeleteSavedUser_thenItIsDeleted() {
        //when
        userService.deleteUser(1L);

        //then
        verify(userRepository, times(1)).delete(1L);
    }

    @Test
    public void whenIDeleteAllUsers_thenTheyAreDeleted() {
        //when
        userService.deleteAllUser();

        //then
        verify(userRepository, times(1)).deleteAll();
    }

}
