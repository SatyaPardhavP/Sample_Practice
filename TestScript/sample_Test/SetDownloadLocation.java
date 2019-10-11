package sample_Test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

public class SetDownloadLocation {
	
	static WebDriver driver;

	@Test (priority = 1)
	public void openBrowser() throws InterruptedException {	

		String path = "driver/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path);
		String filePath = System.getProperty("user.dir") + "\\downloads\\";
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();  
		chromePrefs.put("profile.default_content_settings.popups", 0);  
		chromePrefs.put("download.default_directory", filePath);  
		ChromeOptions options = new ChromeOptions();  
		options.setExperimentalOption("prefs", chromePrefs);  
		options.addArguments("--disable-notifications");  
		DesiredCapabilities cap = DesiredCapabilities.chrome();  
		cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);  
		cap.setCapability(ChromeOptions.CAPABILITY, options);  		
		
		driver = new ChromeDriver(options);     
		driver.manage().window().maximize();
		String url = "https://demo.stqatools.com";
		driver.navigate().to(url);
		
		driver.close();
	}

}
