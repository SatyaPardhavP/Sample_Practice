package sample_Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class STQAAlerts {
	static WebDriver driver;

	@Test (priority = 0,enabled = true)
	public void InvokeBrw() {
		String path = "driver/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path); 
		driver=new ChromeDriver();
	//	String url = "https://demo.stqatools.com/Alerts.php";
		String url = "https://demo.stqatools.com/Tabs.php";
		driver.get(url);
	}

	//Bootstrap Alert's
	//Basic Alert
	@Test (priority = 1,enabled = false)
	public void basicAlert() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.id("btnAlert")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@id='ezAlerts-footer']/button")).click();
		Thread.sleep(3000);
	}

	//Confirm Alert
	@Test (priority = 2,enabled = false)
	public void confirmAlert() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.id("btnConfirm")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("ezok-btn")).click();
		Thread.sleep(3000);
	}

	//Prompt Alert
	@Test (priority = 3,enabled = false)
	public void promptAlert() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.id("btnPrompt")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("prompt")).sendKeys("Prompt");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@id='ezAlerts-footer']/button")).click();
		Thread.sleep(2000);
		String abc = driver.findElement(By.id("ezAlerts-message")).getText();
		System.out.println("Entered text in prompt is:"+abc);
		driver.findElement(By.xpath("//div[@id='ezAlerts-footer']/button")).click();
		driver.close();
	}
	
	//Java script alerts
	@Test (priority = 4,enabled = false)
	public void jConfirmAlert() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.id("jcalert")).click();
		Thread.sleep(3000);
		driver.switchTo().alert().dismiss();
		Thread.sleep(3000);
		driver.findElement(By.id("jpalert")).click();
		Thread.sleep(3000);
		driver.switchTo().alert().sendKeys("Satya");
		Thread.sleep(3000);
	//	driver.switchTo().alert().accept();
	}
	
	
}
