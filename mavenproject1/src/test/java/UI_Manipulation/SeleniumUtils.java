/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI_Manipulation;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 *
 * @author NB22494
 */
public class SeleniumUtils {

    private final WebDriver driver;

    public SeleniumUtils(WebDriver _driver) {
        this.driver = _driver;
    }

    public boolean goToFSLPortal(String username, String password, String role) throws InterruptedException {

        driver.get("http://10.255.33.4/fsl-login/");

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.findElement(By.name("username")).sendKeys(username);

        driver.findElement(By.name("password")).sendKeys(password);

        //click login button
        driver.findElement(By.id("button-1022-btnInnerEl")).click();

        //click on dropdown button to switch role
        driver.findElement(By.id("combo-1026-trigger-picker")).click();

        //switch role
        if (setRoleForLogin(role)) {
            //click login button
            driver.findElement(By.id("button-1030-btnInnerEl")).click();

            Thread.sleep(12000);
            return true;
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

}
