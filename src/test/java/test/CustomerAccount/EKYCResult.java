package test.CustomerAccount;

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
@Feature("Customer Account - EKYC Result")

public class EKYCResult extends BaseTest {

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
    @Description("Show Submitted EKYC List on Customer Account Menu")
    @Story("Show Submitted EKYC List on Customer Account Menu")
    public void showSubmittedEKYCResult() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//span[contains(text(),'Customer Account')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[contains(text(),'e-KYC Result')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-name"))
        ));
        driver.findElement(By.xpath("//div[contains(text(),'Approved')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[contains(text(),'Submitted')]")).click();
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loading')]"))
        ));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-name"))
        ));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\SubmittedEKYCList.png"));
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.NORMAL)
    @Description("Show Approved EKYC List on Customer Account Menu")
    @Story("Show Approved EKYC List on Customer Account Menu")
    public void showApprovedEKYCResult() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//div[contains(text(),'Submitted')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[contains(text(),'Approved')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-name"))
        ));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\ApprovedEKYCList.png"));
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.NORMAL)
    @Description("Show Rejected EKYC List on Customer Account Menu")
    @Story("Show Rejected EKYC List on Customer Account Menu")
    public void showRejectedEKYCResult() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//div[contains(text(),'Approved')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[contains(text(),'Rejected')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loading')]"))
        ));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='table']"))
        ));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\RejectedEKYCList.png"));
    }

    @Test(priority = 4)
    @Severity(SeverityLevel.NORMAL)
    @Description("Show Force Deleted EKYC List on Customer Account Menu")
    @Story("Show Force Deleted EKYC List on Customer Account Menu")
    public void showForceDeletedEKYCResult() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//div[contains(text(),'Rejected')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[contains(text(),'Force Delete')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loading')]"))
        ));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-name"))
        ));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\ForceDeleteEKYCList.png"));
    }

    @Test(priority = 5)
    @Severity(SeverityLevel.NORMAL)
    @Description("Show Pending EKYC List on Customer Account Menu")
    @Story("Show Pending EKYC List on Customer Account Menu")
    public void showPendingEKYCResult() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//div[contains(text(),'Force Delete')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[contains(text(),'Pending')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loading')]"))
        ));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-name"))
        ));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\PendingEKYCList.png"));
    }

    @Test(priority = 6)
    @Severity(SeverityLevel.NORMAL)
    @Description("Decide Pending EKYC List with null analysis and recommendation")
    @Story("Decide Pending EKYC List with null analysis and recommendation")
    public void decidePendingEKYCResultWithNullFields() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//a[contains(text(),'Decide')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'EKYC Result')]"))
        ));
        driver.findElement(By.xpath("//button[contains(text(),'Reject')]")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Analisis wajib diisi')]"));
        driver.findElement(By.xpath("//span[contains(text(),'Rekomendasi wajib diisi')]"));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\ErrorMsgAnalysisRecomEKYCResult.png"));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'OK')]"))
        ));
    }

    @Test(priority = 7)
    @Severity(SeverityLevel.NORMAL)
    @Description("Decide Pending EKYC List with null recommendation")
    @Story("Decide Pending EKYC List with null recommendation")
    public void decidePendingEKYCResultWithNullRecommendationField() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//textarea[@name='ekycAnalysis']")).sendKeys("EKYC Analysis");
        driver.findElement(By.xpath("//button[contains(text(),'Propose to change data')]")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Rekomendasi wajib diisi')]"));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\ErrorMsgRecomEKYCResult.png"));
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'OK')]"))
        ));
    }

    @Test(priority = 8)
    @Severity(SeverityLevel.NORMAL)
    @Description("Decide Pending EKYC List with null analysis")
    @Story("Decide Pending EKYC List with null analysis")
    public void decidePendingEKYCResultWithNullAnalysisField() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//textarea[@name='ekycAnalysis']")).clear();
        driver.findElement(By.xpath("//textarea[@name='recommendation']")).sendKeys("Recommendation");
        driver.findElement(By.xpath("//button[contains(text(),'Approve')]")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Analisis wajib diisi')]"));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\ErrorMsgAnalysisEKYCResult.png"));
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'OK')]"))
        ));
    }

    @Test(priority = 9)
    @Severity(SeverityLevel.NORMAL)
    @Description("Check Selfie with KTP Photo on Pending Decide Page")
    @Story("Check Selfie with KTP Photo on Pending Decide Page")
    public void checkSelfieWithKTPphotoPendingEKYC() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//button[contains(text(),'Selfie with KTP')]")).click();
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\CheckSelfieWithKTP.png"));
    }

    @Test(priority = 10)
    @Severity(SeverityLevel.NORMAL)
    @Description("Check KTP Photo on Pending Decide Page")
    @Story("Check KTP Photo on Pending Decide Page")
    public void checkKTPphotoPendingEKYC() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//button[contains(text(),'KTP')]")).click();
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\CheckKTP.png"));
    }

    @Test(priority = 11)
    @Severity(SeverityLevel.NORMAL)
    @Description("Check Selfie Photo on Pending Decide Page")
    @Story("Check Selfie Photo on Pending Decide Page")
    public void checkSelfiePhotoPendingEKYC() throws IOException, InterruptedException {
        List<WebElement> foundElements = driver.findElements(By.xpath("//button[contains(text(),'Selfie')]"));
        foundElements.get(foundElements.size()-1).click();
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\CheckSelfie.png"));
    }

    @Test(priority = 12)
    @Severity(SeverityLevel.NORMAL)
    @Description("Check Signature Photo on Pending Decide Page")
    @Story("Check Signature Photo on Pending Decide Page")
    public void checkSignaturePhotoPendingEKYC() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//button[contains(text(),'Signature')]")).click();
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\CheckSignature.png"));
    }

    @Test(priority = 13)
    @Severity(SeverityLevel.NORMAL)
    @Description("Success Decide Pending EKYC List")
    @Story("Success Pending EKYC List")
    public void decidePendingEKYCResultSuccess() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//textarea[@name='ekycAnalysis']")).sendKeys("EKYC Analysis");
        driver.findElement(By.xpath("//button[contains(text(),'Approve')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'OK')]"))
        ));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\ApproveEKYCResult.png"));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loading')]"))
        ));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-name"))
        ));
    }

    @Test(priority = 14)
    @Severity(SeverityLevel.NORMAL)
    @Description("Show Waiting EKYC List on Customer Account Menu")
    @Story("Show Waiting EKYC List on Customer Account Menu")
    public void showWaitingEKYCResult() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//span[contains(text(),'e-KYC Result')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-name"))
        ));
        driver.findElement(By.xpath("//div[contains(text(),'Approved')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[contains(text(),'Waiting')]")).click();
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loading')]"))
        ));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-name"))
        ));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\WaitingEKYCList.png"));
    }

    @Test(priority = 15)
    @Severity(SeverityLevel.NORMAL)
    @Description("Decide Waiting EKYC List with null analysis and recommendation")
    @Story("Decide Waiting EKYC List with null analysis and recommendation")
    public void decideWaitingEKYCResultWithNullFields() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//a[contains(text(),'Decide')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'EKYC Result')]"))
        ));
        driver.findElement(By.xpath("//button[contains(text(),'Reject')]")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Analisis wajib diisi')]"));
        driver.findElement(By.xpath("//span[contains(text(),'Rekomendasi wajib diisi')]"));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\ErrorMsgAnalysisRecomEKYCResult.png"));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'OK')]"))
        ));
    }

    @Test(priority = 16)
    @Severity(SeverityLevel.NORMAL)
    @Description("Decide Waiting EKYC List with null recommendation")
    @Story("Decide Waiting EKYC List with null recommendation")
    public void decideWaitingEKYCResultWithNullRecommendationField() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//textarea[@name='ekycAnalysis']")).sendKeys("EKYC Analysis");
        driver.findElement(By.xpath("//button[contains(text(),'Propose to change data')]")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Rekomendasi wajib diisi')]"));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\ErrorMsgRecomEKYCResult.png"));
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'OK')]"))
        ));
    }

    @Test(priority = 17)
    @Severity(SeverityLevel.NORMAL)
    @Description("Decide Waiting EKYC List with null analysis")
    @Story("Decide Waiting EKYC List with null analysis")
    public void decideWaitingEKYCResultWithNullAnalysisField() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//textarea[@name='ekycAnalysis']")).clear();
        driver.findElement(By.xpath("//textarea[@name='recommendation']")).sendKeys("Recommendation");
        driver.findElement(By.xpath("//button[contains(text(),'Approve')]")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Analisis wajib diisi')]"));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\ErrorMsgAnalysisEKYCResult.png"));
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'OK')]"))
        ));
    }

    @Test(priority = 18)
    @Severity(SeverityLevel.NORMAL)
    @Description("Check Selfie with KTP Photo on Waiting Decide Page")
    @Story("Check Selfie with KTP Photo on Waiting Decide Page")
    public void checkSelfieWithKTPphotoWaitingEKYC() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//button[contains(text(),'Selfie with KTP')]")).click();
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\CheckSelfieWithKTP.png"));
    }

    @Test(priority = 19)
    @Severity(SeverityLevel.NORMAL)
    @Description("Check KTP Photo on Waiting Decide Page")
    @Story("Check KTP Photo on Waiting Decide Page")
    public void checkKTPphotoWaitingEKYC() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//button[contains(text(),'KTP')]")).click();
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\CheckKTP.png"));
    }

    @Test(priority = 20)
    @Severity(SeverityLevel.NORMAL)
    @Description("Check Selfie Photo on Waiting Decide Page")
    @Story("Check Selfie Photo on Waiting Decide Page")
    public void checkSelfiePhotoWaitingEKYC() throws IOException, InterruptedException {
        List<WebElement> foundElements = driver.findElements(By.xpath("//button[contains(text(),'Selfie')]"));
        foundElements.get(foundElements.size()-1).click();
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\CheckSelfie.png"));
    }

    @Test(priority = 21)
    @Severity(SeverityLevel.NORMAL)
    @Description("Check Signature Photo on Waiting Decide Page")
    @Story("Check Signature Photo on Waiting Decide Page")
    public void checkSignaturePhotoWaitingEKYC() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//button[contains(text(),'Signature')]")).click();
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\CheckSignature.png"));
    }

    @Test(priority = 22)
    @Severity(SeverityLevel.NORMAL)
    @Description("Success Decide Waiting EKYC List")
    @Story("Success Decide Waiting EKYC List")
    public void decideWaitingEKYCResultSuccess() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//textarea[@name='ekycAnalysis']")).sendKeys("EKYC Analysis");
        driver.findElement(By.xpath("//button[contains(text(),'Reject')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'OK')]"))
        ));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\ApproveEKYCResult.png"));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loading')]"))
        ));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-name"))
        ));
    }

    @Test(priority = 23)
    @Severity(SeverityLevel.NORMAL)
    @Description("Show All EKYC List on Customer Account Menu")
    @Story("Show All EKYC List on Customer Account Menu")
    public void showAllEKYCResult() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//span[contains(text(),'e-KYC Result')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-name"))
        ));
        driver.findElement(By.xpath("//div[contains(text(),'Approved')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[contains(text(),'All')]")).click();
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loading')]"))
        ));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-name"))
        ));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\AllEKYCList.png"));
    }

    @Test(priority = 24)
    @Severity(SeverityLevel.NORMAL)
    @Description("Use Filter Feature in EKYC Result")
    @Story("Use Filter Feature in EKYC Result")
    public void filterEKYCResult() throws IOException, InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@class='focus:outline-none border rounded-lg p-2 px-5 mx-1 bg-white shadow-sm focus:ring-2 focus:ring-green-500 focus:ring-opacity-50 text-sm font-normal']")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[contains(text(),'Filter')]"))
        ));
        driver.findElement(By.xpath("//input[@id='dateFrom']")).sendKeys("1 October 2021");
        driver.findElement(By.xpath("//input[@id='dateTo']")).sendKeys("1 December 2021");
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\FilterEKYCResult.png"));
        driver.findElement(By.xpath("//button[contains(text(),'Proceed')]")).click();
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loading')]"))
        ));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("column-name"))
        ));
    }

    @Test(priority = 25)
    @Severity(SeverityLevel.NORMAL)
    @Description("Search One Account in EKYC Result")
    @Story("Search One Account in EKYC Result")
    public void searchEKYCResult() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//input[@placeholder='Search here..']")).sendKeys("user dev 78");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loading')]"))
        ));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='table']"))
        ));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\SearchEKYCResult.png"));
    }

}