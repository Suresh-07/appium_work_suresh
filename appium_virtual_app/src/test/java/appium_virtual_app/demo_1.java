package appium_virtual_app;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class demo_1 {
AndroidDriver<AndroidElement> driver;
	
	@BeforeTest
	public void BT() throws MalformedURLException{
    DesiredCapabilities dc = new DesiredCapabilities();
		
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "5eeca162");
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		dc.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		dc.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE,"C://Users//HP//Documents//workspace-spring-tool-suite-4-4.16.0.RELEASE//appium_virtual_app//chromedriver.exe");
	
		driver = new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"),dc);
	
	}
	
	@Test
	public void testcase() throws InterruptedException
	{
		
		driver.get("https://www.google.com");
		System.out.println("Hello Let’s do Appium");
		/*
		 * driver.findElement(By.xpath("//*[@class=‘gLFyf’]")).sendKeys("MoolyaEd");
		 * Actions ac = new Actions(driver); ac.sendKeys(Keys.ENTER).build().perform();
		 * JavascriptExecutor js = (JavascriptExecutor)driver; js.
		 * executeScript("document.getElementsByClassName('ynAwRc q8U8x MBeuO oewGkc LeUQr htnRc')[1].scrollIntoView()"
		 * ); Thread.sleep(3000);
		 */
	}
}