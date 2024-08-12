package org.tordoya.todobackend.service;

import org.springframework.stereotype.Service;
import org.tordoya.todobackend.domain.Status;
import org.tordoya.todobackend.domain.User;
import org.tordoya.todobackend.domain.UserStatus;
import org.tordoya.todobackend.repository.UserStatusRepository;
import org.tordoya.todobackend.util.ContextUtil;

import java.util.List;

@Service
public class UserStatusService {
    private final UserStatusRepository userStatusRepository;
    private final UserService userService;
    private final StatusService statusService;

    public UserStatusService(UserStatusRepository userStatusRepository, UserService userService, StatusService statusService) {
        this.statusService = statusService;
        this.userService = userService;
        this.userStatusRepository = userStatusRepository;
    }

    public UserStatus create(Long statusId) {
        User user = ContextUtil.getInstance(userService).getUserFromContext();
        Status status = statusService.getStatusById(statusId);
        return userStatusRepository.save(new UserStatus(user, status));
    }

    public List<Status> findAllByUser() {
        User user = ContextUtil.getInstance(userService).getUserFromContext();
        List<UserStatus> userStatus = userStatusRepository.findAllByUser(user);
        return userStatus.stream().map(UserStatus::getStatus).toList();
    }
}
