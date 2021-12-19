import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class JunitMVC {
    /**
     * Connectez-vous sur l’url https://todomvc.com/
     * Cliquez sur le lien Backbone.js
     * Ajouter plusieurs actions exemples ( Meet a Friend , Buy Meat , clean the car … )
     * Cochez une ou plusieurs actions
     * Exploitez la méthode ExpectedConditions.textToBePresentInElement afin de comparer le champ x item(s) left par le résultat attendu
     * <p>
     * <p>
     * Exploitez l’annotation @ParameterizedTest afin d’effectuer des tests avec plusieurs technologies dans le site
     * https://todomvc.com/
     * Ajoutez les dependencies appropriés afin d’afficher les rapports Junit
     */

    private static WebDriver driver;
    private static JavascriptExecutor javaScriptExecutor;
    private static WebDriverWait driverWait;

    @BeforeAll
    public static void setup() {
        // setup the driver
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        javaScriptExecutor = (JavascriptExecutor) driver;
        driverWait = new WebDriverWait(driver, 3);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        System.out.println("executing : before all ");
    }

    @BeforeEach
    public void func() {

        System.out.println("executing : before each");
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "Backbone.js",
            "React",
            "AngularJS",
            "Polymer",
            "Dojo"
    })

    @BeforeEach
    public void getUrl() {
        driver.get("https://www.todomvc.com");
    }
    public  void testTodoMVC(String technology){
        // visit the website
        WebElement backboneJSLink = driver.findElement(By.linkText(technology));
        driverWait.until(ExpectedConditions.visibilityOf(backboneJSLink));
        backboneJSLink.click();

        WebElement todoInput = driver.findElement(By.className("new-todo"));
        driverWait.until(ExpectedConditions.visibilityOf(todoInput));
        todoInput.sendKeys("Meet a Friend");
        todoInput.sendKeys(Keys.ENTER);

        todoInput.sendKeys("Buy Meat");
        todoInput.sendKeys(Keys.ENTER);

        todoInput.sendKeys("Clean the car");
        todoInput.sendKeys(Keys.ENTER);

        WebElement todoCount = driver.findElement(By.cssSelector(".todo-count > strong"));
        driverWait.until(ExpectedConditions.textToBePresentInElement(todoCount, "3"));

        List<WebElement> toggleCheckbox = driver.findElements(By.className("toggle"));
        toggleCheckbox.get(0).click();
        toggleCheckbox.get(2).click();

        todoCount = driver.findElement(By.cssSelector(".todo-count > strong"));
        driverWait.until(ExpectedConditions.textToBePresentInElement(todoCount, "1"));
    }


    @AfterEach
    public void cleanup() {
        driver.quit();
        System.out.println("executing : after each");
    }



}
