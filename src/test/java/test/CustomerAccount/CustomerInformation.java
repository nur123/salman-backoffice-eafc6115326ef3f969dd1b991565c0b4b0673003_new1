package test.CustomerAccount;

import utils.VariableProperties;
import baseTest.BaseTest;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utils.TestListener;
import io.qameta.allure.*;
import org.testng.annotations.Listeners;

@Listeners({TestListener.class})
@Epic("ON BOARDING")
@Feature("Customer Account - Customer Information")

public class CustomerInformation extends BaseTest {

    VariableProperties vp = new VariableProperties();
    public String newPhone = "6281348206549";
    public String invalidPhone = "6282173621765321";

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
    @Description("Show Customer Information Dashboard Page")
    @Story("Show Customer Information Dashboard Page")
    public void showCustomerInfoDashboard() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//span[contains(text(),'Customer Account')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[contains(text(),\"Customer Information\")]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='customerName']"))
        ));
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.NORMAL)
    @Description("View Specific Customer Information Detail with null data")
    @Story("View Specific Customer Information Detail with null data")
    public void viewCustomerDetailWithNullData() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//button[contains(text(),\"Submit\")]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Birth place field is required')]"))
        ));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Birth date field is required')]"))
        ));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Mother name field is required')]"))
        ));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\ViewCustomerDetailWithNullData.png"));
        driver.findElement(By.linkText("Detail")).click();
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.NORMAL)
    @Description("View Specific Customer Information Detail with null Account Name and Number")
    @Story("View Specific Customer Information Detail with null Account Name and Number")
    public void viewCustomerDetailWithNullAccNameAndNumber() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//input[@name='birthPlace']")).sendKeys("Malang");
        driver.findElement(By.xpath("//input[@name='birthDate']")).sendKeys("17 July 1998");
        driver.findElement(By.xpath("//input[@name='motherName']")).sendKeys("Ibu");
        driver.findElement(By.xpath("//button[contains(text(),\"Submit\")]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Salah satu form Main Account Number atau Account Name Wajib diisi')]"))
        ));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\ViewCustomerDetailWithNullAccNameAndNumber.png"));
        driver.findElement(By.linkText("Detail")).click();
    }

    @Test(priority = 4)
    @Severity(SeverityLevel.NORMAL)
    @Description("Check Customer with Name")
    @Story("Check Customer with Name")
    public void checkCustomerWithName() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//div[contains(text(),\"Choose account type\")]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[contains(text(),\"Both\")]")).click();
        driver.findElement(By.xpath("//input[@name='customerName']")).sendKeys("Latief Nurrohman Alfansuri");
        driver.findElement(By.xpath("//button[contains(text(),\"Submit\")]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.linkText("Detail"))
        ));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\CheckCustomerWithName.png"));
    }

    @Test(priority = 5)
    @Severity(SeverityLevel.NORMAL)
    @Description("Check Customer with Name and ID")
    @Story("Check Customer with Name and ID")
    public void checkCustomerWithNameAndID() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//input[@name='accountNumber']")).sendKeys("110100002987");
        driver.findElement(By.xpath("//button[contains(text(),\"Submit\")]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.linkText("Detail"))
        ));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\CheckCustomerWithNameAndID.png"));
    }

    @Test(priority = 6)
    @Severity(SeverityLevel.NORMAL)
    @Description("Check Customer with ID")
    @Story("Check Customer with ID")
    public void checkCustomerWithID() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//input[@name='customerName']")).clear();
        driver.findElement(By.xpath("//button[contains(text(),\"Submit\")]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.linkText("Detail"))
        ));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\CheckCustomerWithID.png"));
    }

    @Test(priority = 7)
    @Severity(SeverityLevel.NORMAL)
    @Description("View Specific Customer Information Detail")
    @Story("View Specific Customer Information Detail")
    public void viewCustomerDetail() throws IOException, InterruptedException {
        driver.findElement(By.linkText("Detail")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[contains(text(),'Customer Information Detail')]"));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\CustomerInformationDetailPage.png"));
    }

    @Test(priority = 8)
    @Severity(SeverityLevel.NORMAL)
    @Description("Use Transaction Record Filter Feature")
    @Story("Use Transaction Record Filter Feature")
    public void filterTransactionRecord() throws IOException, InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.xpath("//img[@src='/icons/filter.png']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[contains(text(),'Select...')]")).click();
        driver.findElement(By.xpath("//div[contains(text(),'Transfer In')]")).click();
        driver.findElement(By.id("startDate")).sendKeys("1 October 2021");
        driver.findElement(By.id("endDate")).sendKeys("1 December 2021");
        driver.findElement(By.xpath("//button[contains(text(),'Proceed')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'ID')]"))
        ));
    }

    @Test(priority = 9)
    @Severity(SeverityLevel.NORMAL)
    @Description("View Specific Box Account Transaction")
    @Story("View Specific Box Account Transaction")
    public void viewBoxAccountTransaction() throws IOException, InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[3]/div[2]/div/div[2]/div[1]/div[6]/span[2]/button")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[contains(text(),'Box Account Number')]"))
        ));
        driver.findElement(By.xpath("//p[contains(text(),'Main Box')]")).click();
        driver.findElement(By.xpath("//button[contains(text(),'Proceed')]")).click();
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'ID')]"))
        ));
    }

    @Test(priority = 10)
    @Severity(SeverityLevel.NORMAL)
    @Description("Change Handphone Number with Null")
    @Story("Change Handphone Number with Null")
    public void changePhoneNumberWithNull() throws IOException, InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[3]/div[2]/div/div[2]/div[1]/div[10]/span[2]/button")).click();
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Phone Number is required')]"))
        ));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'" + invalidPhone + "')]"))
        ));
    }

    @Test(priority = 11)
    @Severity(SeverityLevel.NORMAL)
    @Description("Change Handphone Number with Incorrect Number")
    @Story("Change Handphone Number with Incorrect Number")
    public void changePhoneNumberWithIncorrect() throws IOException, InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@name='newPhoneNumber']")).sendKeys(invalidPhone);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Phone Number is not valid')]"))
        ));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'" + invalidPhone + "')]"))
        ));
    }

    @Test(priority = 12)
    @Severity(SeverityLevel.NORMAL)
    @Description("Change Handphone Number")
    @Story("Change Handphone Number")
    public void successChangePhoneNumber() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//input[@name='newPhoneNumber']")).clear();
        driver.findElement(By.xpath("//input[@name='newPhoneNumber']")).sendKeys(newPhone);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'" + newPhone + "')]"))
        ));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\NewPhoneNumber.png"));
    }

    @Test(priority = 13)
    @Severity(SeverityLevel.NORMAL)
    @Description("Download Transaction Log")
    @Story("Download Transaction Log")
    public void downloadTransactionLog() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//button[@class='focus:outline-none border rounded-lg p-2 px-5 mx-1 bg-white shadow-sm focus:ring-2 focus:ring-alami-green focus:ring-opacity-50 text-sm font-normal']")).click();
        driver.findElement(By.xpath("//div[contains(text(),'Select...')]")).click();
        driver.findElement(By.xpath("//div[contains(text(),'PDF')]']")).click();
        driver.findElement(By.xpath("//button[contains(text(),'Download')]")).click();
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(projectPath+ "\\src\\test\\java\\screenshots\\DownloadTransLog.png"));
    }
}