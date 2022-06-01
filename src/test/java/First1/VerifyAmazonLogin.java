package First1;

import io.github.bonigarcia.wdm.WebDriverManager;
//import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

public class VerifyAmazonLogin {
    @Test
    public void verifylogin() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.com%2F%3Fref_%3Dnav_custrec_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=usflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&");
        LoginPage login = new LoginPage(driver);

        login.typeEmailId();
        login.continueButton();
        login.typePassword();
        login.signInButton();

    }
         @Test
    public void verifySearchFunction() {
             WebDriverManager.chromedriver().setup();

             WebDriver driver= new ChromeDriver();
             driver.manage().window().maximize();
             driver.get("https://www.amazon.com/");
             WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
             search.sendKeys("computer");
             WebElement enter = driver.findElement(By.id("nav-search-submit-button"));
             enter.click();
             driver.quit();
            }
            @Test
    public void verifyCurrencySettings() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com/");
                Actions actions = new Actions(driver);
                actions.moveToElement(driver.findElement(By.xpath("//*[@id=\"icp-nav-flyout\"]"))).perform();
         driver.get("https://www.amazon.com/customer-preferences/edit?ref=icp_cop_flyout_change?preferencesReturnUrl=%2F");
         driver.findElement(By.xpath("//*[@id=\"icp-currency-dropdown-selected-item-prompt\"]/span/span/span")).click();
         driver.findElement(By.xpath("//*[@id=\"icp-currency-dropdown_44\"]/span")).click();
         driver.findElement(By.xpath("//*[@id=\"icp-save-button\"]/span/input")).click();
         driver.quit();
       //Select countryCurrency = new Select( driver.findElement(By.className("a-button-text a-declarative")));
      // countryCurrency.selectByVisibleText("  ¥ - JPY - Japanese Yen");
       //actions.moveToElement(driver.findElement(By.className("a-button a-button-dropdown a-spacing-top-medium-plus"))).click().perform();
            }

            @Test
        public void rest_test() {
       /* baseURI = "https://www.amazon.com/gp";
        given().get("/goldbox?ref_=nav_cs_gb").then().statusCode(200);*/
                RestAssured.baseURI ="https://www.amazon.com/gp";
                RequestSpecification httpREquest = RestAssured.given();
                Response responce = httpREquest.request(Method.GET,"/goldbox?ref_=nav_cs_gb");
                responce.getBody().asString();
            }

            @Test
    public void navigateMethod() {
       WebDriverManager.chromedriver().setup();
       WebDriver driver = new ChromeDriver();
       driver.manage().window().maximize();
       driver.get("https://www.amazon.com/");
       driver.navigate().to("https://www.google.com/");
       driver.findElement(By.name("q"));

            }

}
