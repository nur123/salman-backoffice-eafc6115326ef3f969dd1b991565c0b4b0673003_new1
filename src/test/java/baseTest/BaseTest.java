package baseTest;

import config.env_target;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

public class BaseTest extends env_target {
    
	protected static WebDriver driver;
	public WebDriver getDriver() {
        return this.driver;
    }
    protected String projectPath = System.getProperty("user.dir");
    protected Properties tfile = readPropertiesFile(projectPath + "\\src\\test\\java\\data\\" + data_env + "-env.properties");
    protected String url = tfile.getProperty("url");
	
    @BeforeTest
    public void setup() throws SQLException, IOException, InterruptedException {
    	System.setProperty("webdriver.chrome.driver", projectPath+ "\\src\\test\\resources\\drivers\\chromedriver.exe");
    	driver = new ChromeDriver();
    	driver.get(url);
		driver.manage().window().maximize();
		Thread.sleep(2000);
    }

    @AfterTest
    public void tearDown() {
    	driver.close();
    }

}
