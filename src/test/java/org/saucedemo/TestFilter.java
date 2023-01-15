package org.saucedemo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.saucedemo.base.CommonAPI;
import org.saucedemo.pages.Homepage;
import org.saucedemo.pages.LoginPage;
import org.saucedemo.utility.Utility;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestFilter extends CommonAPI {

    Logger LOG = LogManager.getLogger(TestFilter.class.getName());
    String username = Utility.decode(prop.getProperty("username"));
    String password = Utility.decode(prop.getProperty("password"));
    @Test
    public void filterFromLowToHigh() {
        LoginPage loginPage = new LoginPage(driver);
        Homepage homePage = new Homepage(driver);

        loginPage.login(username, password);
        Assert.assertTrue(homePage.productsHeaderIsDisplayed());
        captureScreenshot("homepage");

        homePage.selectLowerToHigherFromFilter();
        LOG.info("list of prices: "+homePage.getItemsPrice());
        double[] finalPrices = Utility.listToArrayOfDoubles(homePage.getItemsPrice());
        Assert.assertTrue(Utility.isSorted(finalPrices));
        LOG.info("items sorted success");
    }

}
