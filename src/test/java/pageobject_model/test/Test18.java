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
import pageobject_model.page.Test18HomePage;
import pageobject_model.page.Test18ResultsPage;
public class Test18 {
    private static WebDriver driver;
    private int i=0;
    @BeforeMethod(alwaysRun=true)
    public void browserSetup()  {
        if (i==0) {
            driver=new ChromeDriver(); } }
    @DataProvider(name="Registration")
    public static Object[][] credentials() {
        return new Object[][] {{"","i54321","i54321","igaltshuler@mail.ru"},
		{"AltI1998","","i54321","igaltshuler@mail.ru"},
        {"AltI1998","i54321","","igaltshuler@mail.ru"},{"AltI1998","i54321","i54321",""},{"","","",""}}; }
    @Test(dataProvider="Registration")
    public void test(String login,String password,String confirmPassword,String email){
        //номер параметризованного теста
        i++;
        Test18ResultsPage result=new Test18HomePage(driver).openPage()
                .registrate(login,password,confirmPassword,email,"Обязательное поле.");
        String actualResult=Test18ResultsPage.actualText;
        String expectedResult=result.expectedText;
        Assert.assertEquals(actualResult,expectedResult,"Error"); }
    @AfterMethod(alwaysRun=true)
    public void browserExit() {
        if (i==5){
            driver.quit();
            driver=null; } }
    public static WebElement waitForElementLocatedBy(WebDriver driver, By by, int time){
        return new WebDriverWait(driver,time)
                .until(ExpectedConditions.presenceOfElementLocated(by)); }}