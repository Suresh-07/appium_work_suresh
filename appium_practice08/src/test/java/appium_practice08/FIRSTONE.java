package appium_practice08;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.thrift.server.THsHaServer;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;

public class FIRSTONE {
	 AndroidDriver<AndroidElement> driver;
		@BeforeTest
		public void BT() throws MalformedURLException  {
	    DesiredCapabilities dc = new DesiredCapabilities();
			
			dc.setCapability(MobileCapabilityType.DEVICE_NAME, "5eeca162");
			dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
			dc.setCapability(MobileCapabilityType.AUTOMATION_NAME,AutomationName.ANDROID_UIAUTOMATOR2);
			dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"com.flipkart.android");
			dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"com.flipkart.android.SplashActivity");
			driver = new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"),dc);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		@Test(enabled = true)
		public void flipkart() throws InterruptedException {
			//login
			driver.findElements(MobileBy.id("com.flipkart.android:id/iv_checkbox")).get(3).click();
			driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"CONTINUE\")")).click();
			driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"095380 03864\")")).click();
//			driver.findElements(MobileBy.className("com.flipkart.android:id/iv_checkbox")).get(1).click();
			driver.findElement(MobileBy.id("com.flipkart.android:id/button")).click();
			Thread.sleep(5000);
		// women fashion			
			driver.findElement(MobileBy.id("877a187b-7d5d-43fa-b22d-ffeb83b2a8e4")).click();
			driver.findElement(MobileBy.id("eaf5866f-13f8-4810-81a8-093951f9d232")).click();
			driver.findElement(MobileBy.id("211fac58-2a05-48f5-822b-d70e9cc550d1")).click();
			driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Long Coats\"))").click();
			driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"LATIN QUARTERS\"))").click();
			driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Size\"))");
			driver.findElement(MobileBy.id("b23cd577-3494-4746-aecc-8ac81d665f80")).click();
			Thread.sleep(2000);
			driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"ADD TO CART\")")).click();
			
			
			
		}}