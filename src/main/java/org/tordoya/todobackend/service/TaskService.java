package org.tordoya.todobackend.service;

import org.springframework.stereotype.Service;
import org.tordoya.todobackend.domain.Status;
import org.tordoya.todobackend.domain.Task;
import org.tordoya.todobackend.domain.User;
import org.tordoya.todobackend.dto.TaskRequestDTO;
import org.tordoya.todobackend.exception.TaskNotFoundException;
import org.tordoya.todobackend.repository.TaskRepository;
import org.tordoya.todobackend.util.ContextUtil;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private final UserService userService;

    public TaskService(TaskRepository taskRepository, UserService userService) {
        this.userService = userService;
        this.taskRepository = taskRepository;
    }

    public Task create(TaskRequestDTO taskReq) {
        Task task = new Task(
                taskReq.title(),
                taskReq.description(),
                new Status(taskReq.statusId(), "", null),
                ContextUtil.getInstance(userService).getUserFromContext()
        );
        task = taskRepository.save(task);
        return task;
    }

    public long delete(long taskId) {
        taskRepository.deleteById(taskId);
        return taskId;
    }

    public List<Task> findAllByUser() {
        User user = ContextUtil.getInstance(userService).getUserFromContext();
        return taskRepository.findByUser(user);
    }

    public Task update(TaskRequestDTO task) {
        Task taskToUpdate = taskRepository.findById(task.id()).orElseThrow(() -> new TaskNotFoundException(task.id().toString()));
        taskToUpdate.setTitle(task.title());
        taskToUpdate.setDescription(task.description());
        taskToUpdate.setStatus(new Status(task.statusId(), "", null));
        taskToUpdate = taskRepository.save(taskToUpdate);
        return taskToUpdate;
    }

    public List<Task> findAllByStatus(long statusId) {
        User user = ContextUtil.getInstance(userService).getUserFromContext();
        return taskRepository.findAllByStatusIdAndUser(statusId, user);
    }
}
