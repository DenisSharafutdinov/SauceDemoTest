import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.time.Duration;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;

public class SauceDemoTests {
    WebDriver webDriver;

    @BeforeTest
    public void beforeTest(){
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(25));
    }

    @Test
    public void firstTest(){

        By origin = By.xpath("//*[@id=\"user-name\"]");
        By where = By.xpath("//*[@id=\"password\"]");
        By button = By.xpath("//*[@id=\"login-button\"]");


        By noWay = By.xpath("//*[@id=\"header_container\"]/div[2]");


        webDriver.get("https://www.saucedemo.com/");

        webDriver.findElement(origin).sendKeys("standard_user");
        webDriver.findElement(where).sendKeys("secret_sauce");
        webDriver.findElement(button).click();



        Assert.assertEquals(webDriver.findElement(noWay).getText(), "Products");

    }
    @Test
    public void secondTest(){

        By origin = By.xpath("//*[@id=\"user-name\"]");
        By where = By.xpath("//*[@id=\"password\"]");
        By button = By.xpath("//*[@id=\"login-button\"]");

        webDriver.get("https://www.saucedemo.com/");

        webDriver.findElement(origin).sendKeys("standard_user");
        webDriver.findElement(where).sendKeys("not_secret_sauce");
        webDriver.findElement(button).click();

    }
    @Test
    public void thirdTest(){

        By origin = By.xpath("//*[@id=\"user-name\"]");
        By where = By.xpath("//*[@id=\"password\"]");

        By button = By.xpath("//*[@id=\"login-button\"]");
        By buttonTwo = By.xpath("//*[@id=\"add-to-cart-sauce-labs-bolt-t-shirt\"]");

        By buttonThree = By.xpath("//*[@id=\"shopping_cart_container\"]/a");
        By noWay = By.xpath("//*[@id=\"header_container\"]/div[2]/span");


        webDriver.get("https://www.saucedemo.com/");

        webDriver.findElement(origin).sendKeys("standard_user");
        webDriver.findElement(where).sendKeys("secret_sauce");

        webDriver.findElement(button).click();
        webDriver.findElement(buttonTwo).click();
        webDriver.findElement(buttonThree).click();



        Assert.assertEquals(webDriver.findElement(noWay).getText(), "Your Cart");

    }
    @AfterTest
    public void afterTest(){
        webDriver.quit();
    }
}
