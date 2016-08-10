package Sections;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Login.LoginPage;
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
public class Section2 extends MainSection {


    LoginPage loginpage = new LoginPage(driver);

    public Section2() {

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
    public void TC0010() throws InterruptedException {
      //get loginPage methods

        //go to google page

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
    public void TC007() throws InterruptedException {
        try {
            driver.get("http://store.demoqa.com/");
            Thread.sleep(3000);
            WebElement acceptAnswerLink = driver.findElement(By.xpath("//div[@id='account']/a"));
            acceptAnswerLink.click();
            Thread.sleep(3000);
            driver.quit();
        } catch (Exception ex) {
            throw new Error("O teste falhou porque: " + ex.getCause().toString() + " /n :::::: " + ex.getMessage());

        } finally {
            Assert.assertEquals("ola", "Ola");
        }

    }
}
