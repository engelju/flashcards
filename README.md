# Flashcard App

Wichtige Files:
    - src/main/java/ch/fhnw/webfr/flashcards/FlashcardsApplication.java
    - src/main/resources/application.properties

Start mongodb with:  mongod --dbpath "$(pwd)/data/db"

Start the app with: gradle bootrun

Then connect via: http://localhost:8080/flashcard-mvc/questionnaires

Mongosh:

```
$ mongosh
Current Mongosh Log ID: ...
Connecting to:  mongodb://...
Using MongoDB:  ...
Using Mongosh:  ...
test>
test> use webfr
switched to db webfr
webfr> db.questionnaires.insert({ title: 'Test 1', description: 'Some description...'})
WriteResult({ "nInserted" : 1 })
webfr> db.questionnaires.find()
{ "_id" : ObjectId("5f65fb0ecde6fe22ab47e2e6"), "title" : "Test 1", "description" : "Some description..." }
webfr>
```

Weitere Befehle in der mongo-Shell

- Alle Questionnaire Entitäten auflisten

```
webfr> db.questionnaires.find()
```

- Search Criteria einsetzen – über ID

```
webfr> db.questionnaires.find( { _id: ObjectId('5f65fb0ecde6fe22ab47e2e6') } )
```

- Search Criteria einsetzen – über Title

```
webfr> db.questionnaires.find( { title: 'Test 1'} )
```

Healthcheck-Link: <http://localhost:8080/flashcard-mvc/actuator/health>.

Tomcat is provided thanks to implementation 'org.springframework.boot:spring-boot-starter-web' in build.gradle.
