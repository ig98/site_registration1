package pageobject_model.page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageobject_model.test.Test15;
public class Test15ResultsPage
{
    private WebDriver driver;
    @FindBy(xpath="//span[@class='bg--gradient']")
    private WebElement span;
    public static String theTag;
    public Test15ResultsPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
        Test15.waitForElementLocatedBy(driver,By.xpath("//span[@class='bg--gradient']"),80);
        theTag=span.getTagName();
    }
}