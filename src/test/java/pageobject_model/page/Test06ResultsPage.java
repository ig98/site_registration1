package pageobject_model.page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageobject_model.test.Test06;
public class Test06ResultsPage {
    private WebDriver driver;
    @FindBy(xpath="//*[@id='parsley-id-9']/span")
    private WebElement theField;
    public static String actualText;
    public String expectedText;
    public Test06ResultsPage(WebDriver driver, String theText){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        Test06.waitForElementLocatedBy(driver, By.xpath("//*[@id='parsley-id-9']/span"), 20);
        actualText=theField.getText();
        expectedText=theText; } }