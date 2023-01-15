package org.saucedemo.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.saucedemo.base.CommonAPI;

public class CheckoutCompletePage extends CommonAPI {

    Logger LOG = LogManager.getLogger(CheckoutCompletePage .class.getName());

    public CheckoutCompletePage (WebDriver driver){PageFactory.initElements(driver, this);}
}
