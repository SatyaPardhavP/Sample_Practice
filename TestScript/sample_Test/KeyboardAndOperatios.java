package sample_Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class KeyboardAndOperatios {

	static WebDriver driver;

	@Test (priority = 00)
	public void InvokeBrw() {
		String path = "driver/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path); 
		driver=new ChromeDriver();
		String url = "https://demo.stqatools.com";
		driver.get(url);
	}
	
	@Test (priority = 01)
	public void mouseover() throws InterruptedException {
		Thread.sleep(8000);
		driver.findElement(By.xpath("//a[contains(text(),'Interactions')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(text(),'Mouse Hover')]")).click();
		Thread.sleep(3000);
		WebElement MouseToHour = driver.findElement(By.xpath("//button[@class='dropbtn']"));
		WebElement KeyClick = driver.findElement(By.xpath("//a[contains(text(),'Link 2')]"));
		Actions act = new Actions(driver);
	//	act.moveToElement(MouseToHour).click(KeyClick).build().perform();
		act.moveToElement(MouseToHour).build().perform();
		System.out.println("Mouse");
	}
}
