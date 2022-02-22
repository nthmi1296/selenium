package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageUrlTitle {

    public static void main(String[] args) throws InterruptedException {
        // class method | getChrome | WebDriver
        WebDriver driver = DriverFactory.getChromeDriver();

        try {
            // open target page | https://the-internet.herokuapp.com/login
            driver.get("https://the-internet.herokuapp.com/login");

            System.out.println(driver.getCurrentUrl());
            System.out.println(driver.getTitle());
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
