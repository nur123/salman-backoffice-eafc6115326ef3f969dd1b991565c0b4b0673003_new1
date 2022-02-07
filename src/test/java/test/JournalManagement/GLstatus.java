package test.JournalManagement;

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
@Feature("Journal Management - GL Status")

public class GLstatus extends BaseTest{

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

    @Test(priority = 2)
    @Severity(SeverityLevel.NORMAL)
    @Description("Show Incoming Transfer Data")
    @Story("Show Incoming Transfer Data")
    public void showIncomingTransferData() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//span[contains(text(),'Journal Management')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[contains(text(),'GL Status')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-createdAt"))
        ));
        driver.findElement(By.xpath("//button[contains(text(),'Incoming Transfer')]")).click();
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loading')]"))
        ));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-createdAt"))
        ));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\showIncomingTransferGLStatus.png"));
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.NORMAL)
    @Description("Search Incoming Transfer Data")
    @Story("Search Incoming Transfer Data")
    public void searchIncomingTransferData() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//input[@placeholder='Search here..']")).sendKeys("110100002787");
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loading')]"))
        ));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-createdAt"))
        ));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\searchIncomingTransferGLStatus.png"));
        driver.findElement(By.xpath("//input[@placeholder='Search here..']")).sendKeys(Keys.chord(Keys.CONTROL, "a"));
        driver.findElement(By.xpath("//input[@placeholder='Search here..']")).sendKeys(Keys.BACK_SPACE);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loading')]"))
        ));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-createdAt"))
        ));
    }

    @Test(priority = 4)
    @Severity(SeverityLevel.NORMAL)
    @Description("Download Data from Option Button")
    @Story("Download Data from Option Button")
    public void downloadFromOptionBtn() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//div[@role='gridcell'][6]")).click();
        driver.findElement(By.xpath("//button[contains(text(),'Download')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loading')]"))
        ));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-createdAt"))
        ));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\DownloadFromOptionIncomingTrfGLstatus.png"));
    }

    @Test(priority = 5)
    @Severity(SeverityLevel.NORMAL)
    @Description("See Details of Data")
    @Story("See Details of Data")
    public void seeDetails() throws IOException, InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@role='gridcell'][6]")).click();
        driver.findElement(By.xpath("//button[contains(text(),'See Detail')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Incoming Transfer')]"))
        ));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\SeeDetailsIncomingTrfGLstatus.png"));
    }

    @Test(priority = 6)
    @Severity(SeverityLevel.NORMAL)
    @Description("Download Data from Detail Menu")
    @Story("Download Data from Detail Menu")
    public void downloadFromDetailMenu() throws IOException, InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//img[@src='/icons/icon_download.svg']")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        Thread.sleep(2000);
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\DownloadFromDetailsIncomingTrfGLstatus.png"));
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='flex ml-auto']")).click();
    }

    @Test(priority = 7)
    @Severity(SeverityLevel.NORMAL)
    @Description("Filter Status By Date")
    @Story("Filter Status By Date")
    public void filterStatusByDate() throws IOException, InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 40);
        driver.findElement(By.xpath("//img[@src='/icons/filter.png']")).click();
        driver.findElement(By.xpath("//div[contains(text(),'Select...')]")).click();
        driver.findElement(By.id("react-select-true-option-1")).click();
        driver.findElement(By.id("entryDate")).sendKeys("30 November 2021");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loading')]"))
        ));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-createdAt"))
        ));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\FilterByDateIncomingTrfGLstatus.png"));
    }

    @Test(priority = 8)
    @Severity(SeverityLevel.NORMAL)
    @Description("Approve Pending GL Status")
    @Story("Approve Pending GL Status")
    public void approvePendingGLstatus() throws IOException, InterruptedException {
        driver.navigate().refresh();
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-createdAt"))
        ));
        driver.findElement(By.xpath("//img[@src='/icons/filter.png']")).click();
        driver.findElement(By.xpath("//div[contains(text(),'Select...')]")).click();
        driver.findElement(By.id("react-select-true-option-1")).click();
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loading')]"))
        ));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-createdAt"))
        ));
        driver.findElement(By.xpath("//button[contains(text(),'Confirm')]")).click();
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Incoming Transfer')]"))
        ));
        driver.findElement(By.xpath("//textarea[@id='remarks']")).sendKeys("Remarks");
        driver.findElement(By.xpath("//button[contains(text(),'Approve')]")).click();
        driver.findElement(By.xpath("//button[contains(text(),'Yes')]")).click();
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'successful')]"))
        ));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\ApproveIncomingTrfGLstatus.png"));
    }

    @Test(priority = 9)
    @Severity(SeverityLevel.NORMAL)
    @Description("Reject Pending GL Status With Null Reason")
    @Story("Reject Pending GL Status With Null Reason")
    public void rejectPendingGLstatusWithNullReason() throws IOException, InterruptedException {
        driver.navigate().refresh();
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-createdAt"))
        ));
        driver.findElement(By.xpath("//img[@src='/icons/filter.png']")).click();
        driver.findElement(By.xpath("//div[contains(text(),'Select...')]")).click();
        driver.findElement(By.id("react-select-true-option-1")).click();
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loading')]"))
        ));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-createdAt"))
        ));
        driver.findElement(By.xpath("//button[contains(text(),'Confirm')]")).click();
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Incoming Transfer')]"))
        ));
        driver.findElement(By.xpath("//textarea[@id='remarks']")).sendKeys("Remarks");
        driver.findElement(By.xpath("//button[contains(text(),'Reject')]")).click();
        driver.findElement(By.xpath("//button[contains(text(),'Yes')]")).click();
        driver.findElement(By.xpath("//span[contains(text(),'reason is a required field')]"));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\RejectIncomingTrfGLstatusWithNullReason.png"));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'Reject  successful')]"))
        ));
    }

    @Test(priority = 10)
    @Severity(SeverityLevel.NORMAL)
    @Description("Reject Pending GL Status")
    @Story("Reject Pending GL Status")
    public void rejectPendingGLstatus() throws IOException, InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 40);
        driver.findElement(By.xpath("//textarea[@id='reason']")).sendKeys("Reason");
        driver.findElement(By.xpath("//button[contains(text(),'Yes')]")).click();
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'Reject  successful')]"))
        ));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\RejectIncomingTrfGLstatus.png"));
    }

    @Test(priority = 11)
    @Severity(SeverityLevel.NORMAL)
    @Description("Show Outgoing Transfer Data")
    @Story("Show Outgoing Transfer Data")
    public void showOutgoingTransferData() throws IOException, InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-createdAt"))
        ));
        driver.findElement(By.xpath("//button[contains(text(),'Outgoing Transfer')]")).click();
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loading')]"))
        ));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-createdAt"))
        ));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\showOutgoingTransferGLStatus.png"));
    }

    @Test(priority = 12)
    @Severity(SeverityLevel.NORMAL)
    @Description("Search Outgoing Transfer Data")
    @Story("Search Outgoing Transfer Data")
    public void searchOutgoingTransferData() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//input[@placeholder='Search here..']")).sendKeys("33456756713");
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loading')]"))
        ));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-createdAt"))
        ));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\searchOutgoingTransferGLStatus.png"));
        driver.findElement(By.xpath("//input[@placeholder='Search here..']")).sendKeys(Keys.chord(Keys.CONTROL, "a"));
        driver.findElement(By.xpath("//input[@placeholder='Search here..']")).sendKeys(Keys.BACK_SPACE);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loading')]"))
        ));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-createdAt"))
        ));
    }

    @Test(priority = 13)
    @Severity(SeverityLevel.NORMAL)
    @Description("Download Data from Option Button")
    @Story("Download Data from Option Button")
    public void downloadFromOptionBtnOutgoingTrf() throws IOException, InterruptedException {
        Thread.sleep(4000);
        driver.findElement(By.xpath("//div[@role='gridcell'][7]")).click();
        driver.findElement(By.xpath("//button[contains(text(),'Download')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loading')]"))
        ));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-createdAt"))
        ));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\DownloadFromOptionOutgoingTrfGLstatus.png"));
    }

    @Test(priority = 14)
    @Severity(SeverityLevel.NORMAL)
    @Description("See Details of Data")
    @Story("See Details of Data")
    public void seeDetailsOutgoingTrf() throws IOException, InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@role='gridcell'][7]")).click();
        driver.findElement(By.xpath("//button[contains(text(),'See Detail')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Outgoing Transfer')]"))
        ));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\SeeDetailsOutgoingTrfGLstatus.png"));
    }

    @Test(priority = 15)
    @Severity(SeverityLevel.NORMAL)
    @Description("Download Data from Detail Menu")
    @Story("Download Data from Detail Menu")
    public void downloadFromDetailMenuOutgoingTrf() throws IOException, InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//img[@src='/icons/icon_download.svg']")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        Thread.sleep(2000);
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\DownloadFromDetailsOutgoingTrfGLstatus.png"));
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='flex ml-auto']")).click();
    }

    @Test(priority = 16)
    @Severity(SeverityLevel.NORMAL)
    @Description("Filter Status By Date")
    @Story("Filter Status By Date")
    public void filterStatusByDateOutgoingTrf() throws IOException, InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-createdAt"))
        ));
        driver.findElement(By.xpath("//img[@src='/icons/filter.png']")).click();
        driver.findElement(By.xpath("//div[contains(text(),'Select...')]")).click();
        driver.findElement(By.id("react-select-true-option-1")).click();
        driver.findElement(By.id("entryDate")).sendKeys("30 November 2021");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loading')]"))
        ));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-createdAt"))
        ));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\FilterByDateOutgoingTrfGLstatus.png"));
    }

    @Test(priority = 17)
    @Severity(SeverityLevel.NORMAL)
    @Description("Approve Pending GL Status")
    @Story("Approve Pending GL Status")
    public void approvePendingGLstatusOutgoingTrf() throws IOException, InterruptedException {
        driver.navigate().refresh();
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-createdAt"))
        ));
        driver.findElement(By.xpath("//img[@src='/icons/filter.png']")).click();
        driver.findElement(By.xpath("//div[contains(text(),'Select...')]")).click();
        driver.findElement(By.id("react-select-true-option-1")).click();
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loading')]"))
        ));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-createdAt"))
        ));
        driver.findElement(By.xpath("//button[contains(text(),'Confirm')]")).click();
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Outgoing Transfer')]"))
        ));
        driver.findElement(By.xpath("//textarea[@id='remarks']")).sendKeys("Remarks");
        driver.findElement(By.xpath("//button[contains(text(),'Approve')]")).click();
        driver.findElement(By.xpath("//button[contains(text(),'Yes')]")).click();
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'successful')]"))
        ));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\ApproveOutgoingTrfGLstatus.png"));
    }

    @Test(priority = 18)
    @Severity(SeverityLevel.NORMAL)
    @Description("Reject Pending GL Status With Null Reason")
    @Story("Reject Pending GL Status With Null Reason")
    public void rejectPendingGLstatusOutgoingTrfWithNullReason() throws IOException, InterruptedException {
        driver.navigate().refresh();
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-createdAt"))
        ));
        driver.findElement(By.xpath("//img[@src='/icons/filter.png']")).click();
        driver.findElement(By.xpath("//div[contains(text(),'Select...')]")).click();
        driver.findElement(By.id("react-select-true-option-1")).click();
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loading')]"))
        ));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-createdAt"))
        ));
        driver.findElement(By.xpath("//button[contains(text(),'Confirm')]")).click();
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Outgoing Transfer')]"))
        ));
        driver.findElement(By.xpath("//textarea[@id='remarks']")).sendKeys("Remarks");
        driver.findElement(By.xpath("//button[contains(text(),'Reject')]")).click();
        driver.findElement(By.xpath("//button[contains(text(),'Yes')]")).click();
        driver.findElement(By.xpath("//span[contains(text(),'reason is a required field')]"));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\RejectOutgoingTrfGLstatusWithNullReason.png"));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'Reject  successful')]"))
        ));
    }

    @Test(priority = 19)
    @Severity(SeverityLevel.NORMAL)
    @Description("Reject Pending GL Status")
    @Story("Reject Pending GL Status")
    public void rejectPendingGLstatusOutgoingTrf() throws IOException, InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 40);
        driver.findElement(By.xpath("//textarea[@id='reason']")).sendKeys("Reason");
        driver.findElement(By.xpath("//button[contains(text(),'Yes')]")).click();
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'Reject  successful')]"))
        ));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\RejectOutgoingTrfGLstatus.png"));
    }
}