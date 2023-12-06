package com.example.entrance_task_chat_app.controller;

import com.example.entrance_task_chat_app.entity.Chat;
import com.example.entrance_task_chat_app.entity.User;
import com.example.entrance_task_chat_app.projection.UserView;
import com.example.entrance_task_chat_app.service.UserManagementService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/user")
public class UserController {
    private final UserManagementService userManagementService;

    public UserController(UserManagementService userManagementService) {
        this.userManagementService = userManagementService;
    }

    @GetMapping("/users")
    ResponseEntity<?> all() {
        Iterable<User> users;
        try {
            users = userManagementService.manageUserRetrieval();
        } catch (Exception notFound) {
            return new ResponseEntity<>(notFound.getMessage(), HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
    @GetMapping("/getMessages")
    ResponseEntity<?> getmessages() {
        Iterable<UserView> userView;
        try {
            userView = userManagementService.manageChatRoomRetrieval();
        } catch (Exception notFound) {
            return new ResponseEntity<>(notFound.getMessage(), HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(userView, HttpStatus.OK);
    }

    @PostMapping("/writeMessage/{id}")
    ResponseEntity<?> postMessage(@RequestBody String text, @PathVariable int id) {
        Chat chat;
        try {
            chat = userManagementService.manageMessageWriting(text, id);
        } catch (Exception messageNotWritten) {
            return new ResponseEntity<>(messageNotWritten.getMessage(), HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(chat, HttpStatus.OK);
    }
    @GetMapping("/newToOld")
    ResponseEntity<?> sortMessagesNewestToOldest() {
        Iterable<Chat> chatRoom;
        try {
            chatRoom = userManagementService.manageNewestToOldest();
        } catch (Exception notFound) {
            return new ResponseEntity<>(notFound.getMessage(), HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(chatRoom, HttpStatus.OK);
    }

    @GetMapping("/oldToNew")
    ResponseEntity<?> sortMessagesOldestToNewest() {
        Iterable<Chat> chatRoom;
        try {
            chatRoom = userManagementService.manageOldestToNewest();
        } catch (Exception notFound) {
            return new ResponseEntity<>(notFound.getMessage(), HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(chatRoom, HttpStatus.OK);
    }

}
