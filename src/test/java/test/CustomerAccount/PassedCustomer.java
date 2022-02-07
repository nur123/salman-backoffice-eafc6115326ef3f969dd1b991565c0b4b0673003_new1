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
@Feature("Customer Account - OTP Authentication")

public class PassedCustomer extends BaseTest {

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
    @Description("Show Passed Customer List on Customer Account Menu")
    @Story("Show Passed Customer List on Customer Account Menu")
    public void showPassedCustomer() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//span[contains(text(),'Customer Account')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[contains(text(),'Passed Customer')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-name"))
        ));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\PassedCustomerList.png"));
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.NORMAL)
    @Description("Review One Account in Passed Customer with null comment")
    @Story("Review One Account in Passed Customer with null comment")
    public void reviewWithNullComment() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//button[contains(text(),\"Review\")]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Comment wajib diisi')]"))
        ));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\FailReviewCustomer.png"));
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.NORMAL)
    @Description("Review One Account in Passed Customer")
    @Story("Review One Account in Passed Customer")
    public void successReview() throws IOException, InterruptedException {
        driver.findElement(By.id("note")).sendKeys("Comment");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='mb-2 Toast_notificationMessage__1Rf1w']"))
        ));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\reviewPassedCustomer.png"));
    }

    @Test(priority = 4)
    @Severity(SeverityLevel.NORMAL)
    @Description("Trying to Filtering Reviewed")
    @Story("Trying to Filtering Reviewed")
    public void filterReviewed() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//span[contains(text(),'Passed Customer')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-name"))
        ));
        driver.findElement(By.xpath("//div[contains(text(),\"Not Reviewed\")]")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("react-select-true-option-0")).click();
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-name"))
        ));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\ReviewedPassedCustomerList.png"));
    }

    @Test(priority = 5)
    @Severity(SeverityLevel.NORMAL)
    @Description("Trying to Filtering All Passed Customer")
    @Story("Trying to Filtering All Passed Customer")
    public void filterAllPassedCustomer() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//div[contains(text(),\"Reviewed\")]")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("react-select-true-option-2")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-name"))
        ));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\AllPassedCustomerList.png"));
    }

    @Test(priority = 6)
    @Severity(SeverityLevel.NORMAL)
    @Description("Search One Account in Passed Customer")
    @Story("Search One Account in Passed Customer")
    public void searchPassedCustomer() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//input[@placeholder='Search here..']")).sendKeys("onboarding baru 1");
        Thread.sleep(3000);
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\SearchAccPassedCustomer.png"));
    }
}