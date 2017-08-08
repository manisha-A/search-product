package com.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends PageObject {

    @FindBy(id = "signInSignUp")
    private WebElementFacade signUpform;

    public void isSignUpFormVisible(){
        assert signUpform.isCurrentlyVisible();
    }

    public void verifySignInWithFB() {
        WebElement fblink = signUpform.then(By.linkText("Facebook"));
        assert fblink.isDisplayed();
    }
}
