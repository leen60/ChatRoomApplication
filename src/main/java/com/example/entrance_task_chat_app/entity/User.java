package com.example.entrance_task_chat_app.entity;
import jakarta.persistence.*;
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
@Entity
@Table(name = "usr")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="name", length=255, nullable=false, unique=true)
    private String name;
    @Column(name="created_at", nullable=true, unique=false)
    private Long createdAt;
}
