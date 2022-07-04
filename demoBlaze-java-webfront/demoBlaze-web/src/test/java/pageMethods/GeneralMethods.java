package pageMethods;

import configuration.Iproperties;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;

public class GeneralMethods {
    public static WebDriver driver;
    public static Iproperties props = ConfigFactory.create(Iproperties.class);


    @Before
    public static void ejecutaChrome() {
        //En caso de linux
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver");
        //En caso de Windows
        //System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(GeneralMethods.props.url());
    }

    @After
    public static void cierraApp() {
        System.out.println("FINALIZANDO TEST");
        if (driver != null) {
            driver.quit();
        }
    }

    public static String randomEmail() {
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(99999999);
        return "username" + randomInt + "@gmail.com";
    }

    public static int randomNumber(int size) {
        Random random = new Random();
        return random.nextInt(size);
    }

    public static void elementClick(By element, int timeWait) {
        WebDriverWait wait = new WebDriverWait(GeneralMethods.driver, Duration.ofSeconds(timeWait));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        GeneralMethods.driver.findElement(element).click();
    }

    public static void elementClick(WebElement element, int timeWait) {
        WebDriverWait wait = new WebDriverWait(GeneralMethods.driver, Duration.ofSeconds(timeWait));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public static void elementSendText(By element, String text) {
        WebDriverWait wait = new WebDriverWait(GeneralMethods.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        GeneralMethods.driver.findElement(element).sendKeys(text);
    }

    public static void scrollToElement(WebElement element) {
        WebElement elemento = new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(element));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", elemento);
    }

    public static void elementWaitDisplayed(By element, int tiempoEspera) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(tiempoEspera));
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

}

