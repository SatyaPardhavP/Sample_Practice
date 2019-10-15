package sample_Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class STQARegistrationForm {
	static WebDriver driver;

	@Test (priority = 0,enabled = true)
	public void InvokeBrw() {
		String path = "driver/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path); 
		driver=new ChromeDriver();
		String url = "https://demo.stqatools.com/index.php";
		driver.get(url);
	}

	@Test (priority = 1, enabled = true)
	public void browserAccept() throws InterruptedException {
		Thread.sleep(4000);
		driver.findElement(By.xpath("//form[@name='StudentRegistration']//table/tbody/tr[13]/td[2]/input")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		System.out.println("Accept");
	}
	
	@Test (priority = 2, enabled = true)
	public void enrRegistrationForm() {
		driver.findElement(By.id("studentname")).sendKeys("Satya");
		driver.findElement(By.xpath("//form[@name='StudentRegistration']//table/tbody//tr[6]//td[1]")).click();
	Select sel = new Select(driver.findElement(By.xpath("//form[@name='StudentRegistration']//table/tbody//tr[7]/td[2]/select")));
	sel.selectByIndex(1);
	sel.selectByValue("Patna");
	sel.selectByVisibleText("GOA");
	driver.findElement(By.xpath("//form[@name='StudentRegistration']//table/tbody/tr[13]/td[2]/input")).click();
	
	driver.close();
	}
}

