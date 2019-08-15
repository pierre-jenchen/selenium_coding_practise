package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AmazonResultPage extends AmazonStartPage {

    public AmazonResultPage (WebDriver driver) {
        super(driver);
    }

    public int countResults() {
        List<WebElement> results = fillResults();
        return results.size();
    }

    public AmazonProductPage clickOnResult() {
        List<WebElement> results = fillResults();
        int random = new Random().nextInt(results.size());
        WebElement selectedElement = results.get(random);
        WebElement description = selectedElement.findElement(By.tagName("h2")).findElement(By.tagName("a"));
        description.click();
        return new AmazonProductPage(driver);
    }

    public List<WebElement> fillResults() {
        List<WebElement> elems = driver.findElements(By.cssSelector("div[data-cel-widget]"));
        List<WebElement> results = new ArrayList<>();
        for (WebElement elem: elems) {
            if (elem.getAttribute("data-cel-widget").contains("search_result_")){
                results.add(elem);
            }
        }
        return results;
    }
}
