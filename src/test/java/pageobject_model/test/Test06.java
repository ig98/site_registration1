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
import pageobject_model.page.Test06ResultsPage;
import pageobject_model.page.Test06HomePage;
public class Test06 {
    private WebDriver driver;
    @BeforeMethod(alwaysRun=true)
    public void browserSetup(){
        driver=new ChromeDriver(); }
    @Test (description="Регистрация с введением невалидных данных в поле «Подтвердить пароль»")
    public void elementEquals(){
        Test06ResultsPage result=new Test06HomePage(driver).openPage().registrate("Это значение должно совпадать.");
        String actualResult=Test06ResultsPage.actualText;
        String expectedResult=result.expectedText;
        Assert.assertEquals(actualResult,expectedResult,"Error"); }
    @AfterMethod(alwaysRun=true)
    public void browserExit(){
        driver.quit();
        driver=null; }
    public static void waitForElementLocatedBy(WebDriver driver,By by,int time){
        new WebDriverWait(driver,time)
                .until(ExpectedConditions.presenceOfElementLocated(by)); } }