import com.google.gson.internal.bind.util.ISO8601Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class app {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", System.getenv("CHROME_PATH"));
        //System.getenv("CHROME_PATH");
        System.getenv("CHROME_PATH");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.google.com");

        WebElement searchEntry = driver.findElement(By.name("q"));
        searchEntry.sendKeys("pluralsight");
        searchEntry.submit();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
//        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
//        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Images")));
        WebElement images = driver.findElements(By.linkText("Images")).get(0);
                images.click();
                WebElement imageElement = driver.findElements(By.cssSelector("#Hcm-_Q9i_RhQTM\\:")).get(0);
                imageElement.click();
    }
}
