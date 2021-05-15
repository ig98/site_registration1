package pageobject_model.page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageobject_model.test.Test03;
import java.util.List;
public class Test03HomePage
{
    private static final String HOMEPAGE_URL="https://nlb.by/";
    private WebDriver driver;
    @FindBy(xpath="//span[@class='hide-1280']")
    private WebElement registration1;
    @FindBy(xpath="//noindex/a")
    private WebElement registration2;
    @FindAll({@FindBy(id="reg_userlogin"),@FindBy(id="reg_pwd_2"),@FindBy(name="REGISTER[EMAIL]")})
    List<WebElement> inputs;
    @FindBy(xpath="//a[@class='button']")
    private WebElement button;
    public Test03HomePage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public Test03HomePage openPage()
    {
        driver.get(HOMEPAGE_URL);
        driver.manage().window().maximize();
        return this;
    }
    public Test03ResultsPage registrate(String theText)
    {
        Test03.waitForElementLocatedBy(driver,By.xpath("//span[@class='hide-1280']"),60);
        registration1.click();
        Test03.waitForElementLocatedBy(driver,By.xpath("//noindex/a"),30);
        registration2.click();
        String[] inputData={"AltI1998","i54321","igaltshuler@mail.ru"};
        for (int i=0; i<inputs.size(); i++)
        {
            inputs.get(i).sendKeys(inputData[i]);
        }
        Test03.waitForElementLocatedBy(driver,By.xpath("//a[@class='button']"),60);
        button.click();
        return new Test03ResultsPage(driver,theText);
    }
}