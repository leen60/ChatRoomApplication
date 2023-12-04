package com.example.entrance_task_chat_app;

import com.example.entrance_task_chat_app.entity.Admin;
import com.example.entrance_task_chat_app.entity.Chat;
import com.example.entrance_task_chat_app.entity.User;
import com.example.entrance_task_chat_app.repository.AdminRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.example.entrance_task_chat_app.repository.UserRepository;
import com.example.entrance_task_chat_app.repository.ChatRepository;

import java.time.Instant;
import java.util.UUID;

@SpringBootApplication
public class EntranceTaskChatAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(EntranceTaskChatAppApplication.class, args);
    }
    private static final Logger log = LoggerFactory.getLogger(EntranceTaskChatAppApplication.class);


        @Bean
        CommandLineRunner runner(UserRepository userRepository, AdminRepository adminRepository, ChatRepository chatRepository) {
        return args -> {
            log.info("Preloading " + adminRepository.save(new Admin(12, "Bilbo Baggins", "burglar", Instant.now().toEpochMilli(), Instant.now().toEpochMilli())));
            log.info("Preloading " + userRepository.save(new User(UUID.randomUUID(), "Bilbo Baggins", "burglar", Instant.now().toEpochMilli(), Instant.now().toEpochMilli())));

            User user = new User(UUID.randomUUID(), "Message user", "burglar", Instant.now().toEpochMilli(), Instant.now().toEpochMilli());
            User saved = userRepository.save(user);
            Chat message = new Chat();
            message.setSender(saved);
            message.setBody("This is the first message");
            message.setCreatedAt(Instant.now().toEpochMilli());
            log.info("Preloading " + chatRepository.save(message));
        };
    }
}
