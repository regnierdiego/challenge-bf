package pageMethods;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.DemoBlazePage;

import java.time.Duration;
import java.util.List;

public class DemoBlazeMethods {
    public static void openForm() {
        GeneralMethods.elementWaitDisplayed(DemoBlazePage.getGetSingupButton(), 30);
        GeneralMethods.elementClick(DemoBlazePage.getGetSingupButton(), 10);

        GeneralMethods.elementWaitDisplayed(DemoBlazePage.getUsernameRegister(), 15);
    }

    public static void registerAndLogin() {
        String username = GeneralMethods.randomEmail();

        GeneralMethods.elementSendText(DemoBlazePage.getUsernameRegister(), username);
        GeneralMethods.elementWaitDisplayed(DemoBlazePage.getPasswordRegister(), 15);
        GeneralMethods.elementSendText(DemoBlazePage.getPasswordRegister(), DemoBlazePage.password);
        GeneralMethods.elementClick(DemoBlazePage.getSubmitRegister(), 15);

        WebDriverWait wait = new WebDriverWait(GeneralMethods.driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.alertIsPresent());
        String alertText = GeneralMethods.driver.switchTo().alert().getText();

        if (alertText.contains("Sign up successful")) {
            System.out.println("USER REGISTER SUCCESSFULLY");
        } else {
            Assert.fail("ERROR USER REGISTER!");
        }

        System.out.println("USERNAME CREATED IS => " + username);

        GeneralMethods.driver.switchTo().alert().accept();

        GeneralMethods.elementWaitDisplayed(DemoBlazePage.getLoginButton(), 15);
        GeneralMethods.elementClick(DemoBlazePage.getLoginButton(), 15);

        GeneralMethods.elementWaitDisplayed(DemoBlazePage.getUsernameLogin(), 15);
        GeneralMethods.elementSendText(DemoBlazePage.getUsernameLogin(), username);
        GeneralMethods.elementWaitDisplayed(DemoBlazePage.getPassword(), 15);
        GeneralMethods.elementSendText(DemoBlazePage.getPassword(), DemoBlazePage.password);
        GeneralMethods.elementClick(DemoBlazePage.getSubmitLogin(), 15);

        GeneralMethods.elementWaitDisplayed(DemoBlazePage.getNameOfUser(), 30);
        String welcomeMessage = GeneralMethods.driver.findElement(DemoBlazePage.getNameOfUser())
                .getText();
        if (welcomeMessage.contains(username)) {
            System.out.println("LOGIN SUCCESSFULLY");
        } else {
            Assert.fail("ERROR LOGIN");
        }
    }

    public static void logoutAndCheck() {
        GeneralMethods.elementWaitDisplayed(DemoBlazePage.getLogoutButton(), 10);
        GeneralMethods.elementClick(DemoBlazePage.getLogoutButton(), 10);

        GeneralMethods.elementWaitDisplayed(DemoBlazePage.getLoginButton(), 15);
        System.out.println("LOGOUT SUCCESSFULLY");
    }

    public static void selectProduct() throws InterruptedException {
        GeneralMethods.elementWaitDisplayed(DemoBlazePage.getCategories(), 30);

        List<WebElement> categories = GeneralMethods.driver.findElements(DemoBlazePage.getCategories());
        WebElement randomCategory = categories.get(GeneralMethods.randomNumber(categories.size()));
        GeneralMethods.scrollToElement(randomCategory);
        System.out.println("CATEGORY SELECETED => " + randomCategory.getText());
        GeneralMethods.elementClick(randomCategory, 15);

        Thread.sleep(700);

        GeneralMethods.elementWaitDisplayed(DemoBlazePage.getProducts(), 30);

        List<WebElement> products = GeneralMethods.driver.findElements(DemoBlazePage.getProducts());
        WebElement randomProduct = products.get(GeneralMethods.randomNumber(products.size()));
        GeneralMethods.scrollToElement(randomProduct);
        GeneralMethods.elementClick(randomProduct, 15);
    }

    public static void addToCart() {
        GeneralMethods.elementWaitDisplayed(DemoBlazePage.getAddToCart(), 15);
        GeneralMethods.elementClick(DemoBlazePage.getAddToCart(), 15);

        WebDriverWait wait = new WebDriverWait(GeneralMethods.driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.alertIsPresent());
        String alertText = GeneralMethods.driver.switchTo().alert().getText();

        if (alertText.contains("Product added")) {
            System.out.println("ALERT 'ADD TO CART' IS DISPLAYED");
        } else {
            Assert.fail("ERROR ADD TO CART!");
        }

        GeneralMethods.driver.switchTo().alert().accept();
    }

    public static void addedCartCheck() {
        GeneralMethods.elementWaitDisplayed(DemoBlazePage.getProductName(), 15);
        String productName = GeneralMethods.driver.findElement(DemoBlazePage.getProductName())
                .getText();
        System.out.println("PRODUCT SELECT => " + productName);
        String productPrice = GeneralMethods.driver.findElement(DemoBlazePage.getProductPrice())
                .getText().replaceAll("[^0-9]", "");
        System.out.println("PRODUCT PRICE => $" + productPrice);

        GeneralMethods.elementWaitDisplayed(DemoBlazePage.getCartMenu(), 15);
        GeneralMethods.elementClick(DemoBlazePage.getCartMenu(), 15);

        GeneralMethods.elementWaitDisplayed(DemoBlazePage.getProductAddedName(), 15);
        String productInCartName = GeneralMethods.driver.findElement(DemoBlazePage.getProductAddedName())
                .getText();
        if (productInCartName.contains(productName)) {
            System.out.println("PRODUCT NAME MATCHES");
        } else {
            Assert.fail("PRODUCT NAME NOT MATCHES");
        }
        GeneralMethods.elementWaitDisplayed(DemoBlazePage.getProductAddedPrice(), 15);
        String productInCartPrice = GeneralMethods.driver.findElement(DemoBlazePage.getProductAddedPrice())
                .getText();
        if (productInCartPrice.contains(productPrice)) {
            System.out.println("PRODUCT PRICE MATCHES");
        } else {
            Assert.fail("PRODUCT PRICE NOT MATCHES");
        }

        System.out.println("ADD TO CART SUCCESSFULLY");
    }
}
