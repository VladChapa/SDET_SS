import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AuthorizationPage {
    @FindBy(css = "div[class='desk-notif-card__login-new-item-title']")
    private WebElement enter;

    @FindBy(css = "input[class='Textinput-Control']")
    private WebElement inputLogin;

    @FindBy(css = "button[type='submit']")
    private WebElement enterButton;

    @FindBy(css = "input[data-t='field:input-passwd']")
    private WebElement inputPass;

    @FindBy(css = "div[class='desk-notif-card__mail-title']")
    private WebElement mailButton;

    private WebDriver driver;
    private WebDriverWait wait;

    public AuthorizationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void authorization(String login, String pass) {
        clickEnter();
        sendLogin(login);
        clickLoginEnter();
        sendPass(pass);
        clickLoginEnter();
    }

    public void clickEnter() {
        enter.click();
    }

    public void clickLoginEnter() {
        enterButton.click();
    }

    public void sendLogin(String login) {
        inputLogin.sendKeys(login);
    }

    public void sendPass(String pass) {
        inputPass.sendKeys(pass);
    }

    public void clickMailButton() {
        mailButton.click();
    }
}