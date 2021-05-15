package pageobject_model.page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageobject_model.test.Test09;
import java.util.List;
public class Test09HomePage
{
    private static final String HOMEPAGE_URL="https://nlb.by/";
    private WebDriver driver;
    @FindBy(xpath="//span[@class='hide-1280']")
    private WebElement registration1;
    @FindBy(xpath="//noindex/a")
    private WebElement registration2;
    @FindAll({@FindBy(id="reg_userlogin"),@FindBy(id="reg_pwd_1"),@FindBy(id="reg_pwd_2"),@FindBy(name="REGISTER[EMAIL]")})
    List<WebElement> inputs;
    @FindBy(xpath="//a[@class='button']")
    private WebElement button;
    public Test09HomePage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public Test09HomePage openPage()
    {
        driver.get(HOMEPAGE_URL);
        driver.manage().window().maximize();
        return this;
    }
    public Test09ResultsPage registrate(String theText)
    {
        Test09.waitForElementLocatedBy(driver,By.xpath("//span[@class='hide-1280']"),60);
        registration1.click();
        Test09.waitForElementLocatedBy(driver,By.xpath("//noindex/a"),30);
        registration2.click();
        String[] inputData={"AltI1998","i54321","i54321","igaltshulermail.ru"};
        for (int i=0; i<inputs.size(); i++)
        {
            inputs.get(i).sendKeys(inputData[i]);
        }
        Test09.waitForElementLocatedBy(driver,By.xpath("//a[@class='button']"),60);
        button.click();
        return new Test09ResultsPage(driver,theText);
    }
}