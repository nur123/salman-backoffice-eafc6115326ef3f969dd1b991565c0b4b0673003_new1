package test.AdminManagement;

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
@Epic("ON BOARDING")
@Feature("Admin Management")

public class AdminManagement extends BaseTest {

    VariableProperties vp = new VariableProperties();
    public String adminName = "Create From Automation " + (new SimpleDateFormat("ddMMyyyyHHmm").format(new Date()));
    public String editedName;
    public String adminEmail = "test" + (new SimpleDateFormat("ddMMyyyyHHmm").format(new Date())) + "@gmail.com";
    public String phoneNumber = "8" + (new SimpleDateFormat("ddMMyyyyHHmm").format(new Date()));

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
    @Description("Show Admin List")
    @Story("Show Admin List")
    public void showAdminList() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//span[contains(text(),'Admin Management')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-name"))
        ));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\ShowAdminManagementList.png"));
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.NORMAL)
    @Description("Add New Admin with Null")
    @Story("Add New Admin with Null")
    public void addNewAdminWithNull() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//button[contains(text(),'Add New User')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Save')]"))
        ));
        driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\AddNewAdminWithNull.png"));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loading')]"))
        ));
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.NORMAL)
    @Description("Add New Admin")
    @Story("Add New Admin")
    public void addNewAdmin() throws IOException, InterruptedException {
        driver.findElement(By.id("name")).sendKeys(adminName);
        driver.findElement(By.id("email")).sendKeys(adminEmail);
        driver.findElement(By.id("noHp")).sendKeys(phoneNumber);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-name"))
        ));
    }

    @Test(priority = 4)
    @Severity(SeverityLevel.NORMAL)
    @Description("Search Admin by Name")
    @Story("Search Admin by Name")
    public void searchAdminByName() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//input[@placeholder='Search here..']")).sendKeys(adminName);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loading')]"))
        ));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-name"))
        ));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\SearchAdminByName.png"));
    }

    @Test(priority = 5)
    @Severity(SeverityLevel.NORMAL)
    @Description("Edit Admin")
    @Story("Edit Admin")
    public void editAdmin() throws IOException, InterruptedException {
        List<WebElement> optionBtn = driver.findElements(By.xpath("//button[@aria-haspopup='true']"));
        optionBtn.get(1).click();
        driver.findElement(By.xpath("//button[contains(text(),'Edit')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Save')]"))
        ));
        Thread.sleep(1000);
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("noHp")).clear();
        Thread.sleep(1000);
        editedName = adminName + " Edited";
        driver.findElement(By.id("name")).sendKeys(editedName);
        adminEmail = "test" + (new SimpleDateFormat("ddMMyyyyHHmm").format(new Date())) + "@gmail.com";
        phoneNumber = "8" + (new SimpleDateFormat("ddMMyyyyHHmm").format(new Date()));
        driver.findElement(By.id("email")).sendKeys(adminEmail);
        driver.findElement(By.id("noHp")).sendKeys(phoneNumber);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-name"))
        ));
    }

    @Test(priority = 6)
    @Severity(SeverityLevel.NORMAL)
    @Description("Search Admin by Phone")
    @Story("Search Admin by Phone")
    public void searchAdminByPhone() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//input[@placeholder='Search here..']")).clear();
        Thread.sleep(500);
        driver.findElement(By.xpath("//input[@placeholder='Search here..']")).sendKeys(phoneNumber);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loading')]"))
        ));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-name"))
        ));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\SearchAdminByPhone.png"));
    }

    @Test(priority = 7)
    @Severity(SeverityLevel.NORMAL)
    @Description("Freeze Admin")
    @Story("Freeze Admin")
    public void freezeAdmin() throws IOException, InterruptedException {
        List<WebElement> optionBtn = driver.findElements(By.xpath("//button[@aria-haspopup='true']"));
        optionBtn.get(1).click();
        driver.findElement(By.xpath("//button[contains(text(),'Freeze')]")).click();
        Thread.sleep(2000);
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\FreezeAdmin.png"));
    }

    @Test(priority = 8)
    @Severity(SeverityLevel.NORMAL)
    @Description("Search Admin by Email")
    @Story("Search Admin by Email")
    public void searchAdminByEmail() throws IOException, InterruptedException {
        Thread.sleep(500);
        driver.findElement(By.xpath("//input[@placeholder='Search here..']")).clear();
        Thread.sleep(500);
        driver.findElement(By.xpath("//input[@placeholder='Search here..']")).sendKeys(adminEmail);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loading')]"))
        ));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-name"))
        ));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\SearchAdminByEmail.png"));
    }

    @Test(priority = 9)
    @Severity(SeverityLevel.NORMAL)
    @Description("Unfreeze Admin")
    @Story("Unfreeze Admin")
    public void unfreezeAdmin() throws IOException, InterruptedException {
        List<WebElement> optionBtn = driver.findElements(By.xpath("//button[@aria-haspopup='true']"));
        optionBtn.get(1).click();
        driver.findElement(By.xpath("//button[contains(text(),'Unfreezed')]")).click();
        Thread.sleep(2000);
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\UnfreezeAdmin.png"));
    }

    @Test(priority = 10)
    @Severity(SeverityLevel.NORMAL)
    @Description("Search Admin by Edited Name")
    @Story("Search Admin by Edited Name")
    public void searchAdminByEditedName() throws IOException, InterruptedException {
        Thread.sleep(500);
        driver.findElement(By.xpath("//input[@placeholder='Search here..']")).clear();
        Thread.sleep(500);
        driver.findElement(By.xpath("//input[@placeholder='Search here..']")).sendKeys(editedName);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loading')]"))
        ));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-name"))
        ));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\SearchAdminByEditedName.png"));
    }

    @Test(priority = 11)
    @Severity(SeverityLevel.NORMAL)
    @Description("Delete Admin")
    @Story("Delete Admin")
    public void deleteAdmin() throws IOException, InterruptedException {
        List<WebElement> optionBtn = driver.findElements(By.xpath("//button[@aria-haspopup='true']"));
        optionBtn.get(1).click();
        driver.findElement(By.xpath("//button[contains(text(),'Delete')]")).click();
        Thread.sleep(2000);
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\DeleteAdmin.png"));
    }

    @Test(priority = 12)
    @Severity(SeverityLevel.NORMAL)
    @Description("Filter Admin")
    @Story("Filter Admin")
    public void filterAdmin() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//input[@placeholder='Search here..']")).sendKeys(Keys.chord(Keys.CONTROL, "a"));
        driver.findElement(By.xpath("//input[@placeholder='Search here..']")).sendKeys(Keys.BACK_SPACE);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loading')]"))
        ));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-name"))
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
        driver.findElement(By.xpath("//button[contains(text(),'Set Filter')]")).click();
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loading')]"))
        ));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-name"))
        ));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\FilterAdmin.png"));
    }

    @Test(priority = 13)
    @Severity(SeverityLevel.NORMAL)
    @Description("See Detail")
    @Story("See Detail")
    public void seeDetail() throws IOException, InterruptedException {
        Thread.sleep(500);
        driver.findElement(By.xpath("//a[contains(text(),'Detail')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loading')]"))
        ));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Show All')]"))
        ));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\SeeDetailAdmin.png"));
    }

    @Test(priority = 14)
    @Severity(SeverityLevel.NORMAL)
    @Description("Download Log")
    @Story("Download Log")
    public void downloadLog() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//button[contains(text(),'Show All')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//img[@src='/icons/icon_download.svg']")).click();
        List<WebElement> dateInput = driver.findElements(By.xpath("//input[@id='startDate']"));
        dateInput.get(0).sendKeys("21 January 2020");
        dateInput.get(1).sendKeys("21 January 2022");
        driver.findElement(By.xpath("//button[contains(text(),'Download')]")).click();
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\DownloadLogAdmin.png"));
    }
}