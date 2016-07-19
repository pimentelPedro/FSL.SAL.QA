/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Login.LoginPage;
import java.sql.Driver;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
/**
 *
 * @author NB22494
 */
public class NewEmptyJUnitTest {
    private WebDriver driver = new FirefoxDriver();
    LoginPage loginpage = new LoginPage(driver);
    
    public NewEmptyJUnitTest() {
       
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
 * Test Case 1 Section 1 
 * This test, go to google and click on "Sinto-me com sorte" button
 * @throws InterruptedException 
 */
    @Test
    public void TC1() throws InterruptedException {
      //get loginPage methods
      
      //go to google page
      loginpage.gotoGoogle();
      Thread.sleep(3000);
      
      WebElement acceptAnswerLink = driver.findElement(By.name("btnI"));
      acceptAnswerLink.click();  
      Thread.sleep(3000);
      driver.quit();
  }
    
    @Test
    public void TC2() throws InterruptedException {
          
      driver.get("http://store.demoqa.com/");    
      Thread.sleep(3000);
      loginpage.gotoGoogle();
      WebElement acceptAnswerLink = driver.findElement(By.xpath("//div[@id='account']/a"));
      acceptAnswerLink.click();  
      Thread.sleep(3000);
      driver.quit();
  }
}
