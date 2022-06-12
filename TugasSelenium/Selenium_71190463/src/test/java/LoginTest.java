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

public class LoginTest {

    ChromeDriver chromeDriver;
    ChromeOptions options = new ChromeOptions();

    @Given("browser dibuka")
    public void browser_dibuka() {
        System.out.println("step browser_open");
        System.setProperty("webdriver.chrome.driver",
                Objects.requireNonNull(getClass().getClassLoader().getResource("webdriver/chromedriver.exe")).getFile());
        options.addArguments("--headless");
        chromeDriver = new ChromeDriver();
        chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        chromeDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
    }
    @Given("user berada di halaman login")
    public void user_berada_di_halaman_login() {
        System.out.println("user berada di login page");
        chromeDriver.navigate().to("https://demo.guru99.com/insurance/v1/register.php");
        chromeDriver.findElement(By.xpath("/html/body/div[3]/a")).click();
    }
    @When("^user memasukan (.*) dan (.*)$")
    public void user_memasukan_username_dan_password(String username,String password) {
        System.out.println("memasukan username dan password");
        chromeDriver.findElement(By.name("email")).sendKeys(username);
        chromeDriver.findElement(By.name("password")).sendKeys(password);
        Assertions.assertTrue(username.length() > 0 && password.matches("^[a-zA-Z0-9]*$") && password.length() >= 8 && password.length() <= 13, "Value InCorrect");
    }
    @When("tombol login ditekan")
    public void tombol_login_ditekan() {
        System.out.println("tombol login ditekan");
        chromeDriver.findElement(By.name("submit")).click();
    }
    @Then("user redirect ke halaman utama")
    public void user_redirect_ke_halaman_utama() {
//        System.out.println("user berada di halaman utaama");
//        List<WebElement> list1 = chromeDriver.findElements(By.xpath("/html/body/div[3]/form/input"));
//        Assertions.assertTrue(list1.size() > 0, "Text not Found");
    }
}
