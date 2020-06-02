package Steps;

import Base.BaseUtil;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

import static org.testng.Assert.assertTrue;

public class SncfSteps {
    private BaseUtil base;
    FirefoxOptions firefoxOptions;
    private Boolean process = false;

    public SncfSteps(BaseUtil base) {
        this.base = base;
    }

    @Given("^Setting Environment with IP node (.*) and Site Url (.*)$")
    public void settingEnvironmentWithIPNodeNodeAddressAndSiteUrlUrlSite(String NodeAddress, String UrlSite) throws MalformedURLException, InterruptedException {
        this.base.nodeIPAddress = NodeAddress;
        System.out.println("L'adresse du noeud est  : " + this.base.nodeIPAddress);
        this.base.siteUrl = UrlSite;
        System.out.println("Le lien du site est  : " + this.base.siteUrl);
        this.firefoxOptions = new FirefoxOptions();
        this.base.webDriver = new RemoteWebDriver(new URL(this.base.nodeIPAddress), this.firefoxOptions);
        this.base.webDriver.manage().window().maximize();
        this.base.webDriver.get(this.base.siteUrl);
        Thread.sleep(5000);
    }

    @And("^Authentication on SNCF site with UserName (.*) and PassWord (.*)$")
    public void authenticationOnSNCFSiteWithUserNameUserAndPassWordPassword(String userName, String passWord) throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(this.base.webDriver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ccl-label")));
        this.base.webDriver.findElement(By.id("ccl-label")).click();
        Thread.sleep(2000);
        this.base.webDriver.findElement(By.id("ccl-email")).sendKeys(userName);
        Thread.sleep(1000);
        this.base.webDriver.findElement(By.id("edit-connect")).click();

        WebDriverWait waitt = new WebDriverWait(this.base.webDriver, 15);
        waitt.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
        this.base.webDriver.findElement(By.id("password")).click();
        this.base.webDriver.findElement(By.id("password")).sendKeys(passWord);
        Thread.sleep(1000);
        this.base.webDriver.findElement(By.xpath("//*[@id=\"validate\"]")).submit();
        Thread.sleep(5000);
        process = true;

    }

    @Then("^User login successful$")
    public void userLoginSuccessful() {
        assertTrue(process);
    }
}
