import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class LettersPage {
    @FindBy(css = "span>span>span>span[title='Simbirsoft theme']")
    private List<WebElement> letters;


    private WebDriver driver;
    private WebDriverWait wait;

    public LettersPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    public Integer getCountLetters() {
        return letters.size();
    }
}
