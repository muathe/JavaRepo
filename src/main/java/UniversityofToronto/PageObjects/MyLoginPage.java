package UniversityofToronto.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UniversityofToronto.AbstractComponents.AbstractComponents;

public class MyLoginPage extends AbstractComponents {

	WebDriver driver;

	public MyLoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = "input[type='email']")
	WebElement userEmail;

	@FindBy(css = "input[type='password']")
	WebElement userPassword;

	@FindBy(css = "input[type='submit']")
	WebElement submit;
	
	@FindBy(css= ".toast-message")
	WebElement toastmessage;
	
	@FindBy(css= ".toast-message")
	WebElement message;

	public MyProductsPage login(String email, String password) {
		userEmail.sendKeys(email);
		userPassword.sendKeys(password);
		submit.click();
		MyProductsPage productsPage = new MyProductsPage(driver);
		return productsPage;

	}
	
	public String getMessage() {
		waitForVisibility(toastmessage);
		String myMessage = message.getText();
		return myMessage;
		
	}

}
