package pageobject_model.page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageobject_model.test.Test18;
public class Test18ResultsPage {
    private WebDriver driver;
    private WebElement theField;
    public static String actualText;
    public String expectedText;
    public Test18ResultsPage(WebDriver driver,String theText){
        this.driver=driver;
        //получение локатора активного элемента после нажатия кнопки "Далее"
        String XPath="//input[@name='"+driver.switchTo().activeElement().getAttribute("name")+"']";
        theField=Test18.waitForElementLocatedBy(driver,By.xpath(XPath+"/../span/span"),120);
        actualText=theField.getText();
        expectedText=theText; } }