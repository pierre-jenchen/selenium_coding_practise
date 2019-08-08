import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AmazonTest {


    WebDriver webDriver;

    @Before
    public void  setup() {
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        this.webDriver = new ChromeDriver();
        webDriver.get("https://www.amazon.de");

    }

    @Test
    public void myFirstTest() throws InterruptedException {

        webDriver.findElement(By.id("twotabsearchtextbox")).sendKeys("Selenium");
        Thread.sleep(4000);
        webDriver.findElement(By.id("suggestions")).findElements(By.className("s-suggestion")).get(3).click();
        Thread.sleep(4000);
        List<WebElement> results = webDriver.findElements(By.cssSelector("div[data-cel-widget]"));
        int counter = 0;
        for (WebElement elem: results) {
            if (elem.getAttribute("data-cel-widget").contains("search_result_")){
                counter++;
            }
        }
        Assert.assertTrue(counter > 14);
    }

    @Test
    public void mySecondTest() throws InterruptedException {
        webDriver.findElement(By.id("twotabsearchtextbox")).sendKeys("Selenium");
        webDriver.findElement(By.id("twotabsearchtextbox")).sendKeys(Keys.RETURN);
        Thread.sleep(4000);
        List<WebElement> elems = webDriver.findElements(By.cssSelector("div[data-cel-widget]"));
        Thread.sleep(4000);
        List<WebElement> results = new ArrayList<WebElement>();
        for (WebElement elem: elems) {
            if (elem.getAttribute("data-cel-widget").contains("search_result_")){
                results.add(elem);
            }
        }
        int random = new Random().nextInt(results.size());
        results.get(random).click();
        Thread.sleep(4000);
        webDriver.findElement(By.id("add-to-cart-button")).click();
        Thread.sleep(4000);
        Assert.assertTrue(webDriver.findElement(By.className("a-alert-success")).isDisplayed());
    }


    @After
    public void shutDown() {
        webDriver.close();
    }
}
