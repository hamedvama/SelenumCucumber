package Steps;

import Base.BaseUtil;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static org.testng.Assert.assertTrue;

public class CdiscountSteps extends BaseUtil {

    private BaseUtil base;
    Actions action;
    boolean result = false;

    public CdiscountSteps(BaseUtil base) {
        this.base = base;
    }

    @Given("^Configuration Cdiscount Node with her IP address (.*)$")
    public void configurationCdiscountNodeWithHerIPAddressNodeAddress(String NodeAddress) throws MalformedURLException {
        System.out.println(" La valeur de l'adresse du noeud est  : " + NodeAddress);
        this.base.nodeIPAddress = NodeAddress;
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        this.base.webDriver = new RemoteWebDriver(new URL(this.base.nodeIPAddress), firefoxOptions);
    }

    @And("^Give Cdiscount link of site (.*)$")
    public void GiveCdiscountLinkOfSiteSiteUrl(String SiteUrl) throws InterruptedException {
        System.out.println(" La valeur de l'url du site est  : " + SiteUrl);
        this.base.siteUrl = SiteUrl;
        this.base.webDriver.manage().window().maximize();
        this.base.webDriver.get(this.base.siteUrl);
        Thread.sleep(1000);
    }

    @When("^Authentication on Cdiscount site with (.*) and (.*)$")
    public void authenticationOnCdiscountSiteWithUserNameAndPassWord(String UserName, String PassWord) throws InterruptedException {
        System.out.println(" La valeur du User est  : " + UserName);
        System.out.println(" La valeur du PassWord est  : " + PassWord);
        this.action = new Actions(this.base.webDriver);
        WebElement webElement = this.base.webDriver.findElement(By.xpath("//*[@id=\"hConnect\"]/a/div/span"));
        action.moveToElement(webElement).perform();
        Thread.sleep(3000);
        this.base.webDriver.findElement(By.xpath("//*[@id=\"hLayers\"]/div[4]/div[2]/div/ul/li[1]/a")).click();
        Thread.sleep(2000);
        this.base.webDriver.findElement(By.id("CustomerLogin_CustomerLoginFormData_Email")).sendKeys(UserName);
        this.base.webDriver.findElement(By.id("CustomerLogin_CustomerLoginFormData_Password")).sendKeys(PassWord);
        Thread.sleep(1000);
        this.base.webDriver.findElement(By.xpath("//*[@id=\"loginForm\"]/input[11]")).click();
        Thread.sleep(3000);
    }

    @And("^Go to the basket$")
    public void goToTheBasket() {
        try {
            this.base.webDriver.findElement(By.xpath("//*[@id=\"hFull\"]/div[2]/a/img")).click();
            Thread.sleep(5000);
            this.base.webDriver.findElement(By.xpath("//*[@id=\"pushBloc\"]/div[2]/div[3]")).click();
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            this.base.webDriver.findElement(By.xpath("/html/body/div[1]/header/div/div/div[2]/div/div[4]/div[3]/a")).click();
            Thread.sleep(2000);
        } catch (Exception Ex) {
            System.err.println("pas d'accès au panier");
        }

    }

    @And("^Valid the basket$")
    public void validTheBasket() throws InterruptedException {
        this.base.webDriver.findElement(By.linkText("Choisir ma livraison")).click();
        Thread.sleep(2000);
        this.base.webDriver.findElement(By.xpath("//*[@id=\"op_shippingForm\"]/input[6]")).click();
        Thread.sleep(2000);
    }

    @Then("^Process Done$")
    public void processDone() {
        assertTrue(false);
    }

    @Then("^Fail connection (.*)$")
    public void failConnection(String message) {
        String texte = "";
        try {
            texte = this.base.webDriver.findElement(By.xpath("//*[@id=\"errorIdent\"]/li/strong")).getText();
            System.out.println("Le messaage est : " + texte);
        } catch (WebDriverException ex) {
            System.out.println("L'exception est : " + ex.getMessage());
        }
        this.base.webDriver.quit();
        assertTrue(texte.equals(message));
    }
}
