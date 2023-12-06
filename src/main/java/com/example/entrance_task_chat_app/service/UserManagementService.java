package com.example.entrance_task_chat_app.service;

import com.example.entrance_task_chat_app.entity.Chat;
import com.example.entrance_task_chat_app.entity.User;
import com.example.entrance_task_chat_app.projection.UserView;
import com.example.entrance_task_chat_app.repository.ChatRepository;
import com.example.entrance_task_chat_app.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class UserManagementService {

    private final ChatRepository chatRepository;
    private final UserRepository userRepository;

    public UserManagementService(ChatRepository chatRepository, UserRepository userRepository) {
        this.chatRepository = chatRepository;
        this.userRepository = userRepository;
    }

    public Iterable<User> manageUserRetrieval() throws Exception {
        return userRepository.findAll().orElseThrow( () -> new Exception("No users found"));
    }

    public Chat manageMessageWriting(String text, int id) throws Exception {
        if(id == 1) {
            throw new Exception("Anonymous user - " + id);
        } else {
            User user = userRepository.findById(id).orElseThrow( () -> new Exception("User not found - " + id));
            Chat chat = new Chat();
            chat.setBody(text);
            chat.setSender(user);
            chat.setCreatedAt(Instant.now().toEpochMilli());
            return chatRepository.save(chat);
        }
    }

    public Iterable<UserView> manageChatRoomRetrieval() throws Exception {
        return chatRepository.findChatMessages().orElseThrow( () -> new Exception("Messages not found "));
    }

    public Iterable<Chat> manageNewestToOldest() throws Exception {
        return chatRepository.sortNewestToOldest().orElseThrow( () -> new Exception("Could not sort"));
    }
    public Iterable<Chat> manageOldestToNewest() throws Exception {
        return chatRepository.sortOldestToNewest().orElseThrow( () -> new Exception("Could not sort"));
    }
}