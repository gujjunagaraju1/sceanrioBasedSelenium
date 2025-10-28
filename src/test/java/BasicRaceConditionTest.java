import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class BasicRaceConditionTest {
    private static WebDriver driver;

    @Test(threadPoolSize = 3, invocationCount = 6)
    public void testDriverRaceCondition() {
        String threadName = Thread.currentThread().getName();

        // Race condition: multiple threads checking and creating driver
        if (driver == null) {
            System.out.println("Thread " + threadName + " found driver null, creating...");

            // Add small delay to increase race condition probability
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            // Multiple threads might create driver simultaneously
            driver = new ChromeDriver();
            System.out.println("Thread " + threadName + " created driver: " + driver.hashCode());
        } else {
            System.out.println("Thread " + threadName + " found existing driver: " + driver.hashCode());
        }

        // All threads trying to use the same driver instance
        try {
            driver.get("https://www.google.com");
            System.out.println("Thread " + threadName + " successfully navigated");
        } catch (Exception e) {
            System.err.println("Thread " + threadName + " failed: " + e.getMessage());
        }
    }

    @AfterClass
    public void cleanup() {
        if (driver != null) {
            try {
                driver.quit();
                System.out.println("Driver closed");
            } catch (Exception e) {
                System.err.println("Error closing driver: " + e.getMessage());
            }
        }
    }
}
