package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class RegistrationPage {
    private WebDriver driver;
    private By firstNameField = By.name("firstname");
    private By lastNameField = By.name("lastname");
    private By emailField = By.name("reg_email__");
    private By passwordField = By.name("reg_passwd__");
    private By submitButton = By.name("websubmit");
    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }
    public void enterFirstName(String firstName) {
        driver.findElement(firstNameField).sendKeys(firstName);
    }
    public void enterLastName(String lastName) {
        driver.findElement(lastNameField).sendKeys(lastName);
    }
    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }
    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }
    public void clickSubmit() {
        driver.findElement(submitButton).click();
    }
}
