import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ParallelTests {
    private static WebDriver driver;

    @Test
    public void testGoogle1() throws InterruptedException {
        initializeAndRunGoogle();
    }



    @Test
    public void testBing1() throws InterruptedException {
        initializeAndRunBing();
    }



    private void initializeAndRunGoogle() throws InterruptedException {
        if (driver == null) {
            System.out.println("Thread " + Thread.currentThread().getId() + " creating driver for Google");
            Thread.sleep(10);
            driver = new ChromeDriver();
        }

        try {
            driver.get("https://www.google.com");
            Thread.sleep(2000);
            driver.findElement(By.name("q")).sendKeys("SDET");
            System.out.println("Google Test executed by Thread: " + Thread.currentThread().getId());
        } catch (Exception e) {
            System.err.println("Race condition error in Google test, Thread " +
                    Thread.currentThread().getId() + ": " + e.getMessage());
        }
    }

    private void initializeAndRunBing() throws InterruptedException {
        if (driver == null) {
            System.out.println("Thread " + Thread.currentThread().getId() + " creating driver for Bing");
            Thread.sleep(10);
            driver = new ChromeDriver();
        }

        try {
            Thread.sleep(2000);
            driver.get("https://www.bing.com");
            driver.findElement(By.name("q")).sendKeys("Automation");
            System.out.println("Bing Test executed by Thread: " + Thread.currentThread().getId());
        } catch (Exception e) {
            System.err.println("Race condition error in Bing test, Thread " +
                    Thread.currentThread().getId() + ": " + e.getMessage());
        }
    }
}