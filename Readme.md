# Send Push Notification From Server Side (Spring boot) to client side (Android) with FCM integration


<b>Server Side (Spring boot)</b>
<br>
Let's first try to understand the concept behind FCM, how server sends data to FCM and then FCM sends to client.
<br>
 ![alt text](
  https://github.com/Firoz-Hasan/SpringBootPushNotification/blob/master/pushnotificationconcept.png
  )
1.	 Firstly go to https://console.firebase.google.com/ and create a new project.
 ![alt text](
  https://github.com/Firoz-Hasan/SpringBootPushNotification/blob/master/createproj.PNG
  )
2.	Now we need to generate Firebase SDK admin key for server side authorization which is actually a private JSON file to put it / integrate it in our spring boot project. So to do that you have to go to Project Setting -> Service Accounts -> Choose Java -> Finally click on Generate new private key and save it. This private key gives access to your project's Firebase services.
3.	Now open your spring boot project & create a folder under src/main/resources and place generated json file there.
4.	In your application.properties file create key/value like app.firebase-configuration-file=adminsdk/xxxxxxxxxxxxxxxxxxxxxxxxxxxxx.json
5.	Add firebase admin dependency in pom.xml (https://mvnrepository.com/artifact/com.google.firebase/firebase-admin)
6.	Now we need to initialize our firebase (Create class FCMInitializer)application and integrated with the sdk admin key (firebase configuration file) that we generated from console. 
7.	Create two classes name as FCMService and PushNotificationService. In FCMService we will write actual method of sending data/token/topic to firebase and in PushNotificationService we make another service layer and call actual method from FCMService.

 ![alt text](
  https://github.com/Firoz-Hasan/SpringBootPushNotification/blob/master/pushnotificationservice.png
  )
  So what will happen actually is when we type "localhost:8080/notification/topic" by restcontroller it will point towards
  sendNotification method then it will call pushNotificationService.sendPushNotificationWithoutData and pushNotificationService will
  call FCMService (fcmService.sendMessageWithoutData) to send data to firebase cloud messaging and then FCM downstream the message
  as notification to client(Android).
<br>
8.	Create model file PushNotificationResponse an PushNotificationResponse.
<br>
9.	Create PushNotificationController class to send push notification to firebase.<br>
10. The endpoints are :

      A) localhost:8080/notification/data 
      {
      	"title":"Notification for pending work",
        "message":"pls complete your pending task immediately",
      	"token":"sfsfsdfsdfdsfsdfsdfsdfsdfsdf"
      }
      
      B) localhost:8080/notification/topic
     {
     	"title":"Notification for pending work",
     	"message":"pls complete your pending task immediately",
     	"topic" : "global"
     }
      C) localhost:8080/notification/token
      {
      "title":"Notification for pending work",
      "message":"pls complete your pending task immediately",
      "token":"sfssdfsdfsdfsfsfsfsfsfsfsfsdfsfsfs"
      }
      
     D) localhost:8080/notification/data/customdatawithtopic
        {
        	"topic" : "global"
        }   
      
     In order to test individual notification by fcm, for token id its it equivalent to device id / reg id / firebase id 
     so either you can get it by login authentication or when you install in your android device token id will be provided so
     you can refer to that for testing purpose.
     
      
<b> Client Side (Android) </b>


In order to receive notification you will need a client side application.
For android you can refer to the following link : https://github.com/Firoz-Hasan/AndroidPushNotification

Pls check the youtube video for better understanding :   https://youtu.be/EAszTcaXuFo

