package org.example.dto;

import org.example.model.Schedule;
import java.time.LocalDateTime;

public class ScheduleResponseDto {
    private Long id;
    private String title;
    private String description;
    private String author;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // 1️⃣ No-args 생성자 추가
    public ScheduleResponseDto() {}

    // 2️⃣ Schedule을 받아 초기화하는 생성자
    public ScheduleResponseDto(Schedule schedule) {
        this.id = schedule.getId();
        this.title = schedule.getTitle();
        this.description = schedule.getDescription();
        this.author = schedule.getAuthor();
        this.createdAt = schedule.getCreatedAt();
        this.updatedAt = schedule.getUpdatedAt();
    }

    // getter
    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getAuthor() { return author; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
}



