package Test_Methods;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Module.AddToCartPage;
import Module.LoginPage;

public class VerifyAddToCartFunction {
	
	WebDriver driver;
	LoginPage loginPage;
	AddToCartPage addToCartPage;
	SoftAssert soft;
	
	@BeforeClass
	public void LaunchBrowser() {
		System.out.println("Before Class");
		System.setProperty("webdriver.chrome.driver", "E:\\Pranit\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@BeforeMethod
	public void LauchWebAppliction() {
		System.out.println("Before Method");
		driver.get("https://www.amazon.in");
		loginPage = new LoginPage(driver);
		addToCartPage = new AddToCartPage(driver);
		loginPage.clickOnAccountAndListButton();
		loginPage.loginToApplication();
		
		soft = new SoftAssert();
	}
	
	
	@Test (priority =1)
	public void verifyNameOfFirstProductPresentInCart() throws InterruptedException {
		System.out.println("Test 1");
		addToCartPage.sendDataIntoSearchbox();
		addToCartPage.clickOnFirstSearchResult();
		addToCartPage.switchToChildBrowser();
		addToCartPage.scrollDownWindowBy200Pixels();
		addToCartPage.clickOnAddToCartButton();
		addToCartPage.clickOnViewCartButton();
		String actualName = addToCartPage.getNameOfTheFirstProductPresentInCart();
		System.out.println(addToCartPage.getNameOfTheFirstProductPresentInCart());
		String expectedName = "Apple iPhone 13 (128GB) - Blue";
		String actualPrice = addToCartPage.getThepriceOffirstProductInviewCart();
		System.out.println(addToCartPage.getThepriceOffirstProductInviewCart());
		String expectedPrice = "  60,499.00";
		Thread.sleep(2000);
		addToCartPage.clickOnDeleteButton();
		
		soft.assertEquals(actualName, expectedName);
		soft.assertEquals(actualPrice, expectedPrice);
		
		soft.assertAll();
		
	}
	
	@Test (priority =2)
	public void verifyTheTextPresentOnProccedToCheckOutButton() throws InterruptedException {
		System.out.println("Test 2");
		addToCartPage.sendDataIntoSearchbox();
		addToCartPage.clickOnFirstSearchResult();
		addToCartPage.switchToChildBrowser2();
		addToCartPage.clickOnAddToCartButton();
		String actualText = addToCartPage.getTextPresentOnProccedToCheckOutButton1();
		System.out.println(addToCartPage.getTextPresentOnProccedToCheckOutButton1());
		String expectedText = "Proceed to checkout";
		Thread.sleep(3000);
		addToCartPage.clickOnproccedToCheckOutPopUpCloseButton();
		addToCartPage.scrollUpWindowBy200Pixels();
		Assert.assertEquals(actualText, expectedText);
	}
	
	@AfterMethod
	public void signOutFromApplication() {
		System.out.println("After Method");
		loginPage.clickOnSignOutButton();
	}
	
	@AfterClass
	public void closeBrowser() {
		System.out.println("After Class");
//		driver.quit();
	}

}
