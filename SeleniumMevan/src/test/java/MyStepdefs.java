import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyStepdefs
{
    private WebDriver driver;

    @Given( "I am in the login page of the Para Bank Application" )
    public void i_am_in_the_login_page_of_the_Para_Bank_Application()
    {
        System.setProperty( "webdriver.chrome.driver", "resources/chromedriver.exe" );
        driver = new ChromeDriver();
        driver.get( "https://the-internet.herokuapp.com/login" );
    }

    @When( "I enter valid credentials" )
    public void i_enter_valid_credentials()
    {
        driver.findElement( By.id( "username" ) ).sendKeys( "tomsmith" );
        driver.findElement( By.id( "password" ) ).sendKeys( "SuperSecretPassword!" );
        driver.findElement( By.xpath( "//i[@class='fa fa-2x fa-sign-in']" ) ).submit();
    }

    @Then( "I should be taken to the Overview page" )
    public void i_should_be_taken_to_the_Overview_page() throws Exception
    {
        WebDriverWait wait = new WebDriverWait( driver, 20 );
        wait.until( ExpectedConditions.elementToBeClickable( By.xpath( "//a[@class='button secondary radius']" ) ) );

        driver.findElement( By.id( "flash" ) ).isDisplayed();
        driver.findElement( By.xpath( "//a[@class='button secondary radius']" ) ).click();

        driver.quit();
    }
}
