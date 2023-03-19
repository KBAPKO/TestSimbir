package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    private final WebDriver driver;

    @FindBy (id="checkout")
    private WebElement checkoutButton;

    public CartPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Нажатие кнопки проверки заказа")
    public OrderInfoPage clickChekoutButton() {
        checkoutButton.click();
        return new OrderInfoPage(driver);
    }

}
