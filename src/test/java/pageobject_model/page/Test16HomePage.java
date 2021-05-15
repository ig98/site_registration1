package pageobject_model.page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobject_model.test.Test16;
public class Test16HomePage
{
    private static final String HOMEPAGE_URL="https://nlb.by/";
    private WebDriver driver;
    @FindBy(xpath="//span[@class='hide-1280']")
    private WebElement signIn;
    @FindBy(xpath="//div[1]/div/div/input")
    private WebElement inputLogin;
    @FindBy(xpath="//div[2]/div/div/input")
    private WebElement inputPassword;
    @FindBy(xpath="//input[@value='Войти']")
    private WebElement input;
    @FindBy(xpath="//span[@class='hide-1400']")
    private WebElement goToProfile;
    public Test16HomePage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public Test16HomePage openPage()
    {
        new WebDriverWait(driver,40);
        driver.get(HOMEPAGE_URL);
        driver.manage().window().maximize();
        return this;
    }
    public Test16ResultsPage signIn(String login,String password,String theText)
    {
        signIn.click();
        inputLogin.sendKeys(login);
        inputPassword.sendKeys(password);
        input.click();
        Test16.waitForElementLocatedBy(driver,By.xpath("//span[@class='hide-1400']"),15);
        goToProfile.click();
        return new Test16ResultsPage(driver,theText);
    }
}