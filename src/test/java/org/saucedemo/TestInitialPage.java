package org.saucedemo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.saucedemo.base.CommonAPI;
import org.saucedemo.pages.LoginPage;
import org.saucedemo.utility.ExcelReader;
import org.saucedemo.utility.Utility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class TestInitialPage extends CommonAPI {

    Logger LOG = LogManager.getLogger(TestInitialPage.class.getName());
    ExcelReader excelReader = new ExcelReader(Utility.currentDir+ File.separator+"data"+File.separator+"test-data.xlsx", "data");

    //@Test
    public void validateLandingPage(){
        String expected = excelReader.getDataForGivenHeaderAndKey("key", "login page title");
        String actual = getPageTitle();

        Assert.assertEquals(expected, actual);
        LOG.info("page title validation success");
    }

    @Test
    public void validateLoginPageElements(){
        LoginPage loginPage = new LoginPage(driver);
        String expected = excelReader.getDataForGivenHeaderAndKey("key", "login page title");
        String actual = getPageTitle();

        Assert.assertEquals(expected, actual);
        LOG.info("page title validation success");

        //username
        boolean userNameIsDisplayed = loginPage.usernameFieldIsDisplayed();
        Assert.assertTrue(userNameIsDisplayed);
        LOG.info("username field is displayed");

        //password
        boolean passwordFieldIsDisplayed = loginPage.passwordFieldIsDisplayed();
        Assert.assertTrue(passwordFieldIsDisplayed);
        LOG.info("password field is displayed");

        //login button
        boolean loginButtonIsDisplayed = loginPage.loginBtnIsDisplayed();
        Assert.assertTrue(loginButtonIsDisplayed);
        LOG.info("login button is displayed");
    }



}
