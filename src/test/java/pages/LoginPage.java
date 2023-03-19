package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private final WebDriver driver;

    @FindBy(id = "user-name")
    private WebElement loginInputField;

    @FindBy(css = "#password")
    private WebElement passwordInputField;

    @FindBy(xpath = "//input[@id='login-button']")
    private WebElement loginButton;

    @FindBy(xpath = "//h3[@data-test='error']")
    private WebElement alertMessage;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Вставка логина")
    public LoginPage inputLogin(String username) {
        loginInputField.sendKeys(username);
        return this;
    }

    @Step("Вставка пароля")
    public LoginPage inputPassword(String password) {
        passwordInputField.sendKeys(password);
        return this;
    }

    @Step("Нажатие кнопки логина")
    public void clickLoginButton() {
        loginButton.click();
    }

    public String getAlertMessageText() {
        return alertMessage.getText();
    }
}
