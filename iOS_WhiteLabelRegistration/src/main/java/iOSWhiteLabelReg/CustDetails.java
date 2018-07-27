package iOSWhiteLabelReg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.ios.IOSDriver;

public class CustDetails {
	
	public IOSDriver<WebElement> driver;
	String fname = "iOSTest";
	String lname = "Simulator";
	String password = "Password123";
	
	public CustDetails(IOSDriver<WebElement> driver) {
		this.driver = driver;
	}

	
	public void CustomerDetails()
	{
		driver.findElementByName("First name").sendKeys(fname);
		driver.findElementByName("Last name").sendKeys(lname);
		driver.findElementByName("Password").sendKeys(password);
		driver.findElementByName("Confirm password").sendKeys(password);
		driver.findElementByName("Done").click();
		driver.findElement(By.name("Finish")).click();
		
		WebDriverWait w = new WebDriverWait(driver, 10);
		WebElement chk = w.until(ExpectedConditions.visibilityOfElementLocated(By.name("Congratulations you are now registered. Would you like to add a payment card now?")));
		if (chk.isDisplayed())
		{
			driver.findElement(By.name("Yes")).click();
			AddPaymentCard ap = new AddPaymentCard(driver);
			ap.AddPayCardDetails();
		}
			
	}
}
