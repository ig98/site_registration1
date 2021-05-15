package pageobject_model.page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobject_model.test.Test17;
public class Test17HomePage
{
    private static final String HOMEPAGE_URL="https://nlb.by/";
    private WebDriver driver;
    @FindBy(xpath="//*[@class='svg-logo-animate']")
    private WebElement logotype;
    @FindBy(xpath="//a/span")
    private WebElement btn;
    @FindBy(xpath="//div[3]/div[1]/ul")
    private WebElement menu;
    public Test17HomePage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public Test17HomePage openPage()
    {
        if (Test17.i==0)
        {
            new WebDriverWait(driver,60);
            driver.get(HOMEPAGE_URL);
            driver.manage().window().maximize();
        }
        else
        {
            Test17.waitForElementLocatedBy(driver,By.xpath("//*[@class='svg-logo-animate']"),50);
            logotype.click();
        }
        Test17.waitForElementLocatedBy(driver,By.xpath("//a/span"),60);
        btn.click();
        return this;
    }
    public Test17ResultsPage funcOfLinks(String theText)
    {
        Test17.i++;
        WebElement menuItem=menu.findElement(By.xpath("//div[3]/div[1]/ul/li["+Test17.i+"]/a/span"));
        menuItem.click();
        return new Test17ResultsPage(driver,theText);
    }
}