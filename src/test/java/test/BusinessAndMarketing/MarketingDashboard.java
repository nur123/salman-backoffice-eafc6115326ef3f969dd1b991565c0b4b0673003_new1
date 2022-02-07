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
@Feature("Business & Marketing - Marketing Dashboard")

public class MarketingDashboard extends BaseTest{

    VariableProperties vp = new VariableProperties();

    public String campaignCode = "AT" + (new SimpleDateFormat("ddMMyyyyHHmm").format(new Date()));
    public String campaignName = "Create From Automation " + (new SimpleDateFormat("ddMMyyyyHHmm").format(new Date()));
    public int campaignNo;
    public int prevCampaignNo;
    public String language;
    public String prevLanguage;
    public String startDate;
    public String endDate;

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
    @Description("Show Deleted Marketing Dashboard")
    @Story("Show Deleted Marketing Dashboard")
    public void showDeletedMarketingDashboard() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//span[contains(text(),'Business & Marketing')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[contains(text(),'Marketing Dashboard')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-no"))
        ));
        driver.findElement(By.xpath("//button[contains(text(),'Deleted')]")).click();
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loading')]"))
        ));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-no"))
        ));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\showDeletedMarketingDashboard.png"));
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.NORMAL)
    @Description("Show Live Marketing Dashboard")
    @Story("Show Live Marketing Dashboard")
    public void showLiveMarketingDashboard() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//button[contains(text(),'Live')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loading')]"))
        ));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-no"))
        ));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\showLiveMarketingDashboard.png"));
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.NORMAL)
    @Description("Add New Campaign with Null")
    @Story("Add New Campaign with Null")
    public void addNewCampaignWithNull() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//button[contains(text(),'Add new Campaign')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Add New Marketing Campaign')]"))
        ));
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\AddNewMarketingDashboardWithNull.png"));
    }

    @Test(priority = 4)
    @Severity(SeverityLevel.NORMAL)
    @Description("Add New Campaign")
    @Story("Add New Campaign")
    public void addNewCampaign() throws IOException, InterruptedException {
        List<WebElement> dropdownBtn = driver.findElements(By.xpath("//div[@class=' css-1hwfws3']"));
        Random rand = new Random();
        List<String> listLanguage = Arrays.asList("Indo", "Eng");
        language = listLanguage.get(rand.nextInt(listLanguage.size()));
        dropdownBtn.get(1).click();
        Thread.sleep(2000);
        if (language == "Indo") {
            driver.findElement(By.id("react-select-3-option-0")).click();
        }
        if (language == "Eng") {
            driver.findElement(By.id("react-select-3-option-1")).click();
        }
        driver.findElement(By.id("code")).sendKeys(campaignCode);
        driver.findElement(By.id("title")).sendKeys(campaignName);
        driver.findElement(By.xpath("//div[@data-placeholder='Type Here']")).sendKeys("Narration");
        dropdownBtn.get(2).click();
        driver.findElement(By.id("react-select-4-option-0")).click();
        driver.findElement(By.id("startTimeValidity")).sendKeys("22 January 2022");
        driver.findElement(By.id("endTimeValidity")).sendKeys("22 January 2023");
        Thread.sleep(2000);
        driver.findElement(By.id("promoStartTimeValidity")).sendKeys("22 January 2022");
        driver.findElement(By.id("promoEndTimeValidity")).sendKeys("22 January 2023");
        driver.findElement(By.xpath("//input[@type='file']")).sendKeys(projectPath+ "\\src\\test\\resources\\files\\marketingDashboard.png");
        List<Integer> campaignNoList = Arrays.asList(1,2,3,4,5,6,7,8);
        campaignNo = campaignNoList.get(rand.nextInt(campaignNoList.size()));
        Thread.sleep(2000);
        dropdownBtn.get(0).click();
        Thread.sleep(2000);
        switch(campaignNo) {
            case 1: driver.findElement(By.id("react-select-2-option-0")).click();
            case 2: driver.findElement(By.id("react-select-2-option-1")).click();
            case 3: driver.findElement(By.id("react-select-2-option-2")).click();
            case 4: driver.findElement(By.id("react-select-2-option-3")).click();
            case 5: driver.findElement(By.id("react-select-2-option-4")).click();
            case 6: driver.findElement(By.id("react-select-2-option-5")).click();
            case 7: driver.findElement(By.id("react-select-2-option-6")).click();
            case 8: driver.findElement(By.id("react-select-2-option-7")).click();
        }
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\AddNewMarketingDashboard.png"));
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loading')]"))
        ));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-no"))
        ));
    }

    @Test(priority = 5)
    @Severity(SeverityLevel.NORMAL)
    @Description("Show All Marketing Dashboard")
    @Story("Show All Marketing Dashboard")
    public void showAllMarketingDashboard() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//button[contains(text(),'All')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loading')]"))
        ));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-no"))
        ));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\showAllMarketingDashboard.png"));
    }

    @Test(priority = 6)
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
                ExpectedConditions.visibilityOfElementLocated(By.id("column-no"))
        ));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\SearchMarketingDashboard.png"));
    }

    @Test(priority = 8)
    @Severity(SeverityLevel.NORMAL)
    @Description("Edit Campaign")
    @Story("Edit Campaign")
    public void editCampaign() throws IOException, InterruptedException {
        List<WebElement> optionBtn = driver.findElements(By.xpath("//button[@class='focus:outline-none ring-0']"));
        optionBtn.get(optionBtn.size()-1).click();
        driver.findElement(By.xpath("//button[contains(text(),'Edit')]")).click();
        Thread.sleep(3000);
        campaignCode = "AT" + (new SimpleDateFormat("ddMMyyyyHHmm").format(new Date()));
        driver.findElement(By.id("code")).clear();
        Thread.sleep(1000);
        driver.findElement(By.id("code")).sendKeys(campaignCode);
        driver.findElement(By.id("title")).clear();
        Thread.sleep(1000);
        driver.findElement(By.id("title")).sendKeys(campaignName + " Edited");
        driver.findElement(By.xpath("//div[@data-placeholder='Type Here']")).clear();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@data-placeholder='Type Here']")).sendKeys("Narration Edited");
        driver.findElement(By.xpath("//input[@type='file']")).sendKeys(projectPath+ "\\src\\test\\resources\\files\\editMarketingDashboard.png");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\EditMarketingDashboard.png"));
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loading')]"))
        ));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-no"))
        ));
    }

    @Test(priority = 9)
    @Severity(SeverityLevel.NORMAL)
    @Description("Show Pending Marketing Dashboard")
    @Story("Show Pending Marketing Dashboard")
    public void showPendingMarketingDashboard() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//button[contains(text(),'Pending')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loading')]"))
        ));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-no"))
        ));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\showPendingMarketingDashboard.png"));
    }

    @Test(priority = 10)
    @Severity(SeverityLevel.NORMAL)
    @Description("Deactivate Campaign")
    @Story("Deactivate Campaign")
    public void deactivateCampaign() throws IOException, InterruptedException {
        List<WebElement> optionBtn = driver.findElements(By.xpath("//button[@class='focus:outline-none ring-0']"));
        optionBtn.get(optionBtn.size()-1).click();
        driver.findElement(By.xpath("//button[contains(text(),'Deactivate')]")).click();
        driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();
        Thread.sleep(2000);
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\DeactivateMarketingDashboard.png"));
        Thread.sleep(1000);
        List<WebElement> confirmBtn = driver.findElements(By.xpath("//button[contains(text(),'OK')]"));
        confirmBtn.get(confirmBtn.size()-1).click();
    }

    @Test(priority = 11)
    @Severity(SeverityLevel.NORMAL)
    @Description("Show Inactive Marketing Dashboard")
    @Story("Show Inactive Marketing Dashboard")
    public void showInactiveMarketingDashboard() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//button[contains(text(),'Inactive')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loading')]"))
        ));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-no"))
        ));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\showInactiveMarketingDashboard.png"));
    }

    @Test(priority = 13)
    @Severity(SeverityLevel.NORMAL)
    @Description("Delete Campaign")
    @Story("Delete Campaign")
    public void deleteCampaign() throws IOException, InterruptedException {
        Thread.sleep(1000);
        List<WebElement> optionBtn = driver.findElements(By.xpath("//button[@class='focus:outline-none ring-0']"));
        optionBtn.get(optionBtn.size()-1).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[contains(text(),'Delete')]")).click();
        driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();
        Thread.sleep(2000);
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\DeactivateMarketingDashboard.png"));
        Thread.sleep(1000);
        List<WebElement> confirmBtn = driver.findElements(By.xpath("//button[contains(text(),'OK')]"));
        confirmBtn.get(confirmBtn.size()-1).click();
    }

    @Test(priority = 14)
    @Severity(SeverityLevel.NORMAL)
    @Description("See Detail Campaign")
    @Story("See Detail Campaign")
    public void seeDetailCampaign() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//a[contains(text(),'See Detail')]")).click();
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\SeeDetailMarketingDashboard.png"));
    }
}