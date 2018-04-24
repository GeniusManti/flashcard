package testObjectFactories;

import flashcard.application.domain.User;
import flashcard.application.domain.enums.Role;
import flashcard.web.DTO.response.UserResponseDTO;

public class TestUserFactory {

    public static User createTestUser(){
        return User.builder()
                .nick("yanko")
                .email("jan.kowalski@gmail.com")
                .phoneNumber("2346453342")
                .role(Role.USER)
                .banned(false)
                .password("oossword1234")
                .build();
    }

    public static UserResponseDTO createTestUserResponseDTO(){
        return UserResponseDTO.builder()
                .id(1L)
                .nick("janek")
                .email("jan.kowalski@gmail.com")
                .phoneNumber("2346453342")
                .password("pass12345")
                .build();
    }

}
