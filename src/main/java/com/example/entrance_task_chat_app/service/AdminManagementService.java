package com.example.entrance_task_chat_app.service;

import com.example.entrance_task_chat_app.entity.User;
import com.example.entrance_task_chat_app.projection.Statistics;
import com.example.entrance_task_chat_app.repository.ChatRepository;
import com.example.entrance_task_chat_app.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;

@Service
public class AdminManagementService {

    private final ChatRepository chatRepository;
    private final UserRepository userRepository;

    public AdminManagementService(ChatRepository chatRepository, UserRepository userRepository) {
        this.chatRepository = chatRepository;
        this.userRepository = userRepository;
    }

    public User manageUserCreation(String name) throws Exception {
        if(!userRepository.findByName(name).equals(Optional.empty())) {
            throw new Exception("Name taken - " + name);
        } else {
            User newUser = new User();
            newUser.setName(name);
            newUser.setCreatedAt(Instant.now().toEpochMilli());
            return userRepository.save(newUser).orElseThrow( () -> new Exception("Save failed"));
        }
    }

    public void manageUserDeletion(int id) throws Exception {
        if(id == 1) {
            throw new Exception("Anonymous user - " + id);
        } else {
            chatRepository.setAnonymousSenders(id).orElseThrow( () -> new Exception("Could not update"));
            userRepository.deleteById(id).orElseThrow( () -> new Exception("Could not delete"));
        }
    }

    public Statistics manageUserStatistics(int id) throws Exception {
        if(id == 1) {
            throw new Exception("Anonymous user - " + id);
        } else {
            return chatRepository.statistics(id).orElseThrow( () -> new Exception("Failed getting statistics"));
        }
    }
}
