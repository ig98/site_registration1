package pageobject_model.test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import pageobject_model.page.Test17HomePage;
import pageobject_model.page.Test17ResultsPage;
public class Test17
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
    @DataProvider(name="Функционирование ссылок")
    public static Object[][] credentials()
    {
        return new Object[][] {{"Режим работы"},{"Адрес"},{"Знакомство с Национальной библиотекой Беларуси"},{"Устав"},
                {"Структура библиотеки"},{"Товарные знаки библиотеки"},{"Вышестоящая организация"},
                {"Обращения граждан и юридических лиц"},{"История библиотеки"},{"Известные имена"},{"Современное состояние"},
                {"Научная деятельность"},{"Издательская продукция библиотеки"},{"Награды и благодарности библиотеке"},
                {"Дары библиотеке"},{"Тендеры библиотеки"},{"Вакансии библиотеки"},{"Архив документов"},{"Фотогалерея"}};
    }
    @Test(dataProvider="Функционирование ссылок")
    public void test(String h1)
    {
        Test17ResultsPage result=new Test17HomePage(driver).openPage().funcOfLinks(h1);
        String actualResult=Test17ResultsPage.actualText;
        String expectedResult=result.expectedText;
        Assert.assertEquals(actualResult,expectedResult,"Error");
    }
    @AfterMethod(alwaysRun=true)
    public void browserExit()
    {
        if (i==19)
        {
            driver.quit();
            driver=null;
        }
    }
    public static WebElement waitForElementLocatedBy(WebDriver driver,By by,int time)
    {
        return new WebDriverWait(driver,time)
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }
}