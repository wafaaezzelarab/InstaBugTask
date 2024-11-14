package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class LoginPage
{
    private WebDriver driver;
    private By emailField = By.id("email");
    private By passwordField = By.id("pass");
    private By loginButton = By.name("login");
    private By errorMessage = By.xpath("//div[contains(text(), 'incorrect')]");
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }
    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }
    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

}
