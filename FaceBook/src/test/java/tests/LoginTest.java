package tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

public class LoginTest {
    private WebDriver driver;
    private LoginPage loginPage;
    @BeforeClass
    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/test/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
        Thread.sleep(5000);//accept cookies manual
        loginPage = new LoginPage(driver);
    }
    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        return CustomDataProvider.loadTestData1("src/test/resources/LoginData.csv");
    }

    @Test(dataProvider = "loginData")
    public void testLogin(String email, String password) {
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickLogin();

    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}