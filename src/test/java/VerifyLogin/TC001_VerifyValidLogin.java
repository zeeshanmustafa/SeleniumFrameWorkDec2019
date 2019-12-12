package VerifyLogin;

import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.frameWork.pages.SignOnPage;

import testBase.TestBase;

public class TC001_VerifyValidLogin extends TestBase {

	@Test
	public void validLogin() throws InterruptedException {

		SignOnPage sp = PageFactory.initElements(driver, SignOnPage.class);

		sp.userNameTextBox.sendKeys("zeeshanmb1");
		sp.passwordTextBox.sendKeys("123456789");
		sp.loginButton.click();
		// Thread.sleep(5000);

		// System.out.println(driver.getTitle());
		// driver.getTitle().contains(s)
		Assert.assertTrue(driver.getTitle().contains("http://newtours.demoaut.com/mercurysignon.php"));
	}
}
