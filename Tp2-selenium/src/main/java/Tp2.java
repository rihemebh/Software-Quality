import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Tp2 {
    public static WebDriver driver = null;
    private static JavascriptExecutor javaScriptExecutor;
    void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        javaScriptExecutor = (JavascriptExecutor) driver;
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
        Thread.sleep(5000);
        //fill out address input
        WebElement addressInput = driver.findElement(By.cssSelector("input[name='address1']"));
//
        addressInput.sendKeys("manouba");
//
//        //fill out postcode input
        WebElement postcodeInput = driver.findElement(By.cssSelector("input[name='postcode']"));
        postcodeInput.sendKeys("2010");
//
//        //fill out city input
        WebElement cityInput = driver.findElement(By.cssSelector("input[name='city']"));
       cityInput.sendKeys("manouba");
//
//        //fill out phone input
      WebElement phoneInput = driver.findElement(By.cssSelector("input[name='phone']"));
      phoneInput.sendKeys("45686935");
//
//        //click on confirm button
       WebElement confirmButton = driver.findElement(By.cssSelector("button[name='confirm-addresses']"));
        confirmButton.click();
        driver.findElement(By.id("payment-option-1")).click();
        driver.findElement(By.id("conditions_to_approve[terms-and-conditions]")).click();

//        //click on confirm button
        confirmButton = driver.findElement(By.cssSelector("button[name='confirmDeliveryOption']"));
       confirmButton.click();
//
//        File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//        File dest = new File("./src/test/img/scrrenshot.png");
//        FileUtils.copyFile(screenshotFile, dest);
//
//        //click on the user icon
//        WebElement userIcon = driver.findElement(By.className("user-info"));
//
//
//        javaScriptExecutor.executeScript("arguments[0].click()", userIcon);

    }

    public static void main(String args[]) throws Exception {
        Tp2 tp2 = new Tp2();
        tp2.setup();
        driver.get("https://www.tunisianet.com.tn/");
        tp2.login("rihemebnhassan@gmail.com", "riheme123");
        tp2.search("MacBook M1 13.3");
        tp2.order();
        tp2.checkout();

    }
}


