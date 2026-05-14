import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class NegaTestLogin {

    WebDriver driver;

    @BeforeEach
    void setUp() {
        System.setProperty("webdriver.edge.driver", "C:\\drivers\\msedgedriver.exe");
        driver = new EdgeDriver();
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    void loginNegativeTest() {
        driver.findElement(By.name("user-name")).sendKeys("wrong_user");
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        String errorText = driver
                .findElement(By.cssSelector("[data-test='error']"))
                .getText();

        assertTrue(errorText.contains("Epic sadface"));
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}