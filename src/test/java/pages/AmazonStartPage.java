package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;
import java.util.Random;

public class AmazonStartPage extends BasePage{

    @FindBy(id="twotabsearchtextbox")
    WebElement searchbox;

    public AmazonStartPage(WebDriver driver) {
        super(driver);
    }

    public void fillSearch(String searchElement) {
        searchbox.sendKeys(searchElement);
    }

    public AmazonResultPage search(String searchElement) {
        searchbox.sendKeys(searchElement);
        searchbox.sendKeys(Keys.RETURN);
        return new AmazonResultPage(driver);
    }

    public AmazonResultPage clickOnSuggestions() {
        waitVisibility(By.className("s-suggestion"));
        List<WebElement> suggestions = driver.findElement(By.id("suggestions")).findElements(By.className("s-suggestion"));
        int random = new Random().nextInt(suggestions.size());
        WebElement suggestion = suggestions.get(random);
        suggestion.click();
        return new AmazonResultPage(driver);
    }
}
