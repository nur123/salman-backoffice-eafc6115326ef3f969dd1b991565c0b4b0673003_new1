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
@Feature("Approval - Marketing Campaign")

public class MarketingCampaign extends BaseTest {

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
    @Description("Show Active Marketing Campaign List on Approval Menu")
    @Story("Show Active Marketing Campaign List on Approval Menu")
    public void showActiveMarketingCampaignApproval() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//span[contains(text(),'Approval')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[contains(text(),'Marketing Campaign')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='table']"))
        ));
        driver.findElement(By.xpath("//button[contains(text(),'Active')]")).click();
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='table']"))
        ));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\ActiveApprovalMarketingCampaign.png"));
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.NORMAL)
    @Description("Show Inactive Marketing Campaign List on Approval Menu")
    @Story("Show Inactive Marketing Campaign List on Approval Menu")
    public void showInactiveMarketingCampaignApproval() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//button[contains(text(),'Inactive')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loading')]"))
        ));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='table']"))
        ));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\InactiveApprovalMarketingCampaign.png"));
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.NORMAL)
    @Description("Show Deleted Marketing Campaign List on Approval Menu")
    @Story("Show Deleted Marketing Campaign List on Approval Menu")
    public void showDeletedMarketingCampaignApproval() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//button[contains(text(),'Deleted')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loading')]"))
        ));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='table']"))
        ));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\DeletedApprovalMarketingCampaign.png"));
    }

    @Test(priority = 4)
    @Severity(SeverityLevel.NORMAL)
    @Description("Show All Marketing Campaign List on Approval Menu")
    @Story("Show All Marketing Campaign List on Approval Menu")
    public void showAllMarketingCampaignApproval() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//button[contains(text(),'All')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loading')]"))
        ));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='table']"))
        ));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\AllApprovalMarketingCampaign.png"));
    }

    @Test(priority = 5)
    @Severity(SeverityLevel.NORMAL)
    @Description("Search Account in Approval Marketing Campaign")
    @Story("Search Account in Approval Marketing Campaign")
    public void searchAccountMarketingCampaignApproval() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//input[@placeholder='Search here..']")).sendKeys("R0131");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loading')]"))
        ));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-code"))
        ));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\SearchApprovalMarketingCampaign.png"));
        driver.findElement(By.xpath("//input[@placeholder='Search here..']")).sendKeys(Keys.chord(Keys.CONTROL, "a"));
        driver.findElement(By.xpath("//input[@placeholder='Search here..']")).sendKeys(Keys.BACK_SPACE);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-code"))
        ));
    }

    @Test(priority = 6)
    @Severity(SeverityLevel.NORMAL)
    @Description("Show Pending Marketing Campaign List on Approval Menu")
    @Story("Show Pending Marketing Campaign List on Approval Menu")
    public void showPendingMarketingCampaignApproval() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//button[contains(text(),'Pending')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loading')]"))
        ));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='table']"))
        ));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\PendingApprovalMarketingCampaign.png"));
    }

    @Test(priority = 7)
    @Severity(SeverityLevel.NORMAL)
    @Description("Decide Approval Marketing Campaign with Null Supervisor Comment")
    @Story("Decide Approval Marketing Campaign with Null Supervisor Comment")
    public void decideApprovalMarketingCampaignWithNullSpvComment() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//a[contains(text(),'Decide')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Marketing code')]"))
        ));
        driver.findElement(By.xpath("//button[contains(text(),'Approve')]")).click();
        driver.findElement(By.xpath("//span[contains(text(),'*Supervisor Comment is required')]"));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\SupervisorCmtErrorMsgApprovalMarketingCampaigng.png"));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'Your approval marketing has been submitted')]"))
        ));
    }

    @Test(priority = 8)
    @Severity(SeverityLevel.NORMAL)
    @Description("Decide Approval Marketing Campaign with Null Supervisor Comment and Marketing File")
    @Story("Decide Approval Marketing Campaign with Null Supervisor Comment and Marketing File")
    public void decideApprovalMarketingCampaignWithNullSpvCommentAndFile() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//span[contains(text(),'Clear')]")).click();
        driver.findElement(By.xpath("//button[contains(text(),'Reject')]")).click();
        driver.findElement(By.xpath("//span[contains(text(),'*Supervisor Comment is required')]"));
        driver.findElement(By.xpath("//span[contains(text(),'*Image is required')]"));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\SupervisorCmt&MarketingImgErrorMsgApprovalMarketingCampaigng.png"));
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'Your approval marketing has been submitted')]"))
        ));
    }

    @Test(priority = 9)
    @Severity(SeverityLevel.NORMAL)
    @Description("Decide Approval Marketing Campaign with Null Marketing File")
    @Story("Decide Approval Marketing Campaign with Null Marketing File")
    public void decideApprovalMarketingCampaignWithNullFile() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//textarea[@name='comment']")).sendKeys("Supervisor Comment");
        driver.findElement(By.xpath("//button[contains(text(),'Propose to change data')]")).click();
        driver.findElement(By.xpath("//span[contains(text(),'*Image is required')]"));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\MarketingImgErrorMsgApprovalMarketingCampaigng.png"));
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'Your approval marketing has been submitted')]"))
        ));
    }

    @Test(priority = 10)
    @Severity(SeverityLevel.NORMAL)
    @Description("Decide Approval Marketing Campaign with Invalid Marketing File")
    @Story("Decide Approval Marketing Campaign with Invalid Marketing File")
    public void decideApprovalMarketingCampaignWithInvalidFile() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//input[@type='file']")).sendKeys(projectPath+ "\\src\\test\\resources\\files\\approvalMarketingCampaign.pdf");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'file not support, file is should type image/png,image/jpg,image/jpeg,image/gif')]"))
        ));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\UploadInvalidFileApprovalMarketingCampaigng.png"));
        driver.findElement(By.xpath("//button[contains(text(),'Approve')]")).click();
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'Your approval marketing has been submitted')]"))
        ));
    }

    @Test(priority = 11)
    @Severity(SeverityLevel.NORMAL)
    @Description("Approve Approval Marketing Campaign")
    @Story("Approve Approval Marketing Campaign")
    public void ApproveApprovalMarketingCampaign() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//span[contains(text(),'Clear')]")).click();
        driver.findElement(By.xpath("//input[@type='file']")).sendKeys(projectPath+ "\\src\\test\\resources\\files\\approvalMarketingCampaign.jpg");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[contains(text(),'Approve')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'Your approval marketing has been submitted')]"))
        ));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\ApproveApprovalMarketingCampaignResult.png"));
        driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loading')]"))
        ));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='table']"))
        ));
    }

    @Test(priority = 12)
    @Severity(SeverityLevel.NORMAL)
    @Description("Reject Approval Marketing Campaign")
    @Story("Reject Approval Marketing Campaign")
    public void RejectApprovalMarketingCampaign() throws IOException, InterruptedException {
        Thread.sleep(5000);
        driver.findElement(By.xpath("//span[contains(text(),'Marketing Campaign')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='table']"))
        ));
        driver.findElement(By.xpath("//button[contains(text(),'Pending')]")).click();
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-code"))
        ));
        driver.findElement(By.xpath("//a[contains(text(),'Decide')]")).click();
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Marketing code')]"))
        ));
        driver.findElement(By.xpath("//textarea[@name='comment']")).sendKeys("Supervisor Comment");
        driver.findElement(By.xpath("//button[contains(text(),'Reject')]")).click();
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'Your approval marketing has been submitted')]"))
        ));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\RejectApprovalMarketingCampaignResult.png"));
        driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loading')]"))
        ));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='table']"))
        ));
    }

    @Test(priority = 13)
    @Severity(SeverityLevel.NORMAL)
    @Description("Propose Change Data Approval Marketing Campaign")
    @Story("Propose Change Data Approval Marketing Campaign")
    public void ProposeChangeApprovalMarketingCampaign() throws IOException, InterruptedException {
        Thread.sleep(5000);
        driver.findElement(By.xpath("//span[contains(text(),'Marketing Campaign')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='table']"))
        ));
        driver.findElement(By.xpath("//button[contains(text(),'Pending')]")).click();
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-code"))
        ));
        driver.findElement(By.xpath("//a[contains(text(),'Decide')]")).click();
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Marketing code')]"))
        ));
        driver.findElement(By.xpath("//textarea[@name='comment']")).sendKeys("Supervisor Comment");
        driver.findElement(By.xpath("//button[contains(text(),'Propose to change data')]")).click();
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'Your approval marketing has been submitted')]"))
        ));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\ProposeChangeApprovalMarketingCampaignResult.png"));
        driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loading')]"))
        ));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='table']"))
        ));
    }
}