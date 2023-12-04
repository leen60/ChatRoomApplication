package com.example.entrance_task_chat_app.entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import org.hibernate.annotations.UuidGenerator;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usr")
public class User {
    @Id
    @UuidGenerator
    private UUID id;
    @Column(name="name", length=255, nullable=false, unique=false)
    private String name;
    @Column(name="password", length=255, nullable=false, unique=false)
    private String password;
    @Column(name="created_at", nullable=true, unique=false)
    private Long createdAt;
    @Column(name="updated_at", nullable=true, unique=false)
    private Long updatedAt;
}
