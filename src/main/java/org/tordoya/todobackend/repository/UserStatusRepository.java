package org.tordoya.todobackend.repository;

import org.springframework.data.repository.CrudRepository;
import org.tordoya.todobackend.domain.User;
import org.tordoya.todobackend.domain.UserStatus;

import java.util.List;

public interface UserStatusRepository extends CrudRepository<UserStatus, Long> {
    List<UserStatus> findAllByUser(User user);
}
