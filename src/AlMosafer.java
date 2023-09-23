import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AlMosafer {

	WebDriver driver = new ChromeDriver();
    SoftAssert softAssert = new SoftAssert();
    String Url = "https://global.almosafer.com/ar";
    


	@BeforeTest
	public void myBeforeTest() {
	    System.setProperty("webdriver.chrome.driver", "path/to/chromedriver.exe");


	}

	@Test()

	public void myTest() {
		driver.get(Url);
		driver.findElement(By.className("cta__saudi")).click();

        //  Check the language

		WebElement langugeElement =driver.findElement(By.cssSelector("[data-testid='Header__LanguageSwitch']"));
        String language = langugeElement.getText();
        softAssert.assertEquals(language , "English", "Language check failed");
        //  Check the currency

        WebElement theCurrency =driver.findElement(By.className("sc-dRFtgE"));
        String  currency =  theCurrency.getText();
        softAssert.assertEquals(currency , "SAR", "currency check failed");
//      //  Check the Fligh tab is selected
        boolean isFlightSelected = driver.findElement(By.id("uncontrolled-tab-example-tab-flights")).getAttribute("class").contains("active"); 
		softAssert.assertTrue(isFlightSelected);
        
        softAssert.assertAll();
        
        

        

	}

	@AfterTest

	public void myAfterTest() {
		driver.close();
	}

}
