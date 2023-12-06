package com.example.entrance_task_chat_app.repository;

import com.example.entrance_task_chat_app.entity.Chat;
import com.example.entrance_task_chat_app.projection.Statistics;
import com.example.entrance_task_chat_app.projection.UserView;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface ChatRepository extends Repository<Chat, Integer> {
    Chat save(Chat chat);
    @Query(value = "SELECT USER1.NAME, BODY, ROOM.CREATED_AT FROM CHAT_ROOM AS ROOM, USR AS USER1 WHERE ROOM.SENDER = USER1.ID", nativeQuery = true)
    Optional<List<UserView>> findChatMessages();
    @Query(value = "SELECT * FROM chat_room c ORDER BY c.CREATED_AT DESC", nativeQuery = true)
    Optional<List<Chat>> sortNewestToOldest();
    @Query(value = "SELECT * FROM chat_room c ORDER BY c.CREATED_AT ASC", nativeQuery = true)
    Optional<List<Chat>> sortOldestToNewest();
    @Query(value = "SELECT TEXT_COUNT, CREATED_AT, FIRST_TEXT_TIME,  LAST_TEXT_TIME, AVERAGE_TEXT_LENGTH, BODY FROM CHAT_ROOM, (SELECT MAX(CREATED_AT) AS FIRST_TEXT_TIME, COUNT(SENDER) AS TEXT_COUNT, MIN(CREATED_AT) AS LAST_TEXT_TIME, AVG(LENGTH(BODY)) AS AVERAGE_TEXT_LENGTH FROM CHAT_ROOM WHERE SENDER =?1)  WHERE CREATED_AT =  (SELECT MAX(CREATED_AT) FROM CHAT_ROOM WHERE SENDER =?1)", nativeQuery = true)
    Optional<Statistics> statistics(int id);
    @Modifying
    @Transactional
    @Query(value = "UPDATE CHAT_ROOM SET SENDER= 1 WHERE  SENDER = ?1", nativeQuery = true)
    Optional<Integer> setAnonymousSenders(int id);
}
