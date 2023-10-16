package com.wintex.web.core.pageobjs;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

@Component
public class SearchPage extends _BasePageObject {

    private static final String DEPARTMENT_DROPDOWN_SELECT = "#searchDropdownBox";
    private static final String DEPARTMENT_DROPDOWN_BTN = "#nav-search-dropdown-card";
    private static final String SEARCH_BOX = "#twotabsearchtextbox";
    private static final String SEARCH_BTN = "#nav-search-submit-button";
    private static final String RESULT_SORT_DROPDOWN_BTN = "#s-result-sort-select";


//    private static final String SEARCH_RESULTS= "span[data-component-type='s-search-results'] span[data-component-type='s-product-image'] a";


    private static final String SEARCH_RESULTS = "span[data-component-type='s-search-results'] [class='a-section'] [class*='list-col-right']";


    @Autowired
    public SearchPage(Page page) {
        this.page = page;
        this.url = "https://www.amazon.com/s";
    }



    public void chooseDepartment(String department) {
        page.click(DEPARTMENT_DROPDOWN_BTN);
        page.selectOption(DEPARTMENT_DROPDOWN_SELECT, "search-alias=stripbooks-intl-ship");

    }

    public void inputSearchText(String searchText) {
        page.fill(SEARCH_BOX, searchText);
    }

    public void clickSearch() {
        page.click(SEARCH_BTN);

    }

    public void changeSearchResultLanguage(String language) {
        page.click(String.format("li[aria-label='%s'] i", language));
    }

    public void changeSortOption(String sortBy) {
        page.selectOption(RESULT_SORT_DROPDOWN_BTN, sortBy);

    }

    public void waitForSearchResultToLoad() {
        page.waitForSelector(SEARCH_RESULTS);
    }

    public void verifySearchResultCount(int searchResultCount) {

//        String text = locator.innerText();

        Assert.assertEquals(page.locator(SEARCH_RESULTS).count(), searchResultCount);
    }


    public void verifyResultSortByPublicationDate() {
        Locator locator = page.locator(SEARCH_RESULTS);
        List<String> values = locator.allInnerTexts();
        ;
        long assertTime = System.currentTimeMillis();
        while (values.size() < 16 && (System.currentTimeMillis() - assertTime) < 2000) {
            values = locator.allInnerTexts();
        }

        List<String> dates = extractDateFromText(values);

        System.out.println(123);

    }

    private List<String>  extractDateFromText(List<String> texts){
        List<String> dates = new ArrayList<String>();
        for(String text:texts){
            String [] lines = text.split("\n");
            String date = lines[1].split("by")[1].split("\\|")[1];
            dates.add(date);
        }
        return dates;
    }


}
