import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.AmazonProductPage;
import pages.AmazonResultPage;
import pages.AmazonStartPage;

public class AmazonTestPageObject {

    WebDriver webDriver;

    @Before
    public void  setup() {
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver"); // Linux: /usr/bin/chromedriver MacOS: /Users/bit/bin/chromedriver
        this.webDriver = new ChromeDriver();
        webDriver.get("https://www.amazon.de");
    }

    @Test
    public void myFirstTest() {
        AmazonStartPage startPage = new AmazonStartPage(webDriver);
        startPage.fillSearch("Selenium");
        AmazonResultPage resultPage = startPage.clickOnSuggestion();
        resultPage.pageLoaded();
        Assert.assertTrue(resultPage.countResults() > 14);
    }

    @Test
    public void mySecondTest() {
        AmazonStartPage startPage = new AmazonStartPage(webDriver);
        AmazonResultPage resultPage = startPage.search("Selenium");
        resultPage.pageLoaded();
        AmazonProductPage productPage = resultPage.clickOnRandomItem();
        productPage.addToCart();
        Assert.assertTrue(productPage.isInCart());
    }

    @After
    public void shutDown() {
        webDriver.close();
    }
}
