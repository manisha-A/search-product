package com.steps;

import com.pages.HomePage;
import cucumber.api.PendingException;
import cucumber.api.java8.En;

public class HomeStepdefs implements En {
    HomePage homepage;

    public HomeStepdefs() {
        Given("^user is on Moo homepage$", () -> {
            try {
                homepage.navigate();
                homepage.isOnHomePage();
            } catch (Exception e) {
                e.getMessage();
            }
        });

        When("^user searches for \"([^\"]*)\"$", (String searchTerm) -> {
            try {
                homepage.enterSearchTerm(searchTerm);
                homepage.search();
            } catch (Exception e) {
                e.getMessage();
            }
        });

        Then("^user should search results for \"([^\"]*)\"$", (String searchTerm) -> {
            try {
                homepage.areResultsPresent(searchTerm);
            } catch (Exception e) {
                e.getMessage();
            }
        });

        Then("^user should be notified for product not found$", () -> {
            try {
                homepage.resultNotFound();
            } catch (Exception e) {
                e.getMessage();
            }
        });
        When("^user wants to signin$", () -> {
            try {
                homepage.navigateToSignIn();
            } catch (Exception e) {
                e.getMessage();
            }
        });


    }

}
