package appium_virtual_app;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import  static java.time.Duration.ofSeconds;
import java.util.concurrent.TimeUnit;

import org.antlr.grammar.v3.ANTLRv3Parser.throwsSpec_return;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.internal.PackageUtils;

import com.aventstack.extentreports.reporter.configuration.Theme;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.LongPressOptions;
import  static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

import static io.appium.java_client.touch.offset.ElementOption.element;

import static io.appium.java_client.touch.TapOptions.tapOptions;

public class Natives_Poco {
	 AndroidDriver<AndroidElement> driver;
	@BeforeTest
	public void BT() throws MalformedURLException  {
    DesiredCapabilities dc = new DesiredCapabilities();
		
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "5eeca162");
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME,AutomationName.ANDROID_UIAUTOMATOR2);
		dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"io.appium.android.apis");
		dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"io.appium.android.apis.ApiDemos");
		driver = new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"),dc);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	}
	@Test(enabled = false)
	public void testcase2() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(MobileBy.AccessibilityId("Animation")).click();
		driver.findElement(MobileBy.className("android.widget.TextView")).click();
		driver.findElement(MobileBy.id("io.appium.android.apis:id/startButton")).click();
		driver.navigate().back();
//		driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector())
		
		
		
	}
	@Test(enabled = false)
	public void Task() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(MobileBy.AccessibilityId("Preference")).click();
		driver.findElement(MobileBy.xpath("//android.widget.TextView[@content-desc=\"3. Preference dependencies\"]")).click();
		Thread.sleep(3000);
		driver.findElement(MobileBy.id("android:id/checkbox")).click();
		driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"WiFi settings\")")).click();
		driver.findElement(MobileBy.id("android:id/edit")).sendKeys("SURESH");
        driver.hideKeyboard();
		driver.navigate().back();
        

		
	}
	@Test(enabled = false)    //accessibilty
	public void tc4() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(MobileBy.AccessibilityId("Accessibility")).click();	
		driver.findElement(MobileBy.AccessibilityId("Accessibility Node Querying")).click();
		driver.findElement(MobileBy.id("io.appium.android.apis:id/tasklist_finished")).click();
		
	}
	@Test(enabled = false)  //NOTIFICATIONS
	public void tc3() throws InterruptedException {
		driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"CANCEL\")")).click(); //popup
		
		Thread.sleep(3000);
		driver.openNotifications();
		
		TouchAction tee=new TouchAction(driver);
		Thread.sleep(10000);
		tee.longPress(PointOption.point(533,117)).moveTo(PointOption.point(655,1153)).release().perform();
		Thread.sleep(5000);
		driver.findElements(MobileBy.className("android.widget.ImageView")).get(3).click();  //battery
		Thread.sleep(5000);
//		driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Flashlight\")")).click();
		driver.findElements(MobileBy.className("android.widget.ImageView")).get(7).click();
		Thread.sleep(5000);
//        driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Wi-Fi\")")).click();
//        
//        driver.findElementByAccessibilityId("Settings").click();
//        driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"About phone\")")).click();
//        driver.navigate().back();
}
	@Test(enabled = false) // LONGPRESS
	public void longtap() {
		driver.findElement(MobileBy.AccessibilityId("Views")).click();
		AndroidElement Size = driver.findElementByAndroidUIAutomator("new UiSelector().clickable(true)");
		System.out.println(Size.getSize());

		driver.findElement(MobileBy.AccessibilityId("Expandable Lists")).click();
		AndroidElement tp=   driver.findElement(MobileBy.AccessibilityId("1. Custom Adapter"));
		TouchAction ta = new TouchAction(driver);
		ta.tap(tapOptions().withElement(element(tp))).perform();
		AndroidElement lp =  driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Dog Names\")"));
	    ta.longPress(longPressOptions().withElement(element(lp)).withDuration(ofSeconds(3))).release().perform();
		driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Sample action\")")).click();
	    driver.pressKey(new KeyEvent (AndroidKey.HOME));
	}
	
	
	
	@Test (enabled = false) //scroll and keyboard
	public void tc5() {
		driver.findElement(MobileBy.AccessibilityId("Views")).click();
		
		driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"WebView\")")).click();
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
	    driver.pressKey(new KeyEvent(AndroidKey.HOME));
	    driver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH));
	}

	
	@Test(enabled = false) //swipe
	public void  switch12() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(MobileBy.AccessibilityId("Views")).click();
		driver.findElement(MobileBy.AccessibilityId("Date Widgets")).click();
		driver.findElement(MobileBy.AccessibilityId("2. Inline")).click();
		driver.findElement(MobileBy.AccessibilityId("12")).click();
		
		AndroidElement ele1 =   driver.findElement(MobileBy.AccessibilityId("15"));
		AndroidElement ele2 =  driver.findElement(MobileBy.AccessibilityId("40"));
	      TouchAction ta= new TouchAction(driver);
	      Thread.sleep(5000);
	      ta.longPress(longPressOptions().withElement(element(ele1)).withDuration(ofSeconds(3))).moveTo(element(ele2)).release().perform();
	      driver.findElementByAndroidUIAutomator("text(\"PM\")").click();
	      driver.pressKey(new KeyEvent(AndroidKey.HOME));
	}
	
	
	
	@Test(enabled = false)
	public void draganddrop() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(MobileBy.AccessibilityId("Views")).click();
		driver.findElement(MobileBy.AccessibilityId("Drag and Drop")).click();
		AndroidElement ele1=   driver.findElements(MobileBy.className("android.view.View")).get(0);
		AndroidElement ele2= driver.findElements(MobileBy.className("android.view.View")).get(2);
		TouchAction ta= new TouchAction(driver);
		Thread.sleep(5000);
	      ta.longPress(longPressOptions().withElement(element(ele1)).withDuration(ofSeconds(3))).moveTo(element(ele2)).release().perform();
	      driver.pressKey(new KeyEvent(AndroidKey.BACK));
	      driver.pressKey(new KeyEvent(AndroidKey.HOME));
	}
	
	
	
	@Test(enabled = false) //date bset
	public void dialog() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(MobileBy.AccessibilityId("Views")).click();
		driver.findElement(MobileBy.AccessibilityId("Date Widgets")).click();
		driver.findElement(MobileBy.AccessibilityId("1. Dialog")).click();
		driver.findElement(MobileBy.AccessibilityId("change the date")).click();
		driver.findElement(MobileBy.AccessibilityId("08 December 2022")).click();
		driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"OK\")")).click();
		driver.pressKey(new KeyEvent(AndroidKey.HOME));
	}
	@Test(enabled = false)
	public void tc8() throws InterruptedException {
		driver.findElement(MobileBy.AccessibilityId("OS")).click();
		driver.findElement(MobileBy.AccessibilityId("SMS Messaging")).click();
//		driver.findElement(MobileBy.AccessibilityId("Enable SMS broadcast receiver")).click();
		driver.findElement(MobileBy.id("io.appium.android.apis:id/sms_recipient")).sendKeys("8792339238");
		driver.findElement(MobileBy.id("io.appium.android.apis:id/sms_content")).sendKeys("Hello suresh");
		driver.findElement(MobileBy.AccessibilityId("Send")).click();
		Thread.sleep(2000);
		
		driver.activateApp("com.android.mms");
//		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Basavaraj G\"))");
		String value = driver.findElement(MobileBy.id("c1c1be91-0f8c-4d2d-b8fd-35565bebec58")).getText();
		System.out.println(value);
			
		driver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH));
		Thread.sleep(2000);
		driver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH));
		Thread.sleep(2000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.HOME));
		
		
		
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	text element type
//	driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"WiFi settings\")")).click();
//	driver.findElementByAndroidUIAutomator("text(\"WiFi settings\")"));
	
}
