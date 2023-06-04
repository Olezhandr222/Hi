package SelectBasics;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DreamCar {

    @Test
    public void HeadersOfTheCar() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://cars.com");

        WebElement newOrUsed = driver.findElement(By.xpath("//select[@name = 'stock_type']"));
        BrowserUtils.selectBy(newOrUsed, "New", "text");

        WebElement Mark = driver.findElement(By.cssSelector("#makes"));
        BrowserUtils.selectBy(Mark, "Lexus", "text");
        Thread.sleep(2000);
        WebElement model = driver.findElement(By.cssSelector("#models"));
        BrowserUtils.selectBy(model, "lexus-rx_350", "value");

        WebElement price = driver.findElement(By.cssSelector("#make-model-max-price"));
        Select priceSelect = new Select(price);
        String actualData = BrowserUtils.getText(priceSelect.getFirstSelectedOption());
        String expectedData = "No max price";
        Assert.assertEquals(actualData,expectedData);

        WebElement distance = driver.findElement(By.cssSelector("#make-model-maximum-distance"));
        BrowserUtils.selectBy(distance, "40", "value");

        WebElement ZipCode = driver.findElement(By.cssSelector("#make-model-zip"));
        ZipCode.clear();
        ZipCode.sendKeys("60056");
Thread.sleep(2000);
        WebElement search = driver.findElement(By.xpath("//button[@data-linkname = 'search-new-make']"));

        search.click();

        WebElement headerLexus = driver.findElement(By.xpath("//h1[@class='sds-heading--1 sds-page-section__title']"));
        String actualDataHeaderLexus = BrowserUtils.getText(headerLexus);
        String expectedDataHeaderLexus = "New Lexus RX 350 for sale";
        Assert.assertEquals(actualDataHeaderLexus,expectedDataHeaderLexus);
        Thread.sleep(2000);

        WebElement sortBy = driver.findElement(By.cssSelector("#sort-dropdown"));
        BrowserUtils.selectBy(sortBy, "list_price", "value");

        List<WebElement> Lexus350List = driver.findElements(By.xpath("//h2[@class='title']"));
        Thread.sleep(2000);
        for(int i = 1; i<Lexus350List.size();i++){

            Assert.assertTrue(BrowserUtils.getText(Lexus350List.get(i)).contains("Lexus RX 350"));

        }






  /*
NOTE: Please use browser utils for the select classes if it is needed or getText.
1-Navigate to the website
2-Choose the "New" from the New/used option
3-Choose "Lexus" for Make part
4-Choose "RX-350"
5-Validate the Price is selected "No max price"-->getFirstSelectedOption
6-Choose the distance 40 mil
7-Put your Zip code-->Before that Clear it.60056 element.clear()
8-Click Search Button
9-Validate the header "New Lexus RX 350 for sale"
10-Click Sort by and choose the Lowest Price
11-Validate the all titles has Lexus RX 350
     */
    }
    @Test
    public void AccendHeadersOfTheCar() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://cars.com");

        WebElement newOrUsed = driver.findElement(By.xpath("//select[@name = 'stock_type']"));
        BrowserUtils.selectBy(newOrUsed, "New", "text");

        WebElement Mark = driver.findElement(By.cssSelector("#makes"));
        BrowserUtils.selectBy(Mark, "Lexus", "text");
        Thread.sleep(2000);
        WebElement model = driver.findElement(By.cssSelector("#models"));
        BrowserUtils.selectBy(model, "lexus-rx_350", "value");

        WebElement price = driver.findElement(By.cssSelector("#make-model-max-price"));
        Select priceSelect = new Select(price);
        String actualData = BrowserUtils.getText(priceSelect.getFirstSelectedOption());
        String expectedData = "No max price";
        Assert.assertEquals(actualData,expectedData);

        WebElement distance = driver.findElement(By.cssSelector("#make-model-maximum-distance"));
        BrowserUtils.selectBy(distance, "40", "value");

        WebElement ZipCode = driver.findElement(By.cssSelector("#make-model-zip"));
        ZipCode.clear();
        ZipCode.sendKeys("60056");
        Thread.sleep(2000);
        WebElement search = driver.findElement(By.xpath("//button[@data-linkname = 'search-new-make']"));

        search.click();

        WebElement headerLexus = driver.findElement(By.xpath("//h1[@class='sds-heading--1 sds-page-section__title']"));
        String actualDataHeaderLexus = BrowserUtils.getText(headerLexus);
        String expectedDataHeaderLexus = "New Lexus RX 350 for sale";
        Assert.assertEquals(actualDataHeaderLexus,expectedDataHeaderLexus);
        Thread.sleep(2000);

        WebElement sortBy = driver.findElement(By.cssSelector("#sort-dropdown"));
        BrowserUtils.selectBy(sortBy, "list_price", "value");
        Thread.sleep(5000);
        List<WebElement> Lexus350List = driver.findElements(By.xpath("//span[@class='primary-price']"));
        Thread.sleep(2000);
        ArrayList<Integer>actualPrice = new ArrayList<>();
        ArrayList<Integer>expectedPrice = new ArrayList<>();
        for(int i = 1; i<Lexus350List.size();i++){

           actualPrice.add(Integer.parseInt(BrowserUtils.getText(Lexus350List.get(i)).replace("$","").replace(",","")));
            expectedPrice.add(Integer.parseInt(BrowserUtils.getText(Lexus350List.get(i)).replace("$","").replace(",","")));
        }


       Collections.sort(expectedPrice);
       Assert.assertEquals(actualPrice, expectedPrice);
        System.out.println(actualPrice);
        System.out.println(expectedPrice);

}}
