package org.saucedemo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.saucedemo.base.CommonAPI;
import org.saucedemo.pages.Homepage;
import org.saucedemo.pages.LoginPage;
import org.saucedemo.utility.ExcelReader;
import org.saucedemo.utility.Utility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class TestLogin extends CommonAPI {

    Logger LOG = LogManager.getLogger(TestLogin.class.getName());
    String username = Utility.decode(prop.getProperty("username"));
    String password = Utility.decode(prop.getProperty("password"));
    ExcelReader excelReader = new ExcelReader(Utility.currentDir+ File.separator+"data"+File.separator+"test-data.xlsx", "data");

    //ConnectDB connectDB = new ConnectDB();
    //String dbUsername = connectDB.getTableColumnData("select * from cred;", "username").get(0);
    //String dbPassword = connectDB.getTableColumnData("select * from cred;", "password").get(0);
    //@Test
    public void loginWithValidCredentials() {
        LoginPage loginPage = new LoginPage(driver);
        Homepage homePage = new Homepage(driver);

        //check user land on the right page
        String expected = excelReader.getDataForGivenHeaderAndKey("key", "login page title");
        String actual = getPageTitle();

        Assert.assertEquals(expected, actual);
        LOG.info("page title validation success");

        //enter username
        //loginPage.typeUsername(dbUsername);
        LOG.info("enter username success");

        //enter password
        //loginPage.typePassword(dbPassword);
        LOG.info("enter password success");

        //click on login button
        loginPage.clickOnLoginButton();
        LOG.info("login button click success");

        boolean productsHeaderIsDisplayed = homePage.productsHeaderIsDisplayed();
        Assert.assertTrue(productsHeaderIsDisplayed);
        LOG.info("Products header is displayed success");
    }
    @Test
    public void loginAttemptWithoutUsername() {
        LoginPage loginPage = new LoginPage(driver);
        //check user land on the right page
        String expected = excelReader.getDataForGivenHeaderAndKey("key", "login page title");
        String actual = getPageTitle();

        Assert.assertEquals(expected, actual);
        LOG.info("page title validation success");

        //enter username
        loginPage.typeUsername("");
        LOG.info("enter username success");

        //enter password
        loginPage.typePassword(password);
        LOG.info("enter password success");

        //click on login button
        loginPage.clickOnLoginButton();
        LOG.info("login button click success");

        String textError = loginPage.getErrorMessage();
        LOG.info("error message: "+ textError);
        Assert.assertEquals(excelReader.getDataForGivenHeaderAndKey("key", "invalid username error message"), textError);
        LOG.info("error message validation success");
    }
    @Test
    public void loginAttemptWithoutPassword() {
        LoginPage loginPage = new LoginPage(driver);
        //check user land on the right page
        String expected = excelReader.getDataForGivenHeaderAndKey("key", "login page title");
        String actual = getPageTitle();

        Assert.assertEquals(expected, actual);
        LOG.info("page title validation success");

        //enter username
        loginPage.typeUsername(username);
        LOG.info("enter username success");

        //enter password
        loginPage.typePassword("");
        LOG.info("enter password success");

        //click on login button
        loginPage.clickOnLoginButton();
        LOG.info("login button click success");

        String textError = loginPage.getErrorMessage();
        LOG.info("error message: "+ textError);
        Assert.assertEquals(excelReader.getDataForGivenHeaderAndKey("key", "invalid password error message"), textError);
        LOG.info("error message validation success");
    }
}
