import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.junit.jupiter.api.Test;

public class NegaTestLogin {

    public static void main(String[] args) {
        {
            System.setProperty("webdriver.edge.driver", "C:\\drivers\\msedgedriver.exe");

            WebDriver driver = new EdgeDriver();

            driver.get("https://www.saucedemo.com/");

            driver.findElement(By.name("user-name")).sendKeys("пизденка");

            driver.findElement(By.name("password")).sendKeys("secret_sauce");

            driver.findElement(By.id("login-button")).click();

            String errorText = driver
                    .findElement(By.cssSelector("[data-test='error']"))
                    .getText();

            if (errorText.contains("Epic sadface")) {
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