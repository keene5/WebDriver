import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverTables {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "c:/dev/tools/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:63342/WebDriverDemo/webapp/TableTest.html");
		
		//WebElement outerTable = driver.findElement(By.tagName("table"));
		//WebElement innerTable = outerTable.findElement(By.tagName("table"));
		//WebElement row = innerTable.findElements(By.tagName("td")).get(1);
		//System.out.println(row.getText());

		// note you can get the xpath by inspecting the element
		WebElement row = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[2]/table/tbody/tr[2]/td"));
	// in console you can see we dot the correct data
	System.out.println(row.getText());
	}
}
