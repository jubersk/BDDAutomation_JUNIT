Feature: LoginExample

@web
Scenario Outline: Placing order in swaglabs
Given :User is on application login screen
When : User enter credentials <username>,<password> and click on login button
Then : Add a product to the cart using <productname>
And :Navigate to checkout screen
Then :Verify your cart <productname> and click on checkout button
Then :Enter details <firstname>,<lastname>,<postalcode> and place order
And :Verify checkout overview screen and place order using <productname>
And :Verify order confirmation screen

Examples:
|username	  |password	   |productname		   |firstname|lastname|postalcode|
|standard_user|secret_sauce|Sauce Labs Backpack|testing	 |user	  |12345	 |

