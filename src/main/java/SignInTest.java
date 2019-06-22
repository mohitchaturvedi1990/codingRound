import com.sun.javafx.PlatformUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

@SuppressWarnings("unused")
public class SignInTest {

	private WebDriver driver=null;
	
	

    @Test
    public void shouldThrowAnErrorIfSignInDetailsAreMissing() {
    	DriverManager driverManagerInstance= DriverManager.getInstanceOfDriverManager();
    	driver=driverManagerInstance.getDriver();
    	
        driver.get("https://www.cleartrip.com/");
        waitFor(2000);

        driver.findElement(By.linkText("Your trips")).click();
        driver.findElement(By.id("SignIn")).click();
        
        
        
        driver.switchTo().alert();
        driver.findElement(By.xpath("//*[@id=\'email\']")).sendKeys("mohitchaturvedi091@gmail.com");
        driver.findElement(By.xpath("//*[@id=\'password\']")).sendKeys("123456");
        driver.findElement(By.id("signInButton")).click();
        
        String errors1 = driver.findElement(By.id("errors1")).getText();
        Assert.assertTrue(errors1.contains("There were errors in your submission"));
        driver.quit();
    }

    private void waitFor(int durationInMilliSeconds) {
        try {
            Thread.sleep(durationInMilliSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

   


}
