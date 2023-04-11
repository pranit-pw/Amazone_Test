package Module;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	//Variable Declaration
	@FindBy (xpath = "//span[text() ='Account & Lists']")
	private WebElement accountAndListButton;
	
	@FindBy (xpath = "//input[@id='signInSubmit']")
	private WebElement signin;

	@FindBy(xpath = "//input[@id='ap_email']")
	private WebElement eamilOrPhoneNumeber;
	
	@FindBy (xpath = "//input[@id='ap_password']")
	private WebElement password;
	
	@FindBy (xpath = "//input[@id='continue']")
	private WebElement countinueButton;
	
	@FindBy (xpath = "//a[@id='createAccountSubmit']")
	private WebElement createAccount;
	
	@FindBy (xpath = "//span[@class='a-list-item']")
	private WebElement errorMessageOfIncorrectUserName;
	
	@FindBy (xpath = "//a[@id='auth-fpp-link-bottom']")
	private WebElement forgotpassword ;
	
	@FindBy (xpath = "//input[@type='checkbox']")
	private WebElement keepMeSinginCheckbox;
	
	@FindBy (xpath = "//a[@id='ap_change_login_claim']")
	private WebElement changeLink;
	
	@FindBy (xpath = "//span[@class='a-list-item']")
	private WebElement errorMessageOfIncorrectPassword;
	
	@FindBy (xpath = "//span[text() = 'Sign Out']")
	private WebElement signOutButton;
	
	
	private WebDriver driver ;
	private Actions action;
	
	//variable Initialization
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	//Variable Use
	public void clickOnAccountAndListButton() {
		accountAndListButton.click();
	}
	
	
	public void sendWrongUserName() {
		eamilOrPhoneNumeber.sendKeys("pranitwarhikar@gmail.cm");
	}
	
	
	public void sendCorrectUserName() {
		eamilOrPhoneNumeber.sendKeys("pranitwarhikar@gmail.com");
	}
	
	
	public void sendWrongPassword() {
		password.sendKeys("pranit@5172");
	}
	
	
	public void sendCorrectPassword() {
		password.sendKeys("Pranit@5172");
	}
	
	
	public void clickOnCountinueButton() {
		countinueButton.click();
	}
	
	
	public void clickOnSigninButton() {
		signin.click();
	}
	
	
	public void clickOnCreateAccountButton() {
		createAccount.click();
	}
	
	
	public String getErrorMessageOfIncorrectUserName() {
		String text = errorMessageOfIncorrectUserName.getText();
		return text ;
	}
	
	
	public String getErrorMessageOfIncorrectPassword() {
		String text = errorMessageOfIncorrectPassword.getText();
		return text;
	}
	
	
	public String getTitleOfErrorMessageOfIncorrectUserName() {
		String text = driver.getTitle();
		return text;
	}
	
	
	public String getTextPresentOnCreateAccountButton() {
		String text = createAccount.getText();
		return text;
	}
	
	
	public void clickOnForgotPasswordLink() {
		forgotpassword.click();
	}
	
	
	public void clickOnKeepMeSinginCheckbox() {
		keepMeSinginCheckbox.click();
	}
	
	
	public void clickOnChangeLink() {
		changeLink.click();
	}
	
	public void keepMeSinginCheckboxIsSelectedOrNot() {
		boolean result = keepMeSinginCheckbox.isSelected();
		if(result == false)
		{
			System.out.println("Checkbox is not selected");
		}
		else
		{
			System.out.println("Checkbox is selected");
		}
	}
	
	
	public void loginToApplication() {
		eamilOrPhoneNumeber.sendKeys("pranitwarhikar@gmail.com" + Keys.ENTER);
		password.sendKeys("Pranit@5172" + Keys.ENTER);
	}
	
	
	public void clickOnSignOutButton() {
		action = new Actions(driver);
		action.moveToElement(accountAndListButton).perform();
		signOutButton.click();
	}

}
