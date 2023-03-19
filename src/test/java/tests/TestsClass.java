package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.OrderCompletePage;
import pages.ProductsPage;

public class TestsClass {

    @Test
    public void testOne() {
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://www.saucedemo.com/");
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        String orderData = "test";

        loginPage.inputLogin("standard_user")
                .inputPassword("secret_sauce")
                .clickLoginButton();
        productsPage.clickAddToCartButton()
                        .openCart()
                        .clickChekoutButton()
                        .inputFirstName(orderData)
                        .inputLastName(orderData)
                        .inputZipCode(orderData)
                        .clickContinueButton()
                        .clickFinishButton();

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/checkout-complete.html");
        Assert.assertEquals(new OrderCompletePage(driver).getHeaderText(),"Thank you for your order!");
        driver.quit();
    }

    @Test
    public void testTwo() {
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://www.saucedemo.com/");
        LoginPage loginPage = new LoginPage(driver);
        String loginData = "test";

        loginPage.inputLogin(loginData)
                .inputPassword(loginData)
                .clickLoginButton();

        Assert.assertEquals(loginPage.getAlertMessageText(),"Epic sadface: Username and password do not match any " +
                "user in this service");
        driver.quit();
    }
}
