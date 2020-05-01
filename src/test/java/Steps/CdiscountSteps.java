package Steps;

import Base.BaseUtil;
import Pages.LoginPage;
import Transformation.TransformerClasse;
import cucumber.api.Transform;
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


public class CdiscountSteps extends BaseUtil {

    private BaseUtil base;
    private WebDriver driver;
    String baseUrl, nodeUrl;
    Actions action;

    public CdiscountSteps(BaseUtil base) {
        this.base = base;
    }

    @Given("^Configuration Cdiscount Node with her IP address (.*)$")
    public void configurationCdiscountNodeWithHerIPAddressNodeAddress(String NodeAddress) throws MalformedURLException {
        System.out.println(" La valeur de l'adresse du noeud est  : " + NodeAddress);
        this.nodeUrl = NodeAddress;
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        this.driver = new RemoteWebDriver(new URL(this.nodeUrl), firefoxOptions);
    }

    @And("^give Cdiscount link of site (.*)$")
    public void giveCdiscountLinkOfSiteSiteUrl(String SiteUrl) throws InterruptedException {
        System.out.println(" La valeur de l'url du site est  : " + SiteUrl);
        this.baseUrl = SiteUrl;
        this.driver.manage().window().maximize();
        this.driver.get(this.baseUrl);
        Thread.sleep(1000);
    }

    @When("^Authentication on Cdiscount site with (.*) and (.*)$")
    public void authenticationOnCdiscountSiteWithUserNameAndPassWord(String UserName, String PassWord) throws InterruptedException {
        System.out.println(" La valeur du User est  : " +  UserName);
        System.out.println(" La valeur du PassWord est  : " + PassWord);
        this.action = new Actions(this.driver);
        WebElement webElement = this.driver.findElement(By.xpath("//*[@id=\"hConnect\"]/a/div/span"));
        action.moveToElement(webElement).perform();
        Thread.sleep(3000);
        this.driver.findElement(By.xpath("//*[@id=\"hLayers\"]/div[4]/div[2]/div/ul/li[1]/a")).click();
        Thread.sleep(2000);
        this.driver.findElement(By.id("CustomerLogin_CustomerLoginFormData_Email")).sendKeys(UserName);
        this.driver.findElement(By.id("CustomerLogin_CustomerLoginFormData_Password")).sendKeys(PassWord);
        Thread.sleep(1000);
        this.driver.findElement(By.xpath("//*[@id=\"loginForm\"]/input[11]")).click();
        Thread.sleep(3000);
        this.driver.findElement(By.xpath("//*[@id=\"hFull\"]/div[2]/a/img")).click();
        Thread.sleep(5000);
        try{
            this.driver.findElement(By.xpath("//*[@id=\"pushBloc\"]/div[2]/div[3]")).click();
        }catch (Exception e){
            System.out.println(e);
        }

        try{
            this.driver.findElement(By.xpath("//*[@id=\"paContent\"]/div[1]/div/div[1]/div[2]/div[2]/div/div/ul/li[1]/a/img")).click();
        }catch (Exception Ex){
            System.err.println("Produit non trouvé");
        }

    }


}
