package GetWindowHandle;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class SwitchWindow {

    @Test
    public void switchPractice(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote=allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/windows");

        WebElement click1 = driver.findElement(By.xpath("//a[.='Click Here']"));
        click1.click();
        String mainPageId = driver.getWindowHandle(); //main pageId --> The internet
        //CA26CFB23F749E7A741EEF11BC7E4A40
        Set<String> allPagedID = driver.getWindowHandles();
        //[CA26CFB23F749E7A741EEF11BC7E4A40, B999A02E074F5BF2EE11501D964C2B02]
        for(String id : allPagedID){
            if( !id.equals(mainPageId)){

                driver.switchTo().window(id);
                break;

            }
            System.out.printf(driver.getWindowHandle());
        }

        System.out.println(allPagedID);




    }
}
