package se.enbohms.bdd.step;

import org.jboss.arquillian.drone.api.annotation.Drone;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Represent the various steps in the resource file login.feature
 * 
 * @author enbohm
 *
 */
public class LoginSteps {

	@Drone
	WebDriver driver;

	@Given("a user on start page")
	public void given_a_user_on_start_page() {
		System.out.println(" Given zzzzzz");
	}

	@And("the user is not logged in")
	public void and_user_not_logged_in() {
		System.out.println(" And zzzzzz");
	}

	@When("the fills in username (.+) and password (.+)")
	public void when_fills_in_credentials(String userName, String password) {
		System.out.println(" When zzzzzz");
	}

	@Then("the user should be redirected to MyPages")
	public void then_user_should_be_redirected_to_mypages() {
		System.out.println(" Then zzzzzz");
	}
}
