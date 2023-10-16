package com.wintex.web.core.pageobjs;

import com.microsoft.playwright.Page;
import org.springframework.stereotype.Service;

@Service
public class _BasePageObject {

    protected String url;
    protected Page page;

    public void visit() {
        if (url == null) {
            throw new RuntimeException("Cannot navigate directly to the page ");
        }
        page.navigate(url);

    }
}






