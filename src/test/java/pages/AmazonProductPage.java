package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AmazonProductPage extends AmazonStartPage {

    By addCart = By.id("add-to-cart-button");

    public AmazonProductPage(WebDriver driver) {
        super(driver);
    }

    public void addToCart() {
        this.click(addCart);
    }

    public boolean isInCart() {
        this.pageLoaded();
        return true;
    }

}
