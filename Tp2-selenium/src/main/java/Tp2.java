import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Tp2 {
    public static WebDriver driver = null;

    void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }
    private void login(String email, String password) {
        try {
            Thread.sleep(2000);
            driver.findElement(By.cssSelector(".user-info")).click();
            driver.findElement(By.cssSelector("a[title='Identifiez-vous']")).click();
            Thread.sleep(5000);
            driver.findElement(By.name("email")).sendKeys(email);
            driver.findElement(By.name("password")).sendKeys(password);
            driver.findElement(By.id("submit-login")).click();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void search(String key) throws InterruptedException {
        // find the input of search, write "MacBook M1 13.3" and click the search button
        driver.findElement(By.cssSelector(".search_query")).sendKeys(key);
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".button-search")).click();
    }


    public void order()throws InterruptedException  {
        driver.findElement(By.cssSelector(".product-title a")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".add-to-cart")).click();
        driver.findElement(By.linkText("Commander")).click();
    }
    public void checkout() throws InterruptedException, IOException {

        driver.findElement(By.cssSelector("a.btn-primary")).click();

        //fill out address input
        driver.findElement(By.cssSelector("input[name='address1']")).sendKeys("manouba");

        //fill out postcode input
        driver.findElement(By.cssSelector("input[name='postcode']")).sendKeys("2010");

       //fill out city input
        driver.findElement(By.cssSelector("input[name='city']")).sendKeys("manouba");
       //fill out phone input
       driver.findElement(By.cssSelector("input[name='phone']")).sendKeys("45686935");
       //click on confirm button
        driver.findElement(By.cssSelector("button[name='confirm-addresses']")).click();
        driver.findElement(By.cssSelector("button[name='confirmDeliveryOption']")).click();
        driver.findElement(By.id("payment-option-1")).click();
        driver.findElement(By.id("conditions_to_approve[terms-and-conditions]")).click();
    }

    public static void main(String args[]) throws Exception {
        Tp2 tp2 = new Tp2();
        tp2.setup();
        driver.get("https://www.tunisianet.com.tn/");
        tp2.login("rihemebnhassan@gmail.com", "riheme123");
        tp2.search("MacBook M1 13.3");
        tp2.order();
        tp2.checkout();
        driver.quit();

    }
}


