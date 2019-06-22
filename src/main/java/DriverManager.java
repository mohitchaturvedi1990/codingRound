import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.sun.javafx.PlatformUtil;

@SuppressWarnings("restriction")
public class DriverManager {

	private static DriverManager instanceDriverMannager = null;
	
	private WebDriver driver;
	
	//constructor define as private for singleton design pattern
	@SuppressWarnings("restriction")
	private DriverManager() {
//		instanceDriverMannager.setDriverPath();
		if (PlatformUtil.isMac()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver");
        }
        if (PlatformUtil.isWindows()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        }
        if (PlatformUtil.isLinux()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver_linux");
        }
		driver= new ChromeDriver();
	}
	
	public static DriverManager getInstanceOfDriverManager(){
        if(instanceDriverMannager==null){
        	instanceDriverMannager = new DriverManager();
        }
        return instanceDriverMannager;
    }
    
    // To get driver
    public WebDriver getDriver()
    {
    	return driver;
    }
	
	
	
	
    private void setDriverPath() {
        if (PlatformUtil.isMac()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver");
        }
        if (PlatformUtil.isWindows()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        }
        if (PlatformUtil.isLinux()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver_linux");
        }
    }
	 
}
