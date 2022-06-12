import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;
import java.util.Objects;

public class RegisterTest {

    ChromeDriver chromeDriver;

    ChromeOptions options = new ChromeOptions();

    @Given("browser open")
    public void browser_open() {
        System.out.println("step browser_open");
        System.setProperty("webdriver.chrome.driver",
                Objects.requireNonNull(getClass().getClassLoader().getResource("webdriver/chromedriver.exe")).getFile());
        options.addArguments("--headless");
        chromeDriver = new ChromeDriver();
        chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        chromeDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
    }
    @Given("user berada di halaman register")
    public void user_berada_di_halaman_register() {
        System.out.println("user berada di register page");
        chromeDriver.navigate().to("https://demo.guru99.com/insurance/v1/register.php");
        List<WebElement> list1 = chromeDriver.findElements(By.xpath("//*[@id=\"resetform\"]"));
        Assertions.assertTrue(list1.size() > 0, "Text not Found");
        List<WebElement> list2 = chromeDriver.findElements(By.xpath("//*[@id=\"new_user\"]/div[5]/input[2]"));
        Assertions.assertTrue(list1.size() > 0, "Text not Found");
    }
    @When("^users register dengan (.*) dan (.*)$")
    public void users_register_dengan_email_dan_sandi(String email,String sandi) {
        System.out.println("memasukan email dan password");
        chromeDriver.findElement(By.name("email")).sendKeys(email);
        chromeDriver.findElement(By.name("password")).sendKeys(sandi);
        chromeDriver.findElement(By.name("c_password")).sendKeys(sandi);
        Assertions.assertTrue(email.length() > 0 && sandi.matches("^[a-zA-Z0-9]*$") && sandi.length() >= 8 && sandi.length() <= 13, "Value InCorrect");
    }
    @When("tombol create ditekan")
    public void tombol_create_ditekan() {
        System.out.println("tombol create ditekan");
        chromeDriver.findElement(By.xpath("//*[@id=\"new_user\"]/div[5]/input[2]")).click();
    }
    @Then("user redirect ke halaman login")
    public void user_redirect_ke_halaman_login() {
        System.out.println("user berada di halaman login");
        List<WebElement> list1 = chromeDriver.findElements(By.xpath("//*[@id=\"login-form\"]/div[3]/input"));
        Assertions.assertTrue(list1.size() > 0, "Text not Found");
    }
}