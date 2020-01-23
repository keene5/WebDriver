import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverCheckboxes {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "c:/dev/tools/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:63342/WebDriverDemo/webapp/CheckboxTest.html");
		
		WebElement checkbox = driver.findElement(By.id("lettuceCheckbox"));
		
		checkbox.click();
		//checkbox.click();
	}

}
