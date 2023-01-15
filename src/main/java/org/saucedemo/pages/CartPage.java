package org.saucedemo.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.saucedemo.base.CommonAPI;

import javax.swing.*;

public class CartPage extends CommonAPI {

    Logger LOG = LogManager.getLogger(CartPage.class.getName());

    public CartPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".header_secondary_container")
    WebElement cartHeader;
    @FindBy(css="#continue-shopping")
    WebElement continueShopping;
    @FindBy(css="#checkout")
    WebElement checkoutButton;


    public String getCartHeaderText(){
        LOG.info("cart header display success");
        return getWebElementText(cartHeader);
    }
    public void clickOnContinueShopping(){
        clickOn(continueShopping);
        LOG.info("click on continue shopping  button success");
    }
/*
    public boolean cartHeaderIsDisplayed(){
        boolean flag = isDisplayed(cartHeader);
        LOG.info("cart header is displayed");
        return flag;
    }
*/

    public void clickOnCheckoutButton(){
        clickOn(checkoutButton);
        LOG.info("click on check button success");
    }



}
