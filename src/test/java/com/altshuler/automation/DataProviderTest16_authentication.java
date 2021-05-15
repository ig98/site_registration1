package com.altshuler.automation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
public class DataProviderTest16_authentication
{
    @BeforeMethod(alwaysRun=true)
    public void browserSetup()
    {
        driver=new ChromeDriver();
    }
    private static WebDriver driver;
    @DataProvider(name="Authentication")
    public static Object[][] credentials()
    {
        return new Object[][] {{"AltIO98","i12345"},{"AltIO98","u12345"},{"AltIO97","i12345"},{"AltIO97","u12345"}};
    }
    @Test(dataProvider="Authentication")
    public void test(String login,String password)
    {
        new WebDriverWait(driver,40);
        driver.get("https://nlb.by/");
        driver.manage().window().maximize();
        WebElement signIn=driver.findElement(By.xpath("//span[@class='hide-1280']"));
        signIn.click();
        WebElement inputLogin=driver.findElement(By.xpath("//div[1]/div/div/input"));
        inputLogin.sendKeys(login);
        WebElement inputPassword=driver.findElement(By.xpath("//div[2]/div/div/input"));
        inputPassword.sendKeys(password);
        WebElement input=driver.findElement(By.xpath("//input[@value='Войти']"));
        input.click();
        waitForElementLocatedBy(driver,By.xpath("//span[@class='hide-1400']"),15);
        WebElement goToProfile=driver.findElement(By.xpath("//span[@class='hide-1400']"));
        goToProfile.click();
        WebElement h1=driver.findElement(By.xpath("//h1[text()='Профиль пользователя']"));
        Assert.assertEquals(h1.getText(),"Профиль пользователя","Error");
    }
    @AfterMethod(alwaysRun=true)
    public void browserExit()
    {
        driver.quit();
        driver=null;
    }
    public static void waitForElementLocatedBy(WebDriver driver,By by,int time)
    {
        new WebDriverWait(driver,time)
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }
}