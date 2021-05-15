package pageobject_model.test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject_model.page.Test01HomePage;
import pageobject_model.page.Test01ResultsPage;
public class Test01
{
    private WebDriver driver;
    @BeforeMethod(alwaysRun=true)
    public void browserSetup()
    {
        driver=new ChromeDriver();
    }
    @Test (description="Обязательность заполнения всех полей на первой вкладке формы регистрации")
    public void elementEquals()
    {
        Test01ResultsPage expectedResult=new Test01HomePage(driver).openPage().registrate();
        String actualResult=Test01ResultsPage.theText;
        Assert.assertEquals(actualResult,"Обязательное поле.","Error");
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