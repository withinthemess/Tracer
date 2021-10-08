# Tracer

Tracer is made out of 3 main parts
==> An application
==> A Website
==> A Hardware Device

Demo video: https://youtu.be/aAIiPirII1M

Android Application:

In this repo you will find the code for our application, export it and open it in android studio.
It should download the needed SDKs automatically
 
 Using the Tracking feature:
 The app looks for a message with longitude and latitude in the SMS inbox. 
 It does not matter if it was a recived or a sent SMS, as long as the latest SMS has those two numbers sperated by a comma.
 
 Send a fake message from the emulator to any number with "  XXlatitudeXXX, XXlongitudeXXX " 
 and open the app, go to the navigation page, and it will read the SMS message and zoom on the location.
 
 Component Used:
 Firebase realtime database
 Firebase authentication
 Constraint layout + animation
 
 
 
The Website: 

the website contents can befound in another repo here : https://github.com/mariemmourad/Tracer.git
Export it 
Open in VS code
Run it
Press CTRL + ~ 
Write "ng serve --open"
And it will be open in the browser


The Hardware Code:

Using Android IDE you need to install the ESP Node EMCU library 
Install the CH341SER driver for the ESP8266 
The code can be found here: https://github.com/withinthemess/TracerHardware


