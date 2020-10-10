package com.automation.steps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.automation.exception.AutomationException;
import com.automation.pageobjects.CartCheckoutPage;
import com.automation.utils.DriverUtilsImpl;
import com.automation.utils.TestDataUtils;
import com.automation.utils.TestResultsUtils;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;


public class CartCheckoutPageStepDefinition extends TestDataUtils{


	DriverUtilsImpl reusablemethods = new DriverUtilsImpl();
	/** The logger. */
	private static final Logger LOG = LoggerFactory.getLogger(CartCheckoutPageStepDefinition.class);

	TestResultsUtils testResultUtilities = new TestResultsUtils();
	



    @Then("^:Verify your cart (.+) and click on checkout button$")
    public void verify_your_cart_and_click_on_checkout_button(String productname) throws Throwable {
    	
    	try{
       	  if(reusablemethods.isElementPresent(CartCheckoutPage.yourCartLabel) && reusablemethods.gWebElementGetText(CartCheckoutPage.productNameCartPage).equalsIgnoreCase(productname)){
       		testResultUtilities.logger.log(LogStatus.PASS, "Cart Page :: Your cart text and selected product displayed ");
       		  reusablemethods.gClick(CartCheckoutPage.checkoutButtonInCartPage);
       		testResultUtilities.logger.log(LogStatus.PASS, "Successfully clicked checkout button ");
       	  }else
       	  	throw new AutomationException();
       	  
       	  
         }catch(Exception exception){
      	   testResultUtilities.logger.log(LogStatus.FAIL, "Cart Screen:: Verification failed");
       	  exception.printStackTrace();
       	  
         }
    	
    }
    
    @Then("^:Enter details (.+),(.+),(.+) and place order$")
    public void enter_details_and_place_order(String firstname, String lastname, String postalcode) throws Throwable {
     
    	try{
    		reusablemethods.sendText(CartCheckoutPage.firstNameCheckoutPage, firstname);
      	  	reusablemethods.sendText(CartCheckoutPage.lastNameCheckoutPage, lastname);
      	  reusablemethods.sendText(CartCheckoutPage.postalcodeCheckoutPage, postalcode);
      	  	reusablemethods.gClick(CartCheckoutPage.continueButtonInCheckoutPage);
         		testResultUtilities.logger.log(LogStatus.PASS, "Checkout Page:: Successfully entered personal details and clciked on continue button ");
         	  
         	  
           }catch(Exception exception){
        	   testResultUtilities.logger.log(LogStatus.FAIL, "Checkout Screen:: Verification failed");
         	  exception.printStackTrace();
         	  
           }
    	
    }

    
    @And("^:Verify checkout overview screen and place order using (.+)$")
    public void verify_checkout_overview_screen_and_place_order_using(String productname) throws Throwable {

    	
    	try{
         	  if( reusablemethods.gWebElementGetText(CartCheckoutPage.productNameCartPage).equalsIgnoreCase(productname)){
         		testResultUtilities.logger.log(LogStatus.PASS, "Checkout Overview Page ::Selected product displayed ");
         		  reusablemethods.gClick(CartCheckoutPage.finishButtonInCheckoutPage);
         		testResultUtilities.logger.log(LogStatus.PASS, "Successfully clicked finish button ");
         	  }else
         	  	throw new AutomationException();
         	  
         	  
           }catch(Exception exception){
        	   testResultUtilities.logger.log(LogStatus.FAIL, "Checkout Overview  Screen:: Verification failed");
         	  exception.printStackTrace();
         	  
           }
    	
    }


    @And("^:Verify order confirmation screen$")
    public void verify_order_confirmation_screen() throws Throwable {
        
    	try{
       	  if( reusablemethods.gWebElementGetText(CartCheckoutPage.confirmationMessageHeading).equalsIgnoreCase("THANK YOU FOR YOUR ORDER") &&
       			reusablemethods.gWebElementGetText(CartCheckoutPage.confirmationMessage).contains("Your order has been dispatched")  ){
       		testResultUtilities.logger.log(LogStatus.PASS, "Checkout Overview Page ::Selected product displayed ");
       		testResultUtilities.logger.log(LogStatus.PASS, "Successfully validated order confirmation message");
       	  }else
       	  	throw new AutomationException();
       	  
       	  
         }catch(Exception exception){
      	   testResultUtilities.logger.log(LogStatus.FAIL, "Order confirmationVerification failed");
       	  exception.printStackTrace();
       	  
         }
    	
    }



}

