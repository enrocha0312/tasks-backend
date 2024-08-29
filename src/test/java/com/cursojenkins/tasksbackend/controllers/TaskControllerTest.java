package com.cursojenkins.tasksbackend.controllers;

import com.cursojenkins.tasksbackend.entities.Task;
import com.cursojenkins.tasksbackend.repositories.TaskRepository;

import com.cursojenkins.tasksbackend.utils.ValidationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class TaskControllerTest {
    @Mock
    private TaskRepository taskRepository;
    @InjectMocks
    private TaskController taskController;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void naoDeveSalvarTarefaSemDescricao(){
        Task todo = new Task();
        todo.setDueDate(LocalDate.now());
        try{
            taskController.save(todo);
            fail("Não deveria chegar nesse ponto");
        }catch (Exception e){
            assertEquals("Fill the task description", e.getMessage());
        }
    }
    @Test
    public void naoDeveSalvarTarefaSemData(){
        Task todo = new Task();
        todo.setTask("Descricao");
        try{
            taskController.save(todo);
        }catch (Exception e){
            assertEquals("Fill the due date", e.getMessage());
        }
    }
    @Test
    public void naoDeveSalvarTarefaComDataPassada(){
        Task todo = new Task();
        todo.setTask("Descricao");
        todo.setDueDate(LocalDate.of(2010,01,01));
        try{
            taskController.save(todo);
        }catch (Exception e){
            assertEquals("Due date must not be in past", e.getMessage());
        }
    }
    @Test
    public void deveSalvarTarefaComSucesso() throws ValidationException {
        Task todo = new Task();
        todo.setTask("Descricao");
        todo.setDueDate(LocalDate.now());
        taskController.save(todo);
        Mockito.verify(taskRepository).save(todo);
    }
}
