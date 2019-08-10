package com.twu.biblioteca;

import com.twu.biblioteca.service.LoginService;
import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class LoginTest {

    @Test
    public void shouldReturnTrueWhenLogin(){
        String name = "Tom";
        String password = "123456";
        LoginService loginService = new LoginService();
        assertThat(loginService.login(name,password),equalTo(true));
    }

    @Test
    public void shouldReturnFalseWhenLogin(){
        String name = "Tom";
        String password = "12345";
        String name1 = "aaa";
        String password1 = "1111";
        LoginService loginService = new LoginService();
        assertThat(loginService.login(name,password),equalTo(false));
        assertThat(loginService.login(name1,password1),equalTo(false));
    }
}
