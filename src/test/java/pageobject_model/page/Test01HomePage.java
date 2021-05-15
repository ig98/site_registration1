package pageobject_model.page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageobject_model.test.Test01;
public class Test01HomePage {
    private static final String HOMEPAGE_URL="https://nlb.by/";
    private WebDriver driver;
    @FindBy(xpath="//span[@class='hide-1280']")
    private WebElement registration1;
    @FindBy(xpath="//noindex/a")
    private WebElement registration2;
    @FindBy(xpath="//a[@class='button']")
    private WebElement button;
    public Test01HomePage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public Test01HomePage openPage()
    {
        driver.get(HOMEPAGE_URL);
        driver.manage().window().maximize();
        return this;
    }
    public Test01ResultsPage registrate()
    {
        Test01.waitForElementLocatedBy(driver,By.xpath("//span[@class='hide-1280']"),20);
        registration1.click();
        Test01.waitForElementLocatedBy(driver,By.xpath("//noindex/a"),20);
        registration2.click();
        Test01.waitForElementLocatedBy(driver,By.xpath("//a[@class='button']"),20);
        button.click();
        return new Test01ResultsPage(driver);
    }
}