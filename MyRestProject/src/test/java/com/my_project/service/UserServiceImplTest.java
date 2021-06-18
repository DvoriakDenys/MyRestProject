package com.my_project.service;

import com.my_project.dto.UserDto;
import com.my_project.entity.User;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserServiceImplTest {
    @Mock
    UserService userService;

    UserDto userDto = UserDto.builder().age(12).name("Test").build();
    User user = User.builder().name(userDto.getName()).age(userDto.getAge()).build();

    @Test
    void createUser() {
        Mockito.when(userService.createUser(userDto)).thenReturn(user);
        assertEquals(user.getAge(), 12);
        assertEquals(user.getName(), "Test");
    }

    @Test
    void updateUser() {

    }

    @Test
    void deleteUser() {
        userService.deleteUser(userDto);
        Mockito.verify(userService, Mockito.times(1)).deleteUser(userDto);
    }
}