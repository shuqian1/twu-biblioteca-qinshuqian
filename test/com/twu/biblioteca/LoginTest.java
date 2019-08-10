package com.twu.biblioteca;

import com.twu.biblioteca.service.LoginService;
import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class LoginTest {

    @Test
    public void shouldReturnTrueWhenLogin(){
        String id = "c00-0001";
        String password = "123456";
        String id1 = "l00-0001";
        String password1 = "666666";
        LoginService loginService = new LoginService();
        assertThat(loginService.login(id,password),equalTo(true));
        assertThat(loginService.login(id1,password1),equalTo(true));
    }

    @Test
    public void shouldReturnFalseWhenLogin(){
        String id = "c00-0001";
        String password = "12345";
        String id1 = "c00-0009";
        String password1 = "1111";
        LoginService loginService = new LoginService();
        assertThat(loginService.login(id,password),equalTo(false));
        assertThat(loginService.login(id1,password1),equalTo(false));
    }

}
