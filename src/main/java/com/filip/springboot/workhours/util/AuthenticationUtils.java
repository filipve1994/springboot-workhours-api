package com.filip.springboot.workhours.util;

import com.filip.springboot.workhours.dto.model.user.UserDto;
import com.filip.springboot.workhours.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.time.temporal.ChronoField;
import java.util.Date;


@Component
public class AuthenticationUtils {

    @Autowired
    private UserService userService;

    public UserDto getUserDto(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return userService.findUserByEmail(auth.getName());
    }

}
