package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import url.Urls;

import java.util.List;

public class DynamicControl implements Urls {

    public static void main(String[] args) {

        WebDriver driver = DriverFactory.getChromeDriver();

        try {
            driver.get(BASE_URL.concat(DYNAMIC_CONTROL_PAGE));

            // Get list of button on the page
            List<WebElement> btnElems = driver.findElements(By.cssSelector("button"));

            final int REMOVE_SESSION_BTN_INDEX = 0;
            final int ENABLE_SESSION_BTN_INDEX = 1;

            btnElems.get(REMOVE_SESSION_BTN_INDEX).click();
            btnElems.get(ENABLE_SESSION_BTN_INDEX).click();

            System.out.println(btnElems.size());

            //
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
