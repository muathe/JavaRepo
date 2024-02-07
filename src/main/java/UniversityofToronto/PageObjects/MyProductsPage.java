package UniversityofToronto.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UniversityofToronto.AbstractComponents.AbstractComponents;

public class MyProductsPage extends AbstractComponents {

	WebDriver driver;

	public MyProductsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = ".fa.fa-eye")
	WebElement productsVisibility;

	@FindBy(css = ".card")
	List<WebElement> listOfProducts;

	By filteredName = By.cssSelector("h5 b");

	By addToCartButton = By.cssSelector(".btn.w-10.rounded");

	@FindBy(css = "ngx-spinner")
	WebElement spinner;

	@FindBy(css = "button[routerLink='/dashboard/cart']")
	WebElement cartButton;

	public List<WebElement> getListOfProducts() {
		return listOfProducts;

	}

	public MyCartPage getFilteredProduct(String productName) {
		waitForVisibility(productsVisibility);
		WebElement chosenProduct = getListOfProducts().stream()
				.filter(product -> product.findElement(filteredName).getText().equalsIgnoreCase(productName))
				.findFirst().orElse(null);
		chosenProduct.findElement(addToCartButton).click();
		waitForInvisibility(spinner);
		cartButton.click();
		MyCartPage cartPage = new MyCartPage(driver);
		return cartPage;


	}

	
	
	
	
	
	
}
