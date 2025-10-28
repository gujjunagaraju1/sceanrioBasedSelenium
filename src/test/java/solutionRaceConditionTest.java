import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class solutionRaceConditionTest extends DriverManager {



    @Test
    public void RaceCondition(){
        getDriver().get("https://www.google.com");
        getDriver().findElement(By.cssSelector("textarea[name=\"q\"]")).sendKeys("cricbuzz", Keys.ENTER);
    }
    @Test
    public void race2(){
        getDriver().get("https://www.cricbuzz.com/");
        getDriver().findElement(By.linkText("Live Scores")).click();
    }
}
