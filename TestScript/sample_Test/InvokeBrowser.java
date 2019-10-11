package sample_Test;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class InvokeBrowser {
	static WebDriver driver;

	@Test (priority = 00)
	public void InvokeBrw() {
		String path = "driver/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path); 
		driver=new ChromeDriver();
	}
	
	@Test (priority = 01)
	public void printInkBrw() {
	System.out.println("Chrome Browser Invoked");	
	driver.manage().window().maximize();
	Dimension abc = driver.manage().window().getSize();
	Point abcd=driver.manage().window().getPosition();
	System.out.println("Dimension of screen size :"+abc);
	System.out.println("Get Position :"+abcd);
	}
	
	@Test (priority = 02)
	public void brwClose() {
		driver.close();
	}
}
