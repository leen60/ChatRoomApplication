package com.example.entrance_task_chat_app.projection;

/**
 * Projekcija grąžina statistiką:
 * vartotojas,
 * žinučių kiekis,
 * pirmosios žinutės laikas,
 * paskutinės žinutės laikas,
 * vidutinis žinutės ilgis,
 * paskutiniosios žinutės tekstas
 */
public interface Statistics {
    int getText_count();
    Long getCreated_at();
    Long getFirst_text_time();
    Long getLast_text_time();
    float getAverage_text_length();
    String getBody();
}