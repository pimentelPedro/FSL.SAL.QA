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
    
    public String Login_ErrorMessagesId = "displayfield-1028";

    public Login(WebDriver _driver) {
        super(_driver);
    }

    public String InvalidLogin(String username, String password, String role) throws InterruptedException, Exception {
        
        String errorMessage;
        
        switch(appConfig.DriverToUse){
            case "Firefox":
                Login_LoginButton       = "//a[contains(@id,'button') and contains(@class,'x-btn-login')]";
                roleDropdownListId      = "combo-1026-trigger-picker";
                roleDropdownListUlsId   = "boundlist-1032-listEl";
                Login_ErrorMessagesId   = "//div[contains(@class,'gw-message-error')]";
                break;
            case "Chrome":
                Login_LoginButton       = "//a[contains(@id,'button') and contains(@class,'x-btn-login')]";
                roleDropdownListId      = "combo-1018-trigger-picker";
                roleDropdownListUlsId   = "boundlist-1024-listEl";
                Login_ErrorMessagesId   = "//div[contains(@class,'gw-message-error')]";
                break;
        }

             
        driver.findElement(By.name("username")).clear();
        driver.findElement(By.name("username")).sendKeys(username);
        

        
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys(password);
      
        this.MoveToElementThatIsNotInSight(driver.findElement(By.xpath(Login_LoginButton)), false);
        //this.WaitForElementToBeClickableBySelector(By.id(Login_LoginButton));
       
        if(driver.findElement(By.xpath(Login_LoginButton)).getAttribute("class").contains("x-item-disabled x-btn-disabled")){
            return "Button disabled";
        }        
        //click login button
   
        this.ClickElementBy(By.xpath(Login_LoginButton));
        
        this.WaitForElementToBeClickableBySelector(By.xpath(Login_ErrorMessagesId));
        
        errorMessage = driver.findElement(By.xpath(Login_ErrorMessagesId)).getText();
        
        return errorMessage;
    }

}
