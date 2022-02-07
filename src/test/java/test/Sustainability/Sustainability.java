package test.Sustainability;

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
@Feature("Sustainability - Sustainability")

public class Sustainability extends BaseTest{

    VariableProperties vp = new VariableProperties();
    public String campaignType;
    public String prevCampaignType;
    public String campaignCode = (new SimpleDateFormat("ddMMyyyyHHmm").format(new Date()));
    public String campaignName = "Create From Automation " + (new SimpleDateFormat("ddMMyyyyHHmm").format(new Date()));
    public String language;
    public String prevLanguage;
    public String testimoniStatus;
    public String prevTestimoniStatus;

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
    @Description("Show Rejected Sustainability")
    @Story("Show Rejected Sustainability")
    public void showRejectedSustainability() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//span[contains(text(),'Sustainability')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-campaignCode"))
        ));
        driver.findElement(By.xpath("//button[contains(text(),'Rejected')]")).click();
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loading')]"))
        ));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-campaignCode"))
        ));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\showRejectedSustainability.png"));
    }

    @Test(priority = 4)
    @Severity(SeverityLevel.NORMAL)
    @Description("Show Deleted Sustainability")
    @Story("Show Deleted Sustainability")
    public void showDeletedSustainability() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//button[contains(text(),'Deleted')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loading')]"))
        ));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-campaignCode"))
        ));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\showDeletedSustainability.png"));
    }

    @Test(priority = 5)
    @Severity(SeverityLevel.NORMAL)
    @Description("Show Expired Sustainability")
    @Story("Show Expired Sustainability")
    public void showExpiredSustainability() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//button[contains(text(),'Expired')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loading')]"))
        ));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-campaignCode"))
        ));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\showExpiredSustainability.png"));
    }

    @Test(priority = 6)
    @Severity(SeverityLevel.NORMAL)
    @Description("Show Live Sustainability")
    @Story("Show Live Sustainability")
    public void showLiveSustainability() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//button[contains(text(),'Live')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loading')]"))
        ));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-campaignCode"))
        ));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\showLiveSustainability.png"));
    }

    @Test(priority = 7)
    @Severity(SeverityLevel.NORMAL)
    @Description("Show Active Sustainability")
    @Story("Show Active Sustainability")
    public void showActiveSustainability() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//button[contains(text(),'Active')]")).click();
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\showActiveSustainability.png"));
    }

    @Test(priority = 8)
    @Severity(SeverityLevel.NORMAL)
    @Description("Add New Campaign with Null")
    @Story("Add New Campaign with Null")
    public void addNewCampaignWithNull() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//button[contains(text(),'Add new Campaign')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Add New Campaign')]"))
        ));
        driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();
    }


    @Test(priority = 9)
    @Severity(SeverityLevel.NORMAL)
    @Description("Add New Campaign")
    @Story("Add New Campaign")
    public void addNewCampaignWithNullCode() throws IOException, InterruptedException {
        driver.findElement(By.id("timeValidityStart")).sendKeys("24 January 2021");
        driver.findElement(By.id("timeValidityEnd")).sendKeys("24 January 2022");
        Random rand = new Random();
        List<String> listType = Arrays.asList("SR","SF","SS");
        campaignType = listType.get(rand.nextInt(listType.size()));
        switch(campaignType) {
            case "SR":
                driver.findElement(By.xpath("//input[@value='sr']")).click();
            case "SF":
                driver.findElement(By.xpath("//input[@value='sf']")).click();
            case "SS":
                driver.findElement(By.xpath("//input[@value='SEDEKAH_SIGNUP']")).click();
        }
        driver.findElement(By.id("campaignCode")).sendKeys(campaignCode);
        driver.findElement(By.id("campaignName")).sendKeys(campaignName);
        driver.findElement(By.id("institutionName")).sendKeys("Badan Amil Zakat Nasional");
        driver.findElement(By.id("donationAmount")).sendKeys("25000");
        driver.findElement(By.id("accountNo")).sendKeys("11100220233");
        driver.findElement(By.id("accountName")).sendKeys("Badan Amil Zakat Nasional");
        List<String> listLang = Arrays.asList("Indo","Eng", "Both");
        language = listLang.get(rand.nextInt(listLang.size()));
        List<WebElement> descBox = driver.findElements(By.xpath("//div[@contenteditable='true']"));
        if (language == "Indo" || language == "Both") {
            driver.findElement(By.id("titleId")).sendKeys(campaignName);
            driver.findElement(By.id("accountDescriptionId")).sendKeys("Hari Jumat disebut sebagai sayyidul ayyam atau pemimpin hari-hari lainnya.");
            driver.findElement(By.id("titleThumbId")).click();
            driver.findElement(By.id("titleCampaignId")).sendKeys("Keutamaan Sedekah");
            descBox.get(0).sendKeys("Bersama Hijra kita wujudkan pola hidup Tiada hari tanpa sedekah, walau dengan seribu Rupiah");
            driver.findElement(By.xpath("//input[@value='titleCampaignID']")).click();
        }
        if (language == "Eng" || language == "Both") {
            driver.findElement(By.id("english")).click();
            driver.findElement(By.id("titleEn")).sendKeys(campaignName);
            driver.findElement(By.id("accountDescriptionEn")).sendKeys("Friday is called sayyidul ayyam or the leader of other days.");
            driver.findElement(By.xpath("//input[@value='titleThumbEN']")).click();
            driver.findElement(By.id("titleCampaignEn")).sendKeys("Keutamaan Sedekah");
            descBox.get(descBox.size()-1).sendKeys("Together with Hijra, we create a lifestyle. There is no day without alms, even with a thousand rupiahs");
            driver.findElement(By.xpath("//input[@value='titleCampaignEN']")).click();
        }
        List<WebElement> uploadImg = driver.findElements(By.xpath("//input[@type='file']"));
        uploadImg.get(0).sendKeys(projectPath+ "\\src\\test\\resources\\files\\sustainability.PNG");
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("//button[contains(text(),'Preview Thumbnail')]")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("//button[@tabindex='0']")).click();
        uploadImg.get(uploadImg.size()-1).sendKeys(projectPath+ "\\src\\test\\resources\\files\\detailSustainability.PNG");
        List<String> listTesti = Arrays.asList("Enable","Disable");
        testimoniStatus = listTesti.get(rand.nextInt(listTesti.size()));
        if (testimoniStatus == "Enable") {
            driver.findElement(By.name("testimonialsCampaign")).click();
            driver.findElement(By.id("testimoniName")).sendKeys("Testimoni");
            driver.findElement(By.id("testimoniTeksId")).sendKeys("Ini testimoni");
            uploadImg.get(uploadImg.size()-1).sendKeys(projectPath+ "\\src\\test\\resources\\files\\sustainability.PNG");
            if (language == "Both" || language == "Eng") {
                driver.findElement(By.id("testimoniTeksEn")).sendKeys("This is Testimoni");
            }
        }
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\addSustainability.png"));
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-campaignCode"))
        ));
    }

    @Test(priority = 12)
    @Severity(SeverityLevel.NORMAL)
    @Description("Show All Sustainability")
    @Story("Show All Sustainability")
    public void showAllSustainability() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//button[contains(text(),'All')]")).click();
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\showAllSustainability.png"));
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
                ExpectedConditions.visibilityOfElementLocated(By.id("column-campaignCode"))
        ));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\searchCampaignSustainability.png"));
    }

    @Test(priority = 14)
    @Severity(SeverityLevel.NORMAL)
    @Description("See Detail Campaign")
    @Story("See Detail Campaign")
    public void seeDetailCampaign() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//a[contains(text(),'See Detail')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loading')]"))
        ));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'" + campaignName + "')]"))
        ));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\seeDetailSustainability.png"));
    }

    @Test(priority = 15)
    @Severity(SeverityLevel.NORMAL)
    @Description("Edit Campaign")
    @Story("Edit Campaign")
    public void editCampaign() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//button[contains(text(),'Edit Campaign')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loading')]"))
        ));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Edit Campaign')]"))
        ));
        driver.findElement(By.id("timeValidityStart")).sendKeys("24 January 2021");
        driver.findElement(By.id("timeValidityEnd")).sendKeys("24 January 2022");
        Random rand = new Random();
        List<String> listType = Arrays.asList("SR","SF","SS");
        prevCampaignType = campaignType;
        while (prevCampaignType == campaignType) {
            campaignType = listType.get(rand.nextInt(listType.size()));
        }
        switch(campaignType) {
            case "SR":
                driver.findElement(By.xpath("//input[@value='sr']")).click();
            case "SF":
                driver.findElement(By.xpath("//input[@value='sf']")).click();
            case "SS":
                driver.findElement(By.xpath("//input[@value='SEDEKAH_SIGNUP']")).click();
        }
        campaignCode = (new SimpleDateFormat("ddMMyyyyHHmm").format(new Date()));
        driver.findElement(By.id("campaignCode")).sendKeys(campaignCode);
        driver.findElement(By.id("campaignName")).sendKeys(campaignName + " Edited");
        driver.findElement(By.id("institutionName")).sendKeys("Badan Amil Zakat Nasional Edited");
        driver.findElement(By.id("donationAmount")).sendKeys("25000");
        driver.findElement(By.id("accountNo")).sendKeys("11100220233");
        driver.findElement(By.id("accountName")).sendKeys("Badan Amil Zakat Nasional Edited");
        List<String> listLang = Arrays.asList("Indo","Eng", "Both");
        prevLanguage = language;
        while (prevLanguage == language) {
            language = listLang.get(rand.nextInt(listLang.size()));
        }
        List<WebElement> descBox = driver.findElements(By.xpath("//div[@contenteditable='true']"));
        if (language == "Indo" || language == "Both") {
            driver.findElement(By.id("titleId")).sendKeys(campaignName);
            driver.findElement(By.id("accountDescriptionId")).sendKeys("Edited Hari Jumat disebut sebagai sayyidul ayyam atau pemimpin hari-hari lainnya.");
            driver.findElement(By.id("titleThumbId")).click();
            driver.findElement(By.id("titleCampaignId")).sendKeys("Keutamaan Sedekah Edited");
            descBox.get(0).sendKeys("Edited + Bersama Hijra kita wujudkan pola hidup Tiada hari tanpa sedekah, walau dengan seribu Rupiah");
            driver.findElement(By.xpath("//input[@value='titleCampaignID']")).click();
        }
        if (language == "Eng" || language == "Both") {
            driver.findElement(By.id("english")).click();
            driver.findElement(By.id("titleEn")).sendKeys(campaignName);
            driver.findElement(By.id("accountDescriptionEn")).sendKeys("Edited - Friday is called sayyidul ayyam or the leader of other days.");
            driver.findElement(By.xpath("//input[@value='titleThumbEN']")).click();
            driver.findElement(By.id("titleCampaignEn")).sendKeys("Keutamaan Sedekah Edited");
            descBox.get(descBox.size()-1).sendKeys("Edited - Together with Hijra, we create a lifestyle. There is no day without alms, even with a thousand rupiahs");
            driver.findElement(By.xpath("//input[@value='titleCampaignEN']")).click();
        }
        List<WebElement> uploadImg = driver.findElements(By.xpath("//input[@type='file']"));
        uploadImg.get(0).sendKeys(projectPath+ "\\src\\test\\resources\\files\\sustainability.PNG");
        uploadImg.get(uploadImg.size()-1).sendKeys(projectPath+ "\\src\\test\\resources\\files\\detailSustainability.PNG");
        List<String> listTesti = Arrays.asList("Enable","Disable");
        prevTestimoniStatus = testimoniStatus;
        while (prevTestimoniStatus == testimoniStatus) {
            testimoniStatus = listTesti.get(rand.nextInt(listTesti.size()));
        }
        if (testimoniStatus == "Enable") {
            driver.findElement(By.name("testimonialsCampaign")).click();
            driver.findElement(By.id("testimoniName")).sendKeys("Testimoni Edited");
            driver.findElement(By.id("testimoniTeksId")).sendKeys("Ini testimoni Edited");
            Thread.sleep(1000);
            uploadImg.get(uploadImg.size()-1).sendKeys(projectPath+ "\\src\\test\\resources\\files\\sustainability.PNG");
            if (language == "Both" || language == "Eng") {
                driver.findElement(By.id("testimoniTeksEn")).sendKeys("This is Testimoni");
            }
        }
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\editSustainability.png"));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-campaignCode"))
        ));
    }

    @Test(priority = 6)
    @Severity(SeverityLevel.NORMAL)
    @Description("Show Pending Sustainability")
    @Story("Show Pending Sustainability")
    public void showPendingSustainability() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//button[contains(text(),'Pending')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loading')]"))
        ));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-campaignCode"))
        ));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\showPendingSustainability.png"));
    }

    @Test(priority = 17)
    @Severity(SeverityLevel.NORMAL)
    @Description("Deactive Campaign")
    @Story("Deactive Campaign")
    public void deactiveCampaign() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//a[contains(text(),'See Detail')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[contains(text(),'Deactivate')]")).click();
        driver.findElement(By.xpath("//button[contains(text(),'Yes, Deactivate')]")).click();
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\deactivateSustainability.png"));
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[contains(text(),'Back')]")).click();
    }

    @Test(priority = 18)
    @Severity(SeverityLevel.NORMAL)
    @Description("Show Inactive Sustainability")
    @Story("Show Inactive Sustainability")
    public void showInactiveSustainability() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//button[contains(text(),'Inactive')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loading')]"))
        ));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-campaignCode"))
        ));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\showInactiveSustainability.png"));
    }

    @Test(priority = 19)
    @Severity(SeverityLevel.NORMAL)
    @Description("Delete Campaign")
    @Story("Delete Campaign")
    public void deleteCampaign() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//a[contains(text(),'See Detail')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[contains(text(),'Delete')]")).click();
        driver.findElement(By.xpath("//button[contains(text(),'Yes, Delete')]")).click();
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\deleteSustainability.png"));
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[contains(text(),'Back')]")).click();
    }

}