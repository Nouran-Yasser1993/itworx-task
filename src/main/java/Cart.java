import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.DataReader;

public class Cart {
    WebDriver cartDriver;

    public Cart(WebDriver driver) {
        cartDriver = driver;
    }

    public String getCartPrice() {
        cartDriver.findElement(By.xpath(DataReader.readElement("shoppingCartElement"))).click();
        String cartPrice = cartDriver.findElement(By.xpath(DataReader.readElement("shoppingCartPriceElement"))).getText();
        return cartPrice;
    }

}
