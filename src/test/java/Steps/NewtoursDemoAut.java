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
    Actions action;

    public NewtoursDemoAut (BaseUtil base) {
        this.base = base;
    }

    @Given("^Configuration Node with her IP address (.*)$")
    public void configurationNodeWithHerIPAddressNode(String NodeAddress) throws MalformedURLException {
        System.out.println(" La valeur de l'adresse du noeud est  : " + NodeAddress);
        this.base.nodeIPAddress = NodeAddress;
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        this.base.webDriver = new RemoteWebDriver(new URL(this.base.nodeIPAddress), firefoxOptions);
        //System.out.println("L'info dans la base est : " + this.base.steepInfo);
    }

    @And("^give link of site (.*)$")
    public void giveLinkOfSiteSiteUrl(String SiteUrl) {
        System.out.println(" La valeur de l'url du site est  : " + SiteUrl);
        this.base.siteUrl = SiteUrl;
        this.base.webDriver.manage().window().maximize();
        this.base.webDriver.get(this.base.siteUrl);
    }

    @When("^Authentication with (.*) and (.*)$")
    public void authenticationWithUserNameAndPassWord(String userName, String password) throws InterruptedException {
        LoginPage loginPage = new LoginPage(this.base.webDriver);
        loginPage.Login(userName,password);
        loginPage.ClickLogin();

        WebDriverWait wait = new WebDriverWait(this.base.webDriver, 15);
        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[14]/td/input")));
            this.base.webDriver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[14]/td/input")).click();
        }catch (Exception ex){
            System.err.println(ex);
        }
    }

    @Then("^Connection close$")
    public void connectionClose() {
        //this.base.webDriver.quit();
    }

}
