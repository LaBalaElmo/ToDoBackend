package org.tordoya.todobackend.repository;

import org.springframework.data.repository.CrudRepository;
import org.tordoya.todobackend.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByEmail(String email);
}
