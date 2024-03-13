package com.techx.core.hooks;

import com.techx.core.context.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.testng.Assert;

public class UiSteps {
    private TestContext context;
    private static final Logger LOGGER = Logger.getLogger(UiSteps.class);
    public UiSteps(TestContext context) {
        this.context = context;
    }

    @Given("Open browser with url {string}")
    public void openBrowser(String url){
        this.context.initContext();
        this.context.driver().openUrl(url);
    }
    @When("Type {string} to element {string}")
    public void typeToElement(String text, String elementLocator){
        this.context.driver().type(elementLocator, text);
    }
    @And("Submit element {string}")
    public void submitElement(String elementLocator){
        this.context.driver().click(elementLocator);
    }
    @And("Wait for element {string} to be clickable")
    public void waitElementToBeClickable(String elementLocator){
        this.context.waitUtils().waitForElementToBeClickable(elementLocator);
    }
    @And("Wait for element {string} value to be {string}")
    public void waitForElementValueToContainText(String elementLocator, String expectedValue){
        this.context.waitUtils().waitForElementValueToContainText(elementLocator, expectedValue);
    }
    @And("Wait for element {string} text to match regex {string}")
    public void waitForElementTextMatches(String elementLocator, String regex){
        this.context.waitUtils().waitForElementTextMatches(elementLocator, regex);
    }
    @And("Wait for element {string} text to contain {string}")
    public void waitForElementTextToContainText(String elementLocator, String subText){
        this.context.waitUtils().waitForElementTextToContainText(elementLocator, subText);
    }
    @And("Click element {string}")
    public void waitForElementTextToContainText(String elementLocator){
        this.context.driver().click(elementLocator);
    }
    @And("Read text of element {string} store as variable {string}")
    public void readTextFromElement(String elementLocator, String var){
        String text = this.context.driver().getText(elementLocator);
        this.context.setVar(var, text);
    }

    @And("Assert url start with {string}")
    public void assertUrlStartWith(String expUrlStreamsWith){
        String actualUrl = this.context.driver().getUrl();
        Assert.assertTrue(actualUrl.startsWith(expUrlStreamsWith), "Browser url '" + actualUrl + "' did not start with expected text '" + expUrlStreamsWith + "'");
    }

    @Given("Read page url to variable {string}")
    public void readPageUrlToVariable(String var){
        String url = this.context.driver().getUrl();
        this.context.setVar(var, url);
    }
    @And("Set browser {string}")
    public void setBrowser(String browserName){
        this.context.setVar("browser", browserName.toUpperCase());
    }
    @Given("Open {string} browser with url {string}")
    public void userOpenstheBrowserwithUrl(String browser, String url){
        setBrowser(browser);
        this.context.initContext();
        this.context.driver().openUrl(url);
    }
    @Then("Reload/Refresh (the )browser")
    public void reloadBrowser(){
        this.context.driver().refresh();
    }
    @Then("Close the browser")
    public void closeTheBrowser(){
        this.context.driver().closeBrowser();
        this.context.removeVar("WAIT_UTILS");
        this.context.removeVar("DRIVER");
    }
    @Then("Close all the browser windows")
    public void closeAllTheBrowsers(){
        this.context.driver().quitSession();
        this.context.removeVar("WAIT_UTILS");
        this.context.removeVar("DRIVER");
    }
}
