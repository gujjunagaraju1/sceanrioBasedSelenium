import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RaceImplementationTest {
 private static WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver = new FirefoxDriver();



    }
    @Test
    public void race1(){
        driver.get("https://www.google.com/");
        driver.findElement(By.cssSelector("textarea[name=\"q\"]")).sendKeys("cricbuzz", Keys.ENTER);

    }
    @Test
    public void race2(){
        driver.get("https://www.cricbuzz.com/");
        driver.findElement(By.linkText("Live Scores")).click();
    }

}
