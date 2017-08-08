package com.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;

public class HomePage extends PageObject {

    private final String PRODUCT_NOT_FOUND = "Sorry we couldn’t find anything. Please check the spelling or alternatively chat to our friendly customer services team using the chat below.";
    private final String RESULTS_BOX = "gsc-resultsbox-visible";
    private final String HOMEPAGE_URL = "https://www.moo.com";

    @FindBy(id = "___gcse_0")
    private WebElementFacade results;

    @FindBy(id = "search")
    private WebElementFacade searchForm;

    @FindBy(className = "header")
    private WebElementFacade homeHeader;

    @FindBy(id = "pardot-form")
    private WebElementFacade getQuoteForm;

    public void isOnHomePage(){
        assert homeHeader.isCurrentlyVisible();
        assertThat(homeHeader.getText(),containsText("Sign in"));
    }

    public void resultNotFound() {
        assertThat(results.getText(),containsText(PRODUCT_NOT_FOUND));
    }

    public void search() {
        searchForm.then(By.className("search__btn")).click();
    }

    public void enterSearchTerm(String searchTerm) {
        searchForm.then(By.tagName("input")).sendKeys(searchTerm);
    }

    public void navigate() {
        getDriver().get(HOMEPAGE_URL);
    }

    public void areResultsPresent(String searchTerm) {
        withTimeoutOf(10, TimeUnit.SECONDS).waitFor(ExpectedConditions.visibilityOf(results));
        assert results.then(By.className(RESULTS_BOX)).isCurrentlyVisible();
        assertThat(results.then(By.className(RESULTS_BOX)).getText(),containsText(searchTerm));
    }

    public void navigateToSignIn() {
        getDriver().findElement(By.linkText("Sign in")).click();
    }

    public void navigateToTenPlusEmployees() {
        getDriver().findElement(By.linkText("10+ Employees?")).click();
    }

    public void getQuote() {
        getDriver().findElement(By.linkText("Get a quote and sample pack")).click();
    }

    public void isGetQuoteFormPresent() {
        assert getQuoteForm.isDisplayed();
    }
}
