package appium_virtual_app;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.util.function.ToIntBiFunction;

import org.apache.cassandra.cli.CliParser.endKey_return;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

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


public class All_in_one {
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
	@Test (enabled = true) //Bouncing Balls
	public void tc1() throws InterruptedException {
		driver.findElement(MobileBy.AccessibilityId("Animation")).click();	
		
		driver.findElement(MobileBy.AccessibilityId("Bouncing Balls")).click();
	    AndroidElement ball =	driver.findElement(MobileBy.className("android.view.View"));
	    TouchAction ta = new TouchAction(driver);
	    ta.longPress(longPressOptions().withElement(element(ball)).withDuration(ofSeconds(10))).perform();
	    driver.pressKey(new KeyEvent(AndroidKey.BACK));
	    driver.pressKey(new KeyEvent(AndroidKey.BACK));
	    
	    //
	    driver.findElement(MobileBy.AccessibilityId("App")).click();
	    driver.findElement(MobileBy.AccessibilityId("Fragment")).click();
	    driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Stack\"))");
	    driver.findElement(MobileBy.AccessibilityId("Stack")).click();
	    AndroidElement push=  driver.findElement(MobileBy.AccessibilityId("Push"));
	    
	    TouchAction ta2 = new TouchAction(driver);
		ta2.tap(tapOptions().withElement(element(push))).perform();
		ta2.tap(tapOptions().withElement(element(push))).perform();
		ta2.tap(tapOptions().withElement(element(push))).perform();
		Thread.sleep(3000);
		
//        AndroidElement pop =  driver.findElement(MobileBy.AccessibilityId("POP"));
//	    TouchAction ta3 = new TouchAction(driver);
//		ta2.tap(tapOptions().withElement(element(pop))).perform();
//		ta2.tap(tapOptions().withElement(element(pop))).perform();
//		ta2.tap(tapOptions().withElement(element(pop))).perform();
//		Thread.sleep(2000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
	    driver.pressKey(new KeyEvent(AndroidKey.BACK));
	    driver.pressKey(new KeyEvent(AndroidKey.BACK));
	    driver.pressKey(new KeyEvent(AndroidKey.BACK));
//	    driver.pressKey(new KeyEvent(AndroidKey.BACK));
	    
	    
	   //long press
	
//	    driver.findElement(MobileBy.AccessibilityId("App")).click();
//	    driver.findElement(MobileBy.AccessibilityId("Fragment")).click();	
	    driver.findElement(MobileBy.AccessibilityId("Context Menu")).click();
	    AndroidElement lo =   driver.findElement(MobileBy.AccessibilityId("Long press me"));
	    TouchAction tc=new TouchAction(driver);
	    tc.longPress(longPressOptions().withElement(element(lo)).withDuration(ofSeconds(10))).perform();	    
	    driver.findElementByAndroidUIAutomator("text(\"Menu B\")").click();
	    driver.pressKey(new KeyEvent(AndroidKey.HOME));
	    
    }
	    
	    
	    
	    
	}


