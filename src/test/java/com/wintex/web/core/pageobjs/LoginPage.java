package com.wintex.web.core.pageobjs;

import com.microsoft.playwright.Page;
import org.springframework.beans.factory.annotation.Autowired;

public class LoginPage extends _BasePageObject {

    private static final String EMAIL_INPUT = "#ap_email";
    private static final String PASSWORD_INPUT = "#ap_password";
    private static final String CONTINUE_BTN = "#continue";
    private static final String SIGNIN_BTN = "#signInSubmit";

    @Autowired
    public LoginPage(Page page) {
        this.page = page;
        this.url = "https://www.amazon.com/signin";
    }

    public void login(String email, String password) {
        page.waitForSelector(EMAIL_INPUT);
        page.fill(EMAIL_INPUT, email);
        page.click(CONTINUE_BTN);

        page.waitForSelector(PASSWORD_INPUT);
        page.fill(PASSWORD_INPUT, password);

        // Click login button
        page.click(SIGNIN_BTN);
    }


    public void verifyLoginFail(String failureMessage) {
    }


}
