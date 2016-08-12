/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sections;

import Pages.HomePage.HomePage;
import Pages.PortalLogs.PortalLogs;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Luis Guilherme Castelo <luis.santos.castelo@celfocus.com>
 */
public class Section2 extends MainSection {
    
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
     * TC015 - FSL Portal Logs View - User wants to check single log details 
     * Guarantee that a user wants to: check the EAI Logs; see Log Details the input request, output response, possible to export this information for further analysis.
     * Test with User profile Admin and Support
     * Test Filters: Simple Search and Advanced Search (Day and Hour)    
     * @throws InterruptedException 
     */
    @Test
    public void TC015() throws InterruptedException {
        utils.goToFSLPortal(appConfig.Login_ValidUserName, appConfig.Login_Validpassword, "Administrator");
        
        // From the Homepage, press the 'FSL Portal Logs' button.
        HomePage homePage = new HomePage(driver);
        homePage.goToPortalLogs();
        
        // Hit the search button.
        PortalLogs portalLogs = new PortalLogs(driver);
        portalLogs.searchPortalLog();
        
        // Narrow the search by Day.
        portalLogs.narrowSearchByDay(); 
        
        // Narrow the search by Begin Hour to End Hour.
        
    }
    
}
