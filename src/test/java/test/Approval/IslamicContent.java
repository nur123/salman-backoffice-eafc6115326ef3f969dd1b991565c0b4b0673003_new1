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
@Feature("Approval - Islamic Content")

public class IslamicContent extends BaseTest {

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
    @Description("Show Active Islamic Content List on Approval Menu")
    @Story("Show Active Islamic Content List on Approval Menu")
    public void showActiveIslamicContentApproval() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//span[contains(text(),'Approval')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[contains(text(),'Islamic Content')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='table']"))
        ));
        driver.findElement(By.xpath("//button[contains(text(),'Active')]")).click();
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='table']"))
        ));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\ActiveApprovalIslamicContent.png"));
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.NORMAL)
    @Description("Show Inactive Islamic Content List on Approval Menu")
    @Story("Show Inactive Islamic Content List on Approval Menu")
    public void showInactiveIslamicContentApproval() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//button[contains(text(),'Inactive')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loading')]"))
        ));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='table']"))
        ));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\InactiveApprovalIslamicContent.png"));
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.NORMAL)
    @Description("Show Deleted Islamic Content List on Approval Menu")
    @Story("Show Deleted Islamic Content List on Approval Menu")
    public void showDeletedIslamicContentApproval() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//button[contains(text(),'Deleted')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loading')]"))
        ));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='table']"))
        ));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\DeletedApprovalIslamicContent.png"));
    }

    @Test(priority = 4)
    @Severity(SeverityLevel.NORMAL)
    @Description("Show All Islamic Content List on Approval Menu")
    @Story("Show All Islamic Content List on Approval Menu")
    public void showAllIslamicContentApproval() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//button[contains(text(),'All')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loading')]"))
        ));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='table']"))
        ));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\AllApprovalIslamicContent.png"));
    }

    @Test(priority = 5)
    @Severity(SeverityLevel.NORMAL)
    @Description("Search Account in Approval Islamic Content")
    @Story("Search Account in Approval Islamic Content")
    public void searchAccountIslamicContentApproval() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//input[@placeholder='Search here..']")).sendKeys("Istighfar yuk!");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loading')]"))
        ));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-code"))
        ));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\SearchApprovalIslamicContent.png"));
        driver.findElement(By.xpath("//input[@placeholder='Search here..']")).sendKeys(Keys.chord(Keys.CONTROL, "a"));
        driver.findElement(By.xpath("//input[@placeholder='Search here..']")).sendKeys(Keys.BACK_SPACE);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-code"))
        ));
    }

    @Test(priority = 6)
    @Severity(SeverityLevel.NORMAL)
    @Description("Show Pending Islamic Content List on Approval Menu")
    @Story("Show Pending Islamic Content List on Approval Menu")
    public void showPendingIslamicContentApproval() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//button[contains(text(),'Pending')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loading')]"))
        ));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='table']"))
        ));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\PendingApprovalIslamicContent.png"));
    }

    @Test(priority = 7)
    @Severity(SeverityLevel.NORMAL)
    @Description("Decide Approval Islamic Content with Null Supervisor Comment")
    @Story("Decide Approval Islamic Content with Null Supervisor Comment")
    public void decideApprovalIslamicContentWithNullSpvComment() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//a[contains(text(),'Decide')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Title')]"))
        ));
        driver.findElement(By.xpath("//button[contains(text(),'Approve')]")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Supervisor Comment is required')]"));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\SupervisorCmtErrorMsgApprovalIslamicContentg.png"));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loading')]"))
        ));
    }

    @Test(priority = 8)
    @Severity(SeverityLevel.NORMAL)
    @Description("Decide Approval Islamic Content with Null Supervisor Comment and Marketing File")
    @Story("Decide Approval Islamic Content with Null Supervisor Comment and Marketing File")
    public void decideApprovalIslamicContentWithNullSpvCommentAndFile() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//button[contains(text(),'Clear')]")).click();
        driver.findElement(By.xpath("//button[contains(text(),'Reject')]")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Supervisor Comment is required')]"));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\SupervisorCmt&MarketingImgErrorMsgApprovalIslamicContentg.png"));
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loading')]"))
        ));
    }

    @Test(priority = 9)
    @Severity(SeverityLevel.NORMAL)
    @Description("Decide Approval Islamic Content with Null Marketing File")
    @Story("Decide Approval Islamic Content with Null Marketing File")
    public void decideApprovalIslamicContentWithNullFile() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//textarea[@name='comment']")).sendKeys("Supervisor Comment");
        driver.findElement(By.xpath("//button[contains(text(),'Propose to change data')]")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Upload your image first!')]"));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\MarketingImgErrorMsgApprovalIslamicContentg.png"));
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loading')]"))
        ));
    }

    @Test(priority = 10)
    @Severity(SeverityLevel.NORMAL)
    @Description("Decide Approval Islamic Content with Invalid Marketing File")
    @Story("Decide Approval Islamic Content with Invalid Marketing File")
    public void decideApprovalIslamicContentWithInvalidFile() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//input[@type='file']")).sendKeys(projectPath+ "\\src\\test\\resources\\files\\approvalIslamicContent.pdf");
        driver.findElement(By.xpath("//button[contains(text(),'Approve')]")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Upload your image first!')]"));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\UploadInvalidFileApprovalIslamicContentg.png"));
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loading')]"))
        ));
    }

    @Test(priority = 11)
    @Severity(SeverityLevel.NORMAL)
    @Description("Approve Approval Islamic Content")
    @Story("Approve Approval Islamic Content")
    public void ApproveApprovalIslamicContent() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//button[contains(text(),'Clear')]")).click();
        driver.findElement(By.xpath("//input[@type='file']")).sendKeys(projectPath+ "\\src\\test\\resources\\files\\approvalIslamicContent.jpeg");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[contains(text(),'Approve')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loading')]"))
        ));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\ApproveApprovalIslamicContentResult.png"));
    }

    @Test(priority = 12)
    @Severity(SeverityLevel.NORMAL)
    @Description("Reject Approval Islamic Content")
    @Story("Reject Approval Islamic Content")
    public void RejectApprovalIslamicContent() throws IOException, InterruptedException {
        Thread.sleep(5000);
        driver.findElement(By.xpath("//span[contains(text(),'Islamic Content')]")).click();
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
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Title')]"))
        ));
        driver.findElement(By.xpath("//textarea[@name='comment']")).sendKeys("Supervisor Comment");
        driver.findElement(By.xpath("//button[contains(text(),'Reject')]")).click();
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loading')]"))
        ));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\RejectApprovalIslamicContentResult.png"));
    }

    @Test(priority = 13)
    @Severity(SeverityLevel.NORMAL)
    @Description("Propose Change Data Approval Islamic Content")
    @Story("Propose Change Data Approval Islamic Content")
    public void ProposeChangeApprovalIslamicContent() throws IOException, InterruptedException {
        Thread.sleep(5000);
        driver.findElement(By.xpath("//span[contains(text(),'Islamic Content')]")).click();
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
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Title')]"))
        ));
        driver.findElement(By.xpath("//textarea[@name='comment']")).sendKeys("Supervisor Comment");
        driver.findElement(By.xpath("//button[contains(text(),'Propose to change data')]")).click();
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loading')]"))
        ));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\ProposeChangeApprovalIslamicContentResult.png"));
    }
}