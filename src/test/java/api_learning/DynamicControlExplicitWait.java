package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import url.Urls;

import java.time.Duration;

public class DynamicControlExplicitWait implements Urls {

    public static void main(String[] args) {

        WebDriver driver = DriverFactory.getChromeDriver();

        try {
            driver.get(BASE_URL.concat(DYNAMIC_CONTROL_PAGE));

            // Find the checkbox-example form
            WebElement checkboxExample = driver.findElement(By.id("checkbox-example"));
            // Find the button in the checkbox-example form
            WebElement checkboxExampleFormBtnElem = checkboxExample.findElement(By.cssSelector("button"));
            checkboxExampleFormBtnElem.click();

            // Wait until checkbox disappeared | Explicitly Wait | Strategy 01
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10L));
//            wait.until(ExpectedConditions.invisibilityOf(checkboxExample.findElement(By.tagName("input"))));

            // Wait until msg appeared | Explicitly Wait | Strategy 02
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
            WebElement checkboxMsgElem = checkboxExample.findElement(By.id("message"));

            // Get the message content
            System.out.println(checkboxMsgElem.getText());

//            ==================================

            // input-example form
            // Find the input-example form
            WebElement inputExample = driver.findElement(By.id("input-example"));
            // Find the button in the input-example form
            WebElement inputExampleFormBtnElem = inputExample.findElement(By.cssSelector("button"));
            inputExampleFormBtnElem.click();

            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#input-example input")));
            inputExample.findElement(By.tagName("input")).sendKeys("Meow");

            Thread.sleep(3000);
            inputExampleFormBtnElem.getCssValue("background-color");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
