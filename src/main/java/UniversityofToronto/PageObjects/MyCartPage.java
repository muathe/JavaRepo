package UniversityofToronto.PageObjects;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UniversityofToronto.AbstractComponents.AbstractComponents;

public class MyCartPage extends AbstractComponents {

	WebDriver driver;

	public MyCartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//h1[contains(text(),'My Cart')]")
	WebElement visibilityOfCartPage;

	@FindBy(css = ".cartSection h3")
	List<WebElement> productsInCart;

	@FindBy(css = "li button[type='button']")
	WebElement checkOut;

	public void visibilityOfCartPage() {
		waitForVisibility(visibilityOfCartPage);

	}

	public List<WebElement> getProductsInCart() {
		return productsInCart;

	}

	public boolean getProductNameInCart(String productName) {

		boolean myProductName = getProductsInCart().stream()
				.anyMatch(name -> name.getText().equalsIgnoreCase(productName));
		return myProductName;

	}

	public MyPaymentPage checkOut() throws InterruptedException {
		JavascriptExecutor execute = (JavascriptExecutor) driver;
		execute.executeScript("window.scrollBy(0,500)");
		Thread.sleep(1000);
		checkOut.click();
		MyPaymentPage paymentPage = new MyPaymentPage(driver);
		return paymentPage;

	}

}
