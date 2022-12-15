package appium_virtual_app;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.gherkin.model.And;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;

public class general2 {
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
	@Test(enabled = false)
	public void addcart() throws InterruptedException {
		
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/spinnerCountry")).click(); 
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Belize\"))").click();
		driver.findElementByAndroidUIAutomator("text(\"Enter name here\")").sendKeys("suresh");
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		//addcart    android.widget.CheckBox
		Thread.sleep(2000);
		driver.findElements(MobileBy.xpath("//*[@text='ADD TO CART']")).get(0).click();
		driver.findElements(MobileBy.xpath("//*[@text='ADD TO CART']")).get(0).click();
		
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(new UiSelector().text(\"Jordan 6 Rings\"))"));
		Thread.sleep(2000);
		int count=driver.findElements(MobileBy.id("com.androidsample.generalstore:id/rvProductList")).size();
		for(int i=0;i<count;i++)
		{
			String J=driver.findElement(MobileBy.id("com.androidsample.generalstore:id/productName")).getText();
			System.out.println(J);
			
			if(J.equalsIgnoreCase("Jordan 6 Rings"))
			{
				driver.findElementsByAndroidUIAutomator("text(\"ADD TO CART\")").get(i).click();
			}
		
			break;
		}
		Thread.sleep(2000);
			
		
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		Thread.sleep(5000);
		String price1= driver.findElements(MobileBy.id("com.androidsample.generalstore:id/productPrice")).get(0).getText();
		price1= price1.substring(1);
		Double s1=Double.parseDouble(price1);
		System.out.println(s1);
		Thread.sleep(5000);
		
		String price2= driver.findElements(MobileBy.id("com.androidsample.generalstore:id/productPrice")).get(1).getText();
		price2= price2.substring(1);
		Double s2=Double.parseDouble(price2);
		System.out.println(s2);
		Double Totalprice=s1+s2;
		System.out.println(Totalprice);
		
		String final25= driver.findElement(MobileBy.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		final25=final25.substring(1);
		Double final2=Double.parseDouble(final25);
		System.out.println(final2);
		
//		if(final2.equals(Totalprice)) 
//		{
//			System.out.println("price matching");
//		}
//		else {
//			System.out.println("price not matching");
//		}
		
		Assert.assertEquals(Totalprice, final2);
		driver.findElement(MobileBy.className("android.widget.CheckBox")).click();
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/btnProceed")).click();
		Thread.sleep(5000);

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
	@Test(enabled = true)
	public void task() throws InterruptedException {
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/spinnerCountry")).click(); 
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Belize\"))").click();
		driver.findElementByAndroidUIAutomator("text(\"Enter name here\")").sendKeys("suresh");
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		String shoe1 = driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Converse All Star\"))").getText();
		driver.findElements(MobileBy.xpath("//*[@text='ADD TO CART']")).get(0).click();
		System.out.println("Selected product name "+ shoe1);
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		
		String pz1= driver.findElement(MobileBy.id("com.androidsample.generalstore:id/productPrice")).getText();
		pz1= pz1.substring(1);
		Double s1=Double.parseDouble(pz1);
		System.out.println(s1);
				
		driver.findElement(MobileBy.className("android.widget.CheckBox")).click();
		Thread.sleep(5000);
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/btnProceed")).click();
		
		driver.pressKey(new KeyEvent(AndroidKey.HOME));
		
		
	}
}