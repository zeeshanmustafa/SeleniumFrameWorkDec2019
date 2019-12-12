package testBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestBase{
	public WebDriver driver;

	@BeforeTest
	public void intializeThis() throws IOException {

		Properties prop = new Properties();

		String projectlocation = System.getProperty("user.dir");
		String configPath = projectlocation + "/Resources/data.properties/";
		// System.out.println(configPath);

		// here we have the location of the property
		FileInputStream fis = new FileInputStream(configPath);

		// here we load the file
		prop.load(fis);

		String browserName = prop.getProperty("browser");
		String urlName = prop.getProperty("url");
		int implicitWaitTime = Integer.parseInt(prop.getProperty("implicitWait"));

		if (browserName.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver", "/Users/Zeeshan/Documents/chromedriver");
			driver = new ChromeDriver();
			driver.get(urlName);
			driver.manage().timeouts().implicitlyWait(implicitWaitTime, TimeUnit.SECONDS);
		
		} else 
			
			if (browserName.equalsIgnoreCase("firefox")) {

			System.setProperty("webdriver.chrome.driver", "/Users/Zeeshan/Documents/chromedriver");
			driver = new ChromeDriver();
			driver.get(urlName);
			driver.manage().timeouts().implicitlyWait(implicitWaitTime, TimeUnit.SECONDS);
		} else

		if (browserName.equalsIgnoreCase("internetExplorer")) {

			System.setProperty("webdriver.chrome.driver", "/Users/Zeeshan/Documents/chromedriver");
			driver = new ChromeDriver();
			driver.get(urlName);
			driver.manage().timeouts().implicitlyWait(implicitWaitTime, TimeUnit.SECONDS);
		}
	
	}
	
	@AfterTest
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(5000);
		
		driver.close();
		driver.quit();
	}

		
}
