import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;

public class TestCase001 {

	private WebDriver driver;
	
	  @BeforeClass
	  public void beforeClass() {
			//System.setProperty("webdriver.ie.driver", "C:\\Javalibs\\WebDrivers\\IEDriverServer.exe");
			//driver = new InternetExplorerDriver();
			
			System.setProperty("webdriver.gecko.driver", "C:\\Javalibs\\WebDrivers\\geckodriver.exe");
			driver = new FirefoxDriver();
	  }

@Test
public void verifySearchButton() throws InterruptedException {
	  
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    driver.get("https://accounts.google.com");

    driver.manage().window().maximize();
    
    String expectedTitle = " Sign in - Google Accounts ";
		
    String actualTitle = driver.getTitle();
    
    if (expectedTitle.equals(actualTitle))  {
	                     System.out.println("Verification Successful - The correct title is displayed on the web page.");
	              }
  	             else  {
  	                     System.out.println("Verification Failed - An incorrect title is displayed on the web page.");
  	              }    
    WebElement username = driver.findElement(By.id("identifierId"));
    username.clear();
    username.sendKeys("TestTeamCitySelenium");
    Thread.sleep(2000);    
    WebElement nextbtn = driver.findElement(By.id("identifierNext"));
    nextbtn.click();    
	}

@AfterClass
public void afterClass() {
	  
	  
	  driver.quit();
}

}
