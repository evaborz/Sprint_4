package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {

    private WebDriver driver;
    // Кнопка "Заказать" вверху страницы
    private By orderButtonTop = By.className("Button_Button__ra12g");

    // Кнопка "Заказать" внизу страницы
    private By orderButtonBottom = By.className("Button_Middle__1CSJMm");

    //Вторая кнопка "Вопросы о важном"
    private By question1 = By.xpath("//*[@id='accordion__heading-0']g");
    private By question1text = By.xpath(".//[@id='accordion__panel-1']/p/text()");


    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOrderButtonTop() {
        driver.findElement(orderButtonTop).click();
    }

    public void clickOrderButtonBottom() {
        driver.findElement(orderButtonBottom).click();
    }

    public void clickQuestion1() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(question1)).click();
//        driver.findElement(question1).click();
    }



    public String getText1() {
        return driver.findElement(question1text).getText();
    }

    public void waitForText1Displayed() {
        new WebDriverWait(driver, 10)
                .until(driver -> (
                                driver.findElement(question1text).isDisplayed()
                        )
                );
    }
}
