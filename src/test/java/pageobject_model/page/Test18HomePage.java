package pageobject_model.page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageobject_model.test.Test18;
import java.util.List;
public class Test18HomePage {
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
    public Test18HomePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this); }
    public Test18HomePage openPage(){
        driver.get(HOMEPAGE_URL);
        driver.manage().window().maximize();
        return this; }
    public Test18ResultsPage registrate(String login,String password,String confirmPassword,String email,String theText){
        //переход на форму «Вход в личный кабинет» нажатием на кнопку «Вход / Регистрация»
        //точка риска синхронизации
        Test18.waitForElementLocatedBy(driver,By.xpath("//span[@class='hide-1280']"),20);
        registration1.click();
        //переход на страницу «Регистрация нового пользователя» по ссылке «Регистрация»
        //точка риска синхронизации
        Test18.waitForElementLocatedBy(driver,By.xpath("//noindex/a"),20);
        registration2.click();
        //заполнение формы регистрации данными @DataProvider
        String[] inputData={login,password,confirmPassword,email};
        for (int i=0; i<inputs.size(); i++) {
            inputs.get(i).sendKeys(inputData[i]); }
        Test18.waitForElementLocatedBy(driver,By.xpath("//a[@class='button']"),20);
        button.click();
        return new Test18ResultsPage(driver,theText); } }