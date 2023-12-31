package com.example.entrance_task_chat_app.repository;

import com.example.entrance_task_chat_app.entity.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends Repository<User, Integer> {

    Optional<User> save(User user);
    @Query(value = "SELECT * FROM USR WHERE ID = ?1", nativeQuery = true)
    Optional<User> findById(int id);
    @Query(value = "SELECT * FROM USR WHERE Name = ?1", nativeQuery = true)
    Optional<User> findByName(String name);
    @Modifying
    @Query(value = "DELETE FROM USR WHERE ID = ?1", nativeQuery = true)
    Optional<Integer> deleteById(int id);
    @Query(value = "SELECT * FROM USR", nativeQuery = true)
    Optional<List<User>> findAll();
}