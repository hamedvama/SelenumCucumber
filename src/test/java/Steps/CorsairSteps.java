package Steps;

import Base.BaseUtil;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static org.testng.Assert.assertTrue;

public class CorsairSteps {
    private BaseUtil base;
    FirefoxOptions firefoxOptions;

    public CorsairSteps(BaseUtil base) {
        this.base = base;
    }

    @Given("^Set execution IP node (.*)$")
    public void setExecutionNode(String NodeAddress) {
        this.base.nodeIPAddress = NodeAddress;
        System.out.println("L'adresse du noeud est  : " + this.base.nodeIPAddress);
    }

    @And("^Set url site (.*)$")
    public void setUrlSite(String UrlSite) {
        this.base.siteUrl = UrlSite;
        System.out.println("Le lien du site est  : " + this.base.siteUrl);
    }

    @When("^Configure environment$")
    public void configureEnvironment() throws MalformedURLException, InterruptedException {
        this.firefoxOptions = new FirefoxOptions();
        this.base.webDriver = new RemoteWebDriver(new URL(this.base.nodeIPAddress), this.firefoxOptions);
        this.base.webDriver.manage().window().maximize();
        this.base.webDriver.get(this.base.siteUrl);
        Thread.sleep(2000);
    }

    @Then("^navigation available a ce lien (.*)$")
    public void navigationAvailable(String siteUrl) {
        assertTrue(siteUrl.equals(this.base.webDriver.getCurrentUrl()));
        System.out.println("Etape 1 Ok : " + this.base.webDriver.getCurrentUrl());
    }


    @Given("^send elements (.*) and (.*)$")
    public void sendElementsUserNameAndPassWord(String userName, String passWord) throws InterruptedException {
        this.base.webDriver.findElement(By.id("ccl-label")).click();
        Thread.sleep(2000);
        this.base.webDriver.findElement(By.id("ccl-email")).sendKeys(userName);
        this.base.webDriver.findElement(By.id("password")).sendKeys(passWord);
        Thread.sleep(5000);
    }

    @When("^Try to authenticate$")
    public void tryToAuthenticate() throws InterruptedException {
        this.base.webDriver.findElement(By.className("btn btn-submit btn-popin-login")).submit();
        Thread.sleep(5000);
    }

    @Then("^User login successful$")
    public void userLoginSuccessful() {
        this.base.webDriver.findElement(By.xpath("//*[@id=\"moncompte-section\"]/p/a")).click();
        assertTrue(this.base.webDriver.findElement(By.partialLinkText("Se déconnecter")).isDisplayed());
    }
}
