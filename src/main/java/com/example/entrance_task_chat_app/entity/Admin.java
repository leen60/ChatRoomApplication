package com.example.entrance_task_chat_app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "admin")
public class Admin {
    @Id
    @GeneratedValue
    private int id;
    @Column(name="name", length=255, nullable=false, unique=false)
    private String name;
    @Column(name="password", length=255, nullable=false, unique=false)
    private String password;
    @Column(name="created_at", nullable=true, unique=false)
    private Long createdAt;
    @Column(name="updated_at", nullable=true, unique=false)
    private Long updatedAt;
}
