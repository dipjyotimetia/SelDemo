package seleniumGrid;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class SeleniumGrid {
	WebDriver driver;
	String baseUrl,nodeUrl;
  @Test
  public void simpleTest() {
	  driver.get(baseUrl);
	  Assert.assertEquals("Welcome: Mercury Tours", driver.getTitle());
  }
  @BeforeTest
  public void setup()throws MalformedURLException {
	  baseUrl="http://newtours.demoaut.com/";
	  nodeUrl="http://192.168.0.106:5566/wd/hub";			// ip of the node
	  DesiredCapabilities capability=DesiredCapabilities.firefox();
	  capability.setBrowserName("firefox");
	  //capability.setPlatform(Platform.LINUX);		       //platform of the node
	  capability.setPlatform(Platform.WIN8_1);
	  driver=new RemoteWebDriver(new URL(nodeUrl), capability);
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
