package sample_Test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Sleeper;
import org.testng.annotations.Test;



public class UploadFile {
	static WebDriver driver;
	
	@Test (priority = 1)
	public void openBrowser() {
		String path = "driver/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path); 
		driver=new ChromeDriver();
		String url = "https://demo.stqatools.com/fileupload.php";
		driver.navigate().to(url);
	}
	
	// By using Keyboard (drawback is file explorer window is not closed)
	@Test (priority = 2, enabled = false)
	public void fileupload() throws InterruptedException {
	//	driver.findElement(By.id("fileToUpload")).click();
	//	driver.findElement(By.id("fileToUpload")).sendKeys("C:\\Users\\spamulapati\\Desktop\\Invoice.pdf");
		Thread.sleep(3000);
		WebElement abc = driver.findElement(By.id("fileToUpload"));
		Thread.sleep(2000);
		abc.click();
		Thread.sleep(2000);
		abc.sendKeys("C:\\Users\\spamulapati\\Desktop\\Invoice.pdf");
		Thread.sleep(2000);
		abc.sendKeys(Keys.ENTER);		
	}
	
	//Robot class
	@Test (priority = 3, enabled = true)
	public void fileUploadRobot() throws InterruptedException, AWTException {
		Thread.sleep(2000);
		driver.findElement(By.id("fileToUpload")).click();
		Thread.sleep(2000);
		String filePath = "C:\\Users\\spamulapati\\Desktop\\Invoice.pdf";
		
		StringSelection stringSelection = new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		Thread.sleep(2000);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
	
	//AutoIT
	@Test(priority = 4, enabled = false)
	public void AutoITFile() {
		/*
		 * ControlFocus("Open","","Edit1"); ControlSetText("Open","","Edit1",
		 * "C:\\Users\\spamulapati\\Desktop\\Invoice.pdf");
		 * ControlClick("Open","","Button1"); Sleep(2000);
		 */
	}
	
	@Test (priority = 5)
	public void brwClose() {
		driver.close();
	}
}
