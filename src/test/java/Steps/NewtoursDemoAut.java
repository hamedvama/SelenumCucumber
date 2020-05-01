package Steps;

import Base.BaseUtil;
import Pages.LoginPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

public class NewtoursDemoAut {
    private BaseUtil base;
    private WebDriver driver;
    String baseUrl, nodeUrl;
    Actions action;

    public NewtoursDemoAut (BaseUtil base) {
        this.base = base;
    }

    @Given("^Configuration Node with her IP address (.*)$")
    public void configurationNodeWithHerIPAddressNode(String NodeAddress) throws MalformedURLException {
        System.out.println(" La valeur de l'adresse du noeud est  : " + NodeAddress);
        this.nodeUrl = NodeAddress;
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        this.driver = new RemoteWebDriver(new URL(this.nodeUrl), firefoxOptions);
        System.out.println("L'info dans la base est : " + this.base.steepInfo);
    }

    @And("^give link of site (.*)$")
    public void giveLinkOfSiteSiteUrl(String SiteUrl) {
        System.out.println(" La valeur de l'url du site est  : " + SiteUrl);
        this.baseUrl = SiteUrl;
        this.driver.manage().window().maximize();
        this.driver.get(this.baseUrl);
    }

    @When("^Authentication with (.*) and (.*)$")
    public void authenticationWithUserNameAndPassWord(String userName, String password) throws InterruptedException {
        System.out.println("Les info du webDriver : " + this.driver);
        LoginPage loginPage = new LoginPage(this.driver);
        loginPage.Login(userName,password);
        loginPage.ClickLogin();

        WebDriverWait wait = new WebDriverWait(driver, 15);
        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[14]/td/input")));
            this.driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[14]/td/input")).click();
        }catch (Exception e){
            System.err.println(e);
        }
    }

    @Then("^Connection Okay$")
    public void connectionOkay() {
        //this.driver.findElement(By.id("")).isEnabled();
        //this.driver.quit();
    }
}
