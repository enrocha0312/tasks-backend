package com.cursojenkins.tasksbackend.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Task {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String task;

    @Column(nullable = false)
    private LocalDate dueDate;
}
