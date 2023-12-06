# ChatRoomApplication
### Swagger-ui: http://localhost:8080/swagger-ui/index.html#/
### h2 console: http://localhost:8080/h2-ui

#### REST backend for a simple chat room.

## Intalation
#### Manually run `gradle build` than `gradle bootRun` or run *EntranceTaskChatAppApplication.java* in IntelliJ or other IDE.

## Load Initial Data
#### Gets preloaded with *CommandLineRunner*

## Endpoints
### User
#### GET chat room messages
#### `curl http://localhost:8080/api/user/getMessages`
#### POST a message
#### `curl -i -X POST -H "Content-Type:application/json" http://localhost:8080/api/user/writeMessage/3 -d "text"`
#### GET sorted values
#### `curl http://localhost:8080/api/user/newToOld`
#### `curl http://localhost:8080/api/user/oldToNew`
#### GET all users
#### `curl http://localhost:8080/api/user/users`


### Admin
### POST new user
#### `curl -i -X POST -H "Content-Type:application/json" http://localhost:8080/api/admin/addUser -d "Tom"`
### DELETE a user
#### `curl -i -X DELETE http://localhost:8080/api/admin/deleteUser/2`
### GET statistics
#### `curl http://localhost:8080/api/user/stats/3`
