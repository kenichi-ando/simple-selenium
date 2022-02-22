package example;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SimpleSeleniumTest {
    @Test
    void testGoogleSearch() throws Exception {
        // Set "webdriver.chrome.driver" environment variable
        String path = System.getProperty("DRIVERPATH");
        if (path == null) {
            path = "/usr/bin/google-chrome";
        }
        System.setProperty("webdriver.chrome.driver", path);

        WebDriver driver = new ChromeDriver();
        driver.get("http://www.google.com/");
        Thread.sleep(1000);
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("ChromeDriver");
        searchBox.submit();
        Thread.sleep(1000);
        assertEquals("ChromeDriver - Google 検索", driver.getTitle());
        driver.quit();
    }
}
