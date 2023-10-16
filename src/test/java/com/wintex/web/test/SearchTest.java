package com.wintex.web.test;

import com.wintex.web.core.pageobjs.SearchPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

public class SearchTest extends _BaseTest{

    @Autowired
    SearchPage searchPage;




    @Test
    public void testSearch16Item() {
        // Open the login page
        searchPage.visit();
        searchPage.chooseDepartment("Books");
        searchPage.inputSearchText("apple");
        searchPage.clickSearch();
        searchPage.changeSearchResultLanguage("English");
        searchPage.waitForSearchResultToLoad();
        searchPage.verifySearchResultCount(16);

    }


    @Test
    public void testSearch() {
        // Open the login page
        searchPage.visit();
        searchPage.chooseDepartment("Books");
        searchPage.inputSearchText("apple");
        searchPage.clickSearch();
        searchPage.waitForSearchResultToLoad();
        searchPage.changeSortOption("date-desc-rank");
        searchPage.changeSearchResultLanguage("English");
        searchPage.verifyResultSortByPublicationDate();
    }
}
