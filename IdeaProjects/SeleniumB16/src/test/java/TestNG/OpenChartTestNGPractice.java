package TestNG;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;

import java.util.Collections;
import java.util.List;

public class OpenChartTestNGPractice {

    @Test
    public void successfulLogin() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.opencart.com/admin/");

        WebElement username = driver.findElement(By.cssSelector("#input-username"));
        username.sendKeys("demo");

        WebElement password = driver.findElement(By.cssSelector("#input-password"));
        password.sendKeys("demo");
Thread.sleep(2000);
        WebElement butt = driver.findElement(By.tagName("button"));
        butt.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));

        WebElement close = driver.findElement(By.xpath("//button[@class = 'btn-close']"));
        close.click();


        Assert.assertEquals(driver.getTitle(),("Dashboard"));



    }

    @Test
    public void negativeLoginTest() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.opencart.com/admin/");

        WebElement username = driver.findElement(By.cssSelector("#input-username"));
        username.sendKeys("demo");

        WebElement password = driver.findElement(By.cssSelector("#input-password"));
        password.sendKeys("DEMO");
        Thread.sleep(2000);
        WebElement butt = driver.findElement(By.tagName("button"));
        butt.click();
        Thread.sleep(2000);

        WebElement miss = driver.findElement(By.cssSelector("#alert"));
        String actual =  miss.getText().trim();
        String expected = "No match for Username and/or Password.";
        Assert.assertEquals(actual,expected);


    }

    @Test
    public void validateProductButton() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.opencart.com/admin/");

        WebElement username = driver.findElement(By.cssSelector("#input-username"));
        username.sendKeys("demo");

        WebElement password = driver.findElement(By.cssSelector("#input-password"));
        password.sendKeys("demo");

        WebElement butt = driver.findElement(By.tagName("button"));
        butt.click();
        Thread.sleep(2000);

        WebElement close = driver.findElement(By.xpath("//button[@class = 'btn-close']"));
        close.click();

        WebElement catalog = driver.findElement(By.cssSelector("#menu-catalog"));
        catalog.click();
        Thread.sleep(2000);

        WebElement product = driver.findElement(By.linkText("Products"));


        Assert.assertTrue(product.isDisplayed());
        Assert.assertTrue(product.isEnabled());

    }
    @Test
    public void validateBoxProduct() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.opencart.com/admin/");

        WebElement username = driver.findElement(By.cssSelector("#input-username"));
        username.sendKeys("demo");

        WebElement password = driver.findElement(By.cssSelector("#input-password"));
        password.sendKeys("demo");
        Thread.sleep(2000);
        WebElement butt = driver.findElement(By.tagName("button"));
        butt.click();
        Thread.sleep(2000);

        WebElement close = driver.findElement(By.xpath("//button[@class = 'btn-close']"));
        close.click();

        WebElement catalog = driver.findElement(By.cssSelector("#menu-catalog"));
        catalog.click();
        Thread.sleep(2000);

        WebElement product = driver.findElement(By.linkText("Products"));

        product.click();

        List<WebElement> check = driver.findElements(By.xpath("//input[@type='checkbox']"));

        for(int i = 1; i< check.size() ; i++){
Thread.sleep(1000);
           Assert.assertTrue(check.get(i).isDisplayed());
            Assert.assertTrue(check.get(i).isEnabled());
            Assert.assertFalse(check.get(i).isSelected());
            check.get(i).click();
            Assert.assertTrue(check.get(i).isSelected());

            check.get(i).sendKeys(Keys.ARROW_DOWN);


        }


    }
    @Test
    public void validateProduct() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.opencart.com/admin/");

        WebElement username = driver.findElement(By.cssSelector("#input-username"));
        username.sendKeys("demo");

        WebElement password = driver.findElement(By.cssSelector("#input-password"));
        password.sendKeys("demo");
        Thread.sleep(2000);
        WebElement butt = driver.findElement(By.tagName("button"));
        butt.click();
        Thread.sleep(2000);

        WebElement close = driver.findElement(By.xpath("//button[@class = 'btn-close']"));
        close.click();

        WebElement catalog = driver.findElement(By.cssSelector("#menu-catalog"));
        catalog.click();
        Thread.sleep(2000);

        WebElement product = driver.findElement(By.linkText("Products"));

        product.click();
        WebElement productname = driver.findElement(By.linkText("Product Name"));

        productname.click();
        Thread.sleep(2000);

       // List<WebElement> list = driver.findElements(By.xpath("//td[@class='text-start']"));



        List<WebElement> list =driver.findElements(By.xpath("//td[@class='text-start']"));
        
        ArrayList<String> actualData = new ArrayList<>();
        ArrayList<String> expectedData = new ArrayList<>();
        for(int i = 1; i< list.size() ; i++){


            actualData.add(list.get(i).getText().toLowerCase().trim());

            expectedData.add(list.get(i).getText().toLowerCase().trim());

        }
        System.out.println(actualData);
        System.out.println(expectedData);

        Collections.sort(expectedData);
        Collections.reverse(expectedData);

        Assert.assertEquals(actualData,expectedData);

        /*
TEST CASE:

1-You will click the productName button
2-You should create 2 arraylist
  *-One of them will be actualData
  *-Another will be expectedData
3-For(int i=1)
  *store all the names for both of the list.Please use at the end .toUpperCase or toLowerCase
4-For expected List -->you will use Collections.sort(expectedList)
                    -->Collections.reverse(expected)
                    Assert.equals(actualList,expectedlist)
 */


}

    @Test
    public void ASCvalidateProduct() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.opencart.com/admin/");

        WebElement username = driver.findElement(By.cssSelector("#input-username"));
        username.sendKeys("demo");

        WebElement password = driver.findElement(By.cssSelector("#input-password"));
        password.sendKeys("demo");

        WebElement butt = driver.findElement(By.tagName("button"));
        butt.click();
        Thread.sleep(2000);

        WebElement close = driver.findElement(By.xpath("//button[@class = 'btn-close']"));
        close.click();

        WebElement catalog = driver.findElement(By.cssSelector("#menu-catalog"));
        catalog.click();
        Thread.sleep(2000);

        WebElement product = driver.findElement(By.linkText("Products"));

        product.click();
        WebElement productname = driver.findElement(By.linkText("Product Name"));

        productname.click();
        Thread.sleep(2000);

        // List<WebElement> list = driver.findElements(By.xpath("//td[@class='text-start']"));



        List<WebElement> list =driver.findElements(By.xpath("//td[@class='text-start']"));

        ArrayList<String> actualData = new ArrayList<>();
        ArrayList<String> expectedData = new ArrayList<>();
        for(int i = 1; i< list.size() ; i++){


            actualData.add(list.get(i).getText().toLowerCase().trim());

            expectedData.add(list.get(i).getText().toLowerCase().trim());

        }
        System.out.println(actualData);
        System.out.println(expectedData);

        Collections.sort(expectedData);


        Assert.assertEquals(actualData,expectedData);


    }}
