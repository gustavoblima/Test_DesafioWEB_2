import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class groceryTest {

    WebDriver driver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","C:/Users/gustavo.santos/Documents/JUnit/chromedriver.exe");
        driver  = new ChromeDriver();
        driver.get("https://www.grocerycrud.com/v1.x/demo/bootstrap_theme");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void testChallengeOne(){
        WebElement element = driver.findElement(By.id("switch-version-select"));
        Select combo = new Select(element);
        combo.selectByVisibleText("Bootstrap V4 Theme");
        driver.findElement(By.xpath("//*[@id=\"gcrud-search-form\"]/div[1]/div[1]/a")).click();
        driver.findElement(By.id("field-customerName")).sendKeys("Teste Sicredi");
        driver.findElement(By.id("field-contactLastName")).sendKeys("Teste");
        driver.findElement(By.id("field-contactFirstName")).sendKeys("Gustavo BLima");
        driver.findElement(By.id("field-phone")).sendKeys("51 9999-9999");
        driver.findElement(By.id("field-addressLine1")).sendKeys("Av Assis Brasil, 3970");
        driver.findElement(By.id("field-addressLine2")).sendKeys("Torre D");
        driver.findElement(By.id("field-city")).sendKeys("Porto Alegre");
        driver.findElement(By.id("field-state")).sendKeys("RS");
        driver.findElement(By.id("field-postalCode")).sendKeys("R91000-000");
        driver.findElement(By.id("field-country")).sendKeys("Brasil");
        driver.findElement(By.id("field_salesRepEmployeeNumber_chosen")).click();
        driver.findElement(
                By.xpath("//*[@id=\"field_salesRepEmployeeNumber_chosen\"]/div/div/input")).sendKeys("Fixter", Keys.ENTER);
        driver.findElement(By.id("field-creditLimit")).sendKeys("200");

        driver.findElement(By.id("form-button-save")).click();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath(".//*[text() = 'Your data has been successfully stored into the database. ']")));
        Assert.assertTrue(driver.findElement(
                By.xpath(".//*[text() = 'Your data has been successfully stored into the database. ']")).isDisplayed());
        driver.quit();

    }

    @Test
    public void testChallengeTwo() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement element = driver.findElement(By.id("switch-version-select"));
        Select combo = new Select(element);
        combo.selectByVisibleText("Bootstrap V4 Theme");
        driver.findElement(By.xpath("//*[@id=\"gcrud-search-form\"]/div[1]/div[1]/a")).click();
        driver.findElement(By.id("field-customerName")).sendKeys("Teste Sicredi");
        driver.findElement(By.id("field-contactLastName")).sendKeys("Teste");
        driver.findElement(By.id("field-contactFirstName")).sendKeys("Gustavo BLima");
        driver.findElement(By.id("field-phone")).sendKeys("51 9999-9999");
        driver.findElement(By.id("field-addressLine1")).sendKeys("Av Assis Brasil, 3970");
        driver.findElement(By.id("field-addressLine2")).sendKeys("Torre D");
        driver.findElement(By.id("field-city")).sendKeys("Porto Alegre");
        driver.findElement(By.id("field-state")).sendKeys("RS");
        driver.findElement(By.id("field-postalCode")).sendKeys("R91000-000");
        driver.findElement(By.id("field-country")).sendKeys("Brasil");
        driver.findElement(By.id("field_salesRepEmployeeNumber_chosen")).click();
        driver.findElement(
                By.xpath("//*[@id=\"field_salesRepEmployeeNumber_chosen\"]/div/div/input")).sendKeys("Fixter", Keys.ENTER);
        driver.findElement(By.id("field-creditLimit")).sendKeys("200");
        driver.findElement(By.id("form-button-save")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath(".//*[text() = 'Your data has been successfully stored into the database. ']")));

        driver.findElement(By.xpath(".//*[text() = 'Go back to list']")).click();

        driver.findElement(By.name("customerName")).sendKeys("Teste Sicredi");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"gcrud-search-form\"]/div[2]/table/thead/tr[2]/td[1]/div/input")).click();
        driver.findElement(By.xpath("//*[@id=\"gcrud-search-form\"]/div[2]/table/thead/tr[2]/td[2]/div[1]/a")).click();

        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait2.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("/html/body/div[2]/div[2]/div[3]/div/div/div[2]/p[1]")));
        Assert.assertTrue(driver.findElement(
                By.xpath("/html/body/div[2]/div[2]/div[3]/div/div/div[2]/p[1]")).isDisplayed());

        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/div/div[3]/button[2]")).click();

        WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(6));
        wait3.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath(".//*[text() = 'Your data has been successfully deleted from the database.']")));
        Assert.assertTrue(driver.findElement(
                By.xpath(".//*[text() = 'Your data has been successfully deleted from the database.']")).isDisplayed());

    }

    @After
    public void tearDown(){driver.quit();}


}
