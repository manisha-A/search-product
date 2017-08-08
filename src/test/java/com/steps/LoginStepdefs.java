package com.steps;

import com.pages.LoginPage;
import cucumber.api.PendingException;
import cucumber.api.java8.En;

public class LoginStepdefs implements En {

    LoginPage loginpage;

    public LoginStepdefs() {
        Then("^user is asked to login$", () -> {
            try {
                loginpage.isSignUpFormVisible();
            } catch (Exception e) {
                e.getMessage();
            }
        });
        Then("^user should has option to signin with facebook$", () -> {
            try {
                loginpage.verifySignInWithFB();
            } catch (Exception e) {
                e.getMessage();
            }
        });
    }
}
