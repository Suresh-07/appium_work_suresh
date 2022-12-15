package appium_virtual_app;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.eventbus.AllowConcurrentEvents;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class ORANGE_HRM {
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
		driver.findElement(By.xpath("//*[@class='gLFyf']")).sendKeys("orangehrm");
	    Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(5000);
	    driver.findElement(By.xpath("//*[@href='https://opensource-demo.orangehrmlive.com/']")).click();
	    //login page
	    Thread.sleep(5000);
	    driver.findElement(By.xpath("//*[@name='username']")).sendKeys("Admin");
	    driver.findElement(By.xpath("//*[@name='password']")).sendKeys("admin123");
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//*[@type='submit']")).click();
	    Thread.sleep(5000);
	    driver.findElement(By.xpath("//*[@class='oxd-icon bi-list oxd-topbar-header-hamburger']")).click();
	    Thread.sleep(5000);
	    driver.findElement(By.xpath("//*[@href='/web/index.php/admin/viewAdminModule']")).click();
	    Thread.sleep(5000);
	    System.out.println(driver.getTitle());
	    driver.findElement(By.xpath("//*[@class='oxd-userdropdown']")).click();
		Thread.sleep(5000);
		System.out.println("logout");
	
	   }
	    
}

