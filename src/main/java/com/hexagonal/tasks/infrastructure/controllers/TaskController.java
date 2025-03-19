package com.hexagonal.tasks.infrastructure.controllers;

import com.hexagonal.tasks.application.services.TaskService;
import com.hexagonal.tasks.domain.models.AdditionalTaskInfo;
import com.hexagonal.tasks.domain.models.Task;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        Task createdTask = taskService.createTask(task);
        return new ResponseEntity<>(createdTask, HttpStatus.CREATED);
    }

    @GetMapping("/{taskId}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long taskId) {
        return taskService.getTaskById(taskId)
                .map(task -> new ResponseEntity<>(task, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks(){
        List<Task> task = taskService.getAllTasks();

        return new ResponseEntity<>(task, HttpStatus.OK);
    }

    @PutMapping("/{taskId}")
    public ResponseEntity<Task> updateTask(@PathVariable Long taskId, @RequestBody Task task) {
        return taskService.updateTask(taskId, task)
                .map(updatedTask -> new ResponseEntity<>(updatedTask, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{taskId}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long taskId) {
        boolean deleted = taskService.deleteTask(taskId);
        return deleted ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{taskId}/additionalInfo")
    public ResponseEntity<AdditionalTaskInfo> getAdditionalTaskInfo(@PathVariable Long taskId) {
        AdditionalTaskInfo additionalTaskInfo = taskService.getAdditionalTaskInfo(taskId);
        return additionalTaskInfo != null ? new ResponseEntity<>(additionalTaskInfo, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
