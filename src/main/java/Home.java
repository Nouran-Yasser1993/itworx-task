import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.DataReader;

import java.time.Duration;

public class Home {
    WebDriver homeDriver;
    public Home(WebDriver driver) {
        homeDriver= driver;

    }

   public void goToHomePage()
    {
        homeDriver.get("https://demo.themeparrot.com/shopy/");
        WebElement element =
                homeDriver.findElement(new By.ByXPath(DataReader.readElement("catalogueElement")));
        Actions action = new Actions(homeDriver);
        action.moveToElement(element).perform();

        WebElement firstResult = new WebDriverWait(homeDriver, Duration.ofSeconds(20))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(DataReader.readElement("braceletsElement"))));


        JavascriptExecutor j = (JavascriptExecutor) homeDriver;
        j.executeScript("arguments[0].click();", firstResult);
    }
}
