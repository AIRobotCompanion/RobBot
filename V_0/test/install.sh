#!/bin/sh
echo Installing Software
javac -d bin/ src/*.java
cd bin/
jar cfe H.jar Main *.class
cd ../
ln -s bin/H.jar H
echo Testing...
java -jar H
echo You are Good to Go...Use hapily
#etc.
