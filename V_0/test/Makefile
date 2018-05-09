H.jar: bin/*.class
	jar cfe H.jar -C bin Main bin/*.class
*.class: src/*.java
	javac -d bin src/*.java
clean:
	rm bin/* H
