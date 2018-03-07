This Folder contains the Java .class files for WelcomePage, RegistrationForm, LoginForm, UserPage
***SET-UP MySQL***

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


***Run Program***

$ cd ~/Desktop/RobBot/Prog/[ENTER]
$ javac index.java -Xlint:deprecation[ENTER]
$ java index[ENTER]
