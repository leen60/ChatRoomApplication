package com.example.entrance_task_chat_app.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "chat_room")
public class Chat {
    @Id
    @UuidGenerator
    private UUID id;
    @OneToOne
    @JoinColumn(name = "sender_id", nullable=false, unique=false)
    private User sender;
    @Column(name="body", length=255, nullable=false, unique=false)
    private String body;
    @Column(name="created_at", nullable=false, unique=false)
    private Long createdAt;
}
