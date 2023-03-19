package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OverviewOrderPage {

    private final WebDriver driver;

    @FindBy(id="finish")
    private WebElement finishButton;

    public OverviewOrderPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Нажатие кнопки оформления заказа")
    public OrderCompletePage clickFinishButton() {
        finishButton.click();
        return new OrderCompletePage(driver);
    }
}
