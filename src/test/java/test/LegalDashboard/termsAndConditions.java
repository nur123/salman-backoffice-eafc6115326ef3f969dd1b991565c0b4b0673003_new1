package test.LegalDashboard;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

@Epic("Legal Dashboard")
@Feature("Terms and Conditions")

public class termsAndConditions {
    WebDriver driver;

    @BeforeSuite
    public void setUpTest() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://dev.bis.hijra.id/login");
    }

    @Test(priority = 0)
    @Description("User login to salman backoffice")
    @Story("User login to salman backoffice")
    public void loginTest() throws InterruptedException {
        driver.findElement(By.name("username")).sendKeys("superadmin6@gmail.com");
        driver.findElement(By.name("password")).sendKeys("batubata");
        driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
        Thread.sleep(3000);
    }

    @Test(priority = 1)
    @Description("User searches TnC data")
    @Story("user searches TnC data")
    public void searchTermsAndConditions() throws InterruptedException {
        driver.findElement(By.xpath("//span[contains(text(),'Legal')]")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Terms and Conditions')]")).click();
        Thread.sleep(3000);
    }

    @AfterSuite
    public void tearDownTest() {
        driver.close();
    }
}