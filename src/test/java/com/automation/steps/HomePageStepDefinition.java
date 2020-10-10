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


public class HomePageStepDefinition extends TestDataUtils{


	DriverUtilsImpl reusablemethods = new DriverUtilsImpl();
	/** The logger. */
	private static final Logger LOG = LoggerFactory.getLogger(HomePageStepDefinition.class);

	TestResultsUtils testResultUtilities = new TestResultsUtils();
	


    @Then("^: Add a product to the cart using (.+)$")
    public void _add_a_product_to_the_cart_using(String productname) throws Throwable {
    	 try{
       	  if(reusablemethods.isElementPresent(HomePage.productsTextInHomeScreen)){
       		testResultUtilities.logger.log(LogStatus.PASS, "Successfully logged into the application and Products text displayed");
       		reusablemethods.gClick(By.xpath(HomePage.addToCartButtonForProduct.replace("ProductName", productname)));
       		testResultUtilities.logger.log(LogStatus.PASS, "Successfully clicked on add to cart button for " +productname);
       	  }else
       	  	throw new AutomationException();
       	  
       	  
         }catch(Exception exception){
        	 testResultUtilities.logger.log(LogStatus.FAIL, "Unable to find Products text in the home screen");
       	  exception.printStackTrace();
       	  
         }
    	
    	
    }

    @And("^:Navigate to checkout screen$")
    public void navigate_to_checkout_screen() throws Throwable {

    	try{
         	  if(reusablemethods.isElementPresent(HomePage.cartButtonInHomeScreen)){
         		reusablemethods.gClick(HomePage.cartButtonInHomeScreen);
         		testResultUtilities.logger.log(LogStatus.PASS, "Successfully clicked oncart button ");
         	  }else
         	  	throw new AutomationException();
         	  
         	  
           }catch(Exception exception){
        	   testResultUtilities.logger.log(LogStatus.FAIL, "Home Screen:: Cart button not displayed");
         	  exception.printStackTrace();
         	  
           }
      	
    
    }




}

