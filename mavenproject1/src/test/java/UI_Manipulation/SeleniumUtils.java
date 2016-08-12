/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI_Manipulation;

import Pages.HomePage.HomePage;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
 *
 * @author Pedro Pimentel <pedro.pimentel@celfocus.com>
 * @author Luis Guilherme Castelo <luis.santos.castelo@celfocus.com>
 */
public class SeleniumUtils {
    
    // final private String Login_LoginButton = "button-1030-btnInnerEl";
    // final private String Login_LoginButton = "button-1022-btnInnerEl";
    
    private String Login_LoginButton;
    private String roleDropdownListId;
    private String roleDropdownListUlsId;
    
    final private AppConfig appConfig = new AppConfig();
    public final WebDriver driver;

    public SeleniumUtils(WebDriver _driver) {
        this.driver = _driver;
    }

    public boolean goToFSLPortal(String username, String password, String role) throws InterruptedException {
        switch(appConfig.DriverToUse){
            case "Firefox":
                Login_LoginButton       = "button-1030-btnInnerEl";
                roleDropdownListId      = "combo-1026-trigger-picker";
                roleDropdownListUlsId   = "boundlist-1032-listEl";
                break;
            case "Chrome":
                Login_LoginButton       = "button-1022-btnInnerEl";
                roleDropdownListId      = "combo-1018-trigger-picker";
                roleDropdownListUlsId   = "boundlist-1024-listEl";
                break;
        }
        
        driver.findElement(By.name("username")).sendKeys(username);

        driver.findElement(By.name("password")).sendKeys(password);

        // this.WaitForElementToBeClickableBySelector(By.id(Login_LoginButton));
        
        this.waitForAjax();
        
        //click login button
        driver.findElement(By.id(Login_LoginButton)).click();
        
        this.waitForAjax();
        Thread.sleep(2000);
        
        //click on dropdown button to switch role
        // driver.findElement(By.id("combo-1026-trigger-picker")).click();
        // driver.findElement(By.id("combo-1018-trigger-picker")).click();
        driver.findElement(By.id(roleDropdownListId)).click();

        //switch role
        if (setRoleForLogin(role)) {
            //click login button
            driver.findElement(By.id(Login_LoginButton)).click();
            
            //
            HomePage homePage = new HomePage(driver);
            
            // this.WaitForElementToBeClickableBySelector(By.id(homePage.Header_SpanRoleId));
            
            // this.waitForAjax();
            
            if(driver.findElement(By.id(homePage.Header_SpanRoleId)).getText().equals(role)){
                Thread.sleep(600);
                return true;
            }
            
        }

        return false;
    }

    private boolean setRoleForLogin(String role) {
        // List<WebElement> allRoles = driver.findElement(By.id("boundlist-1032-listEl")).findElements(By.tagName("li"));
        // List<WebElement> allRoles = driver.findElement(By.id("boundlist-1024-listEl")).findElements(By.tagName("li"));
        List<WebElement> allRoles = driver.findElement(By.id(roleDropdownListUlsId)).findElements(By.tagName("li"));

        for (WebElement r : allRoles) {
            if (r.getText().equals(role) == true) {
                r.click();
                return true;
            }
        }
        return false;
    }
    
    /*
    public void WaitForElementToBeClickableBySelector(By by){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }
    
    public void WaitForElementToBeClickableByWebElement(WebElement webElement){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }
    */
       
    /*
    public void waitForAjax() throws InterruptedException
    {
        while(true)
        {
            Boolean ajaxIsComplete = (Boolean) ((JavascriptExecutor)driver).executeScript("return jQuery.active == 0");
            if(ajaxIsComplete) {
                break;
            }
            
            Thread.sleep(100);
        }
    }
    */
    
    public void waitForAjax() throws InterruptedException {
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        
        if((Boolean) executor.executeScript("return window.jQuery != undefined")) {
            while(!(Boolean) executor.executeScript("return jQuery.active == 0")) {
                Thread.sleep(1000);
            }
        }
    }
    
}
