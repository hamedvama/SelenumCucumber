package Steps;

import Base.BaseUtil;
import Pages.LoginPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class NewtoursDemoAut {
    private BaseUtil base;
    Actions action;

    public NewtoursDemoAut(BaseUtil base) {
        this.base = base;
    }

    @Given("^Configuration Node with her IP address (.*)$")
    public void configurationNodeWithHerIPAddressNode(String NodeAddress) throws MalformedURLException {
        this.base.nodeIPAddress = NodeAddress;
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        this.base.webDriver = new RemoteWebDriver(new URL(this.base.nodeIPAddress), firefoxOptions);
    }

    @And("^Give link of site (.*)$")
    public void giveLinkOfSiteSiteUrl(String SiteUrl) {
        System.out.println(" La valeur de l'url du site est  : " + SiteUrl);
        this.base.siteUrl = SiteUrl;
        this.base.webDriver.manage().window().maximize();
        this.base.webDriver.get(this.base.siteUrl);
    }

    @When("^Authentication with (.*) and (.*)$")
    public void authenticationWithUserNameAndPassWord(String userName, String password) throws InterruptedException {
        LoginPage loginPage = new LoginPage(this.base.webDriver);
        loginPage.Login(userName, password);
        loginPage.ClickLogin();
    }

    @Then("^Connexion Successful$")
    public void connexionSuccessful() {
        WebDriverWait wait = new WebDriverWait(this.base.webDriver, 300);
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("passCount")));
        } catch (Exception ex) {
            System.err.println(ex);
        }
    }

    @And("^Find flights on the site$")
    public void findFlightsOnTheSite() throws InterruptedException {
        WebElement elt = this.base.webDriver.findElement(By.name("passCount"));
        Actions builder = new Actions(this.base.webDriver);
        Action seriesOfActions = builder.moveToElement(elt).click().sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).build();
        seriesOfActions.perform();
        Thread.sleep(2000);

        elt = this.base.webDriver.findElement(By.name("fromPort"));
        builder = new Actions(this.base.webDriver);
        seriesOfActions = builder.moveToElement(elt).click().sendKeys(Keys.DOWN).sendKeys(Keys.DOWN)
                .sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).build();
        seriesOfActions.perform();
        Thread.sleep(2000);

        elt = this.base.webDriver.findElement(By.name("toPort"));
        builder = new Actions(this.base.webDriver);
        seriesOfActions = builder.moveToElement(elt).click().sendKeys(Keys.DOWN).sendKeys(Keys.DOWN)
                .sendKeys(Keys.ENTER).build();
        seriesOfActions.perform();
        Thread.sleep(2000);

        elt = this.base.webDriver.findElement(By.name("toMonth"));
        builder = new Actions(this.base.webDriver);
        seriesOfActions = builder.moveToElement(elt).click().sendKeys(Keys.DOWN).sendKeys(Keys.DOWN)
                .sendKeys(Keys.ENTER).build();
        seriesOfActions.perform();
        Thread.sleep(2000);

        this.base.webDriver.findElement(By.name("servClass")).click();
        Thread.sleep(4000);
        this.base.webDriver.findElement(By.name("findFlights")).click();
    }

    @And("^Selected the flight and validate$")
    public void selectedTheFlightAndValidate() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(this.base.webDriver, 300);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("outFlight")));

        List<WebElement> webElements = this.base.webDriver.findElements(By.name("outFlight"));
        for (WebElement webElement : webElements) {
            String theValue = webElement.getAttribute("value");
            if (theValue.contains("Blue Skies Airlines$361$"))
                webElement.click();
        }
        Thread.sleep(2000);
        webElements = this.base.webDriver.findElements(By.name("inFlight"));
        for (WebElement webElement : webElements) {
            String theValue = webElement.getAttribute("value");
            if (theValue.contains("Blue Skies Airlines$361$"))
                webElement.click();
        }
        Thread.sleep(2000);
        this.base.webDriver.findElement(By.name("reserveFlights")).click();
    }

    @And("^Book the flight and validate$")
    public void bookTheFlightAndValidate() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(this.base.webDriver, 100);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("passFirst0")));
        this.base.webDriver.findElement(By.name("passFirst0")).click();
        this.base.webDriver.findElement(By.name("passFirst0")).sendKeys("Hamed");
        this.base.webDriver.findElement(By.name("passLast0")).click();
        this.base.webDriver.findElement(By.name("passLast0")).sendKeys("DIAKITE");
        WebElement webElt = this.base.webDriver.findElement(By.name("creditCard"));
        Actions builder = new Actions(this.base.webDriver);
        Action seriesOfActions = builder.moveToElement(webElt).click().sendKeys(Keys.DOWN).sendKeys(Keys.DOWN)
                .sendKeys(Keys.ENTER).build();
        seriesOfActions.perform();
        Thread.sleep(2000);
        this.base.webDriver.findElement(By.name("creditnumber")).click();
        this.base.webDriver.findElement(By.name("creditnumber")).sendKeys("5135180000000001");
        this.base.webDriver.findElement(By.name("cc_frst_name")).click();
        this.base.webDriver.findElement(By.name("cc_frst_name")).sendKeys("Hamed");
        this.base.webDriver.findElement(By.name("cc_last_name")).click();
        this.base.webDriver.findElement(By.name("cc_last_name")).sendKeys("Diakite");

        this.base.webDriver.findElement(By.name("buyFlights")).click();
        Thread.sleep(2000);
    }

    @Then("^Get flight confirmation$")
    public void getFlightConfirmation() {
        assertTrue (this.base.webDriver.findElement(By.linkText("Your itinerary has been booked!")).isDisplayed());
    }
}
