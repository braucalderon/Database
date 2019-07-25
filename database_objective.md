# Database
<p align = "justify">
  This GIU-base API was deigned to tailor to a specific overnight policy.
The overnight policy is based on a student-housing policy, the policy consists on a maximum of 6 free nights with a period wait of 30 days for each night used. For Example, student x has 6 free nights and wants to register his guest for one overnight, June 6th will be registered as one overnight used in the student’s profile, the student will have then 5 free nights left out of 6 free nights. By July 6th the student will get back the overnight used into the student’s profile which it will be get back to 6 free nights. The 6 free nights will not reset every month.</p>
<p align = "justify">
  However, the software will not only communicate and retrieve data from the database. The overnight policy is implemented into the software. The user is responsible to input the correct data into the databased and the program will do the rest.
The program will do the following tasks, update overnights, distribute data into the panel based on the user request, adding and subtracting days based on user input and updated overnights by the system. A separated registration GUI system is added with administrative privileges to delete wrong data and register employees into the system with privilages. </p> 

The imagine below shows the structure of the database.

<img width="1089" alt="Screen Shot 2019-07-25 at 3 24 15 PM" src="https://user-images.githubusercontent.com/17528320/61903500-a8462a00-aef2-11e9-9a5e-c0f2e6126bdc.png">

Login

<img width="476" alt="Screen Shot 2019-07-25 at 4 12 31 PM" src="https://user-images.githubusercontent.com/17528320/61905800-ed208f80-aef7-11e9-9f97-bc2582df6c63.png">

Main Panel. 

<img width="1307" alt="Screen Shot 2019-07-25 at 4 14 22 PM" src="https://user-images.githubusercontent.com/17528320/61906001-64eeba00-aef8-11e9-9088-f02e553dca65.png">


CHALLENGES:

POLYMORPHISM & ENCAPSULATION
<p align = "justify">
  Implementing the right encapsulation into the program and providing some level of security was a concern because security was the main priority for this project. Access private modifiers requires extra coding to handle any behaviors from outside the class or package, which it would involve extra coding to accept an outside request and process the request within the class and process it back out. Instead, access protected modifiers were implemented into the code to accomplish the right encapsulation and provide some level of protection. Polymorphism could not be applied to this project as it was affecting security and unnecessary code needed to achieve polymorphism.
</p>

FOR LOOPS
<p align = "justify">
Iterations using for loops were used to cut unnecessary extra code and for better functionality. I learned new techniques using for loops to achieve a faster output by implementing statements.  A lot of triggers that could had been implemented into the database were applied into the code instead. I only learned the basic update and select statements specifying specific data, as well to loop throughout the whole table.</p>

BRANCHING USING IF-ELSE STATEMENTS 
<p align = "justify">
A lot of if-else statements were used to update and get data from the database, using this concept was difficult because of the run-time performance level already affecting the program itself, and the ability to perform the task without getting locked out from the database. Few runtime performance issues were solved by using for loops, and others by rearranging the structural layout of the code still using if-else statements.</p>






