import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;


public class LoginTest {
    public static void main(String[] args) {
        {
            System.setProperty("webdriver.edge.driver", "C:\\drivers\\msedgedriver.exe");

            WebDriver driver = new EdgeDriver();

            driver.get("https://www.saucedemo.com/");

            driver.findElement(By.name("user-name")).sendKeys("standard_user");

            driver.findElement(By.name("password")).sendKeys("secret_sauce");

            driver.findElement(By.id("login-button")).click();

            System.out.println("Логин выполнен!");

            if (driver.getCurrentUrl().equals("https://www.saucedemo.com/inventory.html")) {
                System.out.println("TEST PASSED");
            } else {
                System.out.println("TEST FAILED");
            }

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            driver.quit();
        }
    }
}