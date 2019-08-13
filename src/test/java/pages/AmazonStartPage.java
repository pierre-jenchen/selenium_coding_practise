package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AmazonStartPage extends BasePage{

    public AmazonStartPage(WebDriver driver) {
        super(driver);
    }

    String baseURL = "http://www.amazon.de";

    By searchbox = By.id("twotabsearchtextbox");
    By suggestions = By.id("suggestions");
    
}
