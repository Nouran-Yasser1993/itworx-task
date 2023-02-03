import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import util.DataReader;

import java.util.List;

public class Bracelets {
    WebDriver braceletsDriver;

    public Bracelets(WebDriver driver) {
        braceletsDriver = driver;
    }

    public String getPageTitle() {
        String pageName = braceletsDriver.getTitle();
        return pageName;
    }

    public void search() {
        braceletsDriver.findElement(By.name("search")).sendKeys("fa" + Keys.ENTER);
    }

    public boolean checkSearchResults() {
        List<WebElement> searchResults = braceletsDriver.findElements(By.xpath(DataReader.readElement("listOfResultsElements")));
        boolean returnResult = false;
        for (WebElement searchResult : searchResults) {
            String actualText = searchResult.getText();
            returnResult = actualText.startsWith("Fa");

        }
        return returnResult;
    }

    public void addToCart() {
        braceletsDriver.findElement(By.xpath(DataReader.readElement("addToCartElement"))).click();
    }

    public String getBraceletsPrice() {
        String price = braceletsDriver.findElement(By.xpath(DataReader.readElement("braceletsPriceElement"))).getText();
        return price;
    }


}
