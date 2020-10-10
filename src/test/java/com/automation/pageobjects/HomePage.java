package com.automation.pageobjects;

import org.openqa.selenium.By;

import com.automation.constants.Constants;
import com.automation.utils.PropertyUtils;

public class HomePage {
	
	
	public static String baseProjectPath = System.getProperty(Constants.USER_DIR);
	public static PropertyUtils repository = new PropertyUtils(
			baseProjectPath.concat(Constants.HOME_PAGE_OBJECTREPOSITORY_PROPERTY));
	
	public static By productsTextInHomeScreen=By.xpath(repository.getProperty("SAUCEDEMO_HOME_PAGE_PRODUCTS_TEXT"));
	public static String addToCartButtonForProduct=repository.getProperty("SAUCEDEMO_ADD_TO_CART_BUTTON");
	public static By cartButtonInHomeScreen=By.id(repository.getProperty("SAUCEDEMO_CART_BUTTON"));
	
	
	
	
	
	
}