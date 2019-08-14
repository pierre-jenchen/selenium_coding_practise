package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AmazonResultPage extends AmazonStartPage {

    public AmazonResultPage (WebDriver driver) {
        super(driver);
    }

    public int countResults() {
        //waitVisibility(By.className("sg-col-inner"));
        List<WebElement> results = driver.findElements(By.cssSelector("div[data-cel-widget]"));
        int counter = 0;
        for (WebElement elem: results) {
            if (elem.getAttribute("data-cel-widget").contains("search_result_")){
                counter++;
            }
        }
        return counter;
    }
}
