/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pages.PortalLogs;

import UI_Manipulation.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 *
 * @author Luis Guilherme Castelo <luis.santos.castelo@celfocus.com>
 */
public class PortalLogs extends SeleniumUtils {
    // Page Elements' Selectors
    public final String searchSpanId            = "button-1121-btnInnerEl";
    public final String dateDivId               = "datefield-1100-trigger-picker";
    public final String dateTdCssSelector       = "td[aria-label='August 31']"; // 
    
    public PortalLogs(WebDriver _driver) {
        super(_driver);
    }
    
    public void searchPortalLog() throws InterruptedException {
        // super.WaitForElementToBeClickableBySelector(By.id(searchSpanId));
        
        super.waitForAjax();
        Thread.sleep(2000);
        
        WebElement searchSpan = driver.findElement(By.id(searchSpanId));
        searchSpan.click();
    }
    
    public void narrowSearchByDay() throws InterruptedException {        
        // super.WaitForElementToBeClickableBySelector(By.id(dateDivId));
        
        super.waitForAjax();
        Thread.sleep(2000);
        
        WebElement dateDiv = driver.findElement(By.id(dateDivId));
        dateDiv.click();
        
        // super.WaitForElementToBeClickableBySelector(By.id(dateTdCssSelector));
        
        super.waitForAjax();
        
        WebElement dateTd = driver.findElement(By.cssSelector(dateTdCssSelector));
        dateTd.click();
    }
    
}
