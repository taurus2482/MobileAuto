package iOSWhiteLabelReg;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;

import io.appium.java_client.ios.IOSDriver;

public class AddCardDetails {
	
	public IOSDriver<WebElement> driver;
	public String pan= "00010000020";
	public String clientkey = "uatenergycontrols";
	
	public AddCardDetails(IOSDriver<WebElement> driver)
	{
		this.driver = driver;
	}
	
	public void AddTopUpCard()
	{
		GenRandomEmail email = new GenRandomEmail();
		String username = email.EmailAdd();
		driver.findElementByAccessibilityId("Create an account").click();
		driver.findElementByName("Email address").sendKeys(username);
		driver.findElementByAccessibilityId("Add PayPoint card").click();
		driver.findElementByName("The last 11 digits on your card").sendKeys(pan);
		driver.findElementByName("Done").click();
		driver.findElementByAccessibilityId("Save").click();
		driver.findElementByName("Done").click();
		WebElement nxt = driver.findElementByAccessibilityId("forward-arrow");
		nxt.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		GetRegCode gr = new GetRegCode();
		
		driver.findElementByIosNsPredicate("type = 'XCUIElementTypeTextField'").sendKeys(gr.RegistrationCode(username, clientkey));
		driver.findElementByName("Done").click();
		nxt.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
	}

}
