package com.wintex.web.core.springconfig;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.jax.forfun.web")
public class PlaywrightSpringConfig {

    @Bean
    public Playwright playwright() {
        System.out.println("init playwright");
        return Playwright.create();
    }

    @Bean
    @Autowired
    public Browser browser(Playwright playwright) {
        System.out.println("init browser");
        return playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
    }

    @Bean
    @Autowired
    public Page page(Browser browser) {
        System.out.println("init page");
        return browser.newPage();
    }
}
