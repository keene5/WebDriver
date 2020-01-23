import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class WebDriverRadioButtons {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "c:/dev/tools/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:63342/WebDriverDemo/webapp/RadioButtonTest.html");
        List<WebElement> radioButtons = driver.findElements(By.name("color"));
        radioButtons.get(1).click();
        radioButtons.forEach(webElement -> {
            if(webElement.isSelected()) {
                System.out.println(webElement.getAttribute("value"));
            }
        });
    };
}
