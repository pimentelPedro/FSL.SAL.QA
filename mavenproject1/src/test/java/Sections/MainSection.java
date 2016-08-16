/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sections;

import UI_Manipulation.SeleniumUtils;
import org.openqa.selenium.WebDriver;
import UI_Manipulation.AppConfig;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
/**
 *
 * @author Pedro Pimentel <pedro.pimentel@celfocus.com>
 * @author Luis Guilherme Castelo <luis.santos.castelo@celfocus.com>
 */
public abstract class MainSection {
    
  AppConfig appConfig = new AppConfig();
    WebDriver driver;
    SeleniumUtils utils;     

    public MainSection() {
        
        switch(appConfig.DriverToUse) {
            case "Firefox":
                this.driver = new FirefoxDriver();
                break;
            case "Chrome":
                System.setProperty("webdriver.chrome.driver", appConfig.pathtoChrome);
                this.driver = new ChromeDriver();
                break;
            default:
                this.driver = new FirefoxDriver();
                break;
        }

        driver.manage().deleteAllCookies();
        
        driver.get(appConfig.FSL_URL);
        
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        
        driver.manage().window().maximize();
        
        
        this.utils = new SeleniumUtils(driver);
    }
           
}
