package org.saucedemo.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.saucedemo.base.CommonAPI;

public class CheckoutOverviewPage extends CommonAPI {
    Logger LOG = LogManager.getLogger(CheckoutOverviewPage .class.getName());
    public CheckoutOverviewPage (WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".title")
    WebElement checkoutOverviewHeader;

    public boolean checkoutOverviewHeaderIsDisplayed(){
        boolean flag = isDisplayed(checkoutOverviewHeader);
        LOG.info("checkout Overview header is displayed");
        return flag;
    }
}


