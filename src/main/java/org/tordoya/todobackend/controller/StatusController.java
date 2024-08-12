package org.tordoya.todobackend.controller;

import org.springframework.web.bind.annotation.*;
import org.tordoya.todobackend.domain.Status;
import org.tordoya.todobackend.service.StatusService;

@RestController
@RequestMapping("/status")
public class StatusController {
    private final StatusService statusService;

    public StatusController(StatusService statusService) {
        this.statusService = statusService;
    }

    @PostMapping("/create")
    public Status create(@RequestBody Status status) {
        return statusService.create(status);
    }
}
