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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

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
        this.base.nodeIPAddress = NodeAddress;
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        this.base.webDriver = new RemoteWebDriver(new URL(this.base.nodeIPAddress), firefoxOptions);
    }

    @And("^Give Cdiscount link of site (.*)$")
    public void GiveCdiscountLinkOfSiteSiteUrl(String SiteUrl) throws InterruptedException {
        this.base.siteUrl = SiteUrl;
        this.base.webDriver.manage().window().maximize();
        this.base.webDriver.get(this.base.siteUrl); Thread.sleep(1000);
    }

    @When("^Authentication on Cdiscount site with (.*) and (.*)$")
    public void authenticationOnCdiscountSiteWithUserNameAndPassWord(String UserName, String PassWord) throws InterruptedException {
        this.action = new Actions(this.base.webDriver);
        WebElement webElement = this.base.webDriver.findElement(By.xpath("//*[@id=\"hConnect\"]/a/div/span"));
        action.moveToElement(webElement).perform(); Thread.sleep(3000);
        this.base.webDriver.findElement(By.xpath("//*[@id=\"hLayers\"]/div[4]/div[2]/div/ul/li[1]/a")).click(); Thread.sleep(2000);
        this.base.webDriver.findElement(By.id("CustomerLogin_CustomerLoginFormData_Email")).sendKeys(UserName);
        this.base.webDriver.findElement(By.id("CustomerLogin_CustomerLoginFormData_Password")).sendKeys(PassWord); Thread.sleep(1000);
        this.base.webDriver.findElement(By.xpath("//*[@id=\"loginForm\"]/input[11]")).click(); Thread.sleep(3000);
    }

    @And("^Find and add product$")
    public void findAndAddProduct() throws InterruptedException {
        this.base.webDriver.findElement(By.xpath("//*[@id=\"hFull\"]/div[4]/div[1]/input")).click();
        this.base.webDriver.findElement(By.xpath("//*[@id=\"hFull\"]/div[4]/div[1]/input")).sendKeys("Iphone 11");
        this.base.webDriver.findElement(By.xpath("//*[@id=\"hFull\"]/div[4]/div[1]/input")).sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        List<WebElement> results = this.base.webDriver.findElements(By.className("btGreen btS jsValidForm"));
        prod:
        for (WebElement elt : results) {
            if (elt.getAttribute("value") == "Ajouter au panier") {
                elt.click();
                System.out.println("Cliquer");
                break prod;
            }
        }
    }

    @And("^Go to the basket$")
    public void goToTheBasket() {
        try {
            WebDriverWait wait = new WebDriverWait(this.base.webDriver, 100);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"hBskt\"]/a")));
            this.base.webDriver.findElement(By.xpath("//*[@id=\"hBskt\"]/a")).click(); Thread.sleep(5000);
        } catch (Exception e) {
            System.err.println("Pas d'acces au panier"); System.err.println("Error : " + e);
        }
    }

    @And("^Valid the basket$")
    public void validTheBasket() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(this.base.webDriver, 50);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"bBlocPrix\"]/div[1]/a")));
        this.base.webDriver.findElement(By.xpath("//*[@id=\"bBlocPrix\"]/div[1]/a")).click(); Thread.sleep(2000);
        List<WebElement> results = this.base.webDriver.findElements(By.className("sbt btGreen jsWaiting"));
        Basket: for (WebElement elt : results) {
            if (elt.getAttribute("value") == "Choisir") {
                elt.click();
                break Basket;
            }
        }
        Thread.sleep(3000);
        this.base.webDriver.findElement(By.className("headOpBackStep")).click();
        Thread.sleep(3000);
    }

    @Then("^Process Done$")
    public void processDone() {
        assertTrue(this.base.webDriver.findElement(By.className("headOpBackStep")).isDisplayed());
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
