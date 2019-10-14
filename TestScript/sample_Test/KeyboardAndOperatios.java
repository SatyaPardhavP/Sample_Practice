package sample_Test;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class KeyboardAndOperatios {

	static WebDriver driver;

	@Test (priority = 00)
	public void InvokeBrw() {
		String path = "driver/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path); 
		driver=new ChromeDriver();
		//driver.manage().window().maximize();

	}

	@Test (priority = 01,enabled = false)	
	public void mouseover() throws InterruptedException {
		String url = "https://demo.stqatools.com";
		driver.get(url);
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

	@Test (priority = 01,enabled = false)
	public void dropDown() throws InterruptedException {
		String url = "https://demo.stqatools.com/index.php";
		driver.get(url);
		Select sel = new Select(driver.findElement(By.xpath("//form[@name='StudentRegistration']/table/tbody/tr[7]/td[2]/select")));
		Thread.sleep(3000);
		sel.selectByIndex(1);
		Thread.sleep(3000);
		sel.selectByValue("Mumbai");
		Thread.sleep(3000);
		sel.selectByVisibleText("GOA");

		//	String abc = driver.findElement(By.xpath("//form[@name='StudentRegistration']/table/tbody/tr[7]/td[2]")).getText();
		//	System.out.println("Dropdown selected value:" +abc);
	}
	
	@Test (priority = 02,enabled = false)
	public void mouseDrapAndDrop() throws InterruptedException {
		String url = "https://demo.stqatools.com/Drag&Drop.php";
		driver.get(url);
		Thread.sleep(3000);
		Actions act = new Actions(driver);
		WebElement drag = driver.findElement(By.xpath("//img[@id='dragA']"));
		Thread.sleep(3000);
		WebElement drop = driver.findElement(By.xpath("//div[@id='dropBox']"));
		Thread.sleep(3000);
		act.dragAndDrop(drag, drop).build().perform();		
		Thread.sleep(3000);		
	}
	
	@Test (priority = 03,enabled = false)
	public void doubleClick() throws InterruptedException {
		String url = "https://demo.stqatools.com/DoubleClick.php";
		driver.get(url);
		Thread.sleep(3000);
		Actions act = new Actions(driver);
		WebElement drag = driver.findElement(By.xpath("//button[contains(text(),'Click Me / Double Click Me!')]"));
		Thread.sleep(3000);
		//act.doubleClick(drag).perform();	
		act.doubleClick(drag).perform();
		Thread.sleep(3000);			
	}
	@Test (priority = 04,enabled = true)
	public void rightClick() throws InterruptedException {
		String url = "https://demo.stqatools.com/WebTable.php";
		driver.get(url);
		Thread.sleep(3000);
		Actions act = new Actions(driver);
		WebElement drag = driver.findElement(By.id("system-search"));
		Thread.sleep(3000);
		//act.doubleClick(drag).perform();	
		act.contextClick(drag).perform();
		Thread.sleep(3000);			
	}
}
