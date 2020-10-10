package com.automation.steps;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.automation.config.LocalDriverManager;
import com.automation.config.SeleniumNGSuite;
import com.automation.exception.AutomationException;
import com.automation.pageobjects.CartCheckoutPage;
import com.automation.pageobjects.HomePage;
import com.automation.pageobjects.LoginPage;
import com.automation.utils.DriverUtilsImpl;
import com.automation.utils.LocalTestDataManager;
//import com.automation.utils.DriverUtilsImpl;
import com.automation.utils.TestDataUtils;
import com.automation.utils.TestResultsUtils;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class LoginPageStepDefinition extends TestDataUtils{


	DriverUtilsImpl reusablemethods = new DriverUtilsImpl();
	/** The logger. */
	private static final Logger LOG = LoggerFactory.getLogger(LoginPageStepDefinition.class);

	TestResultsUtils testResultUtilities = new TestResultsUtils();
	

	
    @Given("^:User is on application login screen$")
    public void user_is_on_application_login_screen() throws Throwable {
    	SeleniumNGSuite seleniumObject= new SeleniumNGSuite();
		  seleniumObject.setUpSuite("Web");
		  testResultUtilities.logger.log(LogStatus.PASS, "Successfully launched the browser");
		  
    }

    @When("^: User enter credentials (.+),(.+) and click on login button$")
    public void _user_enter_credentials_and_click_on_login_button(String username, String password) throws Throwable {
      try{
    	  reusablemethods.sendText(LoginPage.unameTextField, username);
    	  reusablemethods.sendText(LoginPage.pswdTextField, password);
    	  reusablemethods.gClick(LoginPage.loginButton);
    	  testResultUtilities.logger.log(LogStatus.PASS, "Successfully entered credentails and cliked on login button");
    	  
      }catch(Exception exception){
    	  testResultUtilities.logger.log(LogStatus.FAIL, "Unable to enter credentails and clik on login button");
    	  exception.printStackTrace();
    	  
      }
    }

/*************************** Mobile step Definitions ****************/

	  @Given("^:Install Music player app on the mobile device$")
	    public void install_music_player_app_on_the_mobile_device() throws Throwable {
		  SeleniumNGSuite seleniumObject= new SeleniumNGSuite();
		  seleniumObject.setUpSuite("Mobile");
		  testResultUtilities.logger.log(LogStatus.PASS, "Successfully installed app on the device");
		  
	    }

	  @Then("^:Verify the home screen for the app$")
	    public void verify_the_home_screen_for_the_app() throws Throwable {
	     try{
	    	 Thread.sleep(3000);
		  if(reusablemethods.identifyByAccessibilityId(LoginPage.sideMenuButton).isDisplayed()){
			  String image=testResultUtilities.logger.addScreenCapture(testResultUtilities.takescreenshot(LocalTestDataManager.getScenarioname()));
			  String playListTitle=reusablemethods.gWebElementGetText(LoginPage.playlistTitle);
			  testResultUtilities.logger.log(LogStatus.PASS, "Side menu displayed on the app home screen" +image);
			  testResultUtilities.logger.log(LogStatus.PASS, "Playlist displayed " +playListTitle);
			  
		  }else
		  throw new AutomationException();
	    }catch(Exception exception){
	    	  testResultUtilities.logger.log(LogStatus.FAIL, "App Home screen verification failed");
	    	  exception.printStackTrace();
	    	  
	      }


	  }
	  
	  @And("^: Select playlist and navigate to songs screen$")
	    public void _select_playlist_and_navigate_to_songs_screen() throws Throwable {
		  try{
				 reusablemethods.gClick(LoginPage.playlistTitle);
				 String image=testResultUtilities.logger.addScreenCapture(testResultUtilities.takescreenshot(LocalTestDataManager.getScenarioname()));
				  testResultUtilities.logger.log(LogStatus.PASS, "Successfully selected Playlist " +image);
				  /*** below logic will select song type ****/
				  String songType=reusablemethods.gWebElementGetText(LoginPage.playlistTitle);
				  String image1=testResultUtilities.logger.addScreenCapture(testResultUtilities.takescreenshot(LocalTestDataManager.getScenarioname()));
				  testResultUtilities.logger.log(LogStatus.PASS, "Songs type displayed and selecting " +songType+ " songs" +image1);
				  
				  reusablemethods.gClick(LoginPage.playlistTitle);
				  String image2=testResultUtilities.logger.addScreenCapture(testResultUtilities.takescreenshot(LocalTestDataManager.getScenarioname()));
				  testResultUtilities.logger.log(LogStatus.PASS, "Successfully selected 1st Song type from list" +image2);
				  
				  
		    }catch(Exception exception){
		    	  testResultUtilities.logger.log(LogStatus.FAIL, "Song type selection failed");
		    	  exception.printStackTrace();
		    	  
		      }   
		  
		   
		  
	    }
	  
	  @Then("^:Play and pause a song$")
	    public void play_and_pause_a_song() throws Throwable {
		  try{
				 reusablemethods.gClick(LoginPage.playlistTitle);
				 String image=testResultUtilities.logger.addScreenCapture(testResultUtilities.takescreenshot(LocalTestDataManager.getScenarioname()));
				  testResultUtilities.logger.log(LogStatus.PASS, "Successfully selected 1st song from the list" +image);
				  /*** below logic will play song ****/
				  reusablemethods.gClick(LoginPage.pauseandplaybutton);
				  String image1=testResultUtilities.logger.addScreenCapture(testResultUtilities.takescreenshot(LocalTestDataManager.getScenarioname()));
				  testResultUtilities.logger.log(LogStatus.PASS, "Successfully paused 1st song" +image1);
				  
		    }catch(Exception exception){
		    	  testResultUtilities.logger.log(LogStatus.FAIL, "Song type selection failed");
		    	  exception.printStackTrace();
		    	  
		      } 
	    }
	 
	  
	  
	  @And("^:Navigate back to app home screen$")
	    public void navigate_back_to_app_home_screen() throws Throwable {
	  
		  try{
				 reusablemethods.identifyByAccessibilityId(LoginPage.navigateBackButton).click();
				 String image=testResultUtilities.logger.addScreenCapture(testResultUtilities.takescreenshot(LocalTestDataManager.getScenarioname())); 
				 testResultUtilities.logger.log(LogStatus.PASS, "Successfully clicked on back button and song types screen displayed" +image);
				  reusablemethods.identifyByAccessibilityId(LoginPage.navigateBackButton).click();
				  String image1=testResultUtilities.logger.addScreenCapture(testResultUtilities.takescreenshot(LocalTestDataManager.getScenarioname()));
				  testResultUtilities.logger.log(LogStatus.PASS, "Successfully clicked on back button and home screen displayed" +image1);
				  /**** below logic will verify home screen ***/
				  if(reusablemethods.identifyByAccessibilityId(LoginPage.sideMenuButton).isDisplayed()){
					  String playListTitle=reusablemethods.gWebElementGetText(LoginPage.playlistTitle);
					  String image2=testResultUtilities.logger.addScreenCapture(testResultUtilities.takescreenshot(LocalTestDataManager.getScenarioname()));
					  testResultUtilities.logger.log(LogStatus.PASS, "Side menu displayed on the app home screen" +image2);
					  testResultUtilities.logger.log(LogStatus.PASS, "Playlist displayed " +playListTitle);
					  
				  }else
					  throw new AutomationException();


		    }catch(Exception exception){
		    	  testResultUtilities.logger.log(LogStatus.FAIL, "Unable to navigate back to home screen");
		    	  exception.printStackTrace();
		    	  
		      }
	    }
	  
}
