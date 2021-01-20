# userdisplay
**User info displaying project for logged users in Web App.**<br>
<br>
Web App implemented with Java Spring Boot framework for backend purposes and JavaScript React for operative front-end side. 
Functional pages for <br> Login<br>
                      Register<br>
                      Editing<br>
                      HomePage for showing user's details<br>
<br>
<br>
src files in userdisplay/src/main/java/com/example/userdisplay/ directory are separated in:<br>
<br>
  configuration dir & model dir-> files for handling Spring Security functionalities<br>
  controllers dir-> first layer of communication regarding the server side of the application<br>
  domain dir-> database related entites and data transferring objects<br>
  services dir-> intermediate level for implemented buisness logic, mainly for register and editing purposes<br>
  repositories dir-> final layer for accessing information from the connected database<br>
  <br>
  <br>
 userdisplay/src/main/resources/ directory includes file necessary for front-end purposes <br>
 <br>
  js dir-> React pages mainly for user interaction<br>
  templates dir-> Freemarker enhaced, and React enhanced views<br>
