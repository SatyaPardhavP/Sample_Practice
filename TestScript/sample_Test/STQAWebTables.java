package sample_Test;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class STQAWebTables {
	static WebDriver driver;
	
	@Test (priority = 00)
	public void InvokeBrw() {
		String path = "driver/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path); 
		driver=new ChromeDriver();
		String url = "https://demo.stqatools.com/WebTable.php";
		driver.get(url);
	ArrayList<String> abcd =	getRowdata();
	System.out.println("Array data :"+abcd);
	}
	
	@Test (priority=01)
	public void rowsize() {
		List<WebElement> listrow = driver.findElements(By.xpath("//table[@class='table table-hover table-responsive table-list-search']/tbody/tr/td[2]"));
		int rowsize = listrow.size();
		System.out.println("Row size :"+rowsize);
	}
	@Test (priority=02)
	public void columnsize() {
		List<WebElement> list1 = driver.findElements(By.xpath("//table[@class='table table-hover table-responsive table-list-search']/tbody/tr[2]/td"));
		int colsize = list1.size();
		System.out.println("Column size :"+colsize);
	}
	@Test (priority=03, enabled = false)
	public void webtable() {
		List<WebElement> list = driver.findElements(By.xpath("//table[@class='table table-hover table-responsive table-list-search']/tbody/tr/td[2]"));
		int rowsize = list.size();
		System.out.println("Row size :"+rowsize);
		for (int i = 1; i <= rowsize; i++) {
			String abc = driver.findElement(By.xpath("//table[@class='table table-hover table-responsive table-list-search']/tbody/tr["+i+"]/td[2]")).getText();
			//System.out.println("Rows data :"+abc);
		//	System.out.println("I value is :"+i);
			if (abc.contentEquals("Rahul")) {
				System.out.println("Rahul name is identified");
			//	driver.findElement(By.xpath("//tr[@id='d2']//td[5]/button")).click();
			}
		}
	}
	@Test (priority=04,enabled = false)
	public void webtable1() {
		List<WebElement> list = driver.findElements(By.xpath("//table[@class='table table-hover table-responsive table-list-search']/tbody/tr/td[2]"));
		int rowsize = list.size();
		System.out.println("Row size :"+rowsize);				
		for (int i = 1; i <= rowsize; i++) {
			List<WebElement> list1 = driver.findElements(By.xpath("//table[@class='table table-hover table-responsive table-list-search']/tbody/tr[2]/td"));
			int colsize = list1.size();
			System.out.println("Column size :"+colsize);
			for (int j = 1; j <= colsize; j++) {				
			String abc = driver.findElement(By.xpath("//table[@class='table table-hover table-responsive table-list-search']/tbody/tr["+i+"]/td["+j+"]")).getText();
			System.out.println("Row and Column data :"+abc);
			}
		}
	}
	
//	@Test (priority = 05, enabled = true)
	public static ArrayList<String> getRowdata(){
		List<WebElement> list = driver.findElements(By.xpath("//table[@class='table table-hover table-responsive table-list-search']/tbody/tr"));
		ArrayList<String> rowdata = new ArrayList<String>();
		for (int i = 1; i <= list.size(); i++) {
			rowdata.add(driver.findElement(By.xpath("//table[@class='table table-hover table-responsive table-list-search']/tbody/tr["+i+"]/td[1]")).getText());
			rowdata.add(driver.findElement(By.xpath("//table[@class='table table-hover table-responsive table-list-search']/tbody/tr["+i+"]/td[2]")).getText());
			rowdata.add(driver.findElement(By.xpath("//table[@class='table table-hover table-responsive table-list-search']/tbody/tr["+i+"]/td[3]")).getText());
			rowdata.add(driver.findElement(By.xpath("//table[@class='table table-hover table-responsive table-list-search']/tbody/tr["+i+"]/td[4]")).getText());			
		}
		return rowdata;
		
	}
	
	
}
