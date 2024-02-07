package UniversityofToronto.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UniversityofToronto.AbstractComponents.AbstractComponents;

public class MyConfirmationPage extends AbstractComponents {

	WebDriver driver;

	public MyConfirmationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".hero-primary")
	WebElement confirmTitle;

	public String getConfirmationMessage() {

		waitForVisibility(confirmTitle);
		String confirmation = driver.findElement(By.cssSelector(".hero-primary")).getText();
		return confirmation;

	}

}
