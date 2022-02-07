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
@Feature("Journal Management - Approval Status")

public class ApprovalStatus extends BaseTest{

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
    @Description("Search by Transaction ID")
    @Story("Search by Transaction ID")
    public void searchTransactionID() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//span[contains(text(),'Journal Management')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[contains(text(),'Approval Status')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-createdAt"))
        ));
        driver.findElement(By.xpath("//input[@placeholder='Search here..']")).sendKeys("2ce0ae9a7e106b1");
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loading')]"))
        ));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-createdAt"))
        ));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\SearchByIdJournalApprovalStatus.png"));
        driver.findElement(By.xpath("//input[@placeholder='Search here..']")).clear();
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.NORMAL)
    @Description("Search by Account Number Permata")
    @Story("Search by Account Number Permata")
    public void searchAccountNumberPermata() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//input[@placeholder='Search here..']")).sendKeys("110100002808");
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loading')]"))
        ));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-createdAt"))
        ));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\SearchByAccPermataJournalApprovalStatus.png"));
        driver.findElement(By.xpath("//input[@placeholder='Search here..']")).clear();
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.NORMAL)
    @Description("Search by Account Number Hijra")
    @Story("Search by Account Number Hijra")
    public void searchAccountNumberHijra() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//input[@placeholder='Search here..']")).sendKeys("110100003124");
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loading')]"))
        ));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-createdAt"))
        ));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\SearchByAccHijraJournalApprovalStatus.png"));
        driver.findElement(By.xpath("//input[@placeholder='Search here..']")).clear();
    }

    @Test(priority = 4)
    @Severity(SeverityLevel.NORMAL)
    @Description("Filter Status By Date")
    @Story("Filter Status By Date")
    public void filterStatusByDate() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//img[@src='/icons/filter.png']")).click();
        driver.findElement(By.xpath("//div[contains(text(),'Select...')]")).click();
        driver.findElement(By.id("react-select-true-option-2")).click();
        driver.findElement(By.id("startDate")).sendKeys("01 November 2021");
        driver.findElement(By.id("endDate")).sendKeys("03 November 2021");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loading')]"))
        ));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-createdAt"))
        ));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\FilterByDateJournalApprovalStatus.png"));
    }

    @Test(priority = 5)
    @Severity(SeverityLevel.NORMAL)
    @Description("Download Data from Option Button")
    @Story("Download Data from Option Button")
    public void downloadFromOptionBtn() throws IOException, InterruptedException {
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Approve'])[1]/following::*[name()='svg'][1]")).click();
        driver.findElement(By.xpath("//button[contains(text(),'Download')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loading')]"))
        ));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-createdAt"))
        ));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\DownloadFromOptionJournalApprovalStatus.png"));
    }

    @Test(priority = 6)
    @Severity(SeverityLevel.NORMAL)
    @Description("See Details of Data")
    @Story("See Details of Data")
    public void seeDetails() throws IOException, InterruptedException {
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Approve'])[1]/following::*[name()='svg'][1]")).click();
        driver.findElement(By.xpath("//button[contains(text(),'See Detail')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loading')]"))
        ));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Confirmation to add balance')]"))
        ));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\SeeDetailsJournalApprovalStatus.png"));
    }

    @Test(priority = 7)
    @Severity(SeverityLevel.NORMAL)
    @Description("Download Data from Detail Menu")
    @Story("Download Data from Detail Menu")
    public void downloadFromDetailMenu() throws IOException, InterruptedException {
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Confirmation to add balance'])[1]/following::*[name()='svg'][1]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loading')]"))
        ));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Confirmation to add balance')]"))
        ));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\DownloadFromDetailsJournalApprovalStatus.png"));
        Thread.sleep(2000);
        List<WebElement> btn_x = driver.findElements(By.xpath("//button[@tabindex='0']"));
        btn_x.get(btn_x.size()-1).click();
        driver.navigate().refresh();
    }

    @Test(priority = 8)
    @Severity(SeverityLevel.NORMAL)
    @Description("Approve Approval Request")
    @Story("Approve Approval Request")
    public void approveRequest() throws IOException, InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 30);
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
        driver.findElement(By.xpath("//button[(text() = 'Confirm')]")).click();
        driver.findElement(By.xpath("//button[(text() = 'Approve')]")).click();
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'OK')]"))
        ));
        driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loading')]"))
        ));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-createdAt"))
        ));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\ApproveJournalApprovalStatus.png"));
        driver.navigate().refresh();
    }

    @Test(priority = 9)
    @Severity(SeverityLevel.NORMAL)
    @Description("Reject Approval Request with Null Reason")
    @Story("Reject Approval Request with Null Reason")
    public void rejectRequestNullReason() throws IOException, InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 30);
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
        driver.findElement(By.xpath("//button[(text() = 'Confirm')]")).click();
        driver.findElement(By.xpath("//button[(text() = 'Reject')]")).click();
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@id='reason']"))
        ));
        driver.findElement(By.xpath("//button[contains(text(),'Yes')]")).click();
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\RejectJournalApprovalStatusNullReason.png"));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loading')]"))
        ));
    }

    @Test(priority = 10)
    @Severity(SeverityLevel.NORMAL)
    @Description("Reject Approval Request")
    @Story("Reject Approval Request")
    public void rejectRequest() throws IOException, InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        driver.findElement(By.xpath("//textarea[@id='reason']")).sendKeys("Reason");
        driver.findElement(By.xpath("//button[contains(text(),'Yes')]")).click();
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loading')]"))
        ));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\RejectJournalApprovalStatus.png"));
    }
}