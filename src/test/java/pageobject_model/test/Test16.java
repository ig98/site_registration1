package pageobject_model.test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageobject_model.page.Test16HomePage;
import pageobject_model.page.Test16ResultsPage;
public class Test16
{
    private static WebDriver driver;
    private int i=0;
    @BeforeMethod(alwaysRun=true)
    public void browserSetup()
    {
        if (i==0)
        {
            driver=new ChromeDriver();
        }
    }
    @DataProvider(name="Authentication")
    public static Object[][] credentials()
    {
        return new Object[][] {{"AltIO98","u12345"},{"AltIO97","i12345"},{"AltIO97","u12345"},{"AltIO98","i12345"}};
    }
    @Test(dataProvider="Authentication")
    public void test(String login,String password)
    {
        i++;
        Test16ResultsPage result=new Test16HomePage(driver).openPage()
                .signIn(login,password,"Профиль пользователя");
        String actualResult=Test16ResultsPage.actualText;
        String expectedResult=result.expectedText;
        Assert.assertEquals(actualResult,expectedResult,"Неправильные логин или пароль");
    }
    @AfterMethod(alwaysRun=true)
    public void browserExit()
    {
        if (i==4)
        {
            driver.quit();
            driver=null;
        }
    }
    public static void waitForElementLocatedBy(WebDriver driver,By by,int time)
    {
        new WebDriverWait(driver,time)
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }
}