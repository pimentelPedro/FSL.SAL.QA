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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
 *
 * @author NB22494
 */
public class SeleniumUtils {
    
    final private String Login_LoginButton = "button-1030";
    final private AppConfig appConfig = new AppConfig();
    private final WebDriver driver;
    private final HomePage homePage = new HomePage();

    public SeleniumUtils(WebDriver _driver) {
        this.driver = _driver;
    }

    public boolean goToFSLPortal(String username, String password, String role) throws InterruptedException {

        driver.get(appConfig.FSL_URL);

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.findElement(By.name("username")).sendKeys(username);

        driver.findElement(By.name("password")).sendKeys(password);

        this.WaitForElementToBeClickableBySelector(By.id(Login_LoginButton));
        //click login button
        driver.findElement(By.id(Login_LoginButton)).click();

        //click on dropdown button to switch role
        driver.findElement(By.id("combo-1026-trigger-picker")).click();

        //switch role
        if (setRoleForLogin(role)) {
            //click login button
            driver.findElement(By.id(Login_LoginButton)).click();
            
            this.WaitForElementToBeClickableBySelector(By.id(homePage.Header_SpanRoleId));
            
            if(driver.findElement(By.id(homePage.Header_SpanRoleId)).getText().equals(role)){
                Thread.sleep(600);
                return true;
            }
            
        }

        return false;

    }

    private boolean setRoleForLogin(String role) {
        List<WebElement> allRoles = driver.findElement(By.id("boundlist-1032-listEl")).findElements(By.tagName("li"));

        for (WebElement r : allRoles) {
            if (r.getText().equals(role) == true) {
                r.click();
                return true;
            }
        }
        return false;
    }
    
    public void WaitForElementToBeClickableBySelector(By by){
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }
}
