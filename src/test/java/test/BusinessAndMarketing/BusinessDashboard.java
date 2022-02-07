package test.BusinessAndMarketing;

import utils.VariableProperties;
import baseTest.BaseTest;
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
@Feature("Business & Marketing - Business Dashboard")

public class BusinessDashboard extends BaseTest{

    VariableProperties vp = new VariableProperties();
    public String campaignName = "Automation " + (new SimpleDateFormat("ddMMyyyyHHmm").format(new Date()));
    public int option = 0;
    public int prevOption = 0;
    public int recipientType = 3;
    public int prevRecipientType = 3;
    public int quota = 10;

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
    @Description("Show Inactive Business Dashboard")
    @Story("Show Inactive Business Dashboard")
    public void showInactiveBusinessDashboard() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//span[contains(text(),'Business & Marketing')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[contains(text(),'Business Dashboard')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-type"))
        ));
        driver.findElement(By.xpath("//button[contains(text(),'Inactive')]")).click();
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loading')]"))
        ));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-type"))
        ));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\showInactiveBusinessDashboard.png"));
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.NORMAL)
    @Description("Show Pending Business Dashboard")
    @Story("Show Pending Business Dashboard")
    public void showPendingBusinessDashboard() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//button[contains(text(),'Pending')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loading')]"))
        ));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-type"))
        ));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\showPendingBusinessDashboard.png"));
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.NORMAL)
    @Description("Show Deleted Business Dashboard")
    @Story("Show Deleted Business Dashboard")
    public void showDeletedBusinessDashboard() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//button[contains(text(),'Deleted')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loading')]"))
        ));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-type"))
        ));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\showDeletedBusinessDashboard.png"));
    }

    @Test(priority = 4)
    @Severity(SeverityLevel.NORMAL)
    @Description("Show Live Business Dashboard")
    @Story("Show Live Business Dashboard")
    public void showLiveBusinessDashboard() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//button[contains(text(),'Live')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loading')]"))
        ));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-type"))
        ));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\showLiveBusinessDashboard.png"));
    }

    @Test(priority = 5)
    @Severity(SeverityLevel.NORMAL)
    @Description("Show Active Business Dashboard")
    @Story("Show Active Business Dashboard")
    public void showActiveBusinessDashboard() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//button[contains(text(),'Active')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loading')]"))
        ));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-type"))
        ));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\showActiveBusinessDashboard.png"));
    }

    @Test(priority = 6)
    @Severity(SeverityLevel.NORMAL)
    @Description("Add New Campaign with Null")
    @Story("Add New Campaign with Null")
    public void addNewCampaignWithNull() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//button[contains(text(),'Add new Campaign')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Add Campaign')]"))
        ));
        driver.findElement(By.xpath("//button[contains(text(),'Add Campaign')]")).click();
        driver.findElement(By.xpath("//span[contains(text(),'title is a required field')]"));
        driver.findElement(By.xpath("//span[contains(text(),'type is a required field')]"));
        driver.findElement(By.xpath("//span[contains(text(),'Quota Is A Required Field')]"));
        driver.findElement(By.xpath("//span[contains(text(),'startTimeValidity is a required field')]"));
    }

    @Test(priority = 6)
    @Severity(SeverityLevel.NORMAL)
    @Description("Add New Campaign with Only Fill Title")
    @Story("Add New Campaign with Only Fill Title")
    public void addNewCampaignWithOnlyFillTitle() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//input[@id='title']")).sendKeys(campaignName);
        driver.findElement(By.xpath("//button[contains(text(),'Add Campaign')]")).click();
        driver.findElement(By.xpath("//span[contains(text(),'type is a required field')]"));
        driver.findElement(By.xpath("//span[contains(text(),'Quota Is A Required Field')]"));
        driver.findElement(By.xpath("//span[contains(text(),'startTimeValidity is a required field')]"));
    }

    @Test(priority = 7)
    @Severity(SeverityLevel.NORMAL)
    @Description("Add New Campaign with Only Fill Title and Type")
    @Story("Add New Campaign with Only Fill Title and Type")
    public void addNewCampaignWithOnlyFillTitleType() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//div[@class=' css-1wy0on6']")).click();
        Random rand = new Random();
        List<Integer> list = Arrays.asList(0, 1, 2);
        option = list.get(rand.nextInt(list.size()));
        driver.findElement(By.id("react-select-true-option-" + Integer.toString(option))).click();
        driver.findElement(By.xpath("//button[contains(text(),'Add Campaign')]")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Quota Is A Required Field')]"));
        driver.findElement(By.xpath("//span[contains(text(),'startTimeValidity is a required field')]"));
    }

    @Test(priority = 8)
    @Severity(SeverityLevel.NORMAL)
    @Description("Add New Campaign with Null Time Validity")
    @Story("Add New Campaign with Null Time Validity")
    public void addNewCampaignWithNullStartEndDate() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//input[@id='quota']")).sendKeys(Integer.toString(quota));
        driver.findElement(By.xpath("//button[contains(text(),'Add Campaign')]")).click();
        driver.findElement(By.xpath("//span[contains(text(),'startTimeValidity is a required field')]"));
    }

    @Test(priority = 9)
    @Severity(SeverityLevel.NORMAL)
    @Description("Add New Campaign with Null End Time Validity")
    @Story("Add New Campaign with Null End Time Validity")
    public void addNewCampaignWithNullEndDate() throws IOException, InterruptedException {
        driver.findElement(By.id("startTimeValidity")).sendKeys("20 June 2022");
        driver.findElement(By.xpath("//button[contains(text(),'Add Campaign')]")).click();
        driver.findElement(By.xpath("//span[contains(text(),'endTimeValidity is a required field')]"));
    }

    @Test(priority = 10)
    @Severity(SeverityLevel.NORMAL)
    @Description("Add New Campaign with Null Recipient")
    @Story("Add New Campaign with Null Recipient")
    public void addNewCampaignWithNullRecipient() throws IOException, InterruptedException {
        driver.findElement(By.id("endTimeValidity")).sendKeys("20 June 2023");
        driver.findElement(By.xpath("//button[contains(text(),'Add Campaign')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[contains(text(),'Gagal')]"))
        ));
        driver.findElement(By.xpath("//button[@tabindex='0']")).click();
    }

    @Test(priority = 11)
    @Severity(SeverityLevel.NORMAL)
    @Description("Finish Add New Campaign")
    @Story("Finish Add New Campaign")
    public void finishAddNewCampaign() throws IOException, InterruptedException {
        Random rand = new Random();
        List<Integer> list = Arrays.asList(0, 2, 3);
        recipientType = list.get(rand.nextInt(list.size()));
        switch(recipientType) {
            case 0:
                driver.findElement(By.xpath("//input[@id='all']")).click();
            case 1:
                driver.findElement(By.xpath("balance")).click();
            case 2:
                driver.findElement(By.xpath("//input[@id='dateCreated']")).click();
                driver.findElement(By.id("startCustomerActiveDate")).sendKeys("20 June 2020");
                driver.findElement(By.id("endCustomerActiveDate")).sendKeys("20 June 2021");
            case 3:
                driver.findElement(By.xpath("//input[@id='csvUpload']")).click();
                driver.findElement(By.xpath("//input[@type='file']")).sendKeys(projectPath+ "\\src\\test\\resources\\files\\Template_Bussines_Campaign.csv");
        }
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[contains(text(),'Add Campaign')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loading')]"))
        ));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-type"))
        ));
    }

    @Test(priority = 12)
    @Severity(SeverityLevel.NORMAL)
    @Description("Show All Business Dashboard")
    @Story("Show All Business Dashboard")
    public void showAllBusinessDashboard() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//button[contains(text(),'All')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loading')]"))
        ));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-type"))
        ));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\showAllBusinessDashboard.png"));
    }

    @Test(priority = 13)
    @Severity(SeverityLevel.NORMAL)
    @Description("Search Campaign")
    @Story("Search Campaign")
    public void searchCampaign() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//input[@placeholder='Search here..']")).sendKeys(campaignName);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loading')]"))
        ));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-type"))
        ));
    }

    @Test(priority = 14)
    @Severity(SeverityLevel.NORMAL)
    @Description("Edit Campaign")
    @Story("Edit Campaign")
    public void editCampaign() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//div[@role='gridcell'][6]")).click();
        driver.findElement(By.xpath("//button[contains(text(),'Edit')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Edit Campaign')]"))
        ));
        driver.findElement(By.xpath("//input[@id='title']")).clear();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='title']")).sendKeys(campaignName + "Edited");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@class=' css-1wy0on6']")).click();
        Random rand = new Random();
        List<Integer> list = Arrays.asList(0, 1, 2);
        prevOption = option;
        while (prevOption == option) {
            option = list.get(rand.nextInt(list.size()));
        }
        Thread.sleep(1000);
        System.out.println(option);
        driver.findElement(By.id("react-select-true-option-" + Integer.toString(option))).click();
        driver.findElement(By.xpath("//input[@id='quota']")).clear();
        driver.findElement(By.xpath("//input[@id='quota']")).sendKeys(Integer.toString(quota + 1));
        List<Integer> list2 = Arrays.asList(0, 2, 3);
        prevRecipientType = recipientType;
        while (prevRecipientType == recipientType) {
            recipientType = list2.get(rand.nextInt(list2.size()));
        }
        switch(recipientType) {
            case 0:
                driver.findElement(By.xpath("//input[@id='all']")).click();
            case 1:
                driver.findElement(By.xpath("balance")).click();
            case 2:
                driver.findElement(By.xpath("//input[@id='dateCreated']")).click();
                driver.findElement(By.id("startCustomerActiveDate")).sendKeys("20 June 2020");
                driver.findElement(By.id("endCustomerActiveDate")).sendKeys("20 June 2021");
            case 3:
                driver.findElement(By.xpath("//input[@id='csvUpload']")).click();
                driver.findElement(By.xpath("//input[@type='file']")).sendKeys(projectPath+ "\\src\\test\\resources\\files\\Template_Bussines_Campaign.csv");
        }
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loading')]"))
        ));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-type"))
        ));
    }

    @Test(priority = 15)
    @Severity(SeverityLevel.NORMAL)
    @Description("Deactive Campaign")
    @Story("Deactive Campaign")
    public void deactiveCampaign() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//div[@role='gridcell'][6]")).click();
        driver.findElement(By.xpath("//button[contains(text(),'Deactivate')]")).click();
        driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        driver.findElement(By.xpath("//input[@placeholder='Search here..']")).sendKeys(campaignName);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loading')]"))
        ));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'OK')]"))
        ));
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();
    }
}