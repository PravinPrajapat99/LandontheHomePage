package stepdefinations;

import driver.DriverClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import service.LoginService;

public class LoginSteps {
    LoginService service=new LoginService();
    static WebDriver driver = DriverClass.getDriver("chrome");

    @Given("user is on login page")
    public void user_is_on_login_page() {
        service.getloginPage(driver);
    }

    @When("user enter {string} and {string}")
    public void user_enter_and(String arg0, String arg1) throws InterruptedException {
        service.enterUsernamePassword(arg0,arg1,driver);
    }
    @And("click on login button")
    public void click_on_login_button() {
        service.clickLogin(driver);
    }

    @Then("check if it is navigated to home page")
    public void check_if_it_is_navigated_to_home_page() {
        service.checkIfNavigated(driver);
    }

    public static WebDriver  getCurrentDriver(){
        return driver;
    }

}
