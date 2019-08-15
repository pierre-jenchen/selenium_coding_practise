package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AmazonProductPage extends AmazonStartPage {

    private By addCart = By.id("add-to-cart-button");

    AmazonProductPage(WebDriver driver) {
        super(driver);
    }

    public void addToCart() {
        this.click(addCart);
    }

    public boolean isInCart() {
        this.pageLoaded();
        return driver.findElement(By.className("a-alert-success")).isDisplayed() || driver.findElement(By.className("a-icon-success")).isDisplayed();
    }

}
