import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class DriverManager {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public static WebDriver getDriver() {
        return driver.get();
    }
    @BeforeMethod
    public static void setUp() {
        driver.set(new FirefoxDriver());
    }
    @AfterMethod
    public static void tearDown() {
        getDriver().quit();
        driver.remove();
    }
}
