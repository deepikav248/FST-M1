package StepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GoogleSearchSteps {
    WebDriver driver;
    WebDriverWait wait;
    
    @Given("^User is on Google Home Page$")
    public void userIsOnGooglePage() throws Throwable {
        //Create a new instance of the chrome driver
        System.setProperty("webdriver.chrome.driver","C://Users//DeepikaRani//Downloads//chromedriver_win32//chromedriver.exe");
        driver = new ChromeDriver();
        //wait = new WebDriverWait(driver, 15);
                
        //Open the browser
        driver.get("https://www.google.com");
        Thread.sleep(5000);
    }
    
    @When("^User types in Cheese and hits ENTER$")
    public void User_types_in_Cheese_and_hits_ENTER() throws Throwable {
        driver.findElement(By.name("q")).sendKeys("Cheese", Keys.RETURN);
    }

    @Then("^Show how many search results were shown$")
    public void Show_how_many_search_results_were_shown() throws Throwable {
        //wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("result-stats")));
        String resultStats = driver.findElement(By.id("result-stats")).getText();
        System.out.println("Number of results found: " + resultStats);
    }

    @And("^Close the browser$")
    public void Close_the_browser() throws Throwable {
        driver.close();
    }
}
