package sample_Test;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TabsAndWindows {
	static WebDriver driver;
	
	@Test (priority = 0,enabled = true)
	public void InvokeBrw() {
		String path = "driver/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path); 
		driver=new ChromeDriver();
		
	}
	
	@Test (priority = 1, enabled = false)
	public void tabs() throws InterruptedException {
		String url = "https://demo.stqatools.com/Tabs.php";
		driver.get(url);
		Thread.sleep(3000);
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		Thread.sleep(5000);
		driver.switchTo().window(tabs.get(0));
	}

	@Test (priority = 2, enabled = true)
	public void newWindow() throws InterruptedException {
		String url = "https://demo.stqatools.com/Windows.php";
		driver.get(url);
		Thread.sleep(3000);
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.findElement(By.xpath("//button[contains(text(),'New Message Window')]")).click();
		Thread.sleep(3000);
		//driver.switchTo().window(tabs.get(2));
		driver.switchTo().window(tabs.get(1));
		Thread.sleep(3000);
		System.out.println("Child window");
		driver.close();
		Thread.sleep(5000);
		driver.switchTo().window(tabs.get(0));
	}
	
}
