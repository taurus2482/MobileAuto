package iOSWhiteLabelReg;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.ios.IOSDriver;

public class iOSSetUp {
	
	public IOSDriver<WebElement> driver;
	
	@BeforeClass
	public void setUp() throws MalformedURLException
	{
		DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("automationName", "XCUITest");
        capabilities.setCapability("platformVersion", "11.4");
        capabilities.setCapability("deviceName","iPhone 7");
        capabilities.setCapability("platformName","iOS");
        capabilities.setCapability("app", "/Users/sridharlimited/Documents/EnergyControls.app");
        driver = new IOSDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@Test
	public void Registration()
	{
		AddCardDetails acd = new AddCardDetails(driver);
		acd.AddTopUpCard();
		CustDetails cd = new CustDetails(driver);
		cd.CustomerDetails();
		
	}
	
	@AfterClass
	public void close()
	{
		driver.close();
	}

}
