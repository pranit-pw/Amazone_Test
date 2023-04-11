package Module;

import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AddToCartPage {
	
	//Variable Declaration
	@FindBy(xpath = "//input[@id='twotabsearchtextbox']")
	private WebElement searchbox;
	
	@FindBy (xpath = "(//div[contains(@data-index,'3')]//div//h2//span)[1]")
	private WebElement firstsearchresult;
	
	@FindBy (xpath = "//input[@id='add-to-cart-button']")
	private WebElement addToCartButton;
	
	@FindBy (xpath = "(//span[@class='a-button-text'])[34]//span")
	private WebElement proccedToCheckOutButton;
	
	@FindBy (xpath = "//span[@id='attach-sidesheet-checkout-button-announce']")
	private WebElement proccedToCheckOutButton1;
	
	@FindBy (xpath = "(//div[@id='attach-accessory-pane']//span//input)[1]")
	private WebElement viewCartButton;
	
	@FindBy (xpath = "//a[@id='attach-close_sideSheet-link']")
	private WebElement proccedToCheckOutPopUpCloseButton;
	
//View Cart Fisrt Product xpath
	@FindBy (xpath = "//div[@data-index='3']//h2//span")
	private WebElement firstProductInCart;
	
	@FindBy (xpath = "(((//div[@class='sc-list-item-content'])[1]//li)[1]//span)[5]")
	private WebElement firstProductInviewCart;
	
	@FindBy (xpath = "((//p[@class='a-spacing-mini'])[1]//span)[1]")
	private WebElement priceOffirstProductInviewCart;
	
	
	@FindBy (xpath = "(((//div[contains(@data-asin,\"B\")])[1]//div)[17]//input)[2]")
	private WebElement DeleteButton;
	
//	@FindBy (xpath = "//span[text() = 'Sign Out']")
//	private WebElement signOutButton;

	private WebDriver driver;
	private WebDriverWait wait;
	private JavascriptExecutor javaScriptExecutor ;
	private ArrayList<String> arrayList ;

	//Variable Initialization
	public AddToCartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		javaScriptExecutor = (JavascriptExecutor)driver;
		wait = new WebDriverWait(driver, 20);
	}
	
	
	//Variable Use
	public void sendDataIntoSearchbox() {
		searchbox.sendKeys("Iphone 14" + Keys.ENTER);
	}
	
	
	public void clickOnFirstSearchResult() {
		firstsearchresult.click();
	}
	
	
	public void clickOnAddToCartButton() {
		addToCartButton.click();
		wait.until(ExpectedConditions.visibilityOf(addToCartButton));
	}
	
	
	public void clickOnViewCartButton() {
		viewCartButton.click();
	}
	
	
	public void clickOnDeleteButton() {
		DeleteButton.click();
	}
	
	
//	public void clickOnSignOutButton() {
//		signOutButton.click();
//	}
	
	
	public String getTextPresentOnProccedToCheckOutButton() {
		String text = proccedToCheckOutButton.getText();
		return text;
	}
	
	
	public void clickOnproccedToCheckOutPopUpCloseButton() {
		proccedToCheckOutPopUpCloseButton.click();
	}
	
	
	public String getTextPresentOnProccedToCheckOutButton1() {
		String text = proccedToCheckOutButton1.getText();
		return text;
	}
	

	
	public String getNameOfTheFirstProductPresentInCart() {
		String text = firstProductInviewCart.getText();
		return text;
	}
	
	
	public String getThepriceOffirstProductInviewCart() {
		String text = priceOffirstProductInviewCart.getText();
		return text;
	}
	
	public void scrollDownWindowBy200Pixels() {
		javaScriptExecutor.executeScript("window.scrollBy(0, 200)");
	}
	
	
	public void scrollUpWindowBy200Pixels() {
		javaScriptExecutor.executeScript("window.scrollBy(0, -400)");
	}
	
	
	public void switchToChildBrowser() {
		arrayList = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(arrayList.get(1));
	}
	
	public void switchToChildBrowser2() {
		arrayList = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(arrayList.get(2));
	}

}
