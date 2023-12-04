package com.example.entrance_task_chat_app.controller;

import com.example.entrance_task_chat_app.entity.Chat;
import com.example.entrance_task_chat_app.entity.User;
import com.example.entrance_task_chat_app.repository.ChatRepository;
import com.example.entrance_task_chat_app.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/user")
public class UserController {
    private final UserRepository userRepository;
    private final ChatRepository chatRepository;

    public UserController(UserRepository userRepository, ChatRepository chatRepository) {
        this.userRepository = userRepository;
        this.chatRepository = chatRepository;
    }

    @GetMapping("/users")
    Iterable<User> all() {
        return userRepository.findAll().orElseThrow();
    }

    @GetMapping("/getUser/{id}")
    public User getUserById(@PathVariable UUID id) {
        return userRepository.findById(id).orElseThrow();
    }

    @DeleteMapping("/deleteUser/{id}")
    public Boolean deleteUserFromChatRoom(@PathVariable UUID id) {
        userRepository.deleteById(id);
        return true;
    }

    @PostMapping("/addUser")
    User newUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping("/chatRoom")
    Iterable<Chat> chatRoom() {
        return chatRepository.findAll().orElseThrow();
    }

    @PostMapping("/addMessage")
    Chat newMessage(@RequestBody Chat chat) {
        return chatRepository.save(chat);
    }
}
