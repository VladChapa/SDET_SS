import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateLetterPage {
    @FindBy(css = "span[class='mail-ComposeButton-Text']")
    private WebElement createLetterButton;

    @FindBy(xpath = ".//span[text()='Кому']/../../div/div/div")
    private WebElement fieldTo;

    @FindBy(xpath = ".//span[text()='Тема']/../../div/input")
    private WebElement fieldTheme;

    @FindBy(css = "div[placeholder='Напишите что-нибудь']")
    private WebElement fieldText;

    @FindBy(xpath = ".//span[text()='Отправить']/../../..")
    private WebElement sendLetterButton;

    private WebDriver driver;
    private WebDriverWait wait;

    public CreateLetterPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    public void createLetter(String email, String theme, String text){
        clickCreateLetterButton();
        sendTo(email);
        sendTheme(theme);
        sendText(text);
        clickSendButton();
    }
    public void clickCreateLetterButton() {
        createLetterButton.click();
    }

    public void sendTo(String email) { fieldTo.sendKeys(email); }

    public void sendTheme(String theme) {
        fieldTheme.sendKeys(theme);
    }

    public void sendText(String text) {
        fieldText.sendKeys(text);
    }

    public void clickSendButton() { sendLetterButton.click(); }
}
