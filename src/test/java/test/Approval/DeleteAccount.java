package test.Approval;

import utils.VariableProperties;
import baseTest.BaseTest;
import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utils.TestListener;
import io.qameta.allure.*;
import org.testng.annotations.Listeners;

@Listeners({TestListener.class})
@Epic("ON BOARDING")
@Feature("Approval - Delete Account")

public class DeleteAccount extends BaseTest {

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
    @Description("Show Deleted List on Approval Delete Account")
    @Story("Show Deleted List on Approval Delete Account")
    public void showDeletedApprovalDelete() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//span[contains(text(),'Approval')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[contains(text(),'Delete Account')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-customerName"))
        ));
        driver.findElement(By.xpath("//button[contains(text(),'Deleted')]")).click();
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loading')]"))
        ));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-customerName"))
        ));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\DeletedApprovalDeleteList.png"));
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.NORMAL)
    @Description("Search Deleted Account on Approval Delete Account")
    @Story("Search Deleted Account on Approval Delete Account")
    public void searchDeletedAccount() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//input[@placeholder='Search here..']")).sendKeys("akun gmail");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loading')]"))
        ));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-customerName"))
        ));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\SearchDeletedApprovalDelete.png"));
        driver.findElement(By.xpath("//input[@placeholder='Search here..']")).sendKeys(Keys.chord(Keys.CONTROL, "a"));
        driver.findElement(By.xpath("//input[@placeholder='Search here..']")).sendKeys(Keys.BACK_SPACE);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loading')]"))
        ));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-customerName"))
        ));
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.NORMAL)
    @Description("Show Pending List on Approval Delete Account")
    @Story("Show Pending List on Approval Delete Account")
    public void showPendingApprovalDelete() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//button[contains(text(),'Pending')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loading')]"))
        ));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-customerName"))
        ));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\PendingApprovalDeleteList.png"));
    }

    @Test(priority = 4)
    @Severity(SeverityLevel.NORMAL)
    @Description("Search Pending Account on Approval Delete Account")
    @Story("Search Pending Account on Approval Delete Account")
    public void searchPendingAccount() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//input[@placeholder='Search here..']")).sendKeys("Angeline ZUper Buttercup");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loading')]"))
        ));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='table']"))
        ));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\SearchPendingApprovalDelete.png"));
        driver.findElement(By.xpath("//input[@placeholder='Search here..']")).sendKeys(Keys.chord(Keys.CONTROL, "a"));
        driver.findElement(By.xpath("//input[@placeholder='Search here..']")).sendKeys(Keys.BACK_SPACE);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loading')]"))
        ));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-customerName"))
        ));
    }

    @Test(priority = 5)
    @Severity(SeverityLevel.NORMAL)
    @Description("Decide Pending Approval Delete with Null")
    @Story("Decide Pending Approval Delete with Null")
    public void decidePendingWithNull() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//a[contains(text(),'Decide')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Delete Account Approval')]"))
        ));
        driver.findElement(By.xpath("//button[contains(text(),'Confirm Delete')]")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Supervisor comment is required')]"));
        driver.findElement(By.xpath("//span[contains(text(),'email is not valid')]"));
        driver.findElement(By.xpath("//span[contains(text(),'Date is required')]"));
        driver.findElement(By.xpath("//button[contains(text(),'Reject')]")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Supervisor comment is required')]"));
        driver.findElement(By.xpath("//span[contains(text(),'email is not valid')]"));
        driver.findElement(By.xpath("//span[contains(text(),'Date is required')]"));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\AllErrorMsgApprovalDelete.png"));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'Your approval ekyc has been submitted')]"))
        ));
    }

    @Test(priority = 6)
    @Severity(SeverityLevel.NORMAL)
    @Description("Decide Pending Approval Delete with Null Supervisor Comment")
    @Story("Decide Pending Approval Delete with Null Supervisor Comment")
    public void decidePendingWithNullSpvComment() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//input[@id='moneyOutDate']")).sendKeys("14 December 2030");
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("tes@gmail.com");
        driver.findElement(By.xpath("//button[contains(text(),'Confirm Delete')]")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Supervisor comment is required')]"));
        driver.findElement(By.xpath("//button[contains(text(),'Reject')]")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Supervisor comment is required')]"));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\ErrorMsgSupervisorCommentApprovalEKYC.png"));
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'Your approval ekyc has been submitted')]"))
        ));
    }

    @Test(priority = 7)
    @Severity(SeverityLevel.NORMAL)
    @Description("Decide Pending Approval Delete with Null Finance Email")
    @Story("Decide Pending Approval Delete with Null Finance Email")
    public void decidePendingWithNullFinanceEmail() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//textarea[@id='ekycAnalysis']")).sendKeys("Supervisor Comment");
        driver.findElement(By.xpath("//input[@name='email']")).clear();
        driver.findElement(By.xpath("//button[contains(text(),'Confirm Delete')]")).click();
        driver.findElement(By.xpath("//span[contains(text(),'email is not valid')]"));
        driver.findElement(By.xpath("//button[contains(text(),'Reject')]")).click();
        driver.findElement(By.xpath("//span[contains(text(),'email is not valid')]"));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\ErrorMsgFinanceEmailApprovalDelete.png"));
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'Your approval ekyc has been submitted')]"))
        ));
    }

    @Test(priority = 8)
    @Severity(SeverityLevel.NORMAL)
    @Description("Decide Pending Approval Delete with Null Money Out Estimation")
    @Story("Decide Pending Approval Delete with Null Money Out Estimation")
    public void decidePendingWithNullMoneyOut() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//input[@id='moneyOutDate']")).clear();
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("tes@gmail.com");
        driver.findElement(By.xpath("//button[contains(text(),'Confirm Delete')]")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Date is required')]"));
        driver.findElement(By.xpath("//button[contains(text(),'Reject')]")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Date is required')]"));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\ErrorMsgMoneyOutTimeApprovalDelete.png"));
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'Your approval ekyc has been submitted')]"))
        ));
    }

    @Test(priority = 9)
    @Severity(SeverityLevel.NORMAL)
    @Description("Approve Pending Approval Delete")
    @Story("Approve Pending Approval Delete")
    public void approvePendingApprovalDelete() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//input[@id='moneyOutDate']")).sendKeys("14 December 2030");
//		driver.findElement(By.xpath("//button[contains(text(),'Confirm Delete')]")).click();
//		WebDriverWait wait = new WebDriverWait(driver, 10);
//        wait.until(ExpectedConditions.or(
//            ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loading')]"))
//        ));
//        wait.until(ExpectedConditions.or(
//        	ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'OK')]"))
//        ));
//        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\ApproveApprovalDeleteResult.png"));
//        driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();
    }

    @Test(priority = 10)
    @Severity(SeverityLevel.NORMAL)
    @Description("Reject Pending Approval Delete")
    @Story("Reject Pending Approval Delete")
    public void rejectPendingApprovalDelete() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//span[contains(text(),'Delete Account')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-customerName"))
        ));
        driver.findElement(By.xpath("//button[contains(text(),'Pending')]")).click();
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loading')]"))
        ));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-customerName"))
        ));
        driver.findElement(By.xpath("//a[contains(text(),'Decide')]")).click();
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Delete Account Approval')]"))
        ));
        driver.findElement(By.xpath("//textarea[@id='ekycAnalysis']")).sendKeys("Supervisor Comment");
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("tes@gmail.com");
        driver.findElement(By.xpath("//input[@id='moneyOutDate']")).sendKeys("14 December 2030");
//		driver.findElement(By.xpath("//button[contains(text(),'Reject')]")).click();
//		wait.until(ExpectedConditions.or(
//            ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loading')]"))
//        ));
//        wait.until(ExpectedConditions.or(
//        	ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'OK')]"))
//        ));
//        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\RejectApprovalDeleteResult.png"));
//        driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();
    }
}