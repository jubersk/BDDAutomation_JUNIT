package com.automation.pageobjects;

import org.openqa.selenium.By;

import com.automation.constants.Constants;
import com.automation.utils.PropertyUtils;

public class LoginPage {
	
	
	public static String baseProjectPath = System.getProperty(Constants.USER_DIR);
	public static PropertyUtils repository = new PropertyUtils(
			baseProjectPath.concat(Constants.LOGIN_PAGE_OBJECTREPOSITORY_PROPERTY));
	
	public static By unameTextField=By.id(repository.getProperty("SAUCEDEMO_USERNAME_TEXT_FIELD"));
	public static By pswdTextField=By.id(repository.getProperty("SAUCEDEMO_PASSWORD_TEXT_FIELD"));
	public static By loginButton=By.id(repository.getProperty("SAUCEDEMO_LOGIN-BUTTON"));
	
	
	/************ MOBILE LOCATORS*******/
	public static String sideMenuButton=repository.getProperty("APP_HOME_SCREEN_SIDE_MENU");
	public static String navigateBackButton=repository.getProperty("APP_NAVIGATE_BACK_BTN");
	
	
	public static By playlistTitle=By.id(repository.getProperty("APP_HOME_PLAY_LIST_TITLE"));
	public static By pauseandplaybutton=By.id(repository.getProperty("APP_SONG_PAUSE_BUTTON"));
	
	
	
	
	
	
}