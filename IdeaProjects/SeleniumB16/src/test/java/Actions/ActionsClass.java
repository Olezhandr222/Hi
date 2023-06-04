package Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;

public class ActionsClass {

    @Test//right click
    public void contextClick(){

        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote=allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/context_menu");

        WebElement area = driver.findElement(By.xpath("//div[@class='example']//div[@id='hot-spot']"));
        Actions actions = new Actions(driver);
        actions.contextClick(area).perform();

    }

    @Test
    public void practiceContextClick(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote=allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.guru99.com/test/simple_context_menu.html");

        WebElement click = driver.findElement(By.xpath("//span[.='right click me']"));
        Actions actions = new Actions(driver);
        actions.contextClick(click).perform();
        WebElement doubleClick = driver.findElement(By.xpath("//button[.='Double-Click Me To See Alert']"));
        actions.doubleClick(doubleClick).perform();


    }}

