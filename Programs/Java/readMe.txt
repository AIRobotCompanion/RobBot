These files contains the java codes.

***SET-UP MySQL***

Ctrl+Alt+T
$ sudo apt-get install mysql-server[ENTER]
$ mysql -u root -p[ENTER]
***********
mysql> show databases;
mysql> create database RobBot;
mysql> use RobBot;
mysql> CREATE TABLE Users(Name VARCHAR(50),email VARCHAR(50),mobNo VARCHAR(15),UNm VARCHAR(50),UPsswd VARCHAR(50), PRIMARY KEY(UNm,UPsswd));
Query OK, 0 rows affected (1.64 sec)
mysql> desc Users;

SETTING-UP MySQL-Java CONNECTION 
From Inside:
Ctrl+Alt+T

$ sudo cp /home/sayan/Desktop/RobBot/mysql-connector-java-5.1.45/mysql-connector-java-5.1.45-bin.jar /usr/lib/jvm/java-1.8.0-openjdk-amd64/jre/lib/ext[ENTER]
From Outside:
$ sudo nano /etc/environment[ENTER]
concatinate:
CLASSPATH="~/Desktop/RobBot/mysql-connector-java-5.1.45/mysql-connector-java-5.1.45-bin.jar"
$ source /etc/environment[ENTER]

Before that let's check status of destination

Let's insert something from outsider Java program through JDBC that I've located in jre's ext directory

Compile and Run it as follows:
$ javac index.java -Xlint:deprecation[ENTER]
$ java index[ENTER]
