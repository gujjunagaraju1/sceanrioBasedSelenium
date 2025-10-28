import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Intalization {
    public  WebDriver driver;
    public WebDriver launch(){
        return driver = new ChromeDriver();
    }
}

