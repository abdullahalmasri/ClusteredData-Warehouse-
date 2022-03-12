# ClusteredData Warehouse 


[![Build Status](https://travis-ci.org/joemccann/dillinger.svg?branch=master)](https://travis-ci.org/joemccann/dillinger)

Suppose you are part of a scrum team developing data warehouse for Bloomberg to analyze FX deals. One of customer stories is to accept deals details from and persist them into DB. 

- Support Angular
- Java-Spring-boot
- postgres

## pre-installation

- first need to download postgres i am using fedora 34, well pass pstgres is postgressql13 https://computingforgeeks.com/install-postgresql-13-on-fedora/
- need node js 14.17.5
- need to install angular 12
- java 8 and maven 3.6.3 and set JAVA_HOME
- docker 
- Start code

Technical Specs :

Access to DB should be through JPA. For DB type, you can select between (MySql or MongoDB,postgresDB) Provide a web interface for uploading files and inquire about results "using filename" following web applications 3 tier architecture. Spring Batch is not allowed.

### Info Upload multiple file and store into the database and download file

For configuration of Spring MVC, it uses Java config instead of xml config. For Hibernate 4 and MySQL, please modify src/main/resources/application.properties file Build and run the app in command line environment

### 1.Create table in postgresDB
> sudo -i -u postgres
> psql
> \password 
> "your-password"
> CREATE DATABASE "DATABASE_NAME";
 or you could use docker to build local image in warehose/src/main/resources/DockerFile.yml
 
 the command are too easy first be sure you installed docker then 
 > sudo systemctl start docker 
 > sudo docker-compose -f DockerFile.yml up -d
 
 
 then wait second and the local pgadmin will run and you can there add data base 
 according to data in file where in Host set the postgressql_databse
 port as in file 
 etc..
 
### 2. set up the angular 
delete the node-modules file if exist
open terminal 
> yarn install 
> npm run start 

the ui will be open in localhost:4200


### 3.java

here you need to be sure you downloaded java 8 i use intellij 
so i check it either with command line or intellij 
> java -version

in intellij go to file then project structure and set it to java 8

then use  command to build to application 

> mvn clean install
 
 the port here is 8585 so for postman use the localhost:5858/"the api "

when the application is running open postman there are two way to add deals either import csv file or list of deals there will be postman collections
please there are images to show you the way of upload the csv 
and for adding list 


os used Fedora 34 
