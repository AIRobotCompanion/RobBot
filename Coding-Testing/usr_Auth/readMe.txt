These files contains the User-Authentication Module of RobBot Software
This Folder contains the Java .class files for WelcomePage, RegistrationForm, LoginForm, UserPage
***USER-AUTHENTICATION***
...SET-UP MySQL...

Ctrl+Alt+T
$ sudo apt-get install mysql-server[ENTER]
...Enter "password" as Password
$ mysql -u root -p[ENTER]
****************
mysql> show databases;[ENTER]
mysql> create database RobBot;[ENTER]
mysql> use RobBot;[ENTER]
mysql> CREATE TABLE Users(Name VARCHAR(50),email VARCHAR(50),mobNo VARCHAR(15),UNm VARCHAR(50),UPsswd VARCHAR(50), PRIMARY KEY(UNm,UPsswd));[ENTER]
mysql> desc Users;[ENTER]
mysql> exit;[ENTER]

...Setup Pipeline...
Download MySQL Connector/J from this link:- https://dev.mysql.com/downloads/connector/j/
$ cd ~/Downloads/[ENTER]
$ tar -xvf mysql-connector-java-5.1.45-bin.tar[ENTER]
$ cd mysql-connector-java-5.1.45/[ENTER]
$ sudo cp mysql-connector-java-5.1.45-bin.jar /usr/lib/jvm/java-1.8.0-openjdk-amd64/jre/lib/ext/[ENTER]



...Run Program...

$ cd ~/Desktop/RobBot/Prog/usrAuth/[ENTER]
$ javac index.java -Xlint:deprecation[ENTER]
$ java index[ENTER]
