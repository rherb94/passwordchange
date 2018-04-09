# **Ryan Herb: Password Change**
This is a password change compliance Java application that reads password data of all accounts on a group of servers and generates a consolidated spreadsheet listing accounts with the oldest change date to the most recent.  

## **Instructions**
To run this project, clone this repository, create the jar file by executing a ```mvn clean package```.  Then switch to the target directory and run the jar using the command ```java -jar password-change.jar /passwordchange/src/main/data  ```.  
Note that the input must be the full path of the /data directory on your file system.  This will create the .csv file in the same directory, to open it execute ```open test.csv``` .

