package com.automation.pageobjects;

import org.openqa.selenium.By;

import com.automation.constants.Constants;
import com.automation.utils.PropertyUtils;

public class CartCheckoutPage {
	
	
	public static String baseProjectPath = System.getProperty(Constants.USER_DIR);
	public static PropertyUtils repository = new PropertyUtils(
			baseProjectPath.concat(Constants.CART_CHECKOUT_PAGE_OBJECTREPOSITORY_PROPERTY));
	
	public static By yourCartLabel=By.xpath(repository.getProperty("SAUCEDEMO_CART_PAGE_YOUR_CART_LABEL"));
	public static By productNameCartPage=By.xpath(repository.getProperty("SAUCEDEMO_PRODUCT_NAME_IN_CART_PAGE"));
	public static By checkoutButtonInCartPage=By.xpath(repository.getProperty("SAUCEDEMO_CHECKOUT_BUTTON"));
	public static By firstNameCheckoutPage=By.id(repository.getProperty("SAUCEDEMO_FIRSTNAME_CHECKOUT_PAGE"));
	public static By lastNameCheckoutPage=By.id(repository.getProperty("SAUCEDEMO_LASTNAME_CHECKOUT_PAGE"));
	public static By postalcodeCheckoutPage=By.id(repository.getProperty("SAUCEDEMO_POSTALCODE_CHECKOUT_PAGE"));
	public static By continueButtonInCheckoutPage=By.xpath(repository.getProperty("SAUCEDEMO_CONTINUE_BUTTON_CHECKOUT_PAGE"));
	public static By finishButtonInCheckoutPage=By.xpath(repository.getProperty("SAUCEDEMO_FINISH_BUTTON_CHECKOUT_PAGE"));
	
	public static By confirmationMessageHeading=By.xpath(repository.getProperty("SAUCEDEMO_CONFIRMATION_MESSAGE_HEADING"));
	public static By confirmationMessage=By.xpath(repository.getProperty("SAUCEDEMO_CONFIRMATION_MESSAGE"));
	
	
	
	
	
	
	
	
	
	
}