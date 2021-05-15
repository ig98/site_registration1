package pageobject_model.page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageobject_model.test.Test13;
public class Test13ResultsPage
{
    private WebDriver driver;
    @FindBy(xpath="//*[@id='reg_userlogin']")
    private WebElement theField;
    public static String actualText;
    public String expectedText;
    public Test13ResultsPage(WebDriver driver,String theText)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
        Test13.waitForElementLocatedBy(driver,By.xpath("//*[@id='reg_userlogin']"),40);
        actualText=theField.getAttribute("data-parsley-pattern-message");
        expectedText=theText;
    }
}