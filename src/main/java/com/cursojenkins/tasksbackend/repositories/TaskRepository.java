package com.cursojenkins.tasksbackend.repositories;

import com.cursojenkins.tasksbackend.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
