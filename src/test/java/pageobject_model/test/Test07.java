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
import pageobject_model.page.Test07ResultsPage;
import pageobject_model.page.Test07HomePage;
public class Test07
{
    private WebDriver driver;
    @BeforeMethod(alwaysRun=true)
    public void browserSetup()
    {
        driver=new ChromeDriver();
    }
    @Test (description="Регистрация нового пользователя с логином уже зарегистрированного пользователя")
    public void elementEquals()
    {
        Test07ResultsPage result=new Test07HomePage(driver).openPage().registrate("Этот логин занят");
        String actualResult=Test07ResultsPage.actualText;
        String expectedResult=result.expectedText;
        Assert.assertEquals(actualResult,expectedResult,"Error");
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