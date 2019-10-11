package sample_Test;

import java.io.File;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class SeleniumBasics {
	static WebDriver driver;
	
	/***
	 * driver.get will wait till the whole page gets loaded and driver.
	 * navigate will just redirect to that page and will not wait. 
	 * ***/
	
	@Test (priority = 1)
	public void openBrowser() {
		String path = "driver/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path); 
		driver=new ChromeDriver();
		String url = "https://demo.stqatools.com";
		//driver.navigate().to(url);
		driver.get(url);
	}


	//Screen shots
	@Test(enabled = false)
	public void scnshot() {
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
	}

	//Get data from excel
	@Test(enabled = false)
	public void getExcelData() throws IOException {
		XSSFWorkbook srcBook = new XSSFWorkbook("C:\\Users\\spamulapati\\Desktop\\Sample.xlsx");  
		XSSFSheet sourceSheet = srcBook.getSheet("Sheet1");
		
		//Any approach we can follow
		/*
		 * XSSFRow sourceRow = sourceSheet.getRow(1); XSSFCell
		 * sourcecell=sourceRow.getCell(0); String
		 * userName=sourcecell.getStringCellValue();
		 * System.out.println("User name in excel is :"+userName);
		 */
		
		String usr = sourceSheet.getRow(1).getCell(0).getStringCellValue();
		String pwd = sourceSheet.getRow(1).getCell(1).getStringCellValue();
		System.out.println("user name :"+usr);
		System.out.println("pwd :"+pwd);
	}
	
	//Navigate Forward,Backword and Refresh
	@Test(enabled = false)
	public void test1() {
	driver.navigate().forward();	
	driver.navigate().back();
	driver.navigate().refresh();
	
	// To refresh the page
	Actions aton = new Actions(driver);
	aton.keyDown(Keys.CONTROL).sendKeys(Keys.F5).perform();
	}
	
	// How can we get the font size, font color, font type and background color using WebDriver
	@Test (enabled = true, priority = 2)
	public void lbldetails() {
		Dimension a = driver.findElement(By.id("studentname")).getSize();
		String ab = driver.findElement(By.id("studentname")).getAttribute("size");
		System.out.println("Dimension :"+a);
		System.out.println("size :"+ab);
		
		String fontsize = driver.findElement(By.xpath("//form[@name='StudentRegistration']/table/tbody/tr[13]/td[2]/input")).getCssValue("font-size");
		String fontcolor = driver.findElement(By.xpath("//form[@name='StudentRegistration']/table/tbody/tr[13]/td[2]/input")).getCssValue("font-colour");
		String fonttype = driver.findElement(By.xpath("//form[@name='StudentRegistration']/table/tbody/tr[13]/td[2]/input")).getCssValue("font-type");
		String bgcolor = driver.findElement(By.xpath("//form[@name='StudentRegistration']/table/tbody/tr[13]/td[2]/input")).getCssValue("background-colour");
		String color = driver.findElement(By.xpath("//form[@name='StudentRegistration']/table/tbody/tr[13]/td[2]/input")).getCssValue("color");
		
		System.out.println("Font size :"+fontsize);
		System.out.println("Font type :"+fonttype);
		System.out.println("Font color :"+fontcolor);
		System.out.println("Bag Ground color :"+bgcolor);
		System.out.println("Color :"+color);
		
		driver.close();
	}
	
	
}
