package UniversityofToronto.MainTest;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import UniversityofToronto.PageObjects.MyCartPage;
import UniversityofToronto.PageObjects.MyConfirmationPage;
import UniversityofToronto.PageObjects.MyPaymentPage;
import UniversityofToronto.PageObjects.MyProductsPage;
import UniversityofToronto.Resources.Screenshott;
import UniversityofToronto.Tests.BaseTest;

public class MainStoreTest extends BaseTest {

	String ProductName = "Adidas Original";
	String countryName = "India";

	@Test(dataProvider = "getData")
	public void runTest(HashMap<String, String> input) throws InterruptedException {
		// LoginPage
		MyProductsPage productsPage = myLoginPage.login(input.get("email"), input.get("password"));

		// ProductsPage
		MyCartPage cartPage = productsPage.getFilteredProduct(input.get("product"));// ProductName

		// CartPage
		cartPage.visibilityOfCartPage();
		boolean myProductName = cartPage.getProductNameInCart(input.get("product"));// ProductName
		Assert.assertTrue(myProductName);
		MyPaymentPage paymentPage = cartPage.checkOut();

		// PaymentPage

		paymentPage.insertCountry(countryName);
		MyConfirmationPage confirmationPage = paymentPage.getChosenCountry();

		// ConfirmationPage

		String confirmation = confirmationPage.getConfirmationMessage();
		Assert.assertTrue(confirmation.equalsIgnoreCase("THANKYOU FoR THE ORDER."));
		System.out.println("Success!");
		

	}

	@DataProvider
	public Object[][] getData() throws IOException {

		/*
		 * map1.put("email", "moema@hotmail.com"); map1.put("password", "Password1");
		 * map1.put("product", "ADIDAS ORIGINAL");
		 * 
		 * HashMap<String, String> map2 = new HashMap<String, String>();
		 * map2.put("email", "mike@hotmail.com"); map2.put("password", "Password2");
		 * map2.put("product", "ZARA COAT 3");
		 * 
		 * HashMap<String, String> map3 = new HashMap<String, String>();
		 * map3.put("email", "jack@hotmail.com"); map3.put("password", "Password3");
		 * map3.put("product", "IPHONE 13 PRO");
		 * 
		 */

		List<HashMap<String, String>> data = getJsonDataToMapp(
				System.getProperty("user.dir")+ "\\src\\test\\java\\UniversityofToronto\\Data\\OrderList.json");

		return new Object[][] { { data.get(0) }, { data.get(1) }, { data.get(2) } };
		

	}
	
	

	

}
