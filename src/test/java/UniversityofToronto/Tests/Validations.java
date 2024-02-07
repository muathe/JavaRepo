package UniversityofToronto.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import UniversityofToronto.PageObjects.MyCartPage;
import UniversityofToronto.PageObjects.MyProductsPage;

public class Validations extends BaseTest{
	
	@Test(retryAnalyzer = Retry.class)
	public void getLoginFailureMessage() {
		
		
		
				myLoginPage.login("moema@hotmail.com", "Password2");
				String myMessage =  myLoginPage.getMessage();
				Assert.assertEquals(myMessage, "Incorrect email or password.");
				
				
	}
	

	@Test()
	public void validateCart() {
		String product = "ZARA COAT 3";

		
				MyProductsPage productsPage = myLoginPage.login("moema@hotmail.com", "Password1");
				// ProductsPage

				MyCartPage cartPage = productsPage.getFilteredProduct(product);// ProductName

				// CartPage
				cartPage.visibilityOfCartPage();
				boolean myProductName = cartPage.getProductNameInCart(product);// ProductName
				Assert.assertTrue(myProductName);
				
				
	}
	
	
	
	
	
	
	

}
