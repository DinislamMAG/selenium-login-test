import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginTest {

    WebDriver driver;

    @BeforeEach
    void setUp() {
        System.setProperty("webdriver.edge.driver", "C:\\drivers\\msedgedriver.exe");
        driver = new EdgeDriver();
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    void loginSuccessTest() {
        driver.findElement(By.name("user-name")).sendKeys("standard_user");
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        assertEquals(
                "https://www.saucedemo.com/inventory.html",
                driver.getCurrentUrl()
        );
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}