package org.tordoya.todobackend.repository;

import org.springframework.data.repository.CrudRepository;
import org.tordoya.todobackend.domain.Status;

public interface StatusRepository extends CrudRepository<Status, Long> {
}
