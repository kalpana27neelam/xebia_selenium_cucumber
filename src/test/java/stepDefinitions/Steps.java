package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.ProductsPage;

import java.util.concurrent.TimeUnit;

public class Steps {
    public WebDriver driver;
    public ProductsPage productsPage;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();


    }

    @Given("Open the browser")
    public void open_the_browser() {
        driver = new ChromeDriver();
        productsPage = new ProductsPage(driver);
    }

    @When("Open the website {string}")
    public void open_the_website(String url) {
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//*[@id='onetrust-accept-btn-handler']")).click();
    }

    @Then("click on products page via {string} link in home page")
    public void click_on_products_page_via_link_in_home_page(String linkmessage) {
        driver.findElement(By.linkText("Spend & Save")).click();

    }

    @Then("verify if the products page opened successfully or not")
    public void verify_if_the_products_page_opened_successfully_or_not() {
        productsPage.verifyProductsPageDisplayed();
    }

    @Then("verify if you are able to see the products in the web page")
    public void verify_if_you_are_able_to_see_the_products_in_the_web_page() {
        productsPage.verifyProductsDisplayed();
    }

    @Then("close the browser")
    public void close_the_browser() {
        driver.quit();
    }

    @Then("verify if you are able to see products {string} and  {string} in the products page")
    public void verify_if_you_are_able_to_see_products_and_in_the_products_page(String product1, String product2) {
        productsPage.verfiyNamesOfProductsDisplayed(product1, product2);

    }

    @Then("click on {string} button")
    public void click_on_button(String  buttonstring) {
        productsPage.clickOnProductPlanButton(buttonstring);
    }


    @Then("verify if the email signup textbox appears")
    public void verify_if_the_email_signup_textbox_appears() {

        productsPage.verifysignupinputfield();
    }
    @Then("verify that a modal with monthly and yearly plan appears")
    public void verify_that_a_modal_with_monthly_and_yearly_plan_appears() {
        productsPage.MonthlyYearlyPlanModelDisplay();
    }
    @Then("verify that {string} radio option is {string} paid once")
    public void verify_that_radio_option_is_paid_once(String plan, String value) {
        productsPage.verifyPlanAndCost(plan,value);

    }
    @After
    public void tearDown()
    {
        driver.quit();
    }
}
