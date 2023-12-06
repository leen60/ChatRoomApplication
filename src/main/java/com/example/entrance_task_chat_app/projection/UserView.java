package com.example.entrance_task_chat_app.projection;

/**
 * {@code UserView} projekcija grąžina User matomas žinutes (kas, kada, ką parašė).
 */
public interface UserView {
    String getName();
    String getBody();
    Long getCreated_at();
}