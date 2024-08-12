package org.tordoya.todobackend.repository;

import org.springframework.data.repository.CrudRepository;
import org.tordoya.todobackend.domain.Task;
import org.tordoya.todobackend.domain.User;

import java.util.List;

public interface TaskRepository extends CrudRepository<Task, Long> {
    List<Task> findByUser(User user);
    List<Task> findAllByStatusIdAndUser(long statusId, User user);
}
