package org.tordoya.todobackend.service;

import org.springframework.stereotype.Service;
import org.tordoya.todobackend.domain.Status;
import org.tordoya.todobackend.exception.StatusNotFoundException;
import org.tordoya.todobackend.repository.StatusRepository;

@Service
public class StatusService {
    private final StatusRepository statusRepository;

    public StatusService(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    public Status create(Status status) {
        return statusRepository.save(status);
    }

    public Status getStatusById(Long id) {
        return statusRepository.findById(id).orElseThrow(() -> new StatusNotFoundException(id.toString()));
    }
}
