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
import pageobject_model.page.Test13ResultsPage;
import pageobject_model.page.Test13HomePage;
public class Test13
{
    private WebDriver driver;
    @BeforeMethod(alwaysRun=true)
    public void browserSetup()
    {
        driver=new ChromeDriver();
    }
    @Test (description="Минимальная допустимая длина логина")
    public void elementEquals()
    {
        Test13ResultsPage result=new Test13HomePage(driver).openPage()
                .registrate("Логин должен содержать латинские буквы или  цифры (не менее 3 символов)");
        String actualResult=Test13ResultsPage.actualText;
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