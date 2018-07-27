package iOSWhiteLabelReg;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.ios.IOSDriver;

public class AddPaymentCard {
	
	public IOSDriver<WebElement> driver;
	
	
	
	public AddPaymentCard(IOSDriver<WebElement> driver) {
		this.driver = driver;
	}
	
 public void AddPayCardDetails()
 {
	 driver.findElement(By.name("Card type")).click();
	 driver.findElementByName("Done").click();

	 driver.findElementByName("Card number").sendKeys("9901000000000019");
	 driver.findElementByName("Card expiry date").click();
	 
     List<WebElement> dt = driver.findElements(By.className("XCUIElementTypePickerWheel"));
     dt.get(0).sendKeys("06");
     dt.get(1).sendKeys("2021");
     driver.findElementByAccessibilityId("Done").click();
     driver.findElementByName("Name on card").sendKeys("Test Card");
     driver.findElementByName("CVV number").sendKeys("445");
     driver.findElementByName("Card nickname").sendKeys("iOSSimulatorTest");
     driver.findElementByAccessibilityId("Done").click();
     driver.findElementByAccessibilityId("Save").click(); 
  
     WebDriverWait w = new WebDriverWait(driver, 5);
     WebElement f = w.until(ExpectedConditions.visibilityOfElementLocated(By.name("My Account")));
     if (f.isDisplayed())
     {
    	 driver.findElementByName("menu stripes").click();
    	 driver.findElementByName("Logout").click();
     }
     
 }
	 
	 
 }

