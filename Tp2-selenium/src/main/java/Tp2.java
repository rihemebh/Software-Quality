import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Tp2 {
    public static WebDriver driver = null;
    public void checkout(){
        driver.findElement(By.id("cart")).click();
    }

public void order(){
    driver.findElement(By.cssSelector(".product-title a")).click();
    driver.findElement(By.cssSelector(".add-to-cart")).click();
    driver.findElement(By.linkText("Commander")).click();
}
    public void search(String key) throws InterruptedException {

        driver.findElement(By.cssSelector(".search_query")).sendKeys(key);
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".button-search")).click();
    }

    private void login(String email, String password) {
        try {

            Thread.sleep(2000);
            WebElement userInfo = driver.findElement(By.cssSelector(".user-info"));
            userInfo.click();

            WebElement link = driver.findElement(By.cssSelector("a[title='Identifiez-vous']"));
            link.click();

            Thread.sleep(5000);
            WebElement inputEmail = driver.findElement(By.name("email"));
            inputEmail.sendKeys(email);

            WebElement inputPassword = driver.findElement(By.name("password"));
            inputPassword.sendKeys(password);

            WebElement submit = driver.findElement(By.id("submit-login"));
            submit.click();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public static void main(String args[]) throws Exception {
        Tp2 tp2 = new Tp2();
        tp2.setup();
        driver.get("https://www.tunisianet.com.tn/");
        tp2.login("rihemebnhassan@gmail.com", "riheme123");
        tp2.search("MacBook M1 13.3");
        tp2.order();

    }
}


