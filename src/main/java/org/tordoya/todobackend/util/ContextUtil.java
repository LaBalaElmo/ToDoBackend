package org.tordoya.todobackend.util;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.tordoya.todobackend.domain.User;
import org.tordoya.todobackend.service.UserService;

public class ContextUtil {
    private final UserService userService;
    private static ContextUtil instance;

    private ContextUtil(UserService userService) {
        this.userService = userService;
    }
    public User getUserFromContext() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return userService.getUserByEmail(userDetails.getUsername());
    }

    public static ContextUtil getInstance(UserService userService) {
        if (instance == null) {
            instance = new ContextUtil(userService);
        }
        return instance;
    }
}
