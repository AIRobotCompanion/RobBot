#!/bin/sh

path="/usr/lib/jvm/java-1.8.0-openjdk-amd64/jre/lib/ext/"
if [ -f "${path}mysql-connector-java-5.1.45-bin.jar" ]
then
	echo Found: mysql-connector-java
else
	echo Copying: mysql-connector-java
	sudo cp lib/mysql-connector-java-5.1.45-bin.jar ${path}
fi

if [ -f "${path}jSerialComm-1.3.11.jar" ]
then
	echo Found: jSerialComm
else
	echo Copying: jSerialComm
	sudo cp lib/jSerialComm-1.3.11.jar ${path}
fi


echo Installing Software
echo Compiling Source Files
javac -d bin/ src/*.java
echo Compiling Done
cd bin/
echo Creating Jar
jar cfe RobBot.jar welcome *.class
echo Jar Creation Done
cd ../
echo Linking Jar
ln -s bin/RobBot.jar RobBot
echo Linking Done
echo Testing...
java -jar RobBot
echo You are Good to Go...Use hapily
#etc.
