import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DemoScenarios {
    WebDriver driver;
    Home homePage;
    Cart cartPage;
    Bracelets braceletsPage;

    @BeforeClass
    void setup() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\" + "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        homePage = new Home(driver);
        cartPage = new Cart(driver);
        braceletsPage = new Bracelets(driver);
    }

    @Test
    void checkBraceletsJourney() {

        homePage.goToHomePage();


        Assert.assertEquals(braceletsPage.getPageTitle(), "Bracelets");

        braceletsPage.search();

        Assert.assertTrue(braceletsPage.checkSearchResults());

        braceletsPage.addToCart();

        Assert.assertEquals(braceletsPage.getBraceletsPrice(), cartPage.getCartPrice());


    }


}
