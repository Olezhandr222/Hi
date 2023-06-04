package Actions;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import javax.swing.*;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

public class Test2 {

    @Test
    public void Practice() throws InterruptedException {


        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote=allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demos.telerik.com/kendo-ui/fx/expand");

        List<WebElement> pictures = driver.findElements(By.xpath("//div[@class='product k-listview-item']//img"));
        List<WebElement> name = driver.findElements(By.xpath("//div[@class='product-description']//h3"));
        List<WebElement> price = driver.findElements(By.xpath("//div[@class='product-description']//p"));

        HashMap<String, String> lister = new HashMap<>();
        Actions actions = new Actions(driver);

        for(int i = 0 ; i<pictures.size(); i++){
            Thread.sleep(500);
            actions.moveToElement(pictures.get(i)).perform();

            lister.put(BrowserUtils.getText(name.get(i)),BrowserUtils.getText(price.get(i)));


        }
        System.out.println(lister.entrySet());



    }


}