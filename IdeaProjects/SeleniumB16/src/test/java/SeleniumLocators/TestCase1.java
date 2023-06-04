package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestCase1 {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/text-box");

        WebElement fullname = driver.findElement(By.xpath("//input[@id='userName']"));
        fullname.sendKeys("Oleh Trus");

        WebElement email = driver.findElement(By.xpath("//input[@id='userEmail']"));
        email.sendKeys("kekandos@gmail.com");

        WebElement CurAddress = driver.findElement(By.xpath("//textarea[@id='currentAddress']"));
CurAddress.sendKeys("2200 East Devon");

        WebElement PerAddress = driver.findElement(By.xpath("//textarea[@id='permanentAddress']"));
        PerAddress.sendKeys("2200 East Devon");


        WebElement submit = driver.findElement(By.xpath("//button[contains(text(),'Submit')]"));
        submit.click();



        WebElement info1 = driver.findElement(By.xpath("//p[@id='name']"));
        if(info1.isDisplayed() && info1.getText().contains(fullname.getText())){
            System.out.println("Passed");
        }
        else{
            System.out.println("Failed");
        }

        WebElement info2 = driver.findElement(By.xpath("//p[@id='email']"));
        if(info2.isDisplayed() && info2.getText().contains(email.getText())){
            System.out.println("Passed");
        }
        else{
            System.out.println("Failed");
        }

        WebElement info3 = driver.findElement(By.xpath("//p[@id='currentAddress']"));
        if(info3.isDisplayed() && info3.getText().contains(CurAddress.getText())){
            System.out.println("Passed");
        }
        else{
            System.out.println("Failed");
        }

        WebElement info4 = driver.findElement(By.xpath("//p[@id='permanentAddress']"));
        if(info4.isDisplayed() && info4.getText().contains(PerAddress.getText())){
            System.out.println("Passed");
        }
        else{
            System.out.println("Failed");
        }
    }
}
