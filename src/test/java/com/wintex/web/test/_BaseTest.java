package com.wintex.web.test;

import com.microsoft.playwright.Page;
import com.wintex.web.core.springconfig.PlaywrightSpringConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;

import java.nio.file.Path;
import java.nio.file.Paths;

@ContextConfiguration(classes = PlaywrightSpringConfig.class)
public class _BaseTest extends AbstractTestNGSpringContextTests {

    @Autowired
    Page page;

    @BeforeTest
    public void setUp() {
        ApplicationContext context = new AnnotationConfigApplicationContext(PlaywrightSpringConfig.class);
        context.getBean(PlaywrightSpringConfig.class);
    }

    @AfterMethod
    public void screenshotOnFailure(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            Path path = Paths.get("target/screenshots/" + System.currentTimeMillis() + ".png");
            Page.ScreenshotOptions screenshotOptions = new Page.ScreenshotOptions().setPath(path);
            page.screenshot(screenshotOptions);
        }
    }
}