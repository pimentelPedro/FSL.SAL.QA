/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import org.openqa.selenium.WebDriver;

/**
 *
 * @author NB22494
 */
public class LoginPage {

    VarsLogin vars = new VarsLogin();
    WebDriver _driver;
    
    public LoginPage(WebDriver driver) {
        this._driver=driver;
    }
    
    
    
   public void login(String username, String password){
       //vars.buttonLogin
   }

   
    
}
