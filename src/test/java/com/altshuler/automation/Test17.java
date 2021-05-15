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
public class Test17
{
    private static final String HOMEPAGE_URL="https://nlb.by/";
    private WebDriver driver;
    private int i=0;
    @BeforeMethod(alwaysRun=true)
    public void browserSetup()
    {
        if (i==0)
        {
            driver=new ChromeDriver();
            new WebDriverWait(driver,60);
            driver.get(HOMEPAGE_URL);
            driver.manage().window().maximize();
        }
        else
        {
            WebElement logotype=waitForElementLocatedBy(driver,By.xpath("//*[@class='svg-logo-animate']"),50);
            logotype.click();
        }
        WebElement btn=waitForElementLocatedBy(driver,By.xpath("//a/span"),35);
        btn.click();
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
        i++;
        WebElement menuItem=waitForElementLocatedBy(driver,By.xpath("//div[3]/div[1]/ul/li["+i+"]/a/span"),60);
        menuItem.click();
        WebElement title=waitForElementLocatedBy(driver,By.xpath("//div[2]/div/h1"),30);
        Assert.assertEquals(title.getText(),h1,"Error");
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