package com.yuliya1303.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ParametrizedTestsPages {
    //locators
    SelenideElement searchField = $("#twotabsearchtextbox"),
            searchBtn = $("#nav-search-submit-button"),
            resultItem = $("[cel_widget_id=MAIN-SEARCH_RESULTS-1]"),
            leftMenu = $("#departments"),
            searchDropdown = $("#nav-search-dropdown-card");

    //actions
    public ParametrizedTestsPages openPage(String website) {
        Selenide.open(website);

        return this;
    }

    public ParametrizedTestsPages setSearchData(String searchData) {
        searchField.sendKeys(searchData);

        return this;
    }

    public ParametrizedTestsPages clickSearchBtn () {
        searchBtn.click();

        return this;
    }

    public ParametrizedTestsPages checkItemResult(String expectedItemResult) {
        resultItem.shouldHave(text(expectedItemResult));

        return this;
    }

    public ParametrizedTestsPages checkLeftMenuItem(String expectedMenuItemResult) {
        leftMenu.shouldHave(text(expectedMenuItemResult));

        return this;
    }

    public ParametrizedTestsPages checkLeftMenu(List<String> expectedMenuResult) {
        leftMenu.equals(expectedMenuResult);

        return this;
    }

    public ParametrizedTestsPages clickOnLeftMenuItem(String menuItem) {
        leftMenu.$(byText(menuItem)).click();

        return this;
    }

    public ParametrizedTestsPages checkItemInSearchDropdown(String expectedSearchDropdown) {
        searchDropdown.shouldHave(text(expectedSearchDropdown));

        return this;
    }

}
