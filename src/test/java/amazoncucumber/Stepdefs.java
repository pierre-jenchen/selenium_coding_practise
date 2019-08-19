package amazoncucumber;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.After;
import org.junit.Assert;
import cucumber.api.java.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.AmazonProductPage;
import pages.AmazonResultPage;
import pages.AmazonStartPage;
import pages.BasePage;

public class Stepdefs {
    public static WebDriver webDriver;
    AmazonResultPage resultPage;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver"); // Linux: /usr/bin/chromedriver MacOS: /Users/bit/bin/chromedriver
        this.webDriver = new ChromeDriver();
        webDriver.get("https://www.amazon.de");
    }

    @Given("User is on Amazon starting page")
    public void user_is_on_Amazon_starting_page() {
        new AmazonStartPage(webDriver).isOnStartPage();
    }

    @When("^Enter \"([^\"]*)\" in search box$")
    public void enter_in_search_box(String search) {
        new AmazonStartPage(webDriver).fillSearch(search);
    }

    @When("^Press key \"([^\"]*)\"$")
    public void press_key(String key) {
        new AmazonStartPage(webDriver).enter(By.id("twotabsearchtextbox"));
    }

    @Then("^Search results should be visible$")
    public void search_results_should_be_visible() throws Throwable {
        resultPage = new AmazonResultPage(webDriver);
    }

    @Then("^There are more than (\\d+) search results$")
    public void there_are_more_than_search_results(int count) {
        resultPage.pageLoaded();
        Assert.assertTrue(resultPage.countResults() > count);
    }

    @When("^Click on \"([^\"]*)\"-button$")
    public void click_on_button(String button) {
        switch (button) {
            case "search":
                new AmazonStartPage(webDriver).click(By.className("nav-input"));
                return;

            case "Add to cart":
                AmazonProductPage productPage = new AmazonProductPage(webDriver);
                productPage.pageLoaded();
                productPage.addToCart();
        }
    }

    @When("^A Random item is opened$")
    public void a_Random_item_is_opened() throws Throwable {
        resultPage = new AmazonResultPage(webDriver);
        resultPage.pageLoaded();
        resultPage.clickOnResult();
    }

    @Then("^Item Details should be visible$")
    public void item_Details_should_be_visible() {
        AmazonProductPage productPage = new AmazonProductPage(webDriver);
        Assert.assertTrue(productPage.detailsVisible());

    }

    @Then("^Success Message should be visible$")
    public void success_Message_should_be_visible() throws Throwable {
        AmazonProductPage productPage = new AmazonProductPage(webDriver);
        Assert.assertTrue(productPage.isInCart());
    }

    @After
    public void shutDown() {
        webDriver.close();
    }

}
