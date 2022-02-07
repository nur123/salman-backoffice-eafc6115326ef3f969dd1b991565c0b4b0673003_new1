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
@Feature("Customer Account - EKYC Result")

public class EKYC extends BaseTest {

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
    @Description("Show Approved EKYC List on Approval Menu")
    @Story("Show Approved EKYC List on Approval Menu")
    public void showApprovedEKYC() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//span[contains(text(),'Approval')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[contains(text(),'e-KYC')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-name"))
        ));
        driver.findElement(By.xpath("//button[contains(text(),'Approved')]")).click();
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loading')]"))
        ));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-name"))
        ));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\ApprovedApprovalEKYCList.png"));
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.NORMAL)
    @Description("Show Pending EKYC List on Approval Menu")
    @Story("Show Pending EKYC List on Approval Menu")
    public void showPendingEKYC() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//button[contains(text(),'Pending')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loading')]"))
        ));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-name"))
        ));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\PendingApprovalEKYCList.png"));
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.NORMAL)
    @Description("Show Waiting EKYC List on Approval Menu")
    @Story("Show Waiting EKYC List on Approval Menu")
    public void showWaitingEKYC() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//button[contains(text(),'Waiting')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loading')]"))
        ));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-name"))
        ));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\WaitingApprovalEKYCList.png"));
    }

    @Test(priority = 4)
    @Severity(SeverityLevel.NORMAL)
    @Description("Show Rejected EKYC List on Approval Menu")
    @Story("Show Rejected EKYC List on Approval Menu")
    public void showRejectedEKYC() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//button[contains(text(),'Rejected')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loading')]"))
        ));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-name"))
        ));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\RejectedApprovalEKYCList.png"));
    }

    @Test(priority = 5)
    @Severity(SeverityLevel.NORMAL)
    @Description("Show Force Delete EKYC List on Approval Menu")
    @Story("Show Force Delete EKYC List on Approval Menu")
    public void showForceDeleteEKYC() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//button[contains(text(),'Force Delete')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loading')]"))
        ));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-name"))
        ));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\ForceDeleteApprovalEKYCList.png"));
    }

    @Test(priority = 6)
    @Severity(SeverityLevel.NORMAL)
    @Description("Show All EKYC List on Approval Menu")
    @Story("Show All EKYC List on Approval Menu")
    public void showAllEKYC() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//button[contains(text(),'All')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loading')]"))
        ));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-name"))
        ));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\AllApprovalEKYCList.png"));
    }

    @Test(priority = 7)
    @Severity(SeverityLevel.NORMAL)
    @Description("Search One Account in Approval EKYC")
    @Story("Search One Account in Approval EKYC")
    public void searchAccApprovalEKYC() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//input[@placeholder='Search here..']")).sendKeys("test tengah mambu");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loading')]"))
        ));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-name"))
        ));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\SearchApprovalEKYC.png"));
        driver.findElement(By.xpath("//input[@placeholder='Search here..']")).sendKeys(Keys.chord(Keys.CONTROL, "a"));
        driver.findElement(By.xpath("//input[@placeholder='Search here..']")).sendKeys(Keys.BACK_SPACE);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loading')]"))
        ));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-name"))
        ));
    }

    @Test(priority = 8)
    @Severity(SeverityLevel.NORMAL)
    @Description("Show Submitted EKYC List on Approval Menu")
    @Story("Show Submitted EKYC List on Approval Menu")
    public void showSubmittedEKYC() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//button[contains(text(),'Submitted')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loading')]"))
        ));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-name"))
        ));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\SubmittedApprovalEKYCList.png"));
    }

    @Test(priority = 9)
    @Severity(SeverityLevel.NORMAL)
    @Description("Decide Submitted Approval EKYC with Null")
    @Story("Decide Submitted Approval EKYC with Null")
    public void decideSubmittedEKYCwithNull() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//a[contains(text(),'Decide')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'e-KYC Approval')]"))
        ));
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Supervisor Comment is required')]"));
        driver.findElement(By.xpath("//span[contains(text(),'Actions is required')]"));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\ErrorMsgSupervisorComment&ActionsApprovalEKYC.png"));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'Your approval ekyc has been submitted')]"))
        ));
    }

    @Test(priority = 10)
    @Severity(SeverityLevel.NORMAL)
    @Description("Decide Submitted Approval EKYC with Null Actions")
    @Story("Decide Submitted Approval EKYC with Null Actions")
    public void decideSubmittedEKYCwithNullActions() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//textarea[@name='ekycAnalysis']")).sendKeys("Supervisor Comment");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Actions is required')]"));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\ErrorMsgActionsApprovalEKYC.png"));
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'Your approval ekyc has been submitted')]"))
        ));
    }

    @Test(priority = 11)
    @Severity(SeverityLevel.NORMAL)
    @Description("Decide Submitted Approval EKYC with Null Supervisor Comment")
    @Story("Decide Submitted Approval EKYC with Null Supervisor Comment")
    public void decideSubmittedEKYCwithNullSpvComment() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//textarea[@name='ekycAnalysis']")).clear();
        driver.findElement(By.xpath("//div[contains(text(),'Choose actions')]")).click();
        driver.findElement(By.xpath("//div[contains(text(),'Approve')]")).click();
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Supervisor Comment is required')]"));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\ErrorMsgSupervisorCommentApprovalEKYC.png"));
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'Your approval ekyc has been submitted')]"))
        ));
    }

    @Test(priority = 12)
    @Severity(SeverityLevel.NORMAL)
    @Description("Approve Submitted Approval EKYC")
    @Story("Approve Submitted Approval EKYC")
    public void ApprovedSubmittedEKYC() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//textarea[@name='ekycAnalysis']")).sendKeys("Supervisor Comment");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loading')]"))
        ));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'Your approval ekyc has been submitted')]"))
        ));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\ApproveEKYCApproval.png"));
        driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();
    }

    @Test(priority = 13)
    @Severity(SeverityLevel.NORMAL)
    @Description("Reject Submitted Approval EKYC")
    @Story("Reject Submitted Approval EKYC")
    public void RejectSubmittedEKYC() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//span[contains(text(),'e-KYC')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-name"))
        ));
        driver.findElement(By.xpath("//button[contains(text(),'Submitted')]")).click();
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loading')]"))
        ));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-name"))
        ));
        driver.findElement(By.xpath("//a[contains(text(),'Decide')]")).click();
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'e-KYC Approval')]"))
        ));
        driver.findElement(By.xpath("//textarea[@name='ekycAnalysis']")).sendKeys("Supervisor Comment");
        driver.findElement(By.xpath("//div[contains(text(),'Choose actions')]")).click();
        driver.findElement(By.xpath("//div[contains(text(),'Reject')]")).click();
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loading')]"))
        ));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'Your approval ekyc has been submitted')]"))
        ));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\RejectEKYCApproval.png"));
        driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();
    }

    @Test(priority = 14)
    @Severity(SeverityLevel.NORMAL)
    @Description("Propose Change Submitted Approval EKYC")
    @Story("Propose Change Submitted Approval EKYC")
    public void ProposeChangeSubmittedEKYC() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//span[contains(text(),'e-KYC')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-name"))
        ));
        driver.findElement(By.xpath("//button[contains(text(),'Submitted')]")).click();
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loading')]"))
        ));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-name"))
        ));
        driver.findElement(By.xpath("//a[contains(text(),'Decide')]")).click();
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'e-KYC Approval')]"))
        ));
        driver.findElement(By.xpath("//textarea[@name='ekycAnalysis']")).sendKeys("Supervisor Comment");
        driver.findElement(By.xpath("//div[contains(text(),'Choose actions')]")).click();
        driver.findElement(By.xpath("//div[contains(text(),'Propose to change data')]")).click();
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loading')]"))
        ));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'Your approval ekyc has been submitted')]"))
        ));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\ProposeChangeDataEKYCApproval.png"));
        driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();
    }
}