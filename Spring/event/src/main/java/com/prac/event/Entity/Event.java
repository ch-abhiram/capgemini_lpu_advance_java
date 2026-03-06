package com.prac.event.Entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String eventType;
    private String location;

    private LocalDate eventDate;
    private LocalTime startTime;
    private LocalTime endTime;

    private String organizerName;
    private String contactPhone;

    private String status;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
