package Sections;

import junit.framework.Assert;
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
public class Section1 extends MainSection {
    
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
     * TC001 - Login into FSL Portal: Valid credentials
     * Guarantee that a user with a valid account can correctly log.
     * User should have an existing access with Admin profile access
     * @throws InterruptedException
     * @throws Exception 
     */
    @Test
    public void TC001() throws InterruptedException, Exception {
        boolean validLogin = false;
        try {
            validLogin = utils.goToFSLPortal(appConfig.Login_ValidUserName, appConfig.Login_Validpassword, "Administrator");
            
            driver.quit();
        } catch (Exception ex) {
            throw new Exception("Ocorreu um erro a tentar fazer login: " + ex.getMessage());
        } finally {
            Assert.assertTrue(validLogin);
        }
        
    }
    /**
     *
     * @throws InterruptedException
     */
    
}
