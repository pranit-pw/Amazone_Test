package Test_Methods;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Module.LoginPage;

public class VerifyLoginPage {
	
	WebDriver driver;
	LoginPage loginPage;
	
	@BeforeClass
	public void lunchBrowser() {
		System.out.println("Before Class");
		System.setProperty("webdriver.chrome.driver", "E:\\Pranit\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
	}
	
	@BeforeMethod
	public void goToLoginPage() {
		System.out.println("Before Method");
		driver.get("https://www.amazon.in");
		loginPage = new LoginPage(driver);
	}
	
	@Test (priority = 1)
	public void verifyErrorMessageOfIncorrectUserName() {
		System.out.println("Test 1");
		loginPage.clickOnAccountAndListButton();
		loginPage.sendWrongUserName();
		loginPage.clickOnCountinueButton();
		String actualMsg = loginPage.getErrorMessageOfIncorrectUserName();
		System.out.println(loginPage.getErrorMessageOfIncorrectUserName());
		String expectedMsg = "We cannot find an account with that email address";
		
		Assert.assertEquals(actualMsg, expectedMsg);
	}
	
	@Test (priority = 2)
	public void verifyTextPresentOnCreateAccountButton() {
		System.out.println("Test 2");
		loginPage.clickOnAccountAndListButton();
		String actualText= loginPage.getTextPresentOnCreateAccountButton();
		System.out.println(loginPage.getTextPresentOnCreateAccountButton());
		String expectedText = "Create your Amazon account";
		
		Assert.assertEquals(actualText, expectedText);
		
	}
	
	@Test (priority = 3)
	public void verifyErrorMessageOfIncorrectPassword() {
		System.out.println("Test 3");
		loginPage.clickOnAccountAndListButton();
		loginPage.sendCorrectUserName();
		loginPage.clickOnCountinueButton();
		loginPage.sendWrongPassword();
		loginPage.clickOnSigninButton();
		String actualMsg = loginPage.getErrorMessageOfIncorrectPassword();
		System.out.println(loginPage.getErrorMessageOfIncorrectPassword());
		String expectedMsg = "Your password is incorrect";
		
		Assert.assertEquals(actualMsg, expectedMsg);
	}
	
	@Test (priority = 4)
	public void verifyForgotPasswordLink() {
		System.out.println("Test 4");
		loginPage.clickOnAccountAndListButton();
		loginPage.sendCorrectUserName();
		loginPage.clickOnCountinueButton();
		loginPage.clickOnForgotPasswordLink();
		String actualUrl = driver.getCurrentUrl();
		System.out.println(driver.getCurrentUrl());
		String expectedUrl = "https://www.amazon.in/ap/signin";
		
		Assert.assertNotEquals(actualUrl, expectedUrl);
	}
	
	@Test (priority = 5)
	public void verifyChangeLink() {
		System.out.println("Test 5");
		loginPage.clickOnAccountAndListButton();
		loginPage.sendCorrectUserName();
		loginPage.clickOnCountinueButton();
		loginPage.clickOnChangeLink();
		String actualUrl = driver.getCurrentUrl();
		System.out.println(driver.getCurrentUrl());
		String expectedUrl = "https://www.amazon.in/ap/signin";
		
		Assert.assertNotEquals(actualUrl, expectedUrl);
	}
	
	@Test
	public void verifyKeepMeSigninCheckbox() {
		System.out.println("Test 6");
		loginPage.clickOnAccountAndListButton();
		loginPage.sendCorrectUserName();
		loginPage.clickOnCountinueButton();
		loginPage.clickOnKeepMeSinginCheckbox();
		loginPage.keepMeSinginCheckboxIsSelectedOrNot();
		
	}

}
