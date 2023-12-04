package com.example.entrance_task_chat_app.repository;

import com.example.entrance_task_chat_app.entity.Chat;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ChatRepository extends Repository<Chat, UUID> {

    Chat save(Chat chat);
    @Query(value = "SELECT * FROM chat_room", nativeQuery = true)
    Optional<List<Chat>> findAll();
}
