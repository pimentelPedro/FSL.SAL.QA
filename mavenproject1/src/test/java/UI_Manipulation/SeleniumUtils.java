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

    public final String Login_LoginButtonXpath = "//a[contains(@id,'button-')]//span[contains(text(),'Login')]";
    final private AppConfig appConfig = new AppConfig();
    public final WebDriver driver;
    private final HomePage homePage = new HomePage();

    public SeleniumUtils(WebDriver _driver) {
        this.driver = _driver;
    }

    public boolean goToFSLPortal(String username, String password, String role) throws InterruptedException, Exception {

        driver.findElement(By.name("username")).sendKeys(username);

        driver.findElement(By.name("password")).sendKeys(password);

        this.WaitForElementToBeDisplyedHasPretended(By.xpath(Login_LoginButtonXpath));
        //click login button
        driver.findElement(By.xpath(Login_LoginButtonXpath)).click();

        this.WaitForElementToBeDisplyedHasPretended(By.xpath("//div[contains(@id,'1026-triggerWrap')]/div[contains(@id,'-trigger-picker')]")); //*[@id="combo-1026-trigger-picker"]
        //click on dropdown button to switch role
        driver.findElement(By.xpath("//div[contains(@id,'1026-triggerWrap')]/div[contains(@id,'-trigger-picker')]')]")).click();

        //switch role
        if (setRoleForLogin(role)) {
            Thread.sleep(3000);
            //this.WaitForElementToBeDisplyedHasPretended(By.xpath(Login_LoginButtonXpath));
            //click login button
            driver.findElement(By.xpath(Login_LoginButtonXpath)).click();

            this.WaitForElementToBeClickableBySelector(By.id(homePage.Header_SpanRoleId));

            if (driver.findElement(By.id(homePage.Header_SpanRoleId)).getText().equals(role)) {
                Thread.sleep(600);
                return true;
            }

        }

        return false;

    }

    private boolean setRoleForLogin(String role) {
        List<WebElement> allRoles = driver.findElement(By.xpath("boundlist-1032-listEl")).findElements(By.tagName("li"));

        for (WebElement r : allRoles) {
            if (r.getText().equals(role) == true) {
                r.click();
                return true;
            }
        }
        return false;
    }

    /// <summary>
    /// Creates a temporary WebDriver to use in waits and finds where it is supposed to be faster or slower than usual 
    /// </summary>
    /// <param name="time">Timeout of the webdriver</param>
    /// <returns></returns>
    private WebDriver GetTemporaryWebDriver(long timeInSeconds) {
        if (timeInSeconds == 0) {
            timeInSeconds = 50;
        }
        WebDriver temporaryDriver = driver;
        temporaryDriver.manage().timeouts().implicitlyWait(timeInSeconds, TimeUnit.SECONDS);
        return temporaryDriver;
    }

    /// <summary>
    /// This Method allows the page to wait untill the element is displayed as pretended
    /// </summary>
    /// <param name="xpath">Xpath to the element</param>
    /// <param name="visible">Pass true if you want the element to be visable, false is you want the element to be hidden</param>
    /// <param name="enabled">Pass true if you want the element to be enabled, false is you don't</param>

    public void WaitForElementToBeDisplyedHasPretended(By by) throws Exception {
        try {
            WebDriver temporary = this.GetTemporaryWebDriver(0);
            WebDriverWait wait = new WebDriverWait(temporary, 40);
            wait.until(ExpectedConditions.elementToBeClickable(by));
        } catch (Exception ex) {
            throw new Exception("Error waiting for an Element to be has pretended, here is the XPath to It: " +"More Details: " + ex.getMessage(), ex);
        }
    }

    public void WaitForElementToBeClickableBySelector(By by) {
        WebDriverWait wait = new WebDriverWait(driver, 40);

        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public void WaitForElementToBeClickableByWebElement(WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(driver, 20);

        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public void WaitForElement(By by) throws InterruptedException {

        boolean find = false;
        do {
            if (driver.findElement(by).isEnabled() && driver.findElement(by).isDisplayed()) {
                find = true;
            } else {
                find = false;
                driver.wait(1000);
            }
        } while (find == false);

    }

}
