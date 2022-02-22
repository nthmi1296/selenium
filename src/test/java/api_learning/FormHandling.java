package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FormHandling {

    public static void main(String[] args) throws InterruptedException {
        // class method | getChrome | WebDriver
        WebDriver driver = DriverFactory.getChromeDriver();

        try {
            // open target page | https://the-internet.herokuapp.com/login
            driver.get("https://the-internet.herokuapp.com/login");

            // Find username/password Element by using username selector
            // POST /session/{sessionID}/element --- {selector: ...}
            WebElement usernameElem = driver.findElement(By.id("username"));
            WebElement passwordElem = driver.findElement(By.cssSelector("#password"));

            // Input username and password
            usernameElem.sendKeys("meow");
            passwordElem.sendKeys("12345678");

            WebElement clickLoginBtnElem = driver.findElement(By.cssSelector("#login button[type='submit'']"));
            clickLoginBtnElem.click();

            Thread.sleep(3000);
        } catch (Exception ignored) {

        } finally {
            // Quit driver session
            driver.quit();
        }
    }
}
