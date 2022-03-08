package tool;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ToolTipProject {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		WebElement toolTipBox = driver.findElement(By.xpath("//h5[text()='Tool Tip']"));
		toolTipBox.click();

		WebElement tooltip = driver.findElement(By.xpath("//input[@title='Enter your Name']"));

		Actions a = new Actions(driver);
		a.moveToElement(tooltip).build().perform();
		String attribute = tooltip.getAttribute("title");
		System.out.println(attribute);

		tooltip.sendKeys("Aravinth");
		System.out.println(tooltip.getAttribute("value"));

	}

}
