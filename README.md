# userdisplay
User info displaying project for logged users in Web App.

Web App implemented with Java Spring Boot framework for backend purposes and JavaScript React for operative front-end side. 
Functional pages for  Login
                      Register
                      Editing
                      HomePage for showing user's details


src files in userdisplay/src/main/java/com/example/userdisplay/ directory are separated in:

  configuration dir & model dir-> files for handling Spring Security functionalities
  controllers dir-> first layer of communication regarding the server side of the application
  domain dir-> database related entites and data transferring objects
  services dir-> intermediate level for implemented buisness logic, mainly for register and editing purposes
  repositories dir-> final layer for accessing information from the connected database
  
  
 userdisplay/src/main/resources/ directory includes file necessary for front-end purposes
 
  js dir-> React pages mainly for user interaction
  templates dir-> Freemarker enhaced, and React enhanced views
