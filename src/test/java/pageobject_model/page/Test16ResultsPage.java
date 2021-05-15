package pageobject_model.page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class Test16ResultsPage
{
    private WebDriver driver;
    @FindBy(xpath="//h1[text()='Профиль пользователя']")
    private WebElement h1;
    public static String actualText;
    public String expectedText;
    Test16ResultsPage(WebDriver driver,String theText)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
        actualText=h1.getText();
        expectedText=theText;
    }
}