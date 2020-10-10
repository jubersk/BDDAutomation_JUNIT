Feature: MobileTests

@mobile
Scenario: Perfom operations on mobile app
Given :Install Music player app on the mobile device
Then :Verify the home screen for the app
And : Select playlist and navigate to songs screen
Then :Play and pause a song
And :Navigate back to app home screen