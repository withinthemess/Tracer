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




![1](https://user-images.githubusercontent.com/46242342/149631757-1577cb6b-72a5-4984-8645-87cd178d3299.png)

![2](https://user-images.githubusercontent.com/46242342/149631762-1596b1aa-2f22-44ae-abe8-a66deee2911d.png)

![3](https://user-images.githubusercontent.com/46242342/149631767-b0506cbd-f013-404c-82d6-f3ddf97d4359.png)

![4](https://user-images.githubusercontent.com/46242342/149631778-eed1e5e0-1055-4dad-8822-a081ede3a2ac.png)

![5](https://user-images.githubusercontent.com/46242342/149631782-e5d9341f-d563-4a5d-97f7-724690b46ff3.png)

![5_1](https://user-images.githubusercontent.com/46242342/149631788-2b61efeb-368e-46f9-b3ff-8493b643df58.png)

![5_2](https://user-images.githubusercontent.com/46242342/149631802-e9a7f6ac-eda6-4b93-952e-1ac7fa0e2cd3.png)

![6](https://user-images.githubusercontent.com/46242342/149631811-7e9d9b40-ca36-4bc8-b419-bd7e0cd28437.png)

![7](https://user-images.githubusercontent.com/46242342/149631817-02f14024-7376-4765-8908-68acf4b909fb.png)

![8](https://user-images.githubusercontent.com/46242342/149631822-d6137973-1779-4b55-a889-e511f300439f.png)

![9](https://user-images.githubusercontent.com/46242342/149631827-e61f8683-6ea5-4c4f-ab6c-05dfc0e87f28.png)

![10](https://user-images.githubusercontent.com/46242342/149631839-e6f8f7d1-d435-4612-a85c-f6c12d66f76a.png)

![11](https://user-images.githubusercontent.com/46242342/149631962-6d9c485d-e1c5-4ff4-ab3f-e5514b42e729.png)
