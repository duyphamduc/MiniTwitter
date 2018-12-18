# MiniTwitter

## Before running the project

Step 1: Create a gmail account for senting mail. 

Step 2: Open the project and locate "MailUtilGmail.java" under Source Packages -> controller.

Step 3: Change emailAccount and emailPassword variables accordingly. Note: Google will sent a unsecure application access notice, you will need to enable "run unsecure application" to sent an email.

Step 4: Go to https://cloudinary.com/ and register for an account. This is a media cloud website that allows to uploads media file to the cloud and retrives an URL to save the the database.

Step 5: On the Dashboard of Cloudinary, you will find Cloud name, API Key, and API secret. Please note these three infomations down.

Step 6: On the top navigation bar, there is a tab called "Media Library", click this tab.

Step 7: Below the top navigation bar, next to tab "Home", there is a little arrow, click on this and click on "Add Folder"

Step 8: Add two new folder called "cover" and "profile"

Step 9: Open the project and locate "UploadServlet.java" under Source Packages -> controller.

Step 10: Change API_KEY, API_SECRETE, and CLOUD_NAME variables that you have noted above.

Step 11: Execute twitterdb.sql file in this source folder.

## Execute

Step 1: Run the project using Netbean with tomcat or similar IDE
