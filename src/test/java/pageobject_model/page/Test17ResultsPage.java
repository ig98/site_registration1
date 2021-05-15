package pageobject_model.page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class Test17ResultsPage
{
    private WebDriver driver;
    @FindBy(xpath="//div[2]/div/h1")
    private WebElement title;
    public static String actualText;
    public String expectedText;
    Test17ResultsPage(WebDriver driver,String theText)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
        actualText=title.getText();
        expectedText=theText;
    }
}