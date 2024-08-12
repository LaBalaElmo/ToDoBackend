package org.tordoya.todobackend.controller;

import org.springframework.web.bind.annotation.*;
import org.tordoya.todobackend.domain.Task;
import org.tordoya.todobackend.dto.TaskRequestDTO;
import org.tordoya.todobackend.service.TaskService;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/create")
    public Task createTask(@RequestBody TaskRequestDTO task) {
        return taskService.create(task);
    }

    @DeleteMapping("/delete/{taskId}")
    public long deleteTask(@PathVariable long taskId) {
        return taskService.delete(taskId);
    }

    @GetMapping("/all-user")
    public List<Task> getAllTasksByUser() {
        return taskService.findAllByUser();
    }

    @PutMapping("/update")
    public Task updateTask(@RequestBody TaskRequestDTO task) {
        return taskService.update(task);
    }

    @GetMapping("/all-status/{statusId}")
    public List<Task> getAllTasksByStatus(@PathVariable long statusId) {
        return taskService.findAllByStatus(statusId);
    }
}
