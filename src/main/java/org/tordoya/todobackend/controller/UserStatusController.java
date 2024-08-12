package org.tordoya.todobackend.controller;

import org.springframework.web.bind.annotation.*;
import org.tordoya.todobackend.domain.Status;
import org.tordoya.todobackend.domain.UserStatus;
import org.tordoya.todobackend.dto.UserStatusRequestDTO;
import org.tordoya.todobackend.service.UserStatusService;

import java.util.List;

@RestController
@RequestMapping("/user-status")
public class UserStatusController {
    private final UserStatusService userStatusService;

    public UserStatusController(UserStatusService userStatusService) {
        this.userStatusService = userStatusService;
    }

    @PostMapping("/add")
    public UserStatus create(@RequestBody UserStatusRequestDTO statusId) {
        return userStatusService.create(statusId.statusId());
    }

    @GetMapping("/all")
    public List<Status> getAllByUser() {
        return userStatusService.findAllByUser();
    }
}
