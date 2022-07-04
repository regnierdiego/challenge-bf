package pageObjects;

import org.openqa.selenium.By;

public class DemoBlazePage {
    public static By getGetSingupButton() {
        return By.xpath(".//a[@id='signin2']");
    }

    public static By getUsernameRegister() {
        return By.xpath(".//input[@id='sign-username']");
    }

    public static By getPasswordRegister() {
        return By.xpath(".//input[@id='sign-password']");
    }

    public static By getSubmitRegister() {
        return By.xpath(".//button[@onclick='register()']");
    }

    public static By getLoginButton() {
        return By.xpath(".//a[@id='login2']");
    }

    public static By getUsernameLogin() {
        return By.xpath(".//input[@id='loginusername']");
    }

    public static By getPassword() {
        return By.xpath(".//input[@id='loginpassword']");
    }

    public static By getSubmitLogin() {
        return By.xpath(".//button[@onclick='logIn()']");
    }

    public static By getNameOfUser() {
        return By.xpath(".//a[@id='nameofuser']");
    }

    public static By getLogoutButton() {
        return By.xpath(".//a[@id='logout2']");
    }

    public static By getProducts() {
        return By.xpath(".//a[@class='hrefch']");
    }

    public static By getCategories() {
        return By.xpath(".//a[@id='itemc']");
    }

    public static By getAddToCart() {
        return By.xpath(".//a[contains(@onclick,'addToCart')]");
    }

    public static By getCartMenu() {
        return By.xpath(".//a[@id='cartur']");
    }

    public static By getProductName() {
        return By.xpath(".//h2[@class='name']");
    }

    public static By getProductPrice() {
        return By.xpath(".//h3[@class='price-container']");
    }

    public static By getProductAddedName() {
        return By.xpath(".//tr[@class='success']//td[2]");
    }

    public static By getProductAddedPrice() {
        return By.xpath(".//tr[@class='success']//td[3]");
    }

    //STRINGS
    public static String password = ".Test123";
}
