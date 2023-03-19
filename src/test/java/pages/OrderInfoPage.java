package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderInfoPage {

    private final WebDriver driver;

    @FindBy(id = "first-name")
    private WebElement firstNameField;

    @FindBy(id = "last-name")
    private WebElement lastNameField;

    @FindBy(id = "postal-code")
    private WebElement zipCodeField;

    @FindBy(id="continue")
    private WebElement continueButton;

    public OrderInfoPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Вставка имени")
    public OrderInfoPage inputFirstName(String firstName) {
        firstNameField.sendKeys(firstName);
        return this;
    }

    @Step("Вставка фамилии")
    public OrderInfoPage inputLastName(String lastName) {
        lastNameField.sendKeys(lastName);
        return this;
    }

    @Step("Вставка зип кода")
    public OrderInfoPage inputZipCode(String zipCode) {
        zipCodeField.sendKeys(zipCode);
        return this;
    }

    @Step("Нажатие кнопки проверки заказа")
    public OverviewOrderPage clickContinueButton() {
        continueButton.click();
        return new OverviewOrderPage(driver);
    }
}
