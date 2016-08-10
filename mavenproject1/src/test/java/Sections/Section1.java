package Sections;


import Login.LoginPage;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 *
 * @author NB22494
 */
public class Section1 extends MainSection{


    LoginPage loginpage = new LoginPage(driver);

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
      

        WebElement acceptAnswerLink = driver.findElement(By.name("btnI"));
        acceptAnswerLink.click();
        Thread.sleep(10000);
        driver.quit();
    }
    
    @Test
    public void TC010() throws InterruptedException {
      //get loginPage methods

        //go to google page
        
        utils.goToFSLPortal(appConfig.Login_ValidUserName, appConfig.Login_Validpassword, "Administrator");

        driver.quit();
    }
    /**
     *
     * @throws InterruptedException
     */

}
