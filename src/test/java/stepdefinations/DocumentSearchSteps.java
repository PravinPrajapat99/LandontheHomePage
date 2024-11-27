package stepdefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import service.DocumentSearchService;

public class DocumentSearchSteps {
    DocumentSearchService service=new DocumentSearchService();
    WebDriver driver =LoginSteps.getCurrentDriver();

    @Given("user is in home page")
    public void user_is_in_home_page() {
        service.chkUserIsOnHome(driver);
    }

    @Then("verify the user")
    public void verify_the_user() {
        service.verifyUser(driver);
    }

    @Then("navigate to library section")
    public void navigate_to_library_section() {
        service.navigateToLibrary(driver);
    }

    @Then("get the search bar")
    public WebElement get_the_search_bar() {
        return service.getSearchBar(driver);
    }

    @When("user enter document {string}")
    public void user_enter_document_pages(String docName) {
        service.enterDocument(get_the_search_bar(),driver,docName);
    }

    @When("click search button")
    public void click_search_button() {
        service.click(driver);
    }

    @Then("check if it present")
    public void check_if_it_present() {
       service.checkIfDocumentAvailable(driver);
    }

}
