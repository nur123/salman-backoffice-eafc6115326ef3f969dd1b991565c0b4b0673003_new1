package test.AdminActivityRecord;

import utils.VariableProperties;
import baseTest.BaseTest;

import java.awt.Robot;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

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
@Epic("Admin")
@Feature("Admin Activity Record")

public class AdminActivityRecord extends BaseTest{

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
    @Description("Show Admin Activity Record Menu")
    @Story("Show Admin Activity Record Menu")
    public void showAdminActivityRecordMenu() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//span[contains(text(),'Admin Activity Record')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-user"))
        ));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\ShowAdminActivityRecordMenu.png"));
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.NORMAL)
    @Description("Show All Active User")
    @Story("Show All Active User")
    public void showAllActiveUser() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//button[contains(text(),'Show All')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loading')]"))
        ));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-user"))
        ));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\ShowAllActiveUser.png"));
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.NORMAL)
    @Description("Search Active User")
    @Story("Search Active User")
    public void searchActiveUser() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//input[@placeholder='Search here..']")).sendKeys("kkanskjd@gmail.com");
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'kkanskjd@gmail.com')]"))
        ));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\SearchActiveUser.png"));
    }

    @Test(priority = 4)
    @Severity(SeverityLevel.NORMAL)
    @Description("Freeze Active User")
    @Story("Freeze Active User")
    public void freezeActiveUser() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//button[contains(text(),'Freeze')]")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\FreezeActiveUser.png"));
        Thread.sleep(1000);
        List<WebElement> btnOK = driver.findElements(By.xpath("//button[contains(text(),'OK')]"));
        btnOK.get(btnOK.size()-1).click();
        Thread.sleep(500);
    }

    @Test(priority = 5)
    @Severity(SeverityLevel.NORMAL)
    @Description("Unfreeze Active User")
    @Story("Unfreeze Active User")
    public void unfreezeActiveUser() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//button[contains(text(),'Unfreeze')]")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\UnfreezeActiveUser.png"));
        Thread.sleep(1000);
        List<WebElement> btnOK = driver.findElements(By.xpath("//button[contains(text(),'OK')]"));
        btnOK.get(btnOK.size()-1).click();
        Thread.sleep(500);
    }

    @Test(priority = 6)
    @Severity(SeverityLevel.NORMAL)
    @Description("Filter Active User")
    @Story("Filter Active User")
    public void filterActiveUser() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//input[@placeholder='Search here..']")).sendKeys(Keys.chord(Keys.CONTROL, "a"));
        driver.findElement(By.xpath("//input[@placeholder='Search here..']")).sendKeys(Keys.BACK_SPACE);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loading')]"))
        ));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-user"))
        ));
        driver.findElement(By.xpath("//img[@src='/icons/filter.png']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//select[@id='domain']")).click();
        Thread.sleep(1000);
        List<WebElement> superAdminOption = driver.findElements(By.xpath("//option[@value='SUPER_ADMIN']"));
        superAdminOption.get(0).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//select[@id='role']")).click();
        Thread.sleep(1000);
        superAdminOption.get(1).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//select[@id='status']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//option[@value='active']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//select[@id='activity']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//option[@value='online']")).click();
        driver.findElement(By.xpath("//button[contains(text(),'Set Filter')]")).click();
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-user"))
        ));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\FilterActiveUser.png"));
    }

    @Test(priority = 7)
    @Severity(SeverityLevel.NORMAL)
    @Description("Show All Log Live Feed")
    @Story("Show All Log Live Feed")
    public void showAllLogLiveFeed() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//button[contains(text(),'Back')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loading')]"))
        ));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-user"))
        ));
        List<WebElement> showAllBtn = driver.findElements(By.xpath("//button[contains(text(),'Show All')]"));
        showAllBtn.get(showAllBtn.size()-1).click();
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loading')]"))
        ));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'See Detail')]"))
        ));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\ShowAllLogLiveFeed.png"));
    }

    @Test(priority = 8)
    @Severity(SeverityLevel.NORMAL)
    @Description("Download Log")
    @Story("Download Log")
    public void downloadLog() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//img[@src='/icons/icon_download.svg']")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("startDateDownload")).sendKeys("7 June 2021");
        driver.findElement(By.id("endDateDownload")).sendKeys("8 June 2021");
        driver.findElement(By.xpath("//button[contains(text(),'Download')]")).click();
        Thread.sleep(3000);
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\Download Log.png"));
    }

    @Test(priority = 9)
    @Severity(SeverityLevel.NORMAL)
    @Description("Search Log Live Feed")
    @Story("Search Log Live Feed")
    public void searchLogLiveFeedByEmail() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//input[@placeholder='Search here..']")).sendKeys("suprjenius11@gmail.com");
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'See Detail')]"))
        ));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\SearchLogLiveFeed.png"));
    }

    @Test(priority = 10)
    @Severity(SeverityLevel.NORMAL)
    @Description("See Detail Log Live Feed")
    @Story("See Detail Log Live Feed")
    public void seeDetailLogLiveFeed() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//a[contains(text(),'See Detail')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'suprjenius11@gmail.com')]"))
        ));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\SeeDetailLogLiveFeed.png"));
    }

    @Test(priority = 11)
    @Severity(SeverityLevel.NORMAL)
    @Description("Filter Log Live Feed")
    @Story("Filter Log Live Feed")
    public void filterLogLiveFeed() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//button[contains(text(),'Back')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loading')]"))
        ));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'See Detail')]"))
        ));
        driver.findElement(By.xpath("//img[@src='/icons/filter.png']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//select[@id='domain']")).click();
        Thread.sleep(1000);
        List<WebElement> superAdminOption = driver.findElements(By.xpath("//option[@value='SUPER_ADMIN']"));
        superAdminOption.get(0).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//select[@id='role']")).click();
        Thread.sleep(1000);
        superAdminOption.get(1).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[contains(text(),'Select admin')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[contains(text(),'Rojak Kholer')]")).click();
        driver.findElement(By.id("startDate")).sendKeys("20 January 2021");
        driver.findElement(By.id("endDate")).sendKeys("20 January 2022");
        driver.findElement(By.xpath("//button[contains(text(),'Set Filter')]")).click();
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Rojak Kholer')]"))
        ));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\FilterLogLiveFeed.png"));
    }

}