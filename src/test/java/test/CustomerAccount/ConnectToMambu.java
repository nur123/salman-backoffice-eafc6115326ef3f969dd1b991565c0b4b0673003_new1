package test.CustomerAccount;

import utils.VariableProperties;
import baseTest.BaseTest;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utils.TestListener;
import io.qameta.allure.*;
import org.testng.annotations.Listeners;

@Listeners({TestListener.class})
@Epic("ON BOARDING")
@Feature("Customer Account - Connect To Mambu")

public class ConnectToMambu extends BaseTest {

    VariableProperties vp = new VariableProperties();

    @Test(priority = 0)
    @Severity(SeverityLevel.NORMAL)
    @Description("Input email and password for login")
    @Story("Input email and password for login")
    public void loginValid() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys(vp.getEmailDev());
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(vp.getPassDev());
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\Login.png"));
        driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'Welcome, Admin!')]"))
        ));
        File srcFile2 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile2, new File(projectPath+ "\\src\\test\\java\\screenshots\\LoginDashboard.png"));
    }

    @Test(priority = 1)
    @Severity(SeverityLevel.NORMAL)
    @Description("Retry One Account that has not been Connected to Mambu")
    @Story("Retry One Account that has not been Connected to Mambu")
    public void retryConnectToMambu() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//span[contains(text(),'Customer Account')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[contains(text(),'Connect to Mambu')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='table']"))
        ));
        driver.findElement(By.xpath("//button[contains(text(),\"Retry\")]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[contains(text(),\"OK\")]")).click();
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'Retry success')]"))
        ));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\retryConnectToMambu.png"));
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.NORMAL)
    @Description("Filter Connected Connect To Mambu List")
    @Story("Filter Connected Connect To Mambu List")
    public void filterConnected() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//span[contains(text(),'Connect to Mambu')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='table']"))
        ));
        driver.findElement(By.xpath("//div[contains(text(),\"Not Connected\")]")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("react-select-true-option-0")).click();
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-name"))
        ));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\ConnectedToMambuList.png"));
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.NORMAL)
    @Description("Filter All Connect To Mambu List")
    @Story("Filter All Connect To Mambu List")
    public void filterAll() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//div[contains(text(),\"Connected\")]")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("react-select-true-option-2")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-name"))
        ));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\AllConnectToMambuList.png"));
    }

    @Test(priority = 4)
    @Severity(SeverityLevel.NORMAL)
    @Description("Filter All Connect To Mambu List")
    @Story("Filter All Connect To Mambu List")
    public void filterNotConnected() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//div[contains(text(),\"All\")]")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("react-select-true-option-1")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-name"))
        ));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\NotConnectedConnectToMambuList.png"));
    }
}