package se.enbohms.bdd.core;

import org.jboss.arquillian.drone.api.annotation.Drone;
import org.junit.runner.RunWith;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import cucumber.api.CucumberOptions;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.runtime.arquillian.ArquillianCucumber;
import cucumber.runtime.arquillian.api.Features;

@Features("src/test/resources/bdd/feature/")
@CucumberOptions(strict = false)
//@RunWith(ArquillianCucumber.class)
public class BddEngine {

	// @Deployment(testable = false)
	// public static Archive<?> createDeployment() {
	// return Deployments.createOpenUniverseFullDeployment();
	// }

	// this instance must be injected here, otherwise the upcoming steps can't
	// utilize the drone instance
	@Drone
	WebDriver driver;

	/**
	 * Will run after each scenario. Embeds a screenshot of the current view of
	 * the scenario fails
	 * 
	 * @param scenario
	 * @throws Exception
	 *             if anything goes wrong
	 */
	@After
	public void afterScenario(Scenario scenario) throws Exception {
		if (scenario.isFailed()) {
			embedScreeenshotDesktop(scenario);
		}
	}

	private void embedScreeenshotDesktop(Scenario scenario) {
		driver.manage().window().setSize(new Dimension(768, 1024));
		byte[] screenshot = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.BYTES);
		scenario.embed(screenshot, "image/png");
	}
}
