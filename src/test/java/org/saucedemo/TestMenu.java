package org.saucedemo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.saucedemo.base.CommonAPI;
import org.saucedemo.pages.Homepage;
import org.saucedemo.pages.LoginPage;
import org.saucedemo.pages.SLCommunityPage;
import org.saucedemo.pages.SLHomePage;
import org.saucedemo.utility.Utility;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestMenu extends CommonAPI {

    Logger LOG = LogManager.getLogger(TestMenu.class.getName());

    String username = Utility.decode(prop.getProperty("username"));
    String password = Utility.decode(prop.getProperty("password"));
    @Test
    public void about(){
        LoginPage loginPage = new LoginPage(driver);
        Homepage homePage = new Homepage(driver);
        SLHomePage slHomePage = new SLHomePage(driver);
        SLCommunityPage slCommunityPage = new SLCommunityPage(driver);

        //login
        loginPage.login(username, password);
        Assert.assertTrue(homePage.productsHeaderIsDisplayed());

        //click on hamburger menu
        homePage.clickOnHamburgerMenu();

        //validate hamburger menu options
        Assert.assertTrue(homePage.validateAllItemsOptionIsDisplayed());
        Assert.assertTrue(homePage.validateAboutOptionIsDisplayed());
        Assert.assertTrue(homePage.validateLogoutOptionIsDisplayed());
        Assert.assertTrue(homePage.validateResetAppStateOptionIsDisplayed());

        //click on about
        homePage.clickAboutLink();

        //click on saucelab community
        LOG.info("current url: " + slHomePage.getSLHomePageUrl(driver));
        Assert.assertEquals("https://saucelabs.com/", slHomePage.getSLHomePageUrl(driver));
        LOG.info("url validation success");
        slHomePage.hoverOverContact(driver);
        slHomePage.clickOnSauceCommunity();

        //validate user land on community page
        Assert.assertEquals("Our secret sauce is our people", slCommunityPage.getMainHeaderText());
    }
}
