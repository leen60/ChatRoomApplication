package com.example.entrance_task_chat_app.repository;

import com.example.entrance_task_chat_app.entity.Admin;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface AdminRepository extends Repository<Admin, Integer> {

    Admin save(Admin user);
    @Query(value = "SELECT * FROM admin", nativeQuery = true)
    Optional<List<Admin>> findAll();
    @Modifying
    @Query(value = "DELETE FROM ADMIN WHERE ID = ?1", nativeQuery = true)
    void deleteById(int id);
}
