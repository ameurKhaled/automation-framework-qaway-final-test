package org.saucedemo.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.saucedemo.base.CommonAPI;

public class CheckoutInformationPage extends CommonAPI {

    Logger LOG = LogManager.getLogger(CheckoutInformationPage .class.getName());
    public CheckoutInformationPage (WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css=".title")
    WebElement checkoutInformationHeader;
    @FindBy(xpath ="//input[@id='first-name']")
    WebElement firstNameField;
    @FindBy(xpath ="//input[@id='last-name'] ")
    WebElement lastNameField;
    @FindBy(xpath ="//input[@name='postalCode']")
    WebElement postalCodeField;
    @FindBy(xpath ="//input[@name='continue']")
    WebElement continueButton;
    @FindBy(xpath = "//div[@class='error-message-container error']")
    WebElement errorMessage;


    public String getCheckoutInformationHeaderText(){
        LOG.info("checkout information header display success");
        return getWebElementText(checkoutInformationHeader);
    }
    public boolean firstNameFieldIsDisplayed(){
        LOG.info("checking first name field is displayed ...");
        return isDisplayed(firstNameField);
    }
    public void typeFirstName(String firstName){
        type(firstNameField, firstName);
    }
    public boolean lastNameFieldIsDisplayed(){
        LOG.info("checking last name field is displayed ...");
        return isDisplayed(lastNameField);
    }
    public void typeLastName(String lastName){
        type(lastNameField, lastName);
    }

    public boolean postalCodeFieldIsDisplayed(){
        LOG.info("checking postal code field is displayed ...");
        return isDisplayed(postalCodeField);
    }
    public void typePostalCode(String postalCode){type(postalCodeField,postalCode);}
    public boolean continueBtnIsDisplayed(){
        LOG.info("checking continue button is displayed ...");
        return isDisplayed(continueButton);
    }
    public void clickOnContinueButton(){
        clickOn(continueButton);
    }

    public String getErrorMessage(){
        return getWebElementText(errorMessage);
    }
    public void checkoutInformation(String firstName, String lastName,String postalCode){
        typeFirstName(firstName);
        typeLastName(lastName);
        typePostalCode(postalCode);
        clickOnContinueButton();
        LOG.info("checkout information process success");
    }



}
