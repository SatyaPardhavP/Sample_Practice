package sample_Test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AutoCompleteExample_Frame {
	WebDriver driver;
	WebDriverWait wait;

	String URL = "http://jqueryui.com/autocomplete/";
	private By frameLocator = By.className("demo-frame");
	private By tagText = By.id("tags");

	@BeforeClass
	public void InvokeBrw() {
		String path = "driver/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path); 
		driver=new ChromeDriver();
	}

	@Test
	public void autoClick() throws InterruptedException {
	//	driver.navigate().to(URL);
		driver.get(URL);
		
		System.out.println("wait");
		WebElement frameElement=driver.findElement(frameLocator);
		Thread.sleep(5000);
		driver.switchTo().frame(frameElement);
		Thread.sleep(5000);
		System.out.println("Navigate to Frame");
	//	wait.until(ExpectedConditions.presenceOfElementLocated(tagText));
		Thread.sleep(5000);
		WebElement textBoxElement = driver.findElement(tagText);
		System.out.println("Navigate to frame1");
		textBoxElement.sendKeys("a");
		selectOptionWithText("Java");
	}

	public void selectOptionWithText(String textToSelect) {
		try {
			WebElement autoOptions = driver.findElement(By.id("ui-id-1"));
			wait.until(ExpectedConditions.visibilityOf(autoOptions));

			List<WebElement> optionsToSelect = autoOptions.findElements(By.tagName("li"));
			for(WebElement option : optionsToSelect){
				if(option.getText().equals(textToSelect)) {
					System.out.println("Trying to select: "+textToSelect);
					option.click();
					break;
				}
			}

		} catch (NoSuchElementException e) {
			System.out.println(e.getStackTrace());
		}
		catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}
}
