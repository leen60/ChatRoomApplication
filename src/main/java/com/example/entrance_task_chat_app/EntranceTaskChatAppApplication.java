package com.example.entrance_task_chat_app;

import com.example.entrance_task_chat_app.entity.Chat;
import com.example.entrance_task_chat_app.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.example.entrance_task_chat_app.repository.UserRepository;
import com.example.entrance_task_chat_app.repository.ChatRepository;

import java.time.Instant;

@SpringBootApplication
public class EntranceTaskChatAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(EntranceTaskChatAppApplication.class, args);
    }

    private static final Logger log = LoggerFactory.getLogger(EntranceTaskChatAppApplication.class);
        @Bean
        CommandLineRunner runner(UserRepository userRepository, ChatRepository chatRepository) {
        return args -> {
            User anonymous = new User();
            anonymous.setId(1);
            anonymous.setName("anonymous");
            anonymous.setCreatedAt(Instant.now().toEpochMilli());
            log.info("Preloading " + userRepository.save(anonymous));

            User user1 = new User();
            user1.setName("Timmy");
            user1.setCreatedAt(Instant.now().toEpochMilli());
            log.info("Preloading " + userRepository.save(user1));

            User user = new User();
            user.setName("Jimmy");
            user.setCreatedAt(Instant.now().toEpochMilli());
            User saved = userRepository.save(user).orElseThrow();

            Chat message = new Chat();
            message.setSender(saved);
            message.setBody("This is the first message");
            message.setCreatedAt(Instant.now().toEpochMilli());
            log.info("Preloading " + chatRepository.save(message));
        };
    }
}
