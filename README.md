# Flashcard App

Wichtige Files:
    - src/main/java/ch/fhnw/webfr/flashcards/FlashcardsApplication.java
    - src/main/resources/application.properties

Start mongodb with:  mongod --dbpath "$(pwd)/data/db"

Healthcheck-Link: <http://localhost:8080/flashcard-mvc/actuator/health>.

Tomcat is provided thanks to implementation 'org.springframework.boot:spring-boot-starter-web' in build.gradle.