package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AmazonStartPage extends BasePage{

    By searchBox = By.id("twotabsearchtextbox");
    By cart = By.id("nav-cart");

    public AmazonStartPage(WebDriver driver) {
        super(driver);
    }

    public void fillSearch(String searchElement) {
        this.writeText(searchBox, searchElement);
    }

    public AmazonResultPage search(String searchElement) {
        this.writeText(searchBox, searchElement);
        this.enter(searchBox);
        return new AmazonResultPage(driver);
    }

    public AmazonResultPage clickOnSuggestion() {
        waitVisibility(By.className("s-suggestion"));
        List<WebElement> suggestions = driver.findElement(By.id("suggestions")).findElements(By.className("s-suggestion"));
        int random = new Random().nextInt(suggestions.size());
        WebElement suggestion = suggestions.get(random);
        suggestion.click();
        return new AmazonResultPage(driver);
    }

    public void goToCart(){
        this.click(cart);
    }
}
