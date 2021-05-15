package pageobject_model.page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageobject_model.test.Test19_07_08;
public class Test19ResultsPage
{
    private WebDriver driver;
    public static String actualText;
    public String expectedText;
    public Test19ResultsPage(WebDriver driver,String theText)
    {
        this.driver=driver;
        int id=(Test19_07_08.i==1)?5:11;
        WebElement theField=Test19_07_08.waitForElementLocatedBy(driver,By.xpath("//*[@id='parsley-id-"+id+"']/span"),60);
        actualText=theField.getText();
        expectedText=theText;
    }
}