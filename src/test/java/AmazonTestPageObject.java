import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
        AmazonResultPage resultPage = startPage.clickOnSuggestions();
        resultPage.pageLoaded();
        Assert.assertTrue(resultPage.countResults() > 14);
    }

    @After
    public void shutDown() {
        webDriver.close();
    }
}
