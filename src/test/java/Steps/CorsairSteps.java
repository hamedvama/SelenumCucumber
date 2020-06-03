package Steps;

import Base.BaseUtil;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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

    @Then("Navigation available$")
    public void navigationAvailable() {
        assertTrue(this.base.siteUrl.equals(this.base.webDriver.getCurrentUrl()));
    }

    @And("^Authentication on Corsair site with UserName (.*) and PassWord (.*)$")
    public void authenticationOnCorsairSiteWithUserNameUserAndPassWordPassword(String userName, String passWord)
            throws InterruptedException {
        this.base.webDriver.findElement(By.xpath("//*[@id=\"registerLink\"]")).click();
        Thread.sleep(1000);
        this.base.webDriver.findElement(By.xpath("//*[@id=\"login-identifiant\"]")).sendKeys(userName);
        this.base.webDriver.findElement(By.xpath("//*[@id=\"login-password\"]")).sendKeys(passWord);
        Thread.sleep(3000);
        this.base.webDriver.findElement(By.xpath("//*[@id=\"login-form\"]/div/div[1]/div[3]/button")).submit();
        Thread.sleep(5000);
    }

    @Then("^Authentication successful$")
    public void authenticationSuccessful() {
        this.base.webDriver.findElement(By.xpath("//*[@id=\"moncompte-section\"]/p/a")).click();
        assertTrue(this.base.webDriver.findElement(By.partialLinkText("Se déconnecter")).isDisplayed());
    }



    @When("^Choose destination$")
    public void chooseDestination() throws InterruptedException {
        this.base.webDriver.findElement(By.xpath("//*[@id=\"from-city\"]/div/button/span[1]")).click();
        this.base.webDriver.findElement(By.xpath("//*[@id=\"from-city\"]/div/button/span[1]")).sendKeys("Paris");
        this.base.webDriver.findElement(By.xpath("//*[@id=\"from-city\"]/div/button/span[1]")).sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        this.base.webDriver.findElement(By.xpath("//*[@id=\"to-city\"]/div/button/span[1]")).click();
        this.base.webDriver.findElement(By.xpath("//*[@id=\"to-city\"]/div/button/span[1]")).sendKeys("Miami");
        this.base.webDriver.findElement(By.xpath("//*[@id=\"to-city\"]/div/button/span[1]")).sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        this.base.webDriver.findElement(By.xpath("//*[@id=\"SearchForm\"]/div[1]/div/div[3]/div/div[2]/span[1]/span/span")).click();
        this.base.webDriver.findElement(By.xpath("//*[@id=\"jq-calendar_cnt\"]/div/div[2]/table[2]/tbody/tr[1]/td[3]/div/div")).click();
        this.base.webDriver.findElement(By.xpath("//*[@id=\"jq-calendar_cnt\"]/div/div[2]/table[2]/tbody/tr[5]/td[5]/div/div")).click();

    }
}
