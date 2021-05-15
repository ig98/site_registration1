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
import org.testng.annotations.Test;
public class Test15
{
    private WebDriver driver;
    @BeforeMethod(alwaysRun=true)
    public void browserSetup()
    {
        driver=new ChromeDriver();
    }
    @Test
    public void elementEquals()
    {
        driver.get("https://nlb.by/");
        driver.manage().window().maximize();
        new WebDriverWait(driver,40)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='hide-1280']")));
        WebElement registration=driver.findElement(By.xpath("//span[@class='hide-1280']"));
        registration.click();
        new WebDriverWait(driver,30)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//noindex/a")));
        registration=driver.findElement(By.xpath("//noindex/a"));
        registration.click();
        new WebDriverWait(driver,30)
                .until(ExpectedConditions.presenceOfElementLocated(By.id("reg_userlogin")));
        WebElement login=driver.findElement(By.id("reg_userlogin"));
        login.sendKeys("AltI1998");
        new WebDriverWait(driver,30)
                .until(ExpectedConditions.presenceOfElementLocated(By.id("reg_pwd_1")));
        WebElement password=driver.findElement(By.id("reg_pwd_1"));
        password.sendKeys("i54321");
        new WebDriverWait(driver,30)
                .until(ExpectedConditions.presenceOfElementLocated(By.id("reg_pwd_2")));
        WebElement confirmPassword=driver.findElement(By.id("reg_pwd_2"));
        confirmPassword.sendKeys("i54321");
        new WebDriverWait(driver,30)
                .until(ExpectedConditions.presenceOfElementLocated(By.name("REGISTER[EMAIL]")));
        WebElement emailAddress=driver.findElement(By.name("REGISTER[EMAIL]"));
        emailAddress.sendKeys("igaltshuler@mail.ru");
        new WebDriverWait(driver,30)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class='button']")));
        WebElement button=driver.findElement(By.xpath("//a[@class='button']"));
        button.click();
        new WebDriverWait(driver,40)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='bg--gradient']")));
        WebElement span=driver.findElement(By.xpath("//span[@class='bg--gradient']"));
        Assert.assertEquals(span.getTagName(),"span","Error");
    }
    @AfterMethod(alwaysRun=true)
    public void browserExit()
    {
        driver.quit();
        driver=null;
    }
}