# https://github.com/xerial/sqlite-jdbc#usage

all:
	javac -classpath ".:sqlite-jdbc-3.30.1.jar" ScholarshipClient.java
	java -classpath ".:sqlite-jdbc-3.30.1.jar" ScholarshipClient
