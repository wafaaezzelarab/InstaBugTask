package tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.RegistrationPage;

public class Registration {
    private WebDriver driver;
    private RegistrationPage registrationPage;
    @BeforeClass
    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/test/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/r.php");
        Thread.sleep(5000);// accept cookies manual
        registrationPage = new RegistrationPage(driver);
    }

    @DataProvider(name = "register")
    public Object[][] register() {
        return CustomDataProvider.loadTestData("src/test/resources/TestData.csv");
    }
    @Test(dataProvider = "register")
    public void testRegistration(String firstName, String lastName, String email, String password) {
        registrationPage.enterFirstName(firstName);
        registrationPage.enterLastName(lastName);
        registrationPage.enterEmail(email);
        registrationPage.enterPassword(password);
        registrationPage.clickSubmit();
        // Add assertions to verify registration success or error messages
    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}