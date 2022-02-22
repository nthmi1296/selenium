package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinkText {

    public static void main(String[] args) throws InterruptedException {
        // class method | getChrome | WebDriver
        WebDriver driver = DriverFactory.getChromeDriver();

        try {
            // open target page | https://the-internet.herokuapp.com/login
            driver.get("https://the-internet.herokuapp.com/login");

            WebElement poweredByLinkText = driver.findElement(By.linkText("Elemental Selenium"));
            String linkText = poweredByLinkText.getText();
            String linkHref = poweredByLinkText.getAttribute("href");
            HyperLink hyperLink = new HyperLink(linkHref, linkText);

            System.out.println(hyperLink.text());
            System.out.println(hyperLink.link());

        } catch (Exception ignored) {

        } finally {
            // Quit driver session
            driver.quit();
        }
    }

    public static class HyperLink {
        private String link;
        private String text;

        public HyperLink(String link, String text) {
            this.link = link;
            this.text = text;
        }

        public String link() {
            return link;
        }

        public String text() {
            return text;
        }
    }
}
