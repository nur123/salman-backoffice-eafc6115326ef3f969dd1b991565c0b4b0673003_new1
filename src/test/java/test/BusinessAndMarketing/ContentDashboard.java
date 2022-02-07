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
@Feature("Content & Marketing - Content Dashboard")

public class ContentDashboard extends BaseTest{

    VariableProperties vp = new VariableProperties();
    public String campaignCode = "AT" + (new SimpleDateFormat("ddMMyyyyHHmm").format(new Date()));
    public String campaignName = "Create From Automation " + (new SimpleDateFormat("ddMMyyyyHHmm").format(new Date()));
    public String language;
    public String prevLanguage;

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
    @Description("Show Deleted Content Dashboard")
    @Story("Show Deleted Content Dashboard")
    public void showDeletedContentDashboard() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//span[contains(text(),'Content & Marketing')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[contains(text(),'Content Dashboard')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-code"))
        ));
        driver.findElement(By.xpath("//button[contains(text(),'Deleted')]")).click();
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loading')]"))
        ));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-code"))
        ));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\showDeletedContentDashboard.png"));
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.NORMAL)
    @Description("Show Live Content Dashboard")
    @Story("Show Live Content Dashboard")
    public void showLiveContentDashboard() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//button[contains(text(),'Live')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loading')]"))
        ));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-code"))
        ));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\showLiveContentDashboard.png"));
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.NORMAL)
    @Description("Add New Campaign with Null")
    @Story("Add New Campaign with Null")
    public void addNewCampaignWithNull() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//button[contains(text(),'Add New Campaign')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Add New Islamic Content')]"))
        ));
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @Test(priority = 4)
    @Severity(SeverityLevel.NORMAL)
    @Description("Add New Campaign")
    @Story("Add New Campaign")
    public void addNewCampaign() throws IOException, InterruptedException {
        driver.findElement(By.id("code")).sendKeys(campaignCode);
        driver.findElement(By.id("title")).sendKeys(campaignName);
        driver.findElement(By.id("publishDate")).sendKeys("25 January 2022");
        driver.findElement(By.xpath("//div[@class=' css-1hwfws3']")).click();
        Random rand = new Random();
        List<String> listLanguage = Arrays.asList("Indo", "Eng");
        language = listLanguage.get(rand.nextInt(listLanguage.size()));
        switch(language) {
            case "Indo":
                driver.findElement(By.id("react-select-2-option-0")).click();
            case "Eng":
                driver.findElement(By.id("react-select-2-option-1")).click();
        }
        driver.findElement(By.xpath("//input[@type='file']")).sendKeys(projectPath+ "\\src\\test\\resources\\files\\islamicContent.jpeg");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-code"))
        ));
    }

    @Test(priority = 5)
    @Severity(SeverityLevel.NORMAL)
    @Description("Show All Content Dashboard")
    @Story("Show All Content Dashboard")
    public void showAllContentDashboard() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//button[contains(text(),'All')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loading')]"))
        ));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-code"))
        ));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\showAllContentDashboard.png"));
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
                ExpectedConditions.visibilityOfElementLocated(By.id("column-code"))
        ));
    }

    @Test(priority = 7)
    @Severity(SeverityLevel.NORMAL)
    @Description("Preview Campaign")
    @Story("Preview Campaign")
    public void previewCampaign() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//button[contains(text(),'Preview')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@tabindex='0']")).click();
    }

    @Test(priority = 8)
    @Severity(SeverityLevel.NORMAL)
    @Description("Edit Campaign")
    @Story("Edit Campaign")
    public void editCampaign() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//div[@role='gridcell'][7]")).click();
        driver.findElement(By.xpath("//button[contains(text(),'Edit')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Edit Islamic Content')]"))
        ));
        driver.findElement(By.id("code")).clear();
        campaignCode = "AT" + (new SimpleDateFormat("ddMMyyyyHHmm").format(new Date()));
        driver.findElement(By.id("code")).sendKeys(campaignCode);
        driver.findElement(By.id("title")).clear();
        driver.findElement(By.id("title")).sendKeys(campaignName + " Edited");
        driver.findElement(By.xpath("//div[@class=' css-1hwfws3']")).click();
        Random rand = new Random();
        List<String> listLanguage = Arrays.asList("Indo", "Eng");
        prevLanguage = language;
        while (prevLanguage == language) {
            language = listLanguage.get(rand.nextInt(listLanguage.size()));
        }
        switch(language) {
            case "Indo":
                driver.findElement(By.id("react-select-2-option-0")).click();
            case "Eng":
                driver.findElement(By.id("react-select-2-option-1")).click();
        }
        driver.findElement(By.xpath("//input[@type='file']")).sendKeys(projectPath+ "\\src\\test\\resources\\files\\editIslamicContent.jpeg");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-code"))
        ));
    }

    @Test(priority = 9)
    @Severity(SeverityLevel.NORMAL)
    @Description("Show Pending Content Dashboard")
    @Story("Show Pending Content Dashboard")
    public void showPendingContentDashboard() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//button[contains(text(),'Pending')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loading')]"))
        ));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-code"))
        ));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\showPendingContentDashboard.png"));
    }

    @Test(priority = 10)
    @Severity(SeverityLevel.NORMAL)
    @Description("Deactivate Campaign")
    @Story("Deactivate Campaign")
    public void deactivateCampaign() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//div[@role='gridcell'][7]")).click();
        driver.findElement(By.xpath("//button[contains(text(),'Deactivated')]")).click();
        driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();
    }

    @Test(priority = 11)
    @Severity(SeverityLevel.NORMAL)
    @Description("Show Inactive Content Dashboard")
    @Story("Show Inactive Content Dashboard")
    public void showInactiveContentDashboard() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//button[contains(text(),'Inactive')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loading')]"))
        ));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-code"))
        ));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\showInactiveContentDashboard.png"));
    }

    @Test(priority = 12)
    @Severity(SeverityLevel.NORMAL)
    @Description("Activate Campaign")
    @Story("Activate Campaign")
    public void activateCampaign() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//div[@role='gridcell'][7]")).click();
        driver.findElement(By.xpath("//button[contains(text(),'Activated')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loading')]"))
        ));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-code"))
        ));
    }

    @Test(priority = 13)
    @Severity(SeverityLevel.NORMAL)
    @Description("Delete Campaign")
    @Story("Delete Campaign")
    public void deleteCampaign() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//div[@role='gridcell'][7]")).click();
        driver.findElement(By.xpath("//button[contains(text(),'Delete')]")).click();
        driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();
    }
}