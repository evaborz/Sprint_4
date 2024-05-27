import io.github.bonigarcia.wdm.WebDriverManager;
import org.jsoup.nodes.Element;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobjects.MainPage;

import java.util.concurrent.TimeUnit;

public class DropdownTest{

    private WebDriver driver;
    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
    }
    @Test
    public void testDropdownList() {
        driver = new ChromeDriver();
        MainPage mainPage = new MainPage(driver);

        String tex1 = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";

        // Открываем главную страницу
        driver.get("https://qa-scooter.praktikum-services.ru/");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

 //
        Element doc = null;
        Element element = doc.selectFirst("#content");
                //By.xpath("//*[@id='accordion__heading-0']g"))

        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        // Нажимаем на стрелочку выпадающего списка
        mainPage.clickQuestion1();

        // Проверяем, что соответствующий текст отобразился
        mainPage.waitForText1Displayed();

        Assert.assertEquals(
                mainPage.getText1(), tex1
        );

    }

    @After
    public void teardown() {
        // Закрой браузер
        driver.quit();
    }
}