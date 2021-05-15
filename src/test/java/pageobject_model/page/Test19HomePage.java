package pageobject_model.page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobject_model.test.Test19_07_08;
import java.util.List;
public class Test19HomePage
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
    public Test19HomePage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public Test19HomePage openPage()
    {
        if (Test19_07_08.i==1)
        {
            new WebDriverWait(driver,60);
            driver.get(HOMEPAGE_URL);
            driver.manage().window().maximize();
        }
        return this;
    }
    public Test19ResultsPage registrate(String login, String password, String confirmPassword, String email, String theText)
    {
        Test19_07_08.waitForElementLocatedBy(driver,By.xpath("//span[@class='hide-1280']"),60);
        registration1.click();
        Test19_07_08.waitForElementLocatedBy(driver,By.xpath("//noindex/a"),60);
        registration2.click();
        String[] inputData={login, password, confirmPassword, email};
        for (int i=0; i<inputs.size(); i++)
        {
            inputs.get(i).sendKeys(inputData[i]);
        }
        Test19_07_08.waitForElementLocatedBy(driver,By.xpath("//a[@class='button']"),90);
        button.click();
        return new Test19ResultsPage(driver,theText);
    }
}