package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {

    private final WebDriver driver;

    @FindBy(xpath = "//button[@class='btn btn_primary btn_small btn_inventory'][1]")
    private WebElement addFirstProductButton;

    @FindBy(className = "shopping_cart_link")
    private WebElement openCartButton;

    public ProductsPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Добавление первого товара в корзину")
    public ProductsPage clickAddToCartButton() {
        addFirstProductButton.click();
        return this;
    }

    @Step("Нажание кнопки открытия корзины")
    public CartPage openCart() {
        openCartButton.click();
        return new CartPage(driver);
    }
}
