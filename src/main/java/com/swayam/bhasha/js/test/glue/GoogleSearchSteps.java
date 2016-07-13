package com.swayam.bhasha.js.test.glue;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GoogleSearchSteps {

    private final WebDriver driver = new ChromeDriver();

    static {
	System.setProperty("webdriver.chrome.driver", "D:/installables/chrome-driver/chromedriver.exe");
    }

    @Given("^I am on the Google search page$")
    public void iVisitGoogle() {
	driver.get("file:///D:/personal/code/bhasha-js/index.html");
    }

    @When("^I search for \"(.*)\"$")
    public void iSearchFor(String searchItem) {
	WebElement element = driver.findElement(By.name("q"));
	// Enter something to search for
	element.sendKeys(searchItem);
	// Now submit the form. WebDriver will find the form for us from the
	// element
	element.submit();
    }

    @Then("^the page title should start with \"(.*)\"$")
    public void theTotalPriceShouldBeC(String expectedString) {
	// Google's search is rendered dynamically with JavaScript.
	// Wait for the page to load, timeout after 10 seconds
	(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
	    public Boolean apply(WebDriver d) {
		return d.getTitle().toLowerCase().startsWith(expectedString);
	    }
	});

	assertTrue(driver.getTitle().toLowerCase().contains(expectedString));

    }

    @After
    public void closeBrowser() {
	driver.close();
    }

}
