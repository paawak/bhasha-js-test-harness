package com.swayam.bhasha.js.test.glue;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By.ById;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BanglaTypingSteps {

    private final WebDriver driver = new ChromeDriver();

    static {
	System.setProperty("webdriver.chrome.driver", "D:/installables/chrome-driver/chromedriver.exe");
    }

    @Given("^I am on the Bhasha editor$")
    public void iAmOnBhashaEditor() {
	driver.get("file:///D:/personal/code/bhasha-js/index.html");
    }

    @When("^I type \"(.*)\"$")
    public void iType(String searchItem) {
	WebElement indicTextEditor = driver.findElement(ById.id("indicTextEditor"));
	indicTextEditor.sendKeys(searchItem);
    }

    @Then("^Bhasha editor should display \"(.*)\"$")
    public void theTotalPriceShouldBeC(String expectedString) {
	WebElement indicTextEditor = driver.findElement(ById.id("indicTextEditor"));
	assertEquals(expectedString, indicTextEditor.getAttribute("value"));
    }

    @After
    public void closeBrowser() {
	driver.close();
    }

}
