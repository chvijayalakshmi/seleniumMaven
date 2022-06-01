package First1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage {
    WebDriver driver = new ChromeDriver();
    By email= By.id("ap_email");
    By continueButton = By.xpath("//*[@id=\"continue\"]");
    By password = By.name("password");
    By signInButton = By.xpath("//*[@id=\"signInSubmit\"]");
 public LoginPage(WebDriver driver)
 {

     this.driver=driver;

 }
    public void typeEmailId()
    {

        driver.findElement(email).sendKeys("vijgod8@gmail.com");
    }

    public void continueButton() {

     driver.findElement(continueButton).click();
    }

    public void typePassword() {
driver.findElement(password).sendKeys("vij123!!");
    }

    public void signInButton() {
     driver.findElement(signInButton).click();
    }
   public void closeDriver(){
     driver.quit();
   }
}

