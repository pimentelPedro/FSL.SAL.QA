package Sections;


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
