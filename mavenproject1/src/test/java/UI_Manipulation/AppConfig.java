/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI_Manipulation;

import java.io.File;

/**
 *
 * @author NB22494
 */
public class AppConfig {
    public String FSL_URL = "http://10.255.33.4/fsl-login/";
    public String Login_ValidUserName="fslsit";
    public String Login_Validpassword="123456789";
    
    
    
     //Change this var, to use another browser
    public String DriverToUse = "Firefox";
    
    public String pathtoChrome = new File("src/test/java/SeleniumDrivers/chromedriver.exe").getAbsolutePath();
    
    
    
}
