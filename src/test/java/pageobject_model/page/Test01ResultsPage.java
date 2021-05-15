package pageobject_model.page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageobject_model.test.Test01;
public class Test01ResultsPage
{
    private WebDriver driver;
    @FindBy(xpath="//*[@id='parsley-id-5']/span")
    private WebElement theField;
    public static String theText;
    public Test01ResultsPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
        Test01.waitForElementLocatedBy(driver,By.xpath("//*[@id='parsley-id-5']/span"),20);
        theText=theField.getText();
    }
}