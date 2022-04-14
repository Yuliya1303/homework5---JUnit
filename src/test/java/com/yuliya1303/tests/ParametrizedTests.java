package com.yuliya1303.tests;

import com.yuliya1303.pages.CategoriesList;
import com.yuliya1303.pages.ParametrizedTestsPages;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.List;
import java.util.stream.Stream;

public class ParametrizedTests {

    ParametrizedTestsPages parametrizedTestsPages = new ParametrizedTestsPages();

    String website = "https://www.amazon.com/";

    @ValueSource(strings = {
            "Jacket",
            "JUnit"
    })

    @ParameterizedTest(name = "Check search in Amazon with the word {0}")
    void amazonSearchTestDataEqualsResult(String testData) {
        //Precondition
        parametrizedTestsPages.openPage(website)
        //Steps
                .setSearchData(testData)
                .clickSearchBtn()
        //Expected result
                .checkItemResult(testData);
    }

    @CsvSource(value = {
            "Jacket:Clothing, Shoes & Jewelry",
            "JUnit:Books"
    },
    delimiter = ':'
    )
    @ParameterizedTest(name = "Check search in Amazon with the word {0}, expected result {1}")
    void amazonSearchDataNotEqualsResult(String testData, String expectedResult) {
        //Precondition
        parametrizedTestsPages.openPage(website)
        //Steps
                .setSearchData(testData)
                .clickSearchBtn()
        //Expected result
                .checkLeftMenuItem(expectedResult);
    }

    static Stream<Arguments> methodSourceTestDataAndSeveralResults() {
        return Stream.of(
                Arguments.of("Jacket", List.of("Men's Fleece Jackets & Coats", "Men's Lightweight Jackets")),
                Arguments.of("JUnit", List.of("Programming Languages", "ComputerProgramminf", "Web Development & Design"))
        );
    }

    @MethodSource("methodSourceTestDataAndSeveralResults")
    @ParameterizedTest
    void amazonSearchDataAndSeveralResults(String testData, List<String> expectedResult) {
        //Precondition
        parametrizedTestsPages.openPage(website)
        //Steps
                .setSearchData(testData)
                .clickSearchBtn()
        //Expected result
                .checkLeftMenu(expectedResult);
    }

    @EnumSource(CategoriesList.class)
    @ParameterizedTest
    void amazonMenuItemsFromEnum(CategoriesList testData) {
        //Precondition
        parametrizedTestsPages.openPage(website)
        //Steps
                .setSearchData("Jacket")
                .clickSearchBtn()
                .clickOnLeftMenuItem(testData.fullCategoryName)
        //Expected result
                .checkItemInSearchDropdown(testData.fullCategoryName);
    }

}
