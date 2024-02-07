package UniversityofToronto.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UniversityofToronto.AbstractComponents.AbstractComponents;

public class MyPaymentPage extends AbstractComponents {

	WebDriver driver;

	public MyPaymentPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".payment__title")
	WebElement paymentTitle;

	@FindBy(css = "[placeholder='Select Country']")
	WebElement insertCountry;

	@FindBy(css = ".ta-item")
	List<WebElement> countryList;

	@FindBy(css = ".action__submit")
	WebElement placeOrder;

	public void insertCountry(String countryName) throws InterruptedException {

		JavascriptExecutor execute = (JavascriptExecutor) driver;
		execute.executeScript("window.scrollBy(0,500)");
		Thread.sleep(1000);
		waitForVisibility(paymentTitle);
		Actions a1 = new Actions(driver);
		a1.sendKeys(insertCountry, countryName).build().perform();

	}

	
	
	public List<WebElement> getCountryList() {
		return countryList;

	}
	
	
	

	public MyConfirmationPage getChosenCountry() {
		WebElement chosenCountry = getCountryList().stream().filter(
				country -> country.findElement(By.cssSelector("button span")).getText().equalsIgnoreCase("India"))
				.findFirst().orElse(null);
		chosenCountry.click();
		placeOrder.click();
		MyConfirmationPage confirmationPage = new MyConfirmationPage(driver);
		return confirmationPage;

	}

}
