package Pages.Login;

import UI_Manipulation.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


/**
 *
 * @author NB22494
 */
public class Login extends SeleniumUtils {
    
    public final String Login_ErrorMessagesId = "displayfield-1028";

    public Login(WebDriver _driver) {
        super(_driver);
    }

    public String InvalidLogin(String username, String password, String role) throws InterruptedException {
        String errorMessage;
             
        driver.findElement(By.name("username")).sendKeys(username);

        driver.findElement(By.name("password")).sendKeys(password);

        this.WaitForElementToBeClickableBySelector(By.xpath(Login_LoginButtonXpath));
        
        //click login button
        driver.findElement(By.xpath(Login_LoginButtonXpath)).click();
        
        
        this.WaitForElementToBeClickableBySelector(By.id(Login_ErrorMessagesId));
        
        errorMessage = driver.findElement(By.id(Login_ErrorMessagesId)).getText();
        
        return errorMessage;
    }

}
