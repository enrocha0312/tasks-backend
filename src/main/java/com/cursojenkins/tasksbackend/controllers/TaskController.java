package com.cursojenkins.tasksbackend.controllers;

import com.cursojenkins.tasksbackend.entities.Task;
import com.cursojenkins.tasksbackend.repositories.TaskRepository;
import com.cursojenkins.tasksbackend.utils.DateUtils;
import com.cursojenkins.tasksbackend.utils.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value ="/todo")
public class TaskController {
    @Autowired
    private TaskRepository taskRepository;

    @GetMapping
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Task> save(@RequestBody Task todo) throws ValidationException {
        if(todo.getTask() == null || todo.getTask() == "") {
            throw new ValidationException("Fill the task description");
        }
        if(todo.getDueDate() == null) {
            throw new ValidationException("Fill the due date");
        }
        if(!DateUtils.isEqualOrFutureDate(todo.getDueDate())) {
            throw new ValidationException("Due date must not be in past");
        }
        Task saved = taskRepository.save(todo);
        return new ResponseEntity<Task>(saved, HttpStatus.CREATED);
    }
}
