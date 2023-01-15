package org.saucedemo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.saucedemo.base.CommonAPI;
import org.saucedemo.pages.*;
import org.saucedemo.utility.ExcelReader;
import org.saucedemo.utility.Utility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class TestPurchase extends CommonAPI {

    Logger LOG = LogManager.getLogger(TestPurchase.class.getName());

    String username = Utility.decode(prop.getProperty("username"));
    String password = Utility.decode(prop.getProperty("password"));
    /*
    String firstName = Utility.decode(prop.getProperty("firstName"));
    String lastName = Utility.decode(prop.getProperty("lastName"));
    String postalCode = Utility.decode(prop.getProperty("postalCode"));
    ExcelReader excelReader = new ExcelReader(Utility.currentDir+ File.separator+"data"+File.separator+"test-data.xlsx", "data");

     */
    @Test
    public void addItemToCard(){
        LoginPage loginPage = new LoginPage(driver);
        Homepage homePage = new Homepage(driver);

        //login
        loginPage.login(username, password);
        Assert.assertTrue(homePage.productsHeaderIsDisplayed());

        //add item to cart
        LOG.info(homePage.getItem1Color());
        homePage.addItem1ToCart();

        //check item gets black colored
        LOG.info(homePage.getItem1Color());
    }

    @Test
    public void removeItemInCard(){
        LoginPage loginPage = new LoginPage(driver);
        Homepage homePage = new Homepage(driver);

        //login
        loginPage.login(username, password);
        Assert.assertTrue(homePage.productsHeaderIsDisplayed());

        //add item to cart
        LOG.info(homePage.getItem1Color());
        homePage.addItem1ToCart();

        //check item gets black colored
        LOG.info(homePage.getItem1Color());

        //remove item in cart
        homePage.removeItem1InCard();
        LOG.info("item removed success");

    }
    @Test
    public void clickOnYourCart(){
        LoginPage loginPage = new LoginPage(driver);
        Homepage homePage = new Homepage(driver);
        CartPage cartPage = new CartPage(driver);

        //login
        loginPage.login(username, password);
        Assert.assertTrue(homePage.productsHeaderIsDisplayed());

        //add item to cart
        LOG.info(homePage.getItem1Color());
        homePage.addItem1ToCart();

        //check item gets black colored
        LOG.info(homePage.getItem1Color());

        // click on cart
        homePage.clickOnCart();
        LOG.info("click cart success");

        //check user land on the right page
        LOG.info("check user land on cart page");
        //validate user land on cart page
        Assert.assertEquals("YOUR CART", cartPage.getCartHeaderText());

        /*
        boolean cartHeaderIsDisplayed = cartPage.cartHeaderIsDisplayed();
        Assert.assertTrue(cartHeaderIsDisplayed);
        LOG.info("Products header is displayed success");
*/
    }
@Test
public void clickOnContinueShoppingButton() {
    LoginPage loginPage = new LoginPage(driver);
    Homepage homePage = new Homepage(driver);
    CartPage cartPage = new CartPage(driver);

    //login
    loginPage.login(username, password);
    Assert.assertTrue(homePage.productsHeaderIsDisplayed());

    //add item to cart
    LOG.info(homePage.getItem1Color());
    homePage.addItem1ToCart();

    //check item gets black colored
    LOG.info(homePage.getItem1Color());

    // click on cart
    homePage.clickOnCart();
    LOG.info("click cart success");

    //check user land on the right page
    LOG.info("check user land on cart page");
    //validate user land on cart page
    Assert.assertEquals("YOUR CART", cartPage.getCartHeaderText());

    // click on Continue Shopping Button
    cartPage.clickOnContinueShopping();
    LOG.info("click continue shopping button success");
    Assert.assertTrue(homePage.productsHeaderIsDisplayed());

}

    @Test
    public void clickOnCheckButton() {
        LoginPage loginPage = new LoginPage(driver);
        Homepage homePage = new Homepage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutInformationPage checkoutInformationPage = new CheckoutInformationPage(driver);
       // CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);

        //login
        loginPage.login(username, password);
        Assert.assertTrue(homePage.productsHeaderIsDisplayed());

        //add item to cart
        LOG.info(homePage.getItem1Color());
        homePage.addItem1ToCart();

        //check item gets black colored
        LOG.info(homePage.getItem1Color());

        // click on cart
        homePage.clickOnCart();
        LOG.info("click cart success");

        //check user land on the right page
        LOG.info("check user land on cart page");
        //validate user land on cart page
        Assert.assertEquals("YOUR CART", cartPage.getCartHeaderText());

        //click on cart Checkout Button
        cartPage.clickOnCheckoutButton();
        LOG.info("click checkout button success");

        //check user land on the right page
        LOG.info("check user land on checkout information page");
        //validate user land on cart page
        Assert.assertEquals("CHECKOUT: YOUR INFORMATION",checkoutInformationPage.getCheckoutInformationHeaderText());



    }
    /*
        @Test
        public void CheckoutInformationWithValidCredentials () {
        LoginPage loginPage = new LoginPage(driver);
        Homepage homePage = new Homepage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutInformationPage checkoutInformationPage = new CheckoutInformationPage(driver);
        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);

        //login
        loginPage.login(username, password);
        Assert.assertTrue(homePage.productsHeaderIsDisplayed());

        //add item to cart
        LOG.info(homePage.getItem1Color());
        homePage.addItem1ToCart();

        //check item gets black colored
        LOG.info(homePage.getItem1Color());

        // click on cart
        homePage.clickOnCart();
        LOG.info("click cart success");

        //check user land on the right page
        LOG.info("check user land on cart page");
        //validate user land on cart page
        Assert.assertEquals("YOUR CART", cartPage.getCartHeaderText());

        //click on cart Checkout Button
        cartPage.clickOnCheckoutButton();
        LOG.info("click checkout button success");

        //check user land on the right page
        LOG.info("check user land on checkout information page");
        //validate user land on cart page
        Assert.assertEquals("CHECKOUT: YOUR INFORMATION",checkoutInformationPage.getCheckoutInformationHeaderText());

        //check user land on the right page
        String expected = excelReader.getDataForGivenHeaderAndKey("key", "checkout information page header");
        String actual = getPageTitle();

        Assert.assertEquals(expected, actual);
        LOG.info("page title validation success");

        //enter information
        //enter first name
        checkoutInformationPage.typeFirstName(firstName);
        LOG.info("enter username success");

        //enter last name
        checkoutInformationPage.typeLastName(lastName);
        LOG.info("enter last name success");

        //enter postal code
        checkoutInformationPage.typePostalCode(postalCode);
        LOG.info("enter postal code success");

        //click on check button
        checkoutInformationPage.clickOnContinueButton();
        LOG.info("continue button click success");

        boolean checkoutOverviewsHeaderIsDisplayed = checkoutOverviewPage.checkoutOverviewHeaderIsDisplayed();
        Assert.assertTrue(checkoutOverviewsHeaderIsDisplayed);
        LOG.info("checkout Overview header is displayed success");

    }*/

}
