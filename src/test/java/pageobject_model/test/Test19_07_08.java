package pageobject_model.test;
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
import pageobject_model.page.Test19ResultsPage;
import pageobject_model.page.Test19HomePage;
public class Test19_07_08
{
    private WebDriver driver;
    public static int i=0;
    @BeforeMethod(alwaysRun=true)
    public void browserSetup()
    {
        if (i==0)
        {
            driver=new ChromeDriver();
        }
    }
    @DataProvider(name="Registration")
    public static Object[][] credentials()
    {
        return new Object[][] {{"AltIO98", "i54321", "i54321", "igaltshuler@mail.ru"}, {"AltI1998", "i54321", "i54321", "igaltshuler@mail.ru"}};
    }
    @Test (dataProvider="Registration",
            description="Регистрация нового пользователя с логином или e-mail уже зарегистрированного пользователя")
    public void elementEquals(String login, String password, String confirmPassword, String email)
    {
        //номер параметризованного теста
        i++;
        String expectedText=(i==1)?"Этот логин занят":"Этот адрес эл. почты занят";
        Test19ResultsPage result=new Test19HomePage(driver).openPage()
                .registrate(login, password, confirmPassword, email, expectedText);
        String actualResult=Test19ResultsPage.actualText;
        String expectedResult=result.expectedText;
        Assert.assertEquals(actualResult,expectedResult,"Error");
    }
    @AfterMethod(alwaysRun=true)
    public void browserExit()
    {
        if (i==2)
        {
            driver.quit();
            driver=null;
        }
    }
    public static WebElement waitForElementLocatedBy(WebDriver driver, By by, int time)
    {
        return new WebDriverWait(driver,time)
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }
}