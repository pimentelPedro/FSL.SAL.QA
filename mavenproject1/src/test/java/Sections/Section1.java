package Sections;


import Login.LoginPage;
import UI_Manipulation.SeleniumUtils;
import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 *
 * @author NB22494
 */
public class Section1 {

    private final WebDriver driver = new FirefoxDriver();
    LoginPage loginpage = new LoginPage(driver);
    SeleniumUtils utils = new SeleniumUtils(driver);

    public Section1() {

    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {

    }

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {
    }

    /**
     * Test Case 1 Section 1 This test, go to google and click on "Sinto-me com
     * sorte" button
     *
     * @throws InterruptedException
     */
    @Test
    public void TC001() throws InterruptedException {
      //get loginPage methods

        //go to google page
        loginpage.gotoGoogle();
        Thread.sleep(3000);

        WebElement acceptAnswerLink = driver.findElement(By.name("btnI"));
        acceptAnswerLink.click();
        Thread.sleep(3000);
        driver.quit();
    }

    /**
     *
     * @throws InterruptedException
     */
    @Test
    public void TC002() throws InterruptedException {
        
        boolean enterinportal = false;
        
        
        try {
            driver.get("http://store.demoqa.com/");
            Thread.sleep(3000);
            WebElement acceptAnswerLink = driver.findElement(By.xpath("//div[@id='account']/a"));
            acceptAnswerLink.click();
            Thread.sleep(3000);
            enterinportal = utils.goToSalPortal();
            driver.quit();
        } catch (Exception ex) {
            throw new Error("O teste falhou porque: " + ex.getCause().toString() + " /n :::::: " + ex.getMessage());

        } finally {
            Assert.assertEquals("ola", "Ola");
            Assert.assertTrue(enterinportal);
        }

    }
}
