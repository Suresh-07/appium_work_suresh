package appium_virtual_app;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.cassandra.thrift.Cassandra.multiget_count_args;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import freemarker.log.Logger;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;

public class GENERAL_STORE {
	AndroidDriver<AndroidElement> driver;
	@BeforeTest
	public void BT() throws MalformedURLException  {
    DesiredCapabilities dc = new DesiredCapabilities();
		
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "5eeca162");
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME,AutomationName.ANDROID_UIAUTOMATOR2);
		dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"com.androidsample.generalstore");
		dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"com.androidsample.generalstore.SplashActivity");
		driver = new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"),dc);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@Test(enabled = true)
	public void ticket() throws InterruptedException {
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/spinnerCountry")).click(); 
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Australia\"))").click();
		driver.findElementByAndroidUIAutomator("text(\"Enter name here\")").sendKeys("suresh");
		 driver.findElement(MobileBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		//addcart    android.widget.CheckBox
		 Thread.sleep(2000);
		
		 driver.findElement(MobileBy.id("com.androidsample.generalstore:id/productAddCart")).click();
		 driver.findElement(MobileBy.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
//		 driver.findElement(MobileBy.id("76c806ff-bf80-436c-8ee6-2bbcccbfa15c")).click();
		
		 AndroidElement condtion =	 driver.findElement(MobileBy.id("eeff58d7-97b1-426c-8c0c-57f62857d1a1"));
		 TouchAction ta = new TouchAction(driver);
		 ta.longPress(longPressOptions().withElement(element(condtion)).withDuration(ofSeconds(10))).perform();


		 driver.findElement(MobileBy.className("android.widget.CheckBox")).click();
		 driver.findElement(MobileBy.id("com.androidsample.generalstore:id/btnProceed")).click();
		 Thread.sleep(5000);
		 driver.quit();
		 
	}
	@Test(enabled = false)
	public void negative() throws InterruptedException {
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/spinnerCountry")).click(); 
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Belize\"))").click();
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		driver.getPageSource().concat("please enter ypur name");
		Thread.sleep(3000);
		//toast message
		String toast = driver.findElement(MobileBy.xpath("//android.widget.Toast[1]")).getText();
		System.out.println(toast);
		

	}
}
