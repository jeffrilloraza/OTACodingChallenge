# OTACodingChallenge
 OTA Initial Coding Challenge
Requirement/s:

Java SDK
Maven
Spring
This is a simple CRUD backend implementation for a note-taking app using Spring Boot. ====================Setting up==================== Using IntelliJ IDE (community edition)

import the project
from the navigation bar click Run > Run 'JeffNoteApplication'
If you want to build and run the project manually: Build: - Using cmd > navigate to the project directory (cd /directory/where/you/extracted/the/project) - using cmd > mvn clean install Run using mvn: - using cmd > mvn spring-boot:run Run using java: - using cmd > navigate to the "target" folder - using cmd> java -jar .jar

Server port is set to 9090

you can change this by modifying the "server.port" property from the application.properties file
Endpoints/APIs: POST >>> /notes GET >>> /notes GET >>> /notes/{id} PUT >>> /notes/{id} DELETE >>> /notes/{id}

you can test the APIs via Postman:

Install Postman https://www.postman.com/downloads/
Run the backend app
using Postman > select POST > http://localhost:9090/notes
for the request body select raw > JSON as the format sample data: { "title": "Sample Note", "content": "This is a newly created note" }