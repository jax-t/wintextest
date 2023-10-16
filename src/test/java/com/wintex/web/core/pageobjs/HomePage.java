package com.wintex.web.core.pageobjs;

import com.microsoft.playwright.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HomePage extends _BasePageObject {


    @Autowired
    public HomePage(Page page) {
        this.page = page;
        this.url = "https://www.amazon.com/";
    }

    public void goToLoginPage() {

    }


    public void verifyLoginSuccess() {

    }
}
