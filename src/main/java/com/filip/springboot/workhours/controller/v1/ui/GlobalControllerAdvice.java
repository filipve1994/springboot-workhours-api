package com.filip.springboot.workhours.controller.v1.ui;

import com.filip.springboot.workhours.dto.model.user.UserDto;
import com.filip.springboot.workhours.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice(assignableTypes = {DashboardController.class, PagesController.class})
//@ControllerAdvice()
public class GlobalControllerAdvice {

    @Autowired
    private UserService userService;

    @ModelAttribute("currentUser")
    public UserDto getCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDto userDto = userService.findUserByEmail(auth.getName());
        return userDto;
    }
}
