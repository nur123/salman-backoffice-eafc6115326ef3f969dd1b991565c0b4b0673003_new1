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
@Feature("Journal Management - Incomplete Journal")

public class IncompleteJournal extends BaseTest{

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
    @Description("Show Data for Specific Start and End Date")
    @Story("Show Data for Specific Start and End Date")
    public void showDataByDate() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//span[contains(text(),'Journal Management')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[contains(text(),'Incomplete Journal')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-createdAt"))
        ));
        driver.findElement(By.id("startDate")).sendKeys("01 October 2020");
        driver.findElement(By.id("endDate")).sendKeys("14 December 2021");
        driver.findElement(By.xpath("//button[contains(text(),'Show')]")).click();
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loading')]"))
        ));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-createdAt"))
        ));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\showDataByDateIncompleteJournal.png"));
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.NORMAL)
    @Description("Show Incoming Transfer Data")
    @Story("Show Incoming Transfer Data")
    public void showIncomingTransferData() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//button[contains(text(),'Incoming Transfer')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loading')]"))
        ));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-createdAt"))
        ));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\showIncomingTransferIncompleteJournal.png"));
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.NORMAL)
    @Description("Search Incoming Transfer Data")
    @Story("Search Incoming Transfer Data")
    public void searchIncomingTransferData() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//input[@placeholder='Search here..']")).sendKeys("110100002810");
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loading')]"))
        ));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-createdAt"))
        ));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\searchIncomingTransferIncompleteJournal.png"));
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
    @Description("Complete Journal Incoming Transfer with Null Remarks")
    @Story("Complete Journal Incoming Transfer with Null Remarks")
    public void completeJournalIncomingTrfNullRemarks() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//button[contains(text(),'Complete Journal')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Incoming Transfer')]"))
        ));
        Thread.sleep(5000);
        List<WebElement> btn_completeJournal = driver.findElements(By.xpath("//button[contains(text(),'Complete Journal')]"));
        btn_completeJournal.get(btn_completeJournal.size()-1).click();
        driver.findElement(By.xpath("//span[contains(text(),'remarks is a required field')]"));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\CompleteIncomingTrfIncompleteJournalNullRemarks.png"));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='mb-2 Toast_notificationMessage__1Rf1w']"))
        ));
    }

    @Test(priority = 5)
    @Severity(SeverityLevel.NORMAL)
    @Description("Complete Journal Incoming Transfer")
    @Story("Complete Journal Incoming Transfer")
    public void completeJournalIncomingTrf() throws IOException, InterruptedException {
        driver.findElement(By.name("remarks")).sendKeys("Remarks");
        Thread.sleep(1000);
        List<WebElement> btn_completeJournal = driver.findElements(By.xpath("//button[contains(text(),'Complete Journal')]"));
        btn_completeJournal.get(btn_completeJournal.size()-1).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='mb-2 Toast_notificationMessage__1Rf1w']"))
        ));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\CompleteIncomingTrfIncompleteJournal.png"));
    }

    @Test(priority = 6)
    @Severity(SeverityLevel.NORMAL)
    @Description("See Detail Incoming Transfer Data")
    @Story("See Detail Incoming Transfer Data")
    public void seeDetailIncomingTransferData() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//button[contains(text(),'Detail')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loading')]"))
        ));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Incoming Transfer Detail')]"))
        ));
        Thread.sleep(2000);
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\seeDetailIncomingTransferIncompleteJournal.png"));
        driver.navigate().refresh();
    }

    @Test(priority = 7)
    @Severity(SeverityLevel.NORMAL)
    @Description("Show Outgoing Transfer Data")
    @Story("Show Outgoing Transfer Data")
    public void showOutgoingTransferData() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//button[contains(text(),'Outgoing Transfer')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loading')]"))
        ));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-createdAt"))
        ));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\showOutgoingTransferIncompleteJournal.png"));
    }

    @Test(priority = 8)
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
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\searchOutgoingTransferIncompleteJournal.png"));
        driver.findElement(By.xpath("//input[@placeholder='Search here..']")).sendKeys(Keys.chord(Keys.CONTROL, "a"));
        driver.findElement(By.xpath("//input[@placeholder='Search here..']")).sendKeys(Keys.BACK_SPACE);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loading')]"))
        ));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-createdAt"))
        ));
    }

    @Test(priority = 9)
    @Severity(SeverityLevel.NORMAL)
    @Description("Complete Journal Outgoing Transfer with Null Remarks")
    @Story("Complete Journal Outgoing Transfer with Null Remarks")
    public void completeJournalOutgoingTrfNullRemarks() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//button[contains(text(),'Complete Journal')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Outgoing Transfer')]"))
        ));
        Thread.sleep(5000);
        List<WebElement> btn_completeJournal = driver.findElements(By.xpath("//button[contains(text(),'Complete Journal')]"));
        btn_completeJournal.get(btn_completeJournal.size()-1).click();
        driver.findElement(By.xpath("//span[contains(text(),'remarks is a required field')]"));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\CompleteOutgoingTrfIncompleteJournalNullRemarks.png"));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='mb-2 Toast_notificationMessage__1Rf1w']"))
        ));
    }

    @Test(priority = 10)
    @Severity(SeverityLevel.NORMAL)
    @Description("Complete Journal Outgoing Transfer")
    @Story("Complete Journal Outgoing Transfer")
    public void completeJournalOutgoingTrf() throws IOException, InterruptedException {
        driver.findElement(By.name("remarks")).sendKeys("Remarks");
        Thread.sleep(1000);
        List<WebElement> btn_completeJournal = driver.findElements(By.xpath("//button[contains(text(),'Complete Journal')]"));
        btn_completeJournal.get(btn_completeJournal.size()-1).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='mb-2 Toast_notificationMessage__1Rf1w']"))
        ));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\CompleteOutgoingTrfIncompleteJournal.png"));
    }

    @Test(priority = 11)
    @Severity(SeverityLevel.NORMAL)
    @Description("See Detail Outgoing Transfer Data")
    @Story("See Detail Outgoing Transfer Data")
    public void seeDetailOutgoingTransferData() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//button[contains(text(),'Detail')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loading')]"))
        ));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Transfer Detail')]"))
        ));
        Thread.sleep(2000);
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\seeDetailOutgoingTransferIncompleteJournal.png"));
    }
}