package com.network.backend.socialNetwork.service;

import com.network.backend.model.Users;
import com.network.backend.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class UserServiceTest {
    @MockBean
    private UserService userService;

    public Users getUser(){
        Users users=new Users();
        users.setId(1);
        users.setEmail("testEmail");
        users.setName("testName");
        users.setSurname("testSurname");
        users.setPassword("testPassword");
        return users;
    }

    @Test
    public void testCreateUser(){
        Users users=getUser();
        when(userService.saveUser(any(Users.class))).thenReturn(users);
        Users users1=userService.saveUser(users);
        assertThat(!users1.getName().isBlank());
    }

    @Test
    public void testDeleteUser(){
        doNothing().when(userService).deleteUser(1);
        userService.deleteUser(1);
        assertThat(true);
    }

    @Test
    public void testUpdateUser(){
        Users users=getUser();
        when(userService.updateUser(any(Users.class))).thenReturn(users);
        Users users1=userService.updateUser(users);
        assertThat(!users1.getName().isBlank());
    }

    @Test
    public void testGetUser(){
        Users users=getUser();
        given(userService.getUser(1)).willReturn(users);
        Users users1=userService.getUser(1);
        assertEquals(users1.getId(),1);
    }
}
