package com.wintex.web.test;

import com.wintex.web.core.pageobjs.HomePage;
import com.wintex.web.core.pageobjs.LoginPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

public class LoginTest extends _BaseTest{

    @Autowired
    HomePage homePage;

    @Autowired
    LoginPage loginPage;



    @Test
    public void testLoginSuccess() {
        // Open the login page
        homePage.visit();
        homePage.goToLoginPage();
        loginPage.login("jaxbn0000@gmail.com", "Test1234@qwerty");
        homePage.verifyLoginSuccess();
    }


    @Test
    public void testLoginFailed() {
        // Open the login page
        homePage.visit();
        homePage.goToLoginPage();
        loginPage.login("jaxbn0000@gmail.com", "Test1234@dqwedrty");
        loginPage.verifyLoginFail("invalid password");
    }


}
