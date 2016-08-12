/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pages.HomePage;

import UI_Manipulation.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 *
 * @author Pedro Pimentel <pedro.pimentel@celfocus.com>
 * @author Luis Guilherme Castelo <luis.santos.castelo@celfocus.com>
 */
public class HomePage extends SeleniumUtils {  
    // Page Elements' Selectors
    public final String Header_SpanRoleId    = "ext-element-11";
    public final String processesSpanId      = "button-1047-btnIconEl";
    public final String portalLogsSpanId     = "button-1088-btnInnerEl";
    
    public HomePage(WebDriver _driver) {
        super(_driver);
    }
    
    public void goToPortalLogs() throws InterruptedException {
        WebElement processesSpan = driver.findElement(By.id(processesSpanId));
        processesSpan.click();
        
        // super.WaitForElementToBeClickableBySelector(By.id(portalLogsSpanId));
        
        super.waitForAjax();
        Thread.sleep(2000);
        
        WebElement portalLogsSpan = driver.findElement(By.id(portalLogsSpanId));
        portalLogsSpan.click();
    }
    
}
