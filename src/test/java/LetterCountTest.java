import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class LetterCountTest {
    public WebDriver driver;
    public AuthorizationPage authorizationPage;
    public LettersPage lettersPage;
    public CreateLetterPage createLetterPage;
    public final String email = "Chapoid@yandex.ru";
    public final String pass = "24102014";


    @BeforeClass
    public void before() {
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
        driver = new ChromeDriver();
        authorizationPage = new AuthorizationPage(driver);
        lettersPage = new LettersPage(driver);
        createLetterPage = new CreateLetterPage(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    @Test
    public void checkLetter() {
        Integer count;
        driver.navigate().to("http://yandex.ru");
        authorizationPage.authorization(email,pass);
        authorizationPage.clickMailButton();

        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles()); //все вкладки
        driver.switchTo().window(tabs.get(1)); //переход на новую вкладку

        count = lettersPage.getCountLetters();
        createLetterPage.createLetter(email, "Simbirsoft theme", "Найдено " + count + " писем/ьма");
        Assert.assertEquals(lettersPage.getCountLetters(), count++,"Количество писем осталось неизменным");
    }

    @AfterClass
    public void after() {
        driver.close();
    }
}